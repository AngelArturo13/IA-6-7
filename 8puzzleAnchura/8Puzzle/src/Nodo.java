import java.util.ArrayList;
import java.util.List;

public class Nodo {
    // matriz del estado acutal
    int[][] matriz;
    // coordenadas del 0
    int x1, y1;
    // costo del nodo
    //int costo;
    Nodo padre;
    // visitado
    boolean visitado;
    //profundidad
    int profundidad;

    public List <Rama> ramas; 
    // Nodo padre

    public Nodo(int[][] matriz, int x1, int y1, int x2, int y2,int profundidad,Nodo padre) {
         this.matriz = new int[matriz.length][];
         for (int i = 0; i < matriz.length; i++) {
             this.matriz[i] = matriz[i].clone();
         }
        this.profundidad=profundidad;

        // para cambiar los valores de la nueva matriz de este nodo cuando
        // el cero cambia de posicion mediante suma y resta de matrices
        this.matriz[x1][y1] = this.matriz[x1][y1] + this.matriz[x2][y2];
        this.matriz[x2][y2] = this.matriz[x1][y1] - this.matriz[x2][y2];
        this.matriz[x1][y1] = this.matriz[x1][y1] - this.matriz[x2][y2];
        // y actualizamos la coordenada del 0
        this.x1 = x2;
        this.y1 = y2;

        this.padre = padre;

        ramas = new ArrayList<>();


    }
}

