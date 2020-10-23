/*
 * @Author: KokoTa
 * @Date: 2020-10-21 10:37:31
 * @LastEditTime: 2020-10-23 12:30:40
 * @LastEditors: KokoTa
 * @Description:
 * @FilePath: /lin-cms-spring-boot/src/main/java/io/github/talelin/latticy/service/impl/SpuServiceImpl.java
 */
package io.github.talelin.latticy.service.impl;

import io.github.talelin.latticy.model.CategoryDO;
import io.github.talelin.latticy.model.SpuDO;
import io.github.talelin.latticy.dto.spu.SpuDTO;
import io.github.talelin.latticy.mapper.SpuMapper;
import io.github.talelin.latticy.model.SpuDetailDO;
import io.github.talelin.latticy.model.SpuDetailImgDO;
import io.github.talelin.latticy.model.SpuImgDO;
import io.github.talelin.latticy.model.SpuKeyDO;
import io.github.talelin.latticy.service.SpuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author generator@TaleLin
 * @since 2020-10-21
 */
@Service
public class SpuServiceImpl extends ServiceImpl<SpuMapper, SpuDO> implements SpuService {

  @Autowired
  SpuMapper spuMapper;

  @Autowired
  CategoryServiceImpl categoryServiceImpl;

  @Autowired
  SpuImgServiceImpl spuImgServiceImpl;

  @Autowired
  SpuDetailImgServiceImpl spuDetailImgServiceImpl;

  @Autowired
  SpuKeyServiceImpl spuKeyServiceImpl;

  public List<SpuDetailDO> getDetail(Long id) {
    return spuMapper.getDetail(id);
  }

  /**
   * 创建 SPU，涉及到多个表
   *
   * @param spuDTO
   */
  @Transactional
  public void create(SpuDTO spuDTO) {
    SpuDO spuDO = new SpuDO();
    BeanUtils.copyProperties(spuDTO, spuDO);
    // 保存分类的父ID
    CategoryDO categoryDO = categoryServiceImpl.getCategoryById(spuDO.getCategoryId());
    spuDO.setRootCategoryId(categoryDO.getParentId());
    // 保存 SPU 信息
    this.save(spuDO);

    // 插入 SPU 图片列表
    List<String> spuImgList = new ArrayList<>();
    if (spuDTO.getSpuImgList() == null) {
      spuImgList.add(spuDTO.getImg());
    } else {
      spuImgList = spuDTO.getSpuImgList();
    }
    List<SpuImgDO> spuImgDOList = spuImgList.stream().map(s -> {
      SpuImgDO spuImgDO = new SpuImgDO();
      spuImgDO.setImg(s);
      spuImgDO.setSpuId(spuDO.getId().intValue());
      return spuImgDO;
    }).collect(Collectors.toList());
    // 批量插入图片
    spuImgServiceImpl.saveBatch(spuImgDOList);

    // 插入 SPU 详情图片列表
    List<SpuDetailImgDO> spuDetailImgDOList = new ArrayList<>();
    if (spuDTO.getSpuDetailImgList() != null) {
      List<String> list = spuDTO.getSpuDetailImgList();
      for (int i = 0; i < list.size(); i++) {
        SpuDetailImgDO spuDetailImgDO = new SpuDetailImgDO();
        spuDetailImgDO.setImg(list.get(i)).setSpuId(spuDO.getId().intValue()).setIndex(i);
        spuDetailImgDOList.add(spuDetailImgDO);
      }
      // 批量插入图片
      spuDetailImgServiceImpl.saveBatch(spuDetailImgDOList);
    }

    // 插入 SPU 对应的规格名 ID 到中间表
    List<SpuKeyDO> spuKeyDOList = new ArrayList<>();
    if (spuDTO.getSpecKeyIdList() != null) {
      spuDTO.getSpecKeyIdList().stream().forEach(id -> {
        SpuKeyDO spuKeyDO = new SpuKeyDO();
        spuKeyDO.setSpuId(spuDO.getId().intValue());
        spuKeyDO.setSpecKeyId(id);
        spuKeyDOList.add(spuKeyDO);
      });
      spuKeyServiceImpl.saveBatch(spuKeyDOList);
    }
  }
}
