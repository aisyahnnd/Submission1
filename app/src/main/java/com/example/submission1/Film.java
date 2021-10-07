package com.example.submission1;

import android.os.Parcel;
import android.os.Parcelable;

public class Film implements Parcelable {
    private int photo;
    private int star;
    private String name;
    private String description;
    private String genre;

    int getPhoto() {
        return photo;
    }

    void setPhoto(int photo) {
        this.photo = photo;
    }

    int getStar() {
        return star;
    }

    void setStar(int star) {
        this.star = star;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }

    String getGenre() {
        return genre;
    }

    void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.photo);
        dest.writeInt(this.star);
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeString(this.genre);
    }

    Film() {
    }

    private Film(Parcel in) {
        this.photo = in.readInt();
        this.star = in.readInt();
        this.name = in.readString();
        this.description = in.readString();
        this.genre = in.readString();
    }

    public static final Parcelable.Creator<Film> CREATOR = new Parcelable.Creator<Film>() {
        @Override
        public Film createFromParcel(Parcel source) {
            return new Film(source);
        }

        @Override
        public Film[] newArray(int size) {
            return new Film[size];
        }
    };
}
