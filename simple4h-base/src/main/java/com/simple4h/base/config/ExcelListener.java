package com.simple4h.base.config;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Excel监听
 *
 * @author Simple4H
 */
@Slf4j
@Getter
public class ExcelListener extends AnalysisEventListener<Map<Integer, String>> {

    private final List<Map<Integer, String>> excelDataList = new ArrayList<>();

    private final List<String> heahderList = new ArrayList<>();


    @Override
    public void invoke(Map<Integer, String> data, AnalysisContext analysisContext) {
        excelDataList.add(data);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        headMap.forEach((k, v) -> heahderList.add(v));
    }

    public void checkHeader(List<String> correctHeader) {

        for (int i = 0; i < correctHeader.size(); i++) {
            if (!StringUtils.equals(correctHeader.get(i), heahderList.get(i))) {
                throw new RuntimeException("模板错误");
            }
        }

    }
}
