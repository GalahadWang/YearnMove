package com.comp5703.yearnmove.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.comp5703.yearnmove.pojo.FallsOutcomes;

import java.util.List;
import java.util.Map;

public interface FallsOutcomesService extends IService<FallsOutcomes> {
    Map<String, String> calculateOutcomeRatios(List<Integer> recordIds);
}
