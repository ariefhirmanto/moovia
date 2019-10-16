package com.ariefhirmanto.moovia_2;

import android.os.Parcel;
import android.os.Parcelable;

public class TvShow implements Parcelable {
    private String photo;
    private String title;
    private String release;
    private String rating;
    private String description;
    private String url;

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.photo);
        dest.writeString(this.title);
        dest.writeString(this.release);
        dest.writeString(this.rating);
        dest.writeString(this.description);
        dest.writeString(this.url);
    }

    public TvShow() {
    }

    protected TvShow(Parcel in) {
        this.photo = in.readString();
        this.title = in.readString();
        this.release = in.readString();
        this.rating = in.readString();
        this.description = in.readString();
        this.url = in.readString();
    }

    public static final Parcelable.Creator<TvShow> CREATOR = new Parcelable.Creator<TvShow>() {
        @Override
        public TvShow createFromParcel(Parcel source) {
            return new TvShow(source);
        }

        @Override
        public TvShow[] newArray(int size) {
            return new TvShow[size];
        }
    };
}
