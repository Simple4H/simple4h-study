package com.simple4h.sample.pattern.decorator;

import com.simple4h.sample.pattern.decorator.impl.CommonReportImpl;

/**
 * TODO:
 *
 * @author Simple4H
 */
public class Test {

    public static void main(String[] args) {

        CommonReportImpl iReportService = new CommonReportImpl();
        ReportDecorator reportDecorator = new ImportReportDecorator(iReportService);
        reportDecorator.generateReport();
    }
}
