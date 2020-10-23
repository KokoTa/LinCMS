/*
 * @Author: KokoTa
 * @Date: 2020-10-21 10:37:31
 * @LastEditTime: 2020-10-22 15:02:51
 * @LastEditors: KokoTa
 * @Description:
 * @FilePath: /lin-cms-spring-boot/src/main/java/io/github/talelin/latticy/controller/v1/SkuController.java
 */
package io.github.talelin.latticy.controller.v1;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import io.github.talelin.latticy.model.SkuDO;
import io.github.talelin.latticy.service.impl.SkuServiceImpl;
import io.github.talelin.latticy.vo.CreatedVO;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.PageResponseVO;
import io.github.talelin.latticy.vo.UpdatedVO;

import javax.validation.constraints.Min;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Positive;

import org.springframework.web.bind.annotation.RestController;

/**
 * @author generator@TaleLin
 * @since 2020-10-21
 */
@RestController
@RequestMapping("/v1/sku")
public class SkuController {

  @Autowired
  private SkuServiceImpl skuService;

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
  public SkuDO get(@PathVariable(value = "id") @Positive(message = "{id.positive}") Long id) {
    return null;
  }

  @GetMapping("/page")
  public PageResponseVO<SkuDO> page(
      @RequestParam(name = "pageSize", required = false, defaultValue = "10") @Min(value = 1, message = "{page.count.min}") @Max(value = 30, message = "{page.count.max}") Long pageSize,
      @RequestParam(name = "pageNo", required = false, defaultValue = "1") @Min(value = 0, message = "{page.number.min}") Long pageNo) {
    return null;
  }

  @GetMapping("/by/spu/{spuId}")
  public List<SkuDO> getBySpuId(@PathVariable @Positive Long spuId) {
    return skuService.lambdaQuery().eq(SkuDO::getSpuId, spuId).list();
  }

}
