package com.example.android.quakereport;

/**
 * Created by shivani on 6/26/2017.
 */

public class Earthquake {
    private String place;

    private long date;
    private double mag;
    private String url;
    public Earthquake(Double m,String p,long d,String u)
    {
        mag=m;

        place=p;
        url=u;
        date=d;
    }
    public String getPlace()
    {
        return place;
    }
    public long getDate() {
        return date;
    }
    public Double getMag() {
        return mag;
    }
    public String getUrl(){return url;}
}
