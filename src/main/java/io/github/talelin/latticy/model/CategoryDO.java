/*
 * @Author: KokoTa
 * @Date: 2020-10-22 17:28:42
 * @LastEditTime: 2020-10-23 10:46:25
 * @LastEditors: KokoTa
 * @Description:
 * @FilePath: /lin-cms-spring-boot/src/main/java/io/github/talelin/latticy/model/CategoryDO.java
 */
package io.github.talelin.latticy.model;

import io.github.talelin.latticy.model.BaseModel;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author generator@TaleLin
 * @since 2020-10-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("category")
public class CategoryDO extends BaseModel {

  private String name;

  private String description;

  private Integer isRoot;

  private Integer parentId;

  private String img;

  @TableField(value = "`index`")
  private Integer index;

  private Integer online;

  private Integer level;

}
