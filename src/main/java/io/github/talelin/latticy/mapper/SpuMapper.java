package io.github.talelin.latticy.mapper;

import io.github.talelin.latticy.model.SpuDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.talelin.latticy.model.SpuDetailDO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author generator@TaleLin
 * @since 2020-10-21
 */
@Repository
public interface SpuMapper extends BaseMapper<SpuDO> {

    List<SpuDetailDO> getDetail(Long id);
}
