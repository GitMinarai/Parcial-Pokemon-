import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // Entrenador
        Trainer ash = new Trainer(1, "Ash");

        // Pokemones
        Pokemon pikachu = new Pokemon(1, 1, "Pikachu", "Electrico", 67, "Ash");
        Pokemon charizard = new Pokemon(2, 1, "Charizard", "Fuego", 69, "Ash");

        // Asignacion
        ash.addPokemon(pikachu);
        ash.addPokemon(charizard);

        // Medallas
        ash.addMedal("Roca");
        ash.addMedal("Arcoiris");
        ash.addMedal("Alma");

        // Lista de entrenadores
        ArrayList<Trainer> entrenadores = new ArrayList<>();
        entrenadores.add(ash);

        // Guardar en CSV
        CSV.guardarEntrenadores(entrenadores);
        CSV.guardarPokemones(entrenadores);

        // Leer CSV
        ArrayList<Trainer> recuperados = CSV.leerEntrenadores();
        CSV.leerPokemones(recuperados);

        // Print
        for (Trainer entrenador : recuperados) {

            System.out.println(entrenador);

            for (Pokemon pokemon : entrenador.pokemons) {
                System.out.println(pokemon);
            }
        }
    }
}