package unimagdalena.project.com.otrapracticamas.pojos;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Ingenieros on 16/06/2016.
 */
public class Menu implements Parcelable {
    private String nombre;
    private String imagen;
    private int precio;
    private String descripcion;
    private List<Menu>menu;

    public Menu(String nombre, String imagen, int precio, String descripcion) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Menu> getMenu() {
        return menu;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nombre);
        dest.writeString(this.imagen);
        dest.writeInt(this.precio);
        dest.writeString(this.descripcion);
        dest.writeTypedList(this.menu);
    }

    protected Menu(Parcel in) {
        this.nombre = in.readString();
        this.imagen = in.readString();
        this.precio = in.readInt();
        this.descripcion = in.readString();
        this.menu = in.createTypedArrayList(Menu.CREATOR);
    }

    public static final Creator<Menu> CREATOR = new Creator<Menu>() {
        @Override
        public Menu createFromParcel(Parcel source) {
            return new Menu(source);
        }

        @Override
        public Menu[] newArray(int size) {
            return new Menu[size];
        }
    };
}
