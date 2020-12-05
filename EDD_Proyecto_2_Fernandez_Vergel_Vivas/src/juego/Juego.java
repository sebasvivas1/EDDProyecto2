
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
    
    public void jugar() {
        NodoArbol nodo = tree.getRoot();

        while (nodo != null) {

            if (nodo.getHijo_der() != null) { 
                nodo = (respuesta(nodo.getData())) ? nodo.getHijo_der() : nodo.getHijo_izq();
            } else {
                if (respuesta("Tu animal es un@ " + nodo.getData())) {
                    JOptionPane.showMessageDialog(null, "El adivinador ha ganado");
                } else {
                    animalNuevo(nodo);
                }
                nodo = null;
                return;
            }

        }
    }


    /**
     * AGREGA UN NUEVO NODO ANIMAL
     *
     * @param nodo
     */
    private void animalNuevo(NodoArbol nodo) {
        String animalNodo = (String) nodo.getData();
        String nuevoA = JOptionPane.showInputDialog(null, "Cual es tu animal?");

        String pregunta = JOptionPane.showInputDialog(null, "Que caracteriza a un@ "  + nuevoA);

        NodoArbol nodo1 = new NodoArbol(animalNodo);
        NodoArbol nodo2 = new NodoArbol(nuevoA);

        nodo.setData("¿" + pregunta + "?");
        
        tree.insertar_izq(nodo.getData(), nodo1.getData());
        tree.insetar_der(nodo.getData(), nodo2.getData());

    }
    
    /**
     * Valida la respuesta del usuario
     * @param mensaje
     * @return
     */
    public boolean respuesta(String mensaje) {

        while (true) {
            int resp = JOptionPane.showConfirmDialog(null, mensaje);

            if (resp == 0) {
                return true;
            }
            if (resp == 1) {
                return false;
            }
            if (resp == 2) {
                JOptionPane.showMessageDialog(null, "Gracias por jugar");
                System.exit(0);
            }
            JOptionPane.showMessageDialog(null, "La respuesta debe ser si o no");
        }

    }
}
