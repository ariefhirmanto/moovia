package com.ariefhirmanto.moovia_3;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private String photo;
    private String title;
    private String starring;
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

    public String getStarring() {
        return starring;
    }

    public void setStarring(String starring) {
        this.starring = starring;
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
        dest.writeString(this.starring);
        dest.writeString(this.rating);
        dest.writeString(this.description);
        dest.writeString(this.url);
    }

    public Movie() {
    }

    protected Movie(Parcel in) {
        this.photo = in.readString();
        this.title = in.readString();
        this.starring = in.readString();
        this.rating = in.readString();
        this.description = in.readString();
        this.url = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
