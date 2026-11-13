import java.util.*;

public class Receta {
    private String nombre;
    private List<Ingrediente> ingredientesRequeridos;
    private List<String> pasos;

    public Receta(String nombre, List<Ingrediente> ingredientesRequeridos, List<String> pasos) {
        this.nombre = nombre;
        this.ingredientesRequeridos = ingredientesRequeridos;
        this.pasos = pasos;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Ingrediente> getIngredientesRequeridos() {
        return ingredientesRequeridos;
    }

    public List<String> getPasos() {
        return pasos;
    }

    // Cuenta cuántos ingredientes requeridos tiene el usuario en su despensa
    public int contarIngredientesDisponibles(Despensa despensa) {
        int encontrados = 0;
        for (int i = 0; i < ingredientesRequeridos.size(); i++) {
            Ingrediente ing = ingredientesRequeridos.get(i);
            if (despensa.contiene(ing.getNombre())) {
                encontrados++;
            }
        }
        return encontrados;
    }

    // Devuelve los ingredientes faltantes
    public List<String> obtenerIngredientesFaltantes(Despensa despensa) {
        List<String> faltantes = new ArrayList<>();
        for (int i = 0; i < ingredientesRequeridos.size(); i++) {
            Ingrediente ing = ingredientesRequeridos.get(i);
            if (!despensa.contiene(ing.getNombre())) {
                faltantes.add(ing.getNombre());
            }
        }
        return faltantes;
    }

    // Porcentaje limpio en formato entero o con un solo decimal
    public double calcularCoincidencia(Despensa despensa) {
        int total = ingredientesRequeridos.size();
        if (total == 0) return 0.0;
        int encontrados = contarIngredientesDisponibles(despensa);
        
        // Multiplicamos por 100 y redondeamos para evitar decimales largos
        double porcentaje = ((double) encontrados / total) * 100.0;
        return Math.round(porcentaje * 10.0) / 10.0; 
    }
}