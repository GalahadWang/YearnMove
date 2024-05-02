package com.comp5703.yearnmove.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.comp5703.yearnmove.pojo.FaCeOutcomes;

import java.util.List;
import java.util.Map;

public interface FaCeOutcomesService extends IService<FaCeOutcomes> {
    Map<String, String> calculateOutcomeRatios(List<Integer> recordIds);
}