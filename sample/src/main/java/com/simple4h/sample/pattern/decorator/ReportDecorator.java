package com.simple4h.sample.pattern.decorator;

/**
 * 装饰器
 *
 * @author Simple4H
 */
public abstract class ReportDecorator implements IReportService {

    private final IReportService iReportService;

    public ReportDecorator(IReportService iReportService) {
        this.iReportService = iReportService;
    }

    @Override
    public void generateReport() {
        iReportService.generateReport();
    }
}
