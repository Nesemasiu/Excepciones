/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Excepciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MuyPequeñoElNumero {
        // TODO code application logic here
        int opcion = 0;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("1. Ejemplo 1\n2. Ejemplo 2\n3. Ejemplo 3\n4. Ejercicio\n5. Salir"));
            switch (opcion) {
                case 1:
                    int op1 = Integer.parseInt(JOptionPane.showInputDialog("1. Sin excepcion\n2. Con excepcion "));
                    switch (op1) {
                        case 1:
                            formatoNumero();
                        case 2:
                            formatoNumeroTratado();
                    }

                case 2:
                    int op2 = Integer.parseInt(JOptionPane.showInputDialog("1. Sin excepcion\\2. Con excepcion "));
                    switch (op2) {
                        case 1:
                            desborde();
                        case 2:
                            desbordeTratado();
                    }
                case 3:
                    int op3 = Integer.parseInt(JOptionPane.showInputDialog("1. Sin excepcion\\2. Con excepcion "));
                    switch (op3) {
                        case 1:
                            aritmetico();
                        case 2:
                            aritmeticoTratado();
                    }
                case 4:
                    ejercicio();

            }

        } while (opcion != 5);
    }

    public static void formatoNumero() {

        int numero;

        String cadena = " 1";
        JOptionPane.showMessageDialog(null, cadena);
        numero = Integer.parseInt(cadena);

    }

    public static void formatoNumeroTratado() {

        int numero;

        String cadena = " 1";
        JOptionPane.showMessageDialog(null, cadena);
        try {

            numero = Integer.parseInt(cadena);

        } catch (NumberFormatException ex) {

            System.out.println("No es un número, es una cadena de texto." + ex.getMessage());

        }

    }

    public static void desborde() {

        int v[] = new int[3];

        for (int i = 0; i < 5; i++) {

            v[i] = i;
            System.out.println(v[i]);

        }

    }

    public static void desbordeTratado() {

        int v[] = new int[3];

        try {
            for (int i = 0; i < 5; i++) {
                v[i] = i;
                System.out.println(v[i]);
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("tamaño del vector alcanzado " + ex.getMessage());
        }

    }

    public static void aritmetico() {

        int numero = 5, resultado;

        resultado = numero / 0;

    }

    public static void aritmeticoTratado() {

        int numero = 5, resultado;
        try {
            resultado = numero / 0;

        } catch (ArithmeticException e) {
            System.out.println("No se puede dividir el numero entre 0 " + e.getMessage());

        }

    }

    public static void ejercicio() throws MuyPequeñoElNumero {
        int entero = 0, divisor;
        int resultado = 0;
        try {
            entero = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero a dividir"));
            divisor = Integer.parseInt(JOptionPane.showInputDialog("Digite el divisor"));

            if (entero < 10) {
                throw new MuyPequeñoElNumero(entero);
            }
        } catch (NumberFormatException ex) {
            System.out.println("el numero a dividir no es un número, es una cadena de texto." + ex.getMessage());
        } catch (MuyPequeñoElNumero e) {
            System.out.println("numero a dividir es muuyyyy pequeño " + e.getMessage());
        }
        try {
            resultado = entero / resultado;
        } catch (ArithmeticException e) {
            System.out.println("No se puede dividir el numero entre 0 " + e.getMessage());

        }

    }

    private static class MuyPequeñoElNumero extends Exception {

        protected int valorInvalido;

        public MuyPequeñoElNumero(int valorInvalido) {
            this.valorInvalido = valorInvalido;
        }

        public int getValorInvalido() {
            return valorInvalido;
        }
    }
}
