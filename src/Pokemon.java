public class Pokemon {

    private int id;
    private int numeroPokemon;
    public String nombre;
    public String tipo;
    public int nivel;
    public String nombreEntrenador;


    public Pokemon(int id, int numeroPokemon, String nombre,
                   String tipo, int nivel, String nombreEntrenador) {

        this.id = id;
        this.numeroPokemon = numeroPokemon;
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivel = nivel;
        this.nombreEntrenador = nombreEntrenador;
    }


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
                " | Numero: " + numeroPokemon +
                " | Tipo: " + tipo +
                " | Nivel: " + nivel +
                " | Entrenador: " + nombreEntrenador;
    }
}
