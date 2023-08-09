package challenge;

public class Country {
    private String nombre;

    /**
     * 
     * 
     * constructor vacio
     */
    public Country() {
    }

    /**
     * 
     * 
     * constructor con parametro
     */
    public Country(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Country{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
