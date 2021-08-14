package unimagdalena.project.com.otrapracticamas.pojos;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ingenieros on 16/06/2016.
 */
public class Restaurante implements Parcelable {
    private String nombre;
    private String direccion;
    private int precioEnvio;
    private float calificacion;
    private String imagen;
    private ArrayList<Menu> menu;
    private ArrayList<Comentario> comentarios;
    private Coordenada coordenadas;
    private List<Restaurante>restaurantes;

    public Restaurante(String nombre, String direccion, int precioEnvio, float calificacion, String imagen, ArrayList<Menu> menu, ArrayList<Comentario> comentarios, Coordenada coordenadas) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.precioEnvio = precioEnvio;
        this.calificacion = calificacion;
        this.imagen = imagen;
        this.menu = menu;
        this.comentarios = comentarios;
        this.coordenadas = coordenadas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getPrecioEnvio() {
        return precioEnvio;
    }

    public void setPrecioEnvio(int precioEnvio) {
        this.precioEnvio = precioEnvio;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public ArrayList<Menu> getMenu() {
        return menu;
    }

    public void setMenu(ArrayList<Menu> menu) {
        this.menu = menu;
    }

    public ArrayList<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(ArrayList<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public Coordenada getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Coordenada coordenadas) {
        this.coordenadas = coordenadas;
    }

    public List<Restaurante> getRestaurantes() {
        return restaurantes;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nombre);
        dest.writeString(this.direccion);
        dest.writeInt(this.precioEnvio);
        dest.writeFloat(this.calificacion);
        dest.writeString(this.imagen);
        dest.writeTypedList(this.menu);
        dest.writeTypedList(this.comentarios);
        dest.writeParcelable(this.coordenadas, flags);
        dest.writeTypedList(this.restaurantes);
    }

    protected Restaurante(Parcel in) {
        this.nombre = in.readString();
        this.direccion = in.readString();
        this.precioEnvio = in.readInt();
        this.calificacion = in.readFloat();
        this.imagen = in.readString();
        this.menu = in.createTypedArrayList(Menu.CREATOR);
        this.comentarios = in.createTypedArrayList(Comentario.CREATOR);
        this.coordenadas = in.readParcelable(Coordenada.class.getClassLoader());
        this.restaurantes = in.createTypedArrayList(Restaurante.CREATOR);
    }

    public static final Creator<Restaurante> CREATOR = new Creator<Restaurante>() {
        @Override
        public Restaurante createFromParcel(Parcel source) {
            return new Restaurante(source);
        }

        @Override
        public Restaurante[] newArray(int size) {
            return new Restaurante[size];
        }
    };
}
