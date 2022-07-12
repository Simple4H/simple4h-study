package com.simple4h.sample.pattern.bulider;

/**
 * TODO:
 *
 * @author Simple4H
 */
public class PrimaryBuilder extends Builder {
    @Override
    public void buildScreening() {
        report.setScreening("小学以上-筛查");
    }

    @Override
    public void buildCommon() {
        report.setCommon("小学以上-常见病");
    }

    @Override
    public Report createReport() {
        return report;
    }
}
