import java.util.ArrayList;
public class Main {

    public static void main(String[] args) {
        //Entrenador
        Trainer ash = new Trainer(1, "Ash");
        //Pokemones
        Pokemon pikachu = new Pokemon(1, 1, "Pikachu", "Electrico", 67, "Ash");
        Pokemon charizard = new Pokemon(2, 1, "Charizard", "Fuego", 69, "Ash");

        //Asignación
        ash.addPokemon(pikachu);
        ash.addPokemon(charizard);

        //Medallas
        ash.addMedal("Roca");
        ash.addMedal("Arcoiris");
        ash.addMedal("Alma");

        //Print
        System.out.println(ash);

        for (Pokemon pokemon : ash.pokemons) {
            System.out.println(pokemon);
        }

        //Guardar en el CSV

        ArrayList<Trainer> entrenadores = new ArrayList<>();

        entrenadores.add(ash);

        CSV.guardarEntrenadores(entrenadores);

        //Leer el CSV

        ArrayList<Trainer> recuperados = CSV.leerEntrenadores();

        for (Trainer entrenador : recuperados) {
            System.out.println("Recuperado: " + entrenador);
        }
    }

}
