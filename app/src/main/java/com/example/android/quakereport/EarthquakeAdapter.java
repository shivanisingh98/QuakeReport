package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;



public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> infos) {
        super(context, 0, infos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null) {

            listItemView = LayoutInflater.from(getContext()).inflate(

                    R.layout.list_item, parent, false);

        }


        Earthquake currentInfo = getItem(position);
        Double m=currentInfo.getMag();
        DecimalFormat magnit=new DecimalFormat("0.0");
        String magtodisplay=magnit.format(m);

        TextView magTextView = (TextView) listItemView.findViewById(R.id.magnitude);
        magTextView.setText(magtodisplay);
        GradientDrawable magnitudeCircle = (GradientDrawable) magTextView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentInfo.getMag());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);
        TextView placeTextView = (TextView) listItemView.findViewById(R.id.location);
        placeTextView.setText(currentInfo.getPlace());
        TextView timeTextView = (TextView) listItemView.findViewById(R.id.date);
        TextView hourTextView = (TextView) listItemView.findViewById(R.id.time);


        Long dateToDisplay =currentInfo.getDate();
        Date dateObject =new Date(dateToDisplay);
        SimpleDateFormat dateFormatter=new SimpleDateFormat("MMM dd,yyyy");
        String date=dateFormatter.format(dateObject);
        SimpleDateFormat timeFormatter=new SimpleDateFormat("h:mm aa");
        hourTextView.setText(timeFormatter.format(dateObject));
        timeTextView.setText(date);


        return listItemView;

    }
    public int getMagnitudeColor(double m)
    {
        if(m<=2)
            return ContextCompat.getColor(getContext(), R.color.magnitude1);
        else if(m<=3&&m>2)
            return ContextCompat.getColor(getContext(), R.color.magnitude2);
        else if(m<=4&&m>3)
            return ContextCompat.getColor(getContext(), R.color.magnitude3);
       else  if(m<=5&&m>4)
            return ContextCompat.getColor(getContext(), R.color.magnitude4);
        else if(m<=6&&m>5)
            return ContextCompat.getColor(getContext(), R.color.magnitude5);
        else if(m<=7&&m>6)
            return ContextCompat.getColor(getContext(), R.color.magnitude6);
        else if(m<=8&&m>7)
            return ContextCompat.getColor(getContext(), R.color.magnitude7);
        else if (m<=9&&m>8)
            return ContextCompat.getColor(getContext(), R.color.magnitude8);
        else if(m<=10&&m>9)
            return ContextCompat.getColor(getContext(), R.color.magnitude9);
        else
            return ContextCompat.getColor(getContext(), R.color.magnitude10plus);

    }
}

