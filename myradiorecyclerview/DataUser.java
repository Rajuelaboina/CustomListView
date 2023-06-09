package com.raju.myradiorecyclerview;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class DataUser implements Parcelable {
    int id;
    String name;

    public DataUser(int id, String name) {
        this.id = id;
        this.name = name;
    }

    protected DataUser(Parcel in) {
        id = in.readInt();
        name = in.readString();
    }


    public static final Creator<DataUser> CREATOR = new Creator<DataUser>() {
        @Override
        public DataUser createFromParcel(Parcel in) {
            return new DataUser(in);
        }

        @Override
        public DataUser[] newArray(int size) {
            return new DataUser[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
    }
}
