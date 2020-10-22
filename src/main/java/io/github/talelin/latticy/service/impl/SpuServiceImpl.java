package io.github.talelin.latticy.service.impl;

import io.github.talelin.latticy.model.SpuDO;
import io.github.talelin.latticy.mapper.SpuMapper;
import io.github.talelin.latticy.model.SpuDetailDO;
import io.github.talelin.latticy.service.SpuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author generator@TaleLin
 * @since 2020-10-21
 */
@Service
public class SpuServiceImpl extends ServiceImpl<SpuMapper, SpuDO> implements SpuService {

    @Autowired
    SpuMapper spuMapper;

    public List<SpuDetailDO> getDetail(Long id) {
        return spuMapper.getDetail(id);
    }
}
