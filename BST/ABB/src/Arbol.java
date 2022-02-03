
public class Arbol {
    
public Nodo crear (int valor){
    Nodo aux = new Nodo();
    aux.dato = valor;
    aux.der = null;
    aux.izq = null;
    return aux;
}
public Nodo insertar (Nodo aux, int valor){
    if(aux==null){
        return crear(valor);
    }
    if(valor < aux.dato){
        aux.izq = insertar(aux.izq, valor);
    }
    else if(valor >= aux.dato){
        aux.der = insertar(aux.der, valor);
    }
 
    return aux;
     
}
//Realiza la busqueda InOrden
public void inOrden(Nodo aux){
if(!vacio(aux)){
    inOrden(aux.izq);
    System.out.print(aux.dato + ", ");
    inOrden(aux.der);
}
}
public void buscar(Nodo aux,int valor){
if(!vacio(aux)){
    buscar(aux.izq,valor);
    if(aux.dato == valor){
        System.out.println("El nodo "+valor+" existe en el arbol");
    }
    buscar(aux.der,valor);
}
}
public Boolean vacio (Nodo aux){
    return aux ==  null;
}
}