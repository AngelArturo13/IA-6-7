public class Nodo {
    // matriz del estado acutal
    int[][] matriz;
    // coordenadas del 0
    int x1, y1;
    // costo del nodo
    int costo;
    //profundidad
    int profundidad;
    // Nodo padre
    Nodo padre;

    public Nodo(int[][] matriz, int x1, int y1, int x2, int y2,int profundidad, Nodo padre) {

        this.matriz = new int[matriz.length][];
        for (int i = 0; i < matriz.length; i++) {
            this.matriz[i] = matriz[i].clone();
        }
        // this.matriz = matriz;
        this.profundidad=profundidad;
        this.padre = padre;

        // para cambiar los valores de la nueva matriz de este nodo cuando
        // el cero cambia de posicion
        this.matriz[x1][y1] = this.matriz[x1][y1] + this.matriz[x2][y2];
        this.matriz[x2][y2] = this.matriz[x1][y1] - this.matriz[x2][y2];
        this.matriz[x1][y1] = this.matriz[x1][y1] - this.matriz[x2][y2];
        // y actualizamos la coordenada del 0
        this.x1 = x2;
        this.y1 = y2;

        // for (int i = 0; i < matriz.length; i++) {
        // for (int j = 0; j < matriz.length; j++) {
        // System.out.print(matriz[i][j] + " ");
        // }
        // System.out.println();
        // }
    }
}
