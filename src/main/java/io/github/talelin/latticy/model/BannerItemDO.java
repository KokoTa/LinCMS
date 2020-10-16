package io.github.talelin.latticy.model;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("banner_item")
public class BannerItemDO extends BaseModel {

//    @TableField(value = "banner_id")
    private Long bannerId;

    private String name;

    private String img;

    private String keyword;

    private String type;
}
