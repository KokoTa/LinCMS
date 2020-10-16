package io.github.talelin.latticy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.talelin.latticy.model.BannerDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BannerMapper extends BaseMapper<BannerDO> {
    Long insertBanner(BannerDO bannerDO);

    @Insert("insert into banner(name, description, title, img)\n" +
            "values (#{name}, #{description}, #{title}, #{img})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Long insertBanner2(BannerDO bannerDO);
}
