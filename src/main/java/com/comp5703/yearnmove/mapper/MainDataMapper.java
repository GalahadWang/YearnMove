package com.comp5703.yearnmove.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.comp5703.yearnmove.pojo.MainData;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MainDataMapper extends BaseMapper<MainData> {
    // This interface is used to create a mapper for the MainData table
}