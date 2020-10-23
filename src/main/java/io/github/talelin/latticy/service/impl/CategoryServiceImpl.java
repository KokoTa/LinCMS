/*
 * @Author: KokoTa
 * @Date: 2020-10-22 17:28:42
 * @LastEditTime: 2020-10-22 17:36:22
 * @LastEditors: KokoTa
 * @Description:
 * @FilePath: /lin-cms-spring-boot/src/main/java/io/github/talelin/latticy/service/impl/CategoryServiceImpl.java
 */
package io.github.talelin.latticy.service.impl;

import io.github.talelin.latticy.model.CategoryDO;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.latticy.mapper.CategoryMapper;
import io.github.talelin.latticy.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, CategoryDO> implements CategoryService {

  public CategoryDO getCategoryById(Integer integer) {
    CategoryDO categoryDO = this.getById(integer);
    if (categoryDO == null) {
      throw new NotFoundException();
    }
    return categoryDO;
  }
}
