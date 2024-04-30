package com.comp5703.yearnmove.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.comp5703.yearnmove.pojo.IntrinsicCapacityOutcomes;

import java.util.List;
import java.util.Map;

public interface IntrinsicCapacityOutcomesService extends IService<IntrinsicCapacityOutcomes>{
    Map<String, String> calculateOutcomeRatios(List<Integer> recordIds);
}
