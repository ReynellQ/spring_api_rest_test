package com.project.market_test.domain.dto;

import java.util.Map;

public interface AbstractDTO {
    boolean hasCorrectData();
    Map<String, String> showErrors();
}
