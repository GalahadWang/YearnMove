package com.comp5703.yearnmove.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.comp5703.yearnmove.pojo.FaSocialOutcomes;

import java.util.List;
import java.util.Map;

public interface FaSocialOutcomesService extends IService<FaSocialOutcomes> {
    Map<String, String> calculateOutcomeRatios(List<Integer> recordIds);
}
