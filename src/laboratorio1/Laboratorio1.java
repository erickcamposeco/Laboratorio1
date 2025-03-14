
package laboratorio1;


public class Laboratorio1 {
    
    public static void main(String[] args) {
        String infijo = "A+B*(C^D-E)";
        System.out.println("Expresión Infija: " + infijo);

        String postfijo = InfijoPosfijoPrefijo.convertToPostfix(infijo);
        System.out.println("Expresión Postfija: " + postfijo);

        String prefijo = InfijoPosfijoPrefijo.convertToPrefix(infijo);
        System.out.println("Expresión Prefija: " + prefijo);
    }

    
}
