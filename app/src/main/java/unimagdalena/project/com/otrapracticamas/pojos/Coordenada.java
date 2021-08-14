package unimagdalena.project.com.otrapracticamas.pojos;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ingenieros on 27/06/2016.
 */
public class Coordenada implements Parcelable {
    private double lat;
    private double lon;

    public Coordenada(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(this.lat);
        dest.writeDouble(this.lon);
    }

    protected Coordenada(Parcel in) {
        this.lat = in.readDouble();
        this.lon = in.readDouble();
    }

    public static final Creator<Coordenada> CREATOR = new Creator<Coordenada>() {
        @Override
        public Coordenada createFromParcel(Parcel source) {
            return new Coordenada(source);
        }

        @Override
        public Coordenada[] newArray(int size) {
            return new Coordenada[size];
        }
    };
}
