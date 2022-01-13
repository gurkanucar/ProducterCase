package com.gudev.productercase.model;

public enum Position {
    PG("PG"),
    SG("SG"),
    SF("SF"),
    PF("PF"),
    C("Center");

    public final String label;

    private Position(String label) {
        this.label = label;
    }


}
