public class NodoAVL {
    Receta receta;
    double porcentaje;
    int altura;
    NodoAVL izquierdo;
    NodoAVL derecho;

    public NodoAVL(Receta receta, double porcentaje) {
        this.receta = receta;
        this.porcentaje = porcentaje;
        this.altura = 1; // Altura inicial de un nodo nuevo
    }
}
