import java.util.*;

public class ArbolAVL {
    private NodoAVL raiz;

    // Obtener la altura de un nodo
    private int altura(NodoAVL nodo) {
        if (nodo == null) {
            return 0;
        }
        return nodo.altura;
    }

    // Retornar el mayor entre dos números
    private int max(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    // Calcular el factor de balance de un nodo
    private int obtenerBalance(NodoAVL nodo) {
        if (nodo == null) {
            return 0;
        }
        return altura(nodo.izquierdo) - altura(nodo.derecho);
    }

    // Rotación a la derecha
    private NodoAVL rotarDerecha(NodoAVL y) {
        NodoAVL x = y.izquierdo;
        NodoAVL T2 = x.derecho;

        x.derecho = y;
        y.izquierdo = T2;

        y.altura = max(altura(y.izquierdo), altura(y.derecho)) + 1;
        x.altura = max(altura(x.izquierdo), altura(x.derecho)) + 1;

        return x;
    }

    // Rotación a la izquierda
    private NodoAVL rotarIzquierda(NodoAVL x) {
        NodoAVL y = x.derecho;
        NodoAVL T2 = y.izquierdo;

        y.izquierdo = x;
        x.derecho = T2;

        x.altura = max(altura(x.izquierdo), altura(x.derecho)) + 1;
        y.altura = max(altura(y.izquierdo), altura(y.derecho)) + 1;

        return y;
    }

    // Método público para insertar una receta con su porcentaje
    public void insertar(Receta receta, double porcentaje) {
        raiz = insertarRecursivo(raiz, receta, porcentaje);
    }

    // Inserción recursiva con balanceo AVL
    private NodoAVL insertarRecursivo(NodoAVL nodo, Receta receta, double porcentaje) {
        // 1. Inserción normal de un árbol binario de búsqueda
        if (nodo == null) {
            return new NodoAVL(receta, porcentaje);
        }

        // Ordenamos de mayor a menor porcentaje (si es menor, va a la izquierda, si es mayor o igual, a la derecha)
        if (porcentaje < nodo.porcentaje) {
            nodo.izquierdo = insertarRecursivo(nodo.izquierdo, receta, porcentaje);
        } else {
            nodo.derecho = insertarRecursivo(nodo.derecho, receta, porcentaje);
        }

        // 2. Actualizar la altura del nodo actual
        nodo.altura = 1 + max(altura(nodo.izquierdo), altura(nodo.derecho));

        // 3. Obtener el factor de balance para ver si se desbalanceó
        int balance = obtenerBalance(nodo);

        // 4. Casos de rotación si está desbalanceado
        // Caso Izquierda - Izquierda
        if (balance > 1 && porcentaje < nodo.izquierdo.porcentaje) {
            return rotarDerecha(nodo);
        }

        // Caso Derecha - Derecha
        if (balance < -1 && porcentaje >= nodo.derecho.porcentaje) {
            return rotarIzquierda(nodo);
        }

        // Caso Izquierda - Derecha
        if (balance > 1 && porcentaje >= nodo.izquierdo.porcentaje) {
            nodo.izquierdo = rotarIzquierda(nodo.izquierdo);
            return rotarDerecha(nodo);
        }

        // Caso Derecha - Izquierda
        if (balance < -1 && porcentaje < nodo.derecho.porcentaje) {
            nodo.derecho = rotarDerecha(nodo.derecho);
            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    // Recorrido in-orden inverso (Derecha, Raíz, Izquierda) para obtener el ranking de mayor a menor
    public List<String> obtenerRanking(Despensa despensa) {
        List<String> ranking = new ArrayList<>();
        recorridoInverso(raiz, ranking, despensa);
        return ranking;
    }

    private void recorridoInverso(NodoAVL nodo, List<String> ranking, Despensa despensa) {
        if (nodo != null) {
            recorridoInverso(nodo.derecho, ranking, despensa);
            
            int disponibles = nodo.receta.contarIngredientesDisponibles(despensa);
            int total = nodo.receta.getIngredientesRequeridos().size();
            String linea = nodo.receta.getNombre() + " -> Tienes " + disponibles + " de " + total + " ingredientes (" + nodo.porcentaje + "%)";
            ranking.add(linea);

            recorridoInverso(nodo.izquierdo, ranking, despensa);
        }
    }
}
