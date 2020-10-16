package io.github.talelin.latticy.service.impl;

import io.github.talelin.latticy.mapper.BannerMapper;
import io.github.talelin.latticy.model.BannerDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 按照规范一般要先写接口，再写实现类，这里省略了
 */
@Service
public class TestServiceImpl {

    @Autowired
    private BannerMapper bannerMapper;

    public List<BannerDO> getBanners() {
        return bannerMapper.selectList(null);
    }

    public Long insertBanner(BannerDO bannerDO) {
        return bannerMapper.insertBanner(bannerDO);
    }

    public Long insertBanner2(BannerDO bannerDO) {
        return bannerMapper.insertBanner2(bannerDO);
    }

    public Integer insertBanner3(BannerDO bannerDO) {
        return bannerMapper.insert(bannerDO);
    }
}
