public class ABB{
    public static void main(String[] args) {
    Arbol arbol = new Arbol();
    Nodo raiz = null;
    System.out.println("El arbol esta vacio? " + arbol.vacio(raiz));    
    //insertamos unos nodos
    raiz = arbol.insertar(raiz,8);
    raiz = arbol.insertar(raiz,3);
    raiz = arbol.insertar(raiz,6);
    raiz = arbol.insertar(raiz,10);

    System.out.println("El arbol esta vacio? "+arbol.vacio(raiz)); 
    System.out.println("Recorrido Inorden");
    arbol.inOrden(raiz);
    System.out.println("");
    
    //buscamos el nodo 10
    arbol.buscar(raiz, 10);   
    }   
}
