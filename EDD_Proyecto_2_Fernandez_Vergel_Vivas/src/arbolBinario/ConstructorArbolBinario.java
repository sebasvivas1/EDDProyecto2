
package arbolBinario;

public class ConstructorArbolBinario {
    
    NodoArbol root;
    int preIndex = 0;

//Construir arbol por recorrido
    public NodoArbol construirArbol(String[] in, String[] pre, int inStrt, int inEnd) {
        if (inStrt > inEnd) {
            return null;
        }
        
        NodoArbol tNode = new NodoArbol(pre[preIndex++]);
        
        if (inStrt == inEnd) {
            return tNode;
        }
        int inIndex = search(in, inStrt, inEnd, tNode.getData());

        tNode.setHijo_izq(construirArbol(in, pre, inStrt, inIndex - 1));
        tNode.setHijo_der(construirArbol(in, pre, inIndex + 1, inEnd));

        return tNode;
    }
    
//Buscar nodo por index
    public int search(String arr[], int strt, int end, String value) {
        int i;
        for (i = strt; i <= end; i++) {
            if (arr[i].equals(value)) {
                return i;
            }
        }
        return i;
    }
}
