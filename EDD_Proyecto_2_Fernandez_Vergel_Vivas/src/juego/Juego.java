
package juego;

import arbolBinario.NodoArbol;
import arbolBinario.ArbolBinario;
import javax.swing.JOptionPane;

public class Juego {
    
    private ArbolBinario tree;
    
    public Juego(NodoArbol raiz) {
        this.tree = new ArbolBinario(raiz);
    }

    public ArbolBinario getTree() {
        return tree;
    }
    
}
