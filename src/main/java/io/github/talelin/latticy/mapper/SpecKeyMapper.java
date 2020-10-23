/*
 * @Author: KokoTa
 * @Date: 2020-10-22 15:01:11
 * @LastEditTime: 2020-10-22 15:52:18
 * @LastEditors: KokoTa
 * @Description:
 * @FilePath: /lin-cms-spring-boot/src/main/java/io/github/talelin/latticy/mapper/SpecKeyMapper.java
 */
package io.github.talelin.latticy.mapper;

import io.github.talelin.latticy.model.SpecKeyDO;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author generator@TaleLin
 * @since 2020-10-22
 */
public interface SpecKeyMapper extends BaseMapper<SpecKeyDO> {

  List<SpecKeyDO> getBySpuId(Long id);
}
