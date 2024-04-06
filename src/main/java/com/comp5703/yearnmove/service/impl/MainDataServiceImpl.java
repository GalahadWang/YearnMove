package com.comp5703.yearnmove.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.comp5703.yearnmove.mapper.MainDataMapper;
import com.comp5703.yearnmove.pojo.MainData;
import com.comp5703.yearnmove.service.MainDataService;
import org.springframework.stereotype.Service;

@Service
public class MainDataServiceImpl extends ServiceImpl<MainDataMapper, MainData> implements MainDataService{
}
