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
    
}
