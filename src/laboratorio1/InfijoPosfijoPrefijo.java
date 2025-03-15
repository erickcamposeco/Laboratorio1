
package laboratorio1;


public class InfijoPosfijoPrefijo {
    
    // Método para eliminar espacios de la expresión
    public static String eliminarEspacios(String expresion) {
        return expresion.replaceAll("\\s+", "");
    }
    
    // Método para validar la expresión infija
    public static boolean validarExpresion(String expresion) {
        // Verificar paréntesis balanceados
        Pila pilaParentesis = new Pila(expresion.length());
        for (int i = 0; i < expresion.length(); i++) {
            char ch = expresion.charAt(i);
            if (ch == '(') {
                pilaParentesis.push(ch);
            } else if (ch == ')') {
                if (pilaParentesis.isEmpty() || pilaParentesis.pop() != '(') {
                    return false; // Paréntesis no balanceados
                }
            }
        }
        if (!pilaParentesis.isEmpty()) {
            return false; // Paréntesis no balanceados
        }

        // Verificar operadores correctamente colocados
        for (int i = 0; i < expresion.length(); i++) {
            char ch = expresion.charAt(i);
            if (isOperador(ch)) {
                // No puede haber un operador al inicio o al final
                if (i == 0 || i == expresion.length() - 1) {
                    return false;
                }
                // No puede haber dos operadores seguidos
                char siguiente = expresion.charAt(i + 1);
                if (isOperador(siguiente) || siguiente == ')') {
                    return false;
                }
            }
        }

        return true; // La expresión es válida
    }
    
    // Método para verificar si un carácter es un operador
    public static boolean isOperador(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
    }

    // Método para invertir una cadena
    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }
    
    // Método para validar la jerarquía de los operadores
    public static int validateHierarchy(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    // Método para convertir de infijo a postfijo
    public static String convertToPostfix(String infijo) {
        StringBuilder postfijo = new StringBuilder();
        Pila pila = new Pila(infijo.length());

        for (int i = 0; i < infijo.length(); i++) {
            char ch = infijo.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                postfijo.append(ch);
            } else if (ch == '(') {
                pila.push(ch);
            } else if (ch == ')') {
                while (!pila.isEmpty() && pila.peek() != '(') {
                    postfijo.append(pila.pop());
                }
                pila.pop(); // Sacar '(' de la pila
            } else if (isOperador(ch)) {
                while (!pila.isEmpty() && validateHierarchy(ch) <= validateHierarchy(pila.peek())) {
                    postfijo.append(pila.pop());
                }
                pila.push(ch);
            }
        }

        while (!pila.isEmpty()) {
            postfijo.append(pila.pop());
        }

        return postfijo.toString();
    }
    
    public static String convertToPrefix(String infijo) {
        String reversedInfijo = reverseString(infijo);
        StringBuilder prefijo = new StringBuilder();
        Pila pila = new Pila(reversedInfijo.length());

        for (int i = 0; i < reversedInfijo.length(); i++) {
            char ch = reversedInfijo.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                prefijo.append(ch);
            } else if (ch == ')') {
                pila.push(ch);
            } else if (ch == '(') {
                while (!pila.isEmpty() && pila.peek() != ')') {
                    prefijo.append(pila.pop());
                }
                pila.pop(); // Sacar ')' de la pila
            } else if (isOperador(ch)) {
                while (!pila.isEmpty() && validateHierarchy(ch) < validateHierarchy(pila.peek())) {
                    prefijo.append(pila.pop());
                }
                pila.push(ch);
            }
        }

        while (!pila.isEmpty()) {
            prefijo.append(pila.pop());
        }

        return reverseString(prefijo.toString());
    }
}

