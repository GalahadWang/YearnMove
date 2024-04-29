package com.comp5703.yearnmove.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.comp5703.yearnmove.pojo.PaOutcomes;

import java.util.List;
import java.util.Map;

public interface PaOutcomesService extends IService<PaOutcomes> {
    Map<String, String> calculateOutcomeRatios(List<Integer> recordIds);
}
