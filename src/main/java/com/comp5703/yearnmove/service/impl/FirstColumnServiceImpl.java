package com.comp5703.yearnmove.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.comp5703.yearnmove.DTO.articleMainFilter;
import com.comp5703.yearnmove.mapper.FirstColumnMapper;
import com.comp5703.yearnmove.pojo.FirstColumn;
import com.comp5703.yearnmove.pojo.MainData;
import com.comp5703.yearnmove.service.FirstColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FirstColumnServiceImpl extends ServiceImpl<FirstColumnMapper,FirstColumn> implements FirstColumnService {
    private FirstColumnMapper firstColumnMapper;
    @Autowired
    public FirstColumnServiceImpl(FirstColumnMapper firstColumnMapper){ this.firstColumnMapper = firstColumnMapper;}

    @Override
    public List<FirstColumn> returnFirstColumn(articleMainFilter articleMainFilter){
        QueryWrapper<FirstColumn> queryWrapper = new QueryWrapper<>();

        // type_of_PA condition
        if (articleMainFilter.getTypeOfPA() != null && !articleMainFilter.getTypeOfPA().isEmpty()) {
            queryWrapper.in("type_of_PA", articleMainFilter.getTypeOfPA());
        }

        // type_of_PA_description condition
        if (articleMainFilter.getTypeOfPADescription() != null && !articleMainFilter.getTypeOfPADescription().isEmpty()) {
            queryWrapper.in("type_of_PA_description", articleMainFilter.getTypeOfPADescription());
        }

        // Ensure that the record_id equals the first_recordid
        queryWrapper.apply("record_id = first_recordid");
//        queryWrapper.apply("second_recordid IN (SELECT second_recordid FROM (SELECT * FROM first_column WHERE record_id = first_recordid) as temp GROUP BY second_recordid HAVING COUNT(second_recordid) = 1)");

        queryWrapper.select("first_author", "year","author_year","title","doi");
        List<FirstColumn> mainDataList = firstColumnMapper.selectList(queryWrapper);
     
        System.out.println("Size of mainDataList: " + mainDataList.size());
        return mainDataList;
    }
}
