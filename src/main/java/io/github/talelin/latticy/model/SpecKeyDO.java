package io.github.talelin.latticy.model;

import io.github.talelin.latticy.model.BaseModel;
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
@TableName("spec_key")
public class SpecKeyDO extends BaseModel {


    private String name;

    private String unit;

    private Integer standard;

    private String description;


}
