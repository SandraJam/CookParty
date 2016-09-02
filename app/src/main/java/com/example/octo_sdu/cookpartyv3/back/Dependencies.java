package com.example.octo_sdu.cookpartyv3.back;

public class Dependencies {
    public MainComponent mainComponent;
    public static Dependencies instance;

    public Dependencies(MainComponent mainComponent) {
        this.mainComponent = mainComponent;
    }

    public static void init () {
        instance = new Dependencies(DaggerMainComponent.create());
    }

}
