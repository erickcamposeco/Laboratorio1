
package laboratorio1;

import java.util.Scanner;


public class Laboratorio1 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario que ingrese la expresión infija
        System.out.print("Ingrese la expresión infija: ");
        String infijo = scanner.nextLine();

        // Eliminar espacios de la expresión
        infijo = InfijoPosfijoPrefijo.eliminarEspacios(infijo);

        // Validar la expresión
        if (!InfijoPosfijoPrefijo.validarExpresion(infijo)) {
            System.out.println("La expresión no está bien formada. Verifique los paréntesis y los operadores.");
        } else {
            // Mostrar la expresión infija ingresada
            System.out.println("Expresión Infija: " + infijo);

            // Convertir a postfija
            String postfijo = InfijoPosfijoPrefijo.convertToPostfix(infijo);
            System.out.println("Expresión Postfija: " + postfijo);

            // Convertir a prefija
            String prefijo = InfijoPosfijoPrefijo.convertToPrefix(infijo);
            System.out.println("Expresión Prefija: " + prefijo);
        }

        // Cerrar el scanner
        scanner.close();
    }

    
}
