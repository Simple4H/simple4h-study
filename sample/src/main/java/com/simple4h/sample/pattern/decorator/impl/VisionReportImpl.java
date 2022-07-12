package com.simple4h.sample.pattern.decorator.impl;

import com.simple4h.sample.pattern.decorator.IReportService;

/**
 * 视力报告
 *
 * @author Simple4H
 */
public class VisionReportImpl implements IReportService {
    @Override
    public void generateReport() {
        System.out.println("视力筛查报告");
    }
}
