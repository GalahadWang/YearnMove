package com.comp5703.yearnmove.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.comp5703.yearnmove.pojo.WellbeingOutcomes;

import java.util.List;
import java.util.Map;


public interface WellbeingOutcomesService extends IService<WellbeingOutcomes> {
    Map<String, String> calculateOutcomeRatios(List<Integer> recordIds);
}