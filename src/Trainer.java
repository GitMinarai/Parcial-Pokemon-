
import java.util.ArrayList;

public class Trainer {

    private int id;
    public String name;
    public ArrayList<Pokemon> pokemons;
    public ArrayList<String> medals;


    public Trainer(int id, String name) {
        this.id = id;
        this.name = name;
        this.pokemons = new ArrayList<>();
        this.medals = new ArrayList<>();
    }


    public int getId() {
        return id;
    }


    public void addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
    }


    public void addMedal(String medal) {
        medals.add(medal);
    }

    @Override
    public String toString() {
        return "Trainer: " + name +
                " | ID: " + id +
                " | Cantidad de Pokemon: " + pokemons.size() +
                " | Medallas: " + medals;
    }
}
