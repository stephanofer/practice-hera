package com.stephanofer.practice.data.bootstrap;

public final class DataLayerInfo {

    private DataLayerInfo() {
    }

    public static String describe() {
        return "Data layer available: MySQL driver + HikariCP + Redis client wired in this module.";
    }
}
