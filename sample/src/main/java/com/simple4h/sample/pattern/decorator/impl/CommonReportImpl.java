package com.simple4h.sample.pattern.decorator.impl;

import com.simple4h.sample.pattern.decorator.IReportService;

/**
 * 常见病
 *
 * @author Simple4H
 */
public class CommonReportImpl implements IReportService {
    @Override
    public void generateReport() {
        System.out.println("常见病");
    }
}
