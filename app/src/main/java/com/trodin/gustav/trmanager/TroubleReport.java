package com.trodin.gustav.trmanager;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Trouble Report POJO
 *
 * Created by Gustav Trodin on 2014-09-17.
 */
public class TroubleReport implements Parcelable {

    private String id;
    private Boolean isSolved;

    public TroubleReport(String id){
        this.id = id;
        this.isSolved = false;
    }

    public String getId() {
        return id;
    }

    public boolean isSolved() {
        return isSolved;
    }

    public void setSolved(boolean isSolved) {
        this.isSolved = isSolved;
    }

    @Override
    public String toString() {
        return "TR ID: " + this.id + " IS TR SOLVED: " + this.isSolved;
    }

    //Parcel part
    public TroubleReport(Parcel in) {
        this.id = in.readString();
        this.isSolved = false;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int i) {
        out.writeString(this.id);
        out.writeString(this.isSolved.toString());
    }

    public static final Parcelable.Creator<TroubleReport> CREATOR = new Parcelable.Creator<TroubleReport>(){

        @Override
        public TroubleReport createFromParcel(Parcel in) {
            return new TroubleReport(in);
        }

        @Override
        public TroubleReport[] newArray(int size) {
            return new TroubleReport[size];
        }
    };
}