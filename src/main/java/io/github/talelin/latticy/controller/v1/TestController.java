package io.github.talelin.latticy.controller.v1;

import io.github.talelin.latticy.model.BannerDO;
import io.github.talelin.latticy.service.impl.TestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/test")
public class TestController {

    @Autowired
    private TestServiceImpl testService;

    @GetMapping("/getBanners")
    public List<BannerDO> getBanners() {
        return testService.getBanners();
    }

    @PostMapping("/insertBannerByXmlSQL")
    public Long insertBannerByXmlSQL() {
        BannerDO bannerDO = new BannerDO();
        bannerDO.setImg("https://dummyimage.com/200x200.jpg?text=Hello");
        bannerDO.setDescription("banner描述");
        bannerDO.setName("banner名称");
        bannerDO.setTitle("banner标题");
        testService.insertBanner(bannerDO);
        return bannerDO.getId();
    }

    @PostMapping("/insertBannerByAnnotationSQL")
    public Long insertBannerByAnnotationSQL() {
        BannerDO bannerDO = new BannerDO();
        bannerDO.setImg("https://dummyimage.com/200x200.jpg?text=Hello");
        bannerDO.setDescription("banner描述");
        bannerDO.setName("banner名称");
        bannerDO.setTitle("banner标题");
        testService.insertBanner2(bannerDO);
        return bannerDO.getId();
    }

    @PostMapping("/insertBannerByBaseMapper")
    public Long insertBannerByBaseMapper() {
        BannerDO bannerDO = new BannerDO();
        bannerDO.setImg("https://dummyimage.com/200x200.jpg?text=Hello");
        bannerDO.setDescription("banner描述");
        bannerDO.setName("banner名称");
        bannerDO.setTitle("banner标题");
        testService.insertBanner3(bannerDO);
        return bannerDO.getId();
    }
}
