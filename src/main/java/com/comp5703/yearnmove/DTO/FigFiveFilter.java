package com.comp5703.yearnmove.DTO;

import lombok.Data;

import java.util.List;

@Data
public class FigFiveFilter {
    private List<String> Balance;
    private List<String> Strength;
    private List<String> Walking;
    private List<String> Endurance;
    private List<String> paOutcomesReported;
    private List<String> fallsOutcomesReported;
    private List<String> intrinsicCapacityPhysicalDomainOutcomesReported;
    private List<String> faPhysicalDomainOutcomesReported;
    private List<String> faSocialDomainOutcomesReported;
    private List<String> faCognitiveEmotionalDomainOutcomesReported;
    private List<String> wellbeingAndQualityOfLifeOutcomesReported;
}
