
package arbolBinario;

public class NodoArbol {
    private String data;
    private NodoArbol hijo_izq;
    private NodoArbol hijo_der;

    public NodoArbol(String valor) {
        this.data = valor;
        this.hijo_izq = null;
        this.hijo_der = null;
    }

    public String mostrarNodo(NodoArbol n) {
        return "\n" + n.getData();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public NodoArbol getHijo_izq() {
        return hijo_izq;
    }

    public void setHijo_izq(NodoArbol hijo_izq) {
        this.hijo_izq = hijo_izq;
    }

    public NodoArbol getHijo_der() {
        return hijo_der;
    }

    public void setHijo_der(NodoArbol hijo_der) {
        this.hijo_der = hijo_der;
    }

}
