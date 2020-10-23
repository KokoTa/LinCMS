/*
 * @Author: KokoTa
 * @Date: 2020-10-23 09:47:10
 * @LastEditTime: 2020-10-23 10:53:09
 * @LastEditors: KokoTa
 * @Description:
 * @FilePath: /lin-cms-spring-boot/src/main/java/io/github/talelin/latticy/model/SpuDetailImgDO.java
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
 * @since 2020-10-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("spu_detail_img")
public class SpuDetailImgDO extends BaseModel {

  private String img;

  private Integer spuId;

  @TableField(value = "`index`")
  private Integer index;

}
