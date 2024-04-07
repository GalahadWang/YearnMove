package com.comp5703.yearnmove.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.comp5703.yearnmove.common.Result;
import com.comp5703.yearnmove.pojo.MainData;
import com.comp5703.yearnmove.service.MainDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class MainDataController {
    @Autowired
    private MainDataService mainDataService;

    @PostMapping("/test")
    public Result<MainData> FindById(@RequestBody MainData mainData){
        System.out.println(mainData);
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("record_id",mainData.getRecordId());
        MainData result = mainDataService.getOne(wrapper);
        if(result != null)
            return Result.success(result,"Return the answer");
        return Result.error("Don't find the result");
    }

}
