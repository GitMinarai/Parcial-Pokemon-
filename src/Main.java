import java.util.ArrayList;
import Modelo.*;
import forms.Interfaz;
import Modelo.CSV;
import Modelo.Pokemon;
import Modelo.Trainer;

public class Main {

    public static void main(String[] args) {

        // Entrenador
        Trainer ash = new Trainer(1, "Ash");

        // Pokemones
        Pokemon pikachu = new Pokemon(1, 1, "Pikachu", "Electrico", 67, "Ash");
        Pokemon charizard = new Pokemon(2, 1, "Charizard", "Fuego", 69, "Ash");

        // Asignación
        ash.addPokemon(pikachu);
        ash.addPokemon(charizard);

        // Medallas
        ash.addMedal("Roca");
        ash.addMedal("Arcoiris");
        ash.addMedal("Alma");

        // Lista de entrenadores
        ArrayList<Trainer> entrenadores = new ArrayList<>();
        entrenadores.add(ash);

        // Guardar en Modelo.CSV
        CSV.guardarEntrenadores(entrenadores);
        CSV.guardarPokemones(entrenadores);

        // Leer Modelo.CSV
        ArrayList<Trainer> recuperados = CSV.leerEntrenadores();
        CSV.leerPokemones(recuperados);

        // Print
        for (Trainer entrenador : recuperados) {

            System.out.println(entrenador);

            for (Pokemon pokemon : entrenador.pokemons) {
                System.out.println(pokemon);
            }
        }

        // Buscar entrenador

        Trainer encontrado = CSV.buscarEntrenador(recuperados, "Ash");

        if (encontrado != null) {
            System.out.println("Entrenador encontrado: " + encontrado);
        } else {
            System.out.println("Entrenador no encontrado.");
        }

        // Buscar Modelo.Pokemon

        Pokemon encontradoPokemon = CSV.buscarPokemon(recuperados, "Pikachu");

        if (encontradoPokemon != null) {
            System.out.println("Modelo.Pokemon encontrado: " + encontradoPokemon);
        } else {
            System.out.println("Modelo.Pokemon no encontrado.");
        }
    }
}