package com.simple4h.sample.pattern.bulider;

/**
 * TODO:
 *
 * @author Simple4H
 */
public class kindergartenBuilder extends Builder {
    @Override
    public void buildScreening() {
        report.setScreening("幼儿园-筛查");
    }

    @Override
    public void buildCommon() {
        report.setCommon("幼儿园-常见病");
    }

    @Override
    public Report createReport() {
        return report;
    }
}
