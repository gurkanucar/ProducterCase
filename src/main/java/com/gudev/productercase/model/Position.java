package com.gudev.productercase.model;

public enum Position {
    PG("Point guard"),
    SG("Shooting guard"),
    SF("Small forward"),
    PF("Power forward"),
    C("Center");

    public final String label;

    private Position(String label) {
        this.label = label;
    }


}
