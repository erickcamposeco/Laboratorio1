package laboratorio1;

public class Pila {
    private int maxSize;
    private char[] stackArray;
    private int top;
    
    public Pila(int size){
        this.maxSize = size;
        this.stackArray = new char[maxSize];
        this.top = -1;
    }
    
    public void push(char j){
        if(isFull()) {
            System.out.println("La pila está llena, no se puede agregar más elementos.");
            return;
        }
        stackArray[++top] = j;
    }
    
    public char pop() {
        if (isEmpty()) {
            System.out.println("La pila está vacía, no se puede sacar ningún elemento.");
            return '\0';
        }
        return stackArray[top--];
    }
    
    public char peek() {
        if (isEmpty()) {
            return '\0';
        }
        return stackArray[top];
    }
    
    public boolean isEmpty() {
        return (top == -1);
    }
    
   
    public boolean isFull() {
        return (top == maxSize - 1);
    }
}
