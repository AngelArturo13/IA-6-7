public class ABB{
    public static void main(String[] args) {
    Arbol arbol = new Arbol();
    Nodo raiz = null;
    System.out.println(arbol.vacio(raiz));    
    raiz = arbol.insertar(raiz,8);
    raiz = arbol.insertar(raiz,3);
    raiz = arbol.insertar(raiz,6);
    raiz = arbol.insertar(raiz,10);
    System.out.println(arbol.vacio(raiz)); 
    arbol.inOrden(raiz);   
    }   
}
