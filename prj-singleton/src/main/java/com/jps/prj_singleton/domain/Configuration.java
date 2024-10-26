package com.jps.prj_singleton.domain;

public class Configuration {
    private static Configuration instance;

    private Configuration(){

    }
    public static Configuration getInstance(){
        if (instance == null) {
            instance = new Configuration();

        }
        return instance;
    }
    public static void resetInstance() {
        instance = null;
    }
}
