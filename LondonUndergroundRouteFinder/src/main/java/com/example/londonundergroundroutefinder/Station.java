package com.example.londonundergroundroutefinder;

public class Station {
private int id;
private double latitude;
private double longitude;
private String stationName;
private String displayName;
private int zone;
private int totalLines;
private int rail;

    public Station(int id,double latitude, double longitude, String stationName, String displayName, int zone, int totalLines, int rail) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.stationName = stationName;
        this.displayName = displayName;
        this.zone = zone;
        this.totalLines = totalLines;
        this.rail = rail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getZone() {
        return zone;
    }

    public void setZone(int zone) {
        this.zone = zone;
    }

    public int getTotalLines() {
        return totalLines;
    }

    public void setTotalLines(int totalLines) {
        this.totalLines = totalLines;
    }

    public int getRail() {
        return rail;
    }

    public void setRail(int rail) {
        this.rail = rail;
    }

    @Override
    public String toString() {
        return "Station{" +
                "id=" + id +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", stationName='" + stationName + '\'' +
                ", displayName='" + displayName + '\'' +
                ", zone=" + zone +
                ", totalLines=" + totalLines +
                ", rail=" + rail +
                '}';
    }
}
