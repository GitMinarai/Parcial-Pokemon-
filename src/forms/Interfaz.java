package forms;

import Modelo.*;
import javax.swing.*;
import java.util.ArrayList;

public class Interfaz {

    private JTextField txtBusqueda;
    private JButton btnBuscar;
    private JLabel Título;
    private JPanel panelMedallas;
    private JPanel panelPokemones;
    private JPanel InfoTrainer;
    private JLabel lblId;
    private JLabel lblNombre;
    private JLabel lblCantidad;
    private JPanel mainPanel;

    private ArrayList<Trainer> entrenadores;

    public Interfaz() {

        entrenadores = CSV.leerEntrenadores();
        CSV.leerPokemones(entrenadores);

        btnBuscar.addActionListener(e -> buscarEntrenador());
    }

    private void buscarEntrenador() {

        String nombre = txtBusqueda.getText().trim();

        Trainer entrenador = CSV.buscarEntrenador(entrenadores, nombre);

        if (entrenador == null) {
            JOptionPane.showMessageDialog(null, "Entrenador no encontrado.");
            return;
        }

        lblNombre.setText("Nombre: " + entrenador.name);
        lblId.setText("ID: " + entrenador.getId());
        lblCantidad.setText("Pokémon: " + entrenador.pokemons.size());

        panelMedallas.removeAll();

        for (String medalla : entrenador.medals) {
            panelMedallas.add(new JLabel(medalla));
        }

        panelPokemones.removeAll();

        for (Pokemon pokemon : entrenador.pokemons) {
            panelPokemones.add(new JLabel(
                    pokemon.nombre + " | Nivel: " + pokemon.nivel
                            + " | Cantidad: " + pokemon.getNumeroPokemon()
            ));
        }

        panelMedallas.revalidate();
        panelMedallas.repaint();

        panelPokemones.revalidate();
        panelPokemones.repaint();

    }
    public JPanel getMainPanel() {
        return mainPanel;
    }
}

