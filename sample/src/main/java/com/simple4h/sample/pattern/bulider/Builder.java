package com.simple4h.sample.pattern.bulider;

/**
 * TODO:
 *
 * @author Simple4H
 */
public abstract class Builder {

    public Report report = new Report();

    public abstract void buildScreening();

    public abstract void buildCommon();

    public abstract Report createReport();

    public Report construct() {
        buildScreening();
        buildCommon();
        return this.createReport();
    }
}
