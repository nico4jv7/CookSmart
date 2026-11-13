import java.util.*;

public class BuscadorRecetas {
    private HashMap<String, Receta> catalogo;

    public BuscadorRecetas() {
        catalogo = new HashMap<>();
    }

    public void agregarReceta(Receta receta) {
        catalogo.put(receta.getNombre(), receta);
    }

    // Evalúa las recetas y las inserta en el Árbol AVL para ordenarlas automáticamente
    public List<String> buscarYRecomendar(Despensa despensa) {
        ArbolAVL arbolRanking = new ArbolAVL();

        // Recorremos el catálogo usando los dos puntos (:)
        for (Receta receta : catalogo.values()) {
            double porcentaje = receta.calcularCoincidencia(despensa);
            
            // Solo insertamos si tiene al menos un ingrediente coincidente
            if (porcentaje > 0) {
                arbolRanking.insertar(receta, porcentaje);
            }
        }

        // Retornamos el ranking ordenado mediante el recorrido del Árbol AVL
        return arbolRanking.obtenerRanking(despensa);
    }

    // Método para buscar y retornar la receta completa por su nombre
    public Receta obtenerRecetaPorNombre(String nombre) {
        for (Receta r : catalogo.values()) {
            if (r.getNombre().equalsIgnoreCase(nombre)) {
                return r;
            }
        }
        return null;
    }
}