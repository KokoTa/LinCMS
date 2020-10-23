/*
 * @Author: KokoTa
 * @Date: 2020-10-22 15:01:11
 * @LastEditTime: 2020-10-22 15:52:07
 * @LastEditors: KokoTa
 * @Description:
 * @FilePath: /lin-cms-spring-boot/src/main/java/io/github/talelin/latticy/service/impl/SpecKeyServiceImpl.java
 */
package io.github.talelin.latticy.service.impl;

import io.github.talelin.latticy.model.SpecKeyDO;
import io.github.talelin.latticy.mapper.SpecKeyMapper;
import io.github.talelin.latticy.service.SpecKeyService;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author generator@TaleLin
 * @since 2020-10-22
 */
@Service
public class SpecKeyServiceImpl extends ServiceImpl<SpecKeyMapper, SpecKeyDO> implements SpecKeyService {

  @Autowired
  SpecKeyMapper specKeyMapper;

  public List<SpecKeyDO> getBySpuId(Long id) {
    return specKeyMapper.getBySpuId(id);
  }
}
