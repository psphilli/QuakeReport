package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/*
* {@link EarthquakeAdapter} is an {@link ArrayAdapter} that can provide the layout for each list
* based on a data source, which is a list of {@link Earthquake} objects.
* */
class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param earthquakes A List of AndroidFlavor objects to display in a list
     */
    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_list_item, parent, false);
        }

        // Get the {@link Earthquake} object located at this position in the list
        Earthquake currentEarthquake = getItem(position);

        // Find the magnitude TextView in the earthquake_list_item_list_item.xml layout and set value
        TextView magnitudeView = listItemView.findViewById(R.id.magnitude);
        DecimalFormat formatter = new DecimalFormat("0.00");
        magnitudeView.setText(formatter.format(currentEarthquake.getMagnitude()));

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor =  ContextCompat.getColor(getContext(), getMagnitudeColor(currentEarthquake.getMagnitude()));

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        // Find the location TextViews in the earthquake_list_item.xmlst_item.xml layout and set value
        TextView locationOffsetTextView = listItemView.findViewById(R.id.location_offset);
        TextView primaryLocationTextView = listItemView.findViewById(R.id.primary_location);
        String[] location = currentEarthquake.getLocation().split(" of ");
        if (location.length == 1)
        {
            locationOffsetTextView.setText(R.string.near_the);
            primaryLocationTextView.setText(location[0]);
        } else {
            locationOffsetTextView.setText(location[0]);
            primaryLocationTextView.setText(location[1]);
        }

        // Create a new Date object from the time in milliseconds of the earthquake
        Date dateObject = new Date(currentEarthquake.getTimeInMilliseconds());

        // Find the TextView with view ID date
        TextView dateView = listItemView.findViewById(R.id.date);
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateObject);
        // Display the date of the current earthquake in that TextView
        dateView.setText(formattedDate);

        // Find the TextView with view ID time
        TextView timeView = listItemView.findViewById(R.id.time);
        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(dateObject);
        // Display the time of the current earthquake in that TextView
        timeView.setText(formattedTime);
        // Return the whole list item layout
        // so that it can be shown in the ListView
        return listItemView;
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy", Locale.US);
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a", Locale.US);
        return timeFormat.format(dateObject);
    }

    /**
     * Return the formatted color associated to the given magnitude.
     */
    private int getMagnitudeColor(double magnitude)
    {
        switch ((int) magnitude) {
            case 0 :
            case 1 :
                return R.color.magnitude1;
            case 2 :
                return R.color.magnitude2;
            case 3 :
                return R.color.magnitude3;
            case 4 :
                return R.color.magnitude4;
            case 5 :
                return R.color.magnitude5;
            case 6 :
                return R.color.magnitude6;
            case 7 :
                return R.color.magnitude7;
            case 8 :
                return R.color.magnitude8;
            case 9 :
                return R.color.magnitude9;
            default :
                return R.color.magnitude10plus;
        }
    }
}
