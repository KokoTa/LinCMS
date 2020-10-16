package io.github.talelin.latticy.dto.banner;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
public class BannerDTO {

    @NotBlank
    @Length(min = 2, max = 20)
    private String name;

    @Length(min = 2, max = 30)
    private String description;

    @Length(min = 2, max = 256)
    private String title;

    @Length(min = 2, max = 256)
    private String img;
}
