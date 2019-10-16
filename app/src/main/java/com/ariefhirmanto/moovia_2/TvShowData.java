package com.ariefhirmanto.moovia_2;

import android.content.Context;

import java.util.ArrayList;

public class TvShowData {
    private Context context;
    public static String[] titleData;
    public static String[] releaseData;
    public static String[] ratingData;
    public static String[] photoData;
    public static String[] descriptionData;
    public static String[] urlData;

    public TvShowData(Context context) {
        this.context = context;
        titleData = context.getResources().getStringArray(R.array.tv_title);
        releaseData = context.getResources().getStringArray(R.array.tv_release);
        ratingData = context.getResources().getStringArray(R.array.tv_rating);
        photoData = context.getResources().getStringArray(R.array.tv_photo);
        descriptionData = context.getResources().getStringArray(R.array.tv_description);
        urlData = context.getResources().getStringArray(R.array.tv_url);
    }



    public static ArrayList<TvShow> getListData() {
        ArrayList<TvShow> list = new ArrayList<>();
        for (int data = 0; data < titleData.length; data++) {
            TvShow tvShow = new TvShow();

            tvShow.setTitle(titleData[data]);
            tvShow.setRating(ratingData[data]);
            tvShow.setRelease(releaseData[data]);
            tvShow.setPhoto(photoData[data]);
            tvShow.setDescription(descriptionData[data]);
            tvShow.setUrl(urlData[data]);

            list.add(tvShow);
        }

        return list;
    }
}
