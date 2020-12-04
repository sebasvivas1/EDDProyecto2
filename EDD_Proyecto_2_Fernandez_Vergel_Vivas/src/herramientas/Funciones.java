
package herramientas;

import java.io.*;
import javax.swing.JOptionPane;

public class Funciones {
    private static FileInputStream entrada;
    private static FileOutputStream salida;
    public static File archivo = null;

    /**
     * CARGA UN ARCHIVO DE TEXTO
     *
     * @param file = Ruta del archivo
     * @return
     */
    public static String cargarArchivoTxt(final String file) {
        String content = "";

        BufferedReader bufferedReader = null;

        try {

            bufferedReader = new BufferedReader(new FileReader(file));
            archivo = new File(file);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                content += line + "\n";
            }

        } catch (IOException e) {
            System.out.println("ERROR: " + file + " No se pudo cargar el archivo");
            e.printStackTrace();
        }

        return content;
    }

    /**
     * GUARDA UN ARCHIVO DE TEXTO
     *
     * @param archivo = Archivo cargado
     * @param contenido = Nuevo contenido del archivo cargado
     * @return
     */
    public static boolean guardarArchivoTxt(File archivo, String contenido) {
        boolean respuesta = false;
        try {
            if (archivo != null) {
                salida = new FileOutputStream(archivo);
                byte[] bytesTxt = contenido.getBytes();
                salida.write(bytesTxt);
                respuesta = true;
            } else {
                JOptionPane.showMessageDialog(null, "No existe un archivo para guardar");
            }

        } catch (Exception e) {

        }
        return respuesta;
    }
}
