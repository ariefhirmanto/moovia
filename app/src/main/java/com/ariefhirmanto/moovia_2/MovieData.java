package com.ariefhirmanto.moovia_2;

import android.content.Context;

import java.util.ArrayList;

public class MovieData {
    private Context context;
    public static String[] titleData;
    public static String[] starringData;
    public static String[] ratingData;
    public static String[] descriptionData;
    public static String[] photoData;
    public static String[] urlData;

    public MovieData(Context context) {
        this.context = context;
        titleData = context.getResources().getStringArray(R.array.title);
        starringData = context.getResources().getStringArray(R.array.starring);
        ratingData = context.getResources().getStringArray(R.array.rating);
        descriptionData = context.getResources().getStringArray(R.array.description);
        photoData = context.getResources().getStringArray(R.array.photo);
        urlData = context.getResources().getStringArray(R.array.url);
    }



    public static ArrayList<Movie> getListData() {
        ArrayList<Movie> list = new ArrayList<>();
        for (int data = 0; data < titleData.length; data++) {
            Movie movie = new Movie();

            movie.setTitle(titleData[data]);
            movie.setStarring(starringData[data]);
            movie.setRating(ratingData[data]);
            movie.setDescription(descriptionData[data]);
            movie.setPhoto(photoData[data]);
            movie.setUrl(urlData[data]);

            list.add(movie);
        }

        return list;
    }
}
