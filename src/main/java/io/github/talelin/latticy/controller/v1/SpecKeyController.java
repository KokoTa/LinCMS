package io.github.talelin.latticy.controller.v1;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import io.github.talelin.latticy.model.SpecKeyDO;
import io.github.talelin.latticy.service.SpecKeyService;
import io.github.talelin.latticy.service.impl.SpecKeyServiceImpl;
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
 * @since 2020-10-22
 */
@RestController
@RequestMapping("/v1/spec-key")
@Validated
public class SpecKeyController {

  @Autowired
  private SpecKeyServiceImpl specKeyService;

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
  public SpecKeyDO get(@PathVariable(value = "id") @Positive(message = "{id.positive}") Long id) {
    return null;
  }

  @GetMapping("/page")
  public PageResponseVO<SpecKeyDO> page(
      @RequestParam(name = "pageSize", required = false, defaultValue = "10") @Min(value = 1, message = "{page.count.min}") @Max(value = 30, message = "{page.count.max}") Long pageSize,
      @RequestParam(name = "pageNo", required = false, defaultValue = "1") @Min(value = 0, message = "{page.number.min}") Long pageNo) {
    return null;
  }

  /**
   * 获取可视规格
   *
   * @param spuId
   * @return
   */
  @GetMapping("/by/spu/{spuId}")
  public List<SpecKeyDO> getBySpuId(@PathVariable @Positive Long spuId) {
    return specKeyService.getBySpuId(spuId);
  }

}