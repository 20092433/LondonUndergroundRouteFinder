package com.example.londonundergroundroutefinder;

public class Routes {
    private int lineId;
    private String routeName;
    private String colour;
    private String stripe;

    public Routes(int lineId, String routeName, String colour, String stripe) {
        this.lineId = lineId;
        this.routeName = routeName;
        this.colour = colour;
        this.stripe = stripe;
    }

    public int getLineId() {
        return lineId;
    }

    public void setLineId(int lineId) {
        this.lineId = lineId;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getStripe() {
        return stripe;
    }

    public void setStripe(String stripe) {
        this.stripe = stripe;
    }

    @Override
    public String toString() {
        return "Routes{" +
                "lineId='" + lineId + '\'' +
                ", routeName='" + routeName + '\'' +
                ", colour='" + colour +
                ", stripe='" + stripe +
                '}';
    }
}
