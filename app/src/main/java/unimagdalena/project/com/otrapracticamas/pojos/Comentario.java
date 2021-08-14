package unimagdalena.project.com.otrapracticamas.pojos;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Ingenieros on 16/06/2016.
 */
public class Comentario implements Parcelable{
    private String nombre;
    private String comentario;
    private List<Comentario>comentarios;

    public Comentario(String nombre, String comentario) {
        this.nombre = nombre;
        this.comentario = comentario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nombre);
        dest.writeString(this.comentario);
        dest.writeTypedList(this.comentarios);
    }

    protected Comentario(Parcel in) {
        this.nombre = in.readString();
        this.comentario = in.readString();
        this.comentarios = in.createTypedArrayList(Comentario.CREATOR);
    }

    public static final Creator<Comentario> CREATOR = new Creator<Comentario>() {
        @Override
        public Comentario createFromParcel(Parcel source) {
            return new Comentario(source);
        }

        @Override
        public Comentario[] newArray(int size) {
            return new Comentario[size];
        }
    };
}
