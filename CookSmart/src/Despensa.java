import java.util.HashMap;

public class Despensa {
    private HashMap<String, Ingrediente> items;

    public Despensa() {
        items = new HashMap<>();
    }

    // Agregar un ingrediente a la despensa
    public void agregar(Ingrediente ingrediente) {
        items.put(ingrediente.getNombre(), ingrediente);
    }

    // Verificar si la despensa contiene un ingrediente por su nombre
    public boolean contiene(String nombreIngrediente) {
        return items.containsKey(nombreIngrediente);
    }
}