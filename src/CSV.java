import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSV {

    // Guardar entrenadores

    public static void guardarEntrenadores(ArrayList<Trainer> entrenadores) {

        try {
            BufferedWriter escritor = new BufferedWriter(
                    new FileWriter("entrenadores.csv"));

            for (Trainer entrenador : entrenadores) {

                String medallas = String.join("|", entrenador.medals);

                escritor.write(
                        entrenador.getId() + ";" +
                                entrenador.name + ";" +
                                medallas
                );

                escritor.newLine();
            }

            escritor.close();

        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    // Leer entrenadores

    public static ArrayList<Trainer> leerEntrenadores() {

        ArrayList<Trainer> entrenadores = new ArrayList<>();

        try {
            BufferedReader lector = new BufferedReader(
                    new FileReader("entrenadores.csv"));

            String linea;

            while ((linea = lector.readLine()) != null) {

                String[] datos = linea.split(";", -1);

                int id = Integer.parseInt(datos[0]);
                String nombre = datos[1];

                Trainer entrenador = new Trainer(id, nombre);

                if (!datos[2].isEmpty()) {

                    String[] medallas = datos[2].split("\\|");

                    for (String medalla : medallas) {
                        entrenador.addMedal(medalla);
                    }
                }

                entrenadores.add(entrenador);
            }

            lector.close();

        } catch (IOException e) {
            System.out.println("Error al leer: " + e.getMessage());
        }

        return entrenadores;
    }

    // Guardar Pokemones

    public static void guardarPokemones(ArrayList<Trainer> entrenadores) {

        try {
            BufferedWriter escritor = new BufferedWriter(
                    new FileWriter("pokemones.csv"));

            for (Trainer entrenador : entrenadores) {

                for (Pokemon pokemon : entrenador.pokemons) {

                    escritor.write(
                            pokemon.getId() + ";" +
                                    pokemon.getNumeroPokemon() + ";" +
                                    pokemon.nombre + ";" +
                                    pokemon.tipo + ";" +
                                    pokemon.nivel + ";" +
                                    pokemon.nombreEntrenador
                    );

                    escritor.newLine();
                }
            }

            escritor.close();

        } catch (IOException e) {
            System.out.println("Error al guardar Pokémon: " + e.getMessage());
        }
    }

    // Leer Pokemones

    public static void leerPokemones(ArrayList<Trainer> entrenadores) {

        try {
            BufferedReader lector = new BufferedReader(
                    new FileReader("pokemones.csv"));

            String linea;

            while ((linea = lector.readLine()) != null) {

                String[] datos = linea.split(";");

                int id = Integer.parseInt(datos[0]);
                int cantidad = Integer.parseInt(datos[1]);
                String nombre = datos[2];
                String tipo = datos[3];
                int nivel = Integer.parseInt(datos[4]);
                String nombreEntrenador = datos[5];

                Pokemon pokemon = new Pokemon(
                        id, cantidad, nombre, tipo, nivel, nombreEntrenador);

                for (Trainer entrenador : entrenadores) {

                    if (entrenador.name.equals(nombreEntrenador)) {
                        entrenador.addPokemon(pokemon);
                        break;
                    }
                }
            }

            lector.close();

        } catch (IOException e) {
            System.out.println("Error al leer Pokémon: " + e.getMessage());
        }
    }

    // Búsqueda Entrenador

    public static Trainer buscarEntrenador(ArrayList<Trainer> entrenadores, String nombre) {

        for (Trainer entrenador : entrenadores) {

            if (entrenador.name.equalsIgnoreCase(nombre)) {
                return entrenador;
            }
        }

        return null;
    }

    // Búsqueda Pokemones

    public static Pokemon buscarPokemon(ArrayList<Trainer> entrenadores, String nombre) {

        for (Trainer entrenador : entrenadores) {

            for (Pokemon pokemon : entrenador.pokemons) {

                if (pokemon.nombre.equalsIgnoreCase(nombre)) {
                    return pokemon;
                }
            }
        }

        return null;
    }
}
