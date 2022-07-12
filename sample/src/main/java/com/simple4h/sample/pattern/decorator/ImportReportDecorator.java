package com.simple4h.sample.pattern.decorator;

/**
 * 导入报告
 *
 * @author Simple4H
 */
public class ImportReportDecorator extends ReportDecorator {
    public ImportReportDecorator(IReportService iReportService) {
        super(iReportService);
    }

    @Override
    public void generateReport() {
        System.out.println("导入报告");
        super.generateReport();
    }
}
