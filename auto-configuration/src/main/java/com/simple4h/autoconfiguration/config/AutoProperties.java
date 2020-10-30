package com.simple4h.autoconfiguration.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * author Create By Simple4H
 * date 2020-10-30 10:27
 */
@ConfigurationProperties(prefix = "simple4h.auto.configuration")
public class AutoProperties {

    public static final String DEFAULT_WORD = "Simple4H";

    private String word = DEFAULT_WORD;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
