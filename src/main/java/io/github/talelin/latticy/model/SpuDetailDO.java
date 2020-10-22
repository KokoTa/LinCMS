package io.github.talelin.latticy.model;

import io.github.talelin.latticy.model.SpuDO;
import lombok.Data;

import java.util.List;

@Data
public class SpuDetailDO extends SpuDO {

  private String categoryName;

  private String sketchSpecName;

  private String defaultSkuTitle;

  private List<String> spuImgList;

  private List<String> spuDetailImgList;
}
