/*
 * @Author: KokoTa
 * @Date: 2020-10-22 16:22:59
 * @LastEditTime: 2020-10-22 16:27:01
 * @LastEditors: KokoTa
 * @Description:
 * @FilePath: /lin-cms-spring-boot/src/main/java/io/github/talelin/latticy/dto/spu/SpuDTO.java
 */
package io.github.talelin.latticy.dto.spu;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import io.github.talelin.autoconfigure.validator.Length;
import lombok.Data;

@Data
public class SpuDTO {
  @NotBlank
  @Length(min = 1, max = 128)
  private String title;

  @Length(min = 1, max = 255)
  private String subtitle;

  @Length(min = 1, max = 255)
  private String img;

  @Length(min = 1, max = 255)
  private String forThemeImg;

  @Positive
  @NotNull
  private Integer categoryId;

  @Max(1)
  @Min(0)
  private Integer online;

  @Positive
  private Integer sketchSpecId;

  @Positive
  private Integer defaultSkuId;

  @NotBlank
  @Length(min = 1, max = 20)
  private String price;

  @Length(min = 1, max = 20)
  private String discountPrice;

  @Length(min = 1, max = 255)
  private String description;

  @Length(min = 1, max = 255)
  private String tags;

  private List<Integer> specKeyIdList;

  private List<String> spuImgList;

  private List<String> spuDetailImgList;
}
