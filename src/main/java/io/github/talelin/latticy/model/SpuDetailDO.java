package io.github.talelin.latticy.bo;

import io.github.talelin.latticy.model.SpuDO;
import lombok.Data;

import java.util.List;

@Data
public class SpuDetailBO extends SpuDO {

    private String categoryName;

    private String sketchSpecName;

    private String defaultSkuName;

    private List<String> bannerImgs;

    private List<String> detailImgs;
}
