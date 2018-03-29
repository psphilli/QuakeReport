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

    // Time which the earthquake occurred
    private long mTimeInMilliseconds;

    // Time which the earthquake occurred
    private String mUrl;

    /**
     * Constructs a new {@link Earthquake} object.
     *
     * @param magnitude is the magnitude (size) of the earthquake
     * @param location is the location where the earthquake happened
     * @param timeInMilliseconds is the time in milliseconds (from the Epoch) when the
     *                           earthquake happened
     * @param url is the URL for the earthquake's USGS webpage
     */
    public Earthquake(double magnitude, String location, long timeInMilliseconds, String url)
    {
        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMilliseconds = timeInMilliseconds;
        mUrl = url;
    }

    /**
     * Returns the magnitude of the earthquake.
     */
    public double getMagnitude() {
        return mMagnitude;
    }

    /**
     * Returns the earthquake location
     */
    public String getLocation() {
        return mLocation;
    }

    /**
     * Returns the time of the earthquake.
     */
    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

    /**
     * Returns the USGS webpage for the earthquake.
     */
    public String getUrl() {
        return mUrl;
    }
}
