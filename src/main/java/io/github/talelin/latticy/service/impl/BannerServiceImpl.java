package io.github.talelin.latticy.service.impl;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.latticy.bo.BannerWithItemsBO;
import io.github.talelin.latticy.dto.banner.BannerDTO;
import io.github.talelin.latticy.mapper.BannerItemMapper;
import io.github.talelin.latticy.mapper.BannerMapper;
import io.github.talelin.latticy.model.BannerDO;
import io.github.talelin.latticy.model.BannerItemDO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImpl extends ServiceImpl<BannerMapper, BannerDO> {

    @Autowired
    BannerItemMapper bannerItemMapper;

    // 这里使用单表查询后组装数据
    public BannerWithItemsBO getWithItems(Long id) {
        BannerDO bannerDO = this.getById(id);
        if (bannerDO == null) {
            throw new NotFoundException(20000);
        }

        // 方式一：普通调用，相当于 SQL 的 where 条件
//        QueryWrapper<BannerItemDO> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("banner_id", id);
//        List<BannerItemDO> bannerItemList = bannerItemMapper.selectList(queryWrapper);
        // 方式二：lambda 调用
//        LambdaQueryWrapper<BannerItemDO> lambdaQueryWrapper = new LambdaQueryWrapper<>();
//        lambdaQueryWrapper.eq(BannerItemDO::getBannerId, id);
//        List<BannerItemDO> bannerItemList = bannerItemMapper.selectList(lambdaQueryWrapper);
        // 方式三：链式调用
        List<BannerItemDO> bannerItemList = new LambdaQueryChainWrapper<>(bannerItemMapper)
                .eq(BannerItemDO::getBannerId, id)
                .list();

        return new BannerWithItemsBO(bannerDO, bannerItemList);
    }

    public void updateBanner(BannerDTO bannerDTO, Long id) {
        BannerDO bannerDO = this.getById(id);
        if (bannerDO == null) {
            throw new NotFoundException(20000);
        }
        BeanUtils.copyProperties(bannerDTO, bannerDO);
        this.updateById(bannerDO);
    }

    public void deleteBanner(Long id) {
        BannerDO bannerDO = this.getById(id);
        if (bannerDO == null) {
            throw new NotFoundException(20000);
        }
        this.removeById(id);
    }
}
