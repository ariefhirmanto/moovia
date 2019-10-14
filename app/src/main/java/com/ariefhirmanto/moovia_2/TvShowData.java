package com.ariefhirmanto.moovia_2;

import android.content.Context;

import java.util.ArrayList;

public class TvShowData {
    private Context context;
    public static String[] titleData;
    public static String[] actorData;
    public static String[] descriptionData;
    public static String[] photoData;

    public TvShowData(Context context) {
        this.context = context;
        titleData = context.getResources().getStringArray(R.array.title);
        actorData = context.getResources().getStringArray(R.array.starring);
        descriptionData = context.getResources().getStringArray(R.array.description);
        photoData = context.getResources().getStringArray(R.array.photo);
    }



    public static ArrayList<TvShow> getListData() {
        ArrayList<TvShow> list = new ArrayList<>();
        for (int data = 0; data < titleData.length; data++) {
            TvShow tvShow = new TvShow();

            tvShow.setTitle(titleData[data]);
            tvShow.setActor(actorData[data]);
            tvShow.setDescription(descriptionData[data]);
            tvShow.setPhoto(photoData[data]);

            list.add(tvShow);
        }

        return list;
    }
}
