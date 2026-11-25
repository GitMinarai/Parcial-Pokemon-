public class Pokemon {

    //Variables
    private int id;
    private int numeroPokemon;
    public String nombre;
    public String tipo;
    public int nivel;
    public String nombreEntrenador;

    //Constructor
    public Pokemon(int id, int numeroPokemon, String nombre,
                   String tipo, int nivel, String nombreEntrenador) {

        this.id = id;
        this.numeroPokemon = numeroPokemon;
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivel = nivel;
        this.nombreEntrenador = nombreEntrenador;
    }

    //Encapsulamiento
    public int getId() {
        return id;
    }

    public int getNumeroPokemon() {
        return numeroPokemon;
    }

    @Override
    public String toString() {
        return "Pokemon: " + nombre +
                " | ID: " + id +
                " | Cantidad: " + numeroPokemon +
                " | Tipo: " + tipo +
                " | Nivel: " + nivel +
                " | Entrenador: " + nombreEntrenador;
    }
}
