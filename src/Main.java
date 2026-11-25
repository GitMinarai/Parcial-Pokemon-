import forms.Interfaz;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            Interfaz interfaz = new Interfaz();

            JFrame ventana = new JFrame("Pokémon - Gestor de entrenadores");

            ventana.setContentPane(interfaz.getMainPanel());
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.pack();
            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);

        });
    }
}