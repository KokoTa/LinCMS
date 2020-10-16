package io.github.talelin.latticy.bo;

import io.github.talelin.latticy.model.BannerDO;
import io.github.talelin.latticy.model.BannerItemDO;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Data
public class BannerWithItemsBO {

    private Long id;

    private String name;

    private String description;

    private String title;

    private String img;

    private List<BannerItemDO> items;

    public BannerWithItemsBO(BannerDO bannerDO, List<BannerItemDO> items) {
        BeanUtils.copyProperties(bannerDO, this);
        this.setItems(items);
    }
}
