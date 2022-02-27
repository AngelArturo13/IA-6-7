import java.util.LinkedList;

public class EightPuzzle {
    // arrays para moverse en las columnas/filas
    int[] fila = { 1, 0, -1, 0 };
    // abajo,izq,arriba,dereha;
    int[] columna = { 0, -1, 0, 1 };

    public static void main(String[] args) throws Exception {
        int[][] objetivo = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 } };
        // int [][] m1 = {{0,1,4},{3,2,6},{5,7,8}};
        int[][] m3 = { {1,2,3}, {4,0,5}, {6,7,8} };
        // int [][] m2 = {{2,7,0},{8,1,6},{4,3,5}};
        EightPuzzle ep = new EightPuzzle();
        ep.resolver(m3, objetivo, ep.getX(m3), ep.getY(m3));

    }

    public void resolver(int[][] inicial, int[][] objetivo, int x, int y) {
        // lista para ir guardando los nodos hijos
        LinkedList<Nodo> listN = new LinkedList<>();
        // raiz en base al estado inicial
        int profundidad=0;
        Nodo raiz = new Nodo(inicial, x, y, x, y,profundidad, null);
        // calculamos el costo
        raiz.costo = calcularCosto(raiz.matriz, objetivo);
        // lo agreamos a la lista
        listN.add(raiz);
        while (!listN.isEmpty()) {
            Nodo aux = listN.remove();
            // Cuando el costo sea 0 significa que ya se resolvio e imprimira los estados
            // por los que paso
            if (aux.costo == 0) {
                imprimirRuta(aux);
                return;
            }
            profundidad++;
            // checamos si podemos mover el 0 a una de las 4 posiciones
            for (int i = 0; i < 4; i++) {
                if (puedeMover(aux.x1 + fila[i], aux.y1 + columna[i])) {
                    Nodo hijo = new Nodo(aux.matriz, aux.x1, aux.y1, aux.x1 + fila[i], aux.y1 + columna[i],profundidad, aux);
                    hijo.costo = calcularCosto(hijo.matriz, objetivo);
                    // if(hijo.costo <= aux.costo){
                    listN.add(hijo);
                    // }
                }
            }
        }
    }

    // metodos getX y getY para obtener la posicion del 0
    public int getX(int[][] m) {
        int x = 0;
        int n = m.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (m[i][j] == 0) {
                    x = i;
                    return x;
                }
            }
        }
        return x;
    }

    public int getY(int[][] m) {
        int y = 0;
        int n = m.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (m[i][j] == 0) {
                    y = j;
                    return j;
                }
            }
        }
        return y;
    }

    // metodo para saber si se puede mover a (x,y) posicion en la matriz
    public boolean puedeMover(int x, int y) {
        // checamos que ambas coorneadas sean mayores a 0 y menores a 3
        // para evitar excepciones de OutOfBounds
        return (x >= 0 && x < 3 && y >= 0 && y < 3);
    }

    // metodo para calcular el costo, comparando los match que hay entre
    // el estado actual y el objetivo
    public int calcularCosto(int[][] estado, int[][] objetivo) {
        // Variable que devolver el costo
        int costo = 0;
        int n = estado.length;
        // Recorremos la matriz
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (estado[i][j] != objetivo[i][j] && estado[i][j] != 0) {
                    costo++;
                }
            }
        }
        return costo;
    }

    // metodo para imprimir la matriz del nodo
    public void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    // metodo para imprimir la ruta
    public void imprimirRuta(Nodo raiz) {
        if (raiz == null) {
            return;
        }
        // recursivamente llamamos a este metodo para moverse entre los nodos
        // y llamamos al "imprimirMatriz"
        imprimirRuta(raiz.padre);
        imprimirMatriz(raiz.matriz);
        System.out.println("Costo: "+ raiz.costo);
        System.out.println("Profundidad: "+raiz.profundidad);
        System.out.println();
    }
}
