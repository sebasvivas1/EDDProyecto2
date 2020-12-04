
package dibujarArbolBinario;

import arbolBinario.ArbolBinario;
import arbolBinario.NodoArbol;
import java.awt.FontMetrics;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Graphics;


public class DibujarArbol extends JPanel{
    
    public ArbolBinario tree;

    public DibujarArbol(ArbolBinario tree) {
        this.tree = tree;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub

        g.setFont(new Font("Arial", Font.BOLD, 10));
        //g.drawString(String.valueOf(tree.root.data), this.getWidth()/2, 30);

        //DrawNode(g, tree.root,100, 50,2);
        Draw(g, 0, getWidth(), 0, getHeight() / tree.getAltura(tree.getRoot()), tree.getRoot());
    }

    public void Draw(Graphics g, int StartWidth, int EndWidth, int StartHeight, int Level, NodoArbol node) {
        String data = String.valueOf(node.getData());
        g.setFont(new Font("Arial", Font.BOLD, 14));
        FontMetrics fm = g.getFontMetrics();
        int dataWidth = fm.stringWidth(data);
        g.drawString(data, (StartWidth + EndWidth) / 2 - dataWidth / 2, StartHeight + Level / 2);

        if (node.getHijo_izq() != null) {
            Draw(g, StartWidth, (StartWidth + EndWidth) / 2, StartHeight + Level, Level, node.getHijo_izq());
        }

        if (node.getHijo_der()!= null) {
            Draw(g, (StartWidth + EndWidth) / 2, EndWidth, StartHeight + Level, Level, node.getHijo_der());
        }
    }
}
