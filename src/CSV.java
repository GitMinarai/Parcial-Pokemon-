
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSV {

    //Guardar
    public static void guardarEntrenadores(ArrayList<Trainer> entrenadores) {

        try {
            BufferedWriter escritor = new BufferedWriter(
                    new FileWriter("entrenadores.csv"));

            for (Trainer entrenador : entrenadores) {

                escritor.write(
                        entrenador.getId() + "," +
                                entrenador.name + "," +
                                entrenador.medals
                );

                escritor.newLine();
            }

            escritor.close();

        } catch (IOException e) {
            System.out.println("Mátrix error: " + e.getMessage());
        }
    }

    //Leer
    public static ArrayList<Trainer> leerEntrenadores() {

        ArrayList<Trainer> entrenadores = new ArrayList<>();

        try {
            BufferedReader lector = new BufferedReader(
                    new FileReader("entrenadores.csv"));

            String linea;

            while ((linea = lector.readLine()) != null) {

                String[] datos = linea.split(",");

                int id = Integer.parseInt(datos[0]);
                String nombre = datos[1];

                Trainer entrenador = new Trainer(id, nombre);

                String medallas = datos[2]
                        .replace("[", "")
                        .replace("]", "");

                if (!medallas.isEmpty()) {
                    String[] listaMedallas = medallas.split(", ");

                    for (String medalla : listaMedallas) {
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
}
