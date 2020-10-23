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
@TableName("spec_value")
public class SpecValueDO extends BaseModel {


    private String value;

    private Integer specId;

    private String extend;


}
