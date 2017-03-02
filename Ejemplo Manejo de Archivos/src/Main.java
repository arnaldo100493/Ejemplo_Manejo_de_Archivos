
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author FABAME
 */
public class Main {

    public static Console c = new Console("EJEMPLO MANEJO DE ARCHIVOS");

    public Main() {

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //ejercicio01();
        //ejercicio02();
        //ejercicio03();
        ejercicio04();
    }

    // Lectura nativa de Java
    public static void ejercicio01() {
        try {
            File file = new File("entrada.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String linea = br.readLine();
            while (linea != null) {
                System.out.println(linea);
                linea = br.readLine();
            }

        } catch (Exception ex) {
            System.out.println("ERROR DE ARCHIVO " + ex.getMessage());

        }
    }

    // Lectura de datos utilizando la consola
    public static void ejercicio02() {
        Archivo a1 = new Archivo("entrada.txt");

        if (a1.reset()) {
            String linea = a1.readLine();
            while (linea != null) {
                c.println(linea);
                linea = a1.readLine();
            }
            a1.close();

        } else {
            c.println("ERROR EN EL ARCHIVO");
        }
    }

    // Escritura de datos utilizando la consola
    public static void ejercicio03() {
        Archivo a1 = new Archivo("entrada.txt");
        Archivo a2 = new Archivo("salida.txt");

        if (a1.reset()) {
            if (a2.rewrite()) {
                String linea = a1.readLine();
                while (linea != null) {
                    c.println(linea);
                    a2.writeLine(linea); // Escribe en a2
                    linea = a1.readLine();
                }
                a2.close();
            } else {
                c.println("ERROR ARCHIVO DE SALIDA");
            }
            a1.close();
        } else {
            c.println("ERROR ARCHIVO DE ENTRADA");
        }

    }

    public static void ejercicio04() {
        Archivo a1 = new Archivo("ventas.txt");

        if (a1.reset()) {
            String linea = a1.readLine();
            while (linea != null) {
                String nombre = "";
                String montoString = "";
                String ciudad = "";

                // Método 1
                StringTokenizer st = new StringTokenizer(linea, "_");
                nombre = st.nextToken();
                montoString = st.nextToken();
                ciudad = st.nextToken();

                // Método 2
                String[] arreglo = linea.split("_");
                nombre = arreglo[0];
                montoString = arreglo[1];
                ciudad = arreglo[2];

                int monto = Integer.parseInt(montoString);
                if (monto > 7000) {
                    c.println(nombre);
                }

                // if(ciudad.equalsIgnoreCase("ANTOFAGASTA")){
                //   c.println(nombre);
                //}
                linea = a1.readLine();
            }
            a1.close();

        } else {
            c.println("ERROR EN EL ARCHIVO");
        }
    }

}


    

