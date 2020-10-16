package io.github.talelin.latticy.controller.v1;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.talelin.latticy.bo.BannerWithItemsBO;
import io.github.talelin.latticy.dto.banner.BannerDTO;
import io.github.talelin.latticy.model.BannerDO;
import io.github.talelin.latticy.service.impl.BannerServiceImpl;
import io.github.talelin.latticy.vo.CreatedVO;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.PageResponseVO;
import io.github.talelin.latticy.vo.UpdatedVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@RequestMapping("/v1/banner")
@RestController
@Validated
public class BannerController {

    @Autowired
    private BannerServiceImpl bannerService;

    /**
     * 分页获取 Banner
     */
    @GetMapping("/page")
    public PageResponseVO<BannerDO> getBanners(
            @RequestParam(required = false, defaultValue = "1")
            @Min(value = 1, message = "{page.count.min}") Integer pageNo,
            @RequestParam(required = false, defaultValue = "10")
            @Min(value = 10, message = "{page.count.min}")
            @Max(value = 30, message = "{page.count.max}") Integer pageSize
    ) {
        IPage<BannerDO> page = new Page<>(pageNo, pageSize);
        IPage<BannerDO> result = bannerService.getBaseMapper().selectPage(page, null);
        return new PageResponseVO<>(
                result.getTotal(),
                result.getRecords(),
                result.getCurrent(),
                result.getSize()
        );
    }

    /**
     * 获取 Banner 及其对应的 BannerItem
     */
    @GetMapping("/{id}")
    public BannerWithItemsBO getWithItems(
            @PathVariable @Positive Long id
    ) {
        return bannerService.getWithItems(id);
    }

    /**
     * 创建 Banner
     * @return
     */
    @PostMapping("")
    public CreatedVO createBanner(
        @RequestBody @Validated BannerDTO bannerDTO
    ) {
        BannerDO bannerDO = new BannerDO();
        BeanUtils.copyProperties(bannerDTO, bannerDO);
        bannerService.save(bannerDO);
        return new CreatedVO<>();
    }

    /**
     * 更新 Banner
     */
    @PutMapping("/{id}")
    public UpdatedVO updateBanner(
            @RequestBody @Validated BannerDTO bannerDTO,
            @PathVariable @Positive Long id
    ) {
        bannerService.updateBanner(bannerDTO, id);
        return new UpdatedVO<>();
    }

    /**
     * 软删除 Banner
     */
    @DeleteMapping("/{id}")
    public DeletedVO deleteBanner(
            @PathVariable @Positive Long id
    ) {
        bannerService.deleteBanner(id);
        return new DeletedVO<>();
    }
}
