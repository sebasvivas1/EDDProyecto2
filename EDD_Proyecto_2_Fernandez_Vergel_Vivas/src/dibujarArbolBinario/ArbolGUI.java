
package dibujarArbolBinario;

import arbolBinario.ArbolBinario;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.BorderLayout;

public class ArbolGUI extends JFrame{

    public ArbolBinario tree;
    public DibujarArbol drawer;
    private JPanel Pane;

    /**
     * Create the frame.
     */
    public ArbolGUI(ArbolBinario tree) {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        setBounds(100, 100, 1500, 900);

        Pane = new JPanel();
        Pane.setBorder(new EmptyBorder(3, 3, 3, 3));
        Pane.setLayout(new BorderLayout(0, 0));
        drawer = new DibujarArbol(tree);

        Pane.add(drawer);
        this.setLayout(new BorderLayout());
        setContentPane(Pane);
        this.tree = tree;
        setVisible(true);
    }

}
