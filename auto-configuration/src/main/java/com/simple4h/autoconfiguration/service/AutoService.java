package com.simple4h.autoconfiguration.service;

/**
 * author Create By Simple4H
 * date 2020-10-30 10:24
 */
public class AutoService {

    public String word;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String sayWhat() {
        return "Hello " + word;
    }
}
