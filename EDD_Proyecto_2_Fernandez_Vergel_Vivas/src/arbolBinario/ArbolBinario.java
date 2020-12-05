
package arbolBinario;

import herramientas.Funciones;

public class ArbolBinario {
    
    NodoArbol root;
    public String txt = "-";

    public ArbolBinario() {
        this.root = null;
    }

    public ArbolBinario(NodoArbol root) {
        this.root = root;
    }

    public boolean es_Vacio(NodoArbol n) {
        return n == null;
    }

    public void insertar_izq(String parent, String leftvalue) {
        NodoArbol n = buscar(root, parent);
        NodoArbol izquierdo = new NodoArbol(leftvalue);
        n.setHijo_izq(izquierdo);
    }

    public void insetar_der(String parent, String rightvalue) {
        NodoArbol n = buscar(root, parent);
        NodoArbol derecho = new NodoArbol(rightvalue);
        n.setHijo_der(derecho);
    }

    public void insertar_root(String data) {
        root = new NodoArbol(data);
    }

    public NodoArbol getRoot() {
        return root;
    }

    public NodoArbol buscar(NodoArbol n, String key) {
        NodoArbol result = null;
        if (n == null) {
            return null;
        }
        if (n.getData().equals(key)) {
            return n;
        }
        if (n.getHijo_izq()!= null) {
            result = buscar(n.getHijo_izq(), key);
        }
        if (result == null) {
            result = buscar(n.getHijo_der(), key);
        }
        return result;
    }

    public int getAltura(NodoArbol root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getAltura(root.getHijo_izq()), getAltura(root.getHijo_der())) + 1;
    }

    public void imprimirArbol(NodoArbol n) {
        if (n == null) {
            return;
        }
        imprimirArbol(n.getHijo_izq());
        n.mostrarNodo(n);
        imprimirArbol(n.getHijo_der());
    }

    public NodoArbol Max(NodoArbol n) {
        if (n.getHijo_der() == null) {
            return n;
        } else {
            return Max(n.getHijo_der());
        }
    }

    /**
     * Carga archivo txt para crear arbol
     */
    public void ObtenerArbolBinarioTxt() {
        this.setTxt(Funciones.cargarArchivoTxt("datos/arbol.txt"));

        if (this.getTxt().isEmpty()) { // TXT vacio
            this.root = new NodoArbol("pájaro");
        } else {
            String data[] = getTxt().split("-");

            String[] preSucio = data[1].split("\n");
            String pre[] = new String[preSucio.length - 1];

            String[] inSucio = data[2].split("\n");
            String in[] = new String[inSucio.length - 1];

            for (int i = 1; i < preSucio.length; i++) {
                String text = preSucio[i].toLowerCase().trim();
                pre[i - 1] = text;
            }

            for (int i = 1; i < inSucio.length; i++) {
                String text = inSucio[i].toLowerCase().trim();
                in[i - 1] = text;
            }

            ConstructorArbolBinario builder = new ConstructorArbolBinario();
            int len = in.length;

            this.root = builder.construirArbol(in, pre, 0, len - 1);
        }
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }
   
//Obtener recorrido del arbol en Preorden   
    public void PreOrder(NodoArbol n) {

        if (n == null) {
            return;
        }
        setTxt(getTxt() + n.mostrarNodo(n));
        PreOrder(n.getHijo_izq());
        PreOrder(n.getHijo_der());
    }

//Obtener recorrido del arbol en Inorden 
    public void InOrder(NodoArbol n) {

        if (n == null) {
            return;
        }
        InOrder(n.getHijo_izq());
        setTxt(getTxt() + n.mostrarNodo(n));
        InOrder(n.getHijo_der());
    }

//Obtener recorrido del arbol en Postorden 
    public void PostOrder(NodoArbol n) {

        if (n == null) {
            return;
        }
        PostOrder(n.getHijo_izq());
        PostOrder(n.getHijo_der());
        n.mostrarNodo(n);
    }

}
