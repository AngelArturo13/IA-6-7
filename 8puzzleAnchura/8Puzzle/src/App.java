import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
// Implementar comparable o equals to para solucionar lo de visitado
public class App {
    // arrays para moverse en las columnas/filas
    int[] fila = { 1, 0, -1, 0 };
    // abajo,izq,arriba,dereha;
    int[] columna = { 0, -1, 0, 1 };

    static int[][] objetivo = {{0,1,2}, { 3, 4, 5 }, { 6, 7, 8 } };
    static int[][] estado = {{2 ,1, 0}, { 3, 4, 5 }, { 6, 7, 8 } };

    public static void main(String[] args) {
        App puzzle = new App();
        int x = puzzle.getX(estado);
        int y = puzzle.getY(estado);
        Nodo raiz = new Nodo(estado,x,y,x,y,0,null);
        //Nodo raiz2 = new Nodo(estado,x,y,x,y,0,null);
        //System.out.println(puzzle.encontroObj(estado,objetivo));
        //System.out.println(raiz.compareTo(raiz2));
        puzzle.Buscar(raiz);
        
    }

    boolean encontroObj(int [][]v, int [][] objetivo) {
      int n = 3;
      for (int i = 0; i < n; i++){
         for (int j = 0; j < n; j++){
            if (v[i][j] != objetivo[i][j]){
                return false;
            }
        }
    }
    return true;
}
    
    List<Nodo> obtenerSuc(Nodo v) {
        List<Nodo> nodos = new ArrayList<>();
        for (Rama r : v.ramas) {
            nodos.add(r.desc);
        }
        return nodos;
    }

    private Nodo Buscar(Nodo inicio) {
        Queue<Nodo> cola = new LinkedList<>();
        List<Rama> r = new ArrayList<Rama>();
        int profundidad = 0;
        inicio.visitado = true;
        r.add(new Rama(inicio));
        cola.add(inicio);
        //flag para checar si ya existe en la coleccion de rama
        boolean existeEnR = false;

        while (cola.size() > 0) {
            Nodo v = cola.remove();
            if (encontroObj(v.matriz,objetivo)) {
                System.out.println("Ruta: ");
                imprimirRuta(v);
                System.out.println(r.size());
                return v;
            }

            profundidad++;
            for (int i = 0; i < 4; i++) {
                if (puedeMover(v.x1 + fila[i], v.y1 + columna[i])) {
                    Nodo n = new Nodo(v.matriz, v.x1, v.y1, v.x1 + fila[i], v.y1 + columna[i],profundidad,v);
                    for (int j = 0; j < r.size(); j++) {
                        if(r.get(j).desc.compareTo(n)==0){
                            //r.get(j).desc.visitado = true;
                            existeEnR = true;
                            break;
                        }
                    }
                    if(!existeEnR){
                    // System.out.println("hijos de profundida "+profundidad);
                    // System.out.println(existeEnR);
                    // imprimirMatriz(n.matriz);
                    // System.out.println();
                        r.add(new Rama(n));
                }
                }
                existeEnR = false;
            }
           existeEnR = false; 
            
            v.ramas = r;
            //System.out.println(r.size());
            // ahora tenemos que ver como compararlos con el queu
            for (Nodo w : obtenerSuc(v)) {
                if (!w.visitado) {
                    // w.visitado = true;                    
                    cola.add(w);
                }
            }
        }
        return null;
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
        System.out.println("Profundidad: " + raiz.profundidad);
        System.out.println();
    }

}
