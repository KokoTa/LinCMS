package io.github.talelin.latticy.controller.v1;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.talelin.latticy.common.util.PageUtil;
import io.github.talelin.latticy.model.SkuDO;
import io.github.talelin.latticy.model.SpuDetailDO;
import io.github.talelin.latticy.service.impl.SpuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import io.github.talelin.latticy.model.SpuDO;
import io.github.talelin.latticy.vo.CreatedVO;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.PageResponseVO;
import io.github.talelin.latticy.vo.UpdatedVO;

import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.Positive;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
* @author generator@TaleLin
* @since 2020-10-21
*/
@RestController
@RequestMapping("/v1/spu")
public class SpuController {

    @Autowired
    SpuServiceImpl spuService;

    @PostMapping("")
    public CreatedVO create() {
        return new CreatedVO();
    }

    @PutMapping("/{id}")
    public UpdatedVO update(@PathVariable @Positive(message = "{id.positive}") Long id) {
        return new UpdatedVO();
    }

    @DeleteMapping("/{id}")
    public DeletedVO delete(@PathVariable @Positive(message = "{id.positive}") Long id) {
        return new DeletedVO();
    }

    @GetMapping("/{id}")
    public SpuDO get(@PathVariable(value = "id") @Positive(message = "{id.positive}") Long id) {
        return null;
    }

    @GetMapping("/page")
    public PageResponseVO<SpuDO> page(
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
            @Min(value = 1, message = "{page.count.min}")
            @Max(value = 30, message = "{page.count.max}") Long pageSize,
            @RequestParam(name = "pageNo", required = false, defaultValue = "1")
            @Min(value = 0, message = "{page.number.min}") Long pageNo
    ) {
        IPage<SpuDO> page = new Page<>(pageNo, pageSize);
        IPage<SpuDO> result = spuService.getBaseMapper().selectPage(page, null);
        return PageUtil.build(result);
    }

    @GetMapping("/{id}/detail")
    public List<SpuDetailDO> getDetail(@PathVariable @Positive Long id) {
        return spuService.getDetail(id);
    }

}
