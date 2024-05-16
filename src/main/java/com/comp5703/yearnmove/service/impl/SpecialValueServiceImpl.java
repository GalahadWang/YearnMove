package com.comp5703.yearnmove.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.comp5703.yearnmove.DTO.CircleNum;
import com.comp5703.yearnmove.mapper.SpecialValueMapper;
import com.comp5703.yearnmove.pojo.SpecialValue;
import com.comp5703.yearnmove.service.SpecialValueService;
import com.sun.source.tree.LabeledStatementTree;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialValueServiceImpl extends ServiceImpl<SpecialValueMapper, SpecialValue> implements SpecialValueService {
    private SpecialValueMapper specialValueMapper;

    public SpecialValueServiceImpl(SpecialValueMapper specialValueMapper) {this.specialValueMapper = specialValueMapper;}

    @Override
    public List<SpecialValue> returnSpecialValue(CircleNum Circlenumber){
        Integer number = Circlenumber.getNumber();
        QueryWrapper<SpecialValue> queryWrapper = new QueryWrapper<>();
        if(number == 1){
            queryWrapper.between("record_id",1,24);
        }
        else if(number == 2){
            queryWrapper.between("record_id",25,28);
        }
        else if(number == 3){
            queryWrapper.between("record_id",29,67);
        }
        else if(number == 4){
            queryWrapper.between("record_id",68,82);
        }
        else {
            queryWrapper.between("record_id",0,0);
        }
        queryWrapper.select("first_author", "year","author_year","title","doi");
        List<SpecialValue> dataList = specialValueMapper.selectList(queryWrapper);
        System.out.println("Size of DataList: " + dataList.size());
        return dataList;
    }
}
