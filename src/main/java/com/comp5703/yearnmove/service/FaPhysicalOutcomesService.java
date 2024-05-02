package com.comp5703.yearnmove.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.comp5703.yearnmove.pojo.FaPhysicalOutcomes;

import java.util.List;
import java.util.Map;

public interface FaPhysicalOutcomesService extends IService<FaPhysicalOutcomes> {
    Map<String, String> calculateOutcomeRatios(List<Integer> recordIds);
}
