package com.example.android.quakereport;

import java.util.Date;

/**
 * {@link Earthquake} represents information for a single earth quake.
 * Each object has 3 properties: magnitude, location, and event date.
 */
public class Earthquake {

    // Magnitude of the earthquake
    private double mMagnitude;

    // Location where the earthquake occurred
    private String mLocation;

    // Date which the earthquake occurred
    private String mEventDate;

    /*
    * Create a new Earthquake object.
    *
    * @param magnitude is the magnitude of the earthquake
    * @param location is the location where the earthquake occurred
    * @param eventDate is date which the earthquake occurred
    * */
    public Earthquake(double magnitude, String location, String eventDate)
    {
        mMagnitude = magnitude;
        mLocation = location;
        mEventDate = eventDate;
    }

    /**
     * Get the name of the earthquake magnitude
     */
    public double getMagnitude() {
        return mMagnitude;
    }

    /**
     * Get the earthquake location
     */
    public String getLocation() {
        return mLocation;
    }

    /**
     * Get the earthquake event date
     */
    public String getEventDate() {
        return mEventDate;
    }
}
