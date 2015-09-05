package edd.webserviceexterno.datos;

/**
 *
 * @author Marvin
 */
public class Numero implements Comparador{
    
    int valor;

    public Numero(int n) {
        valor = n;
    }

    public String aString() {
        return " " + valor;
    }

    @Override
    public boolean igualQue(Object op2) {
        Numero p2 = (Numero) op2;
        return valor == p2.valor;
    }

    @Override
    public boolean menorQue(Object op2) {
        Numero p2 = (Numero) op2;
        return valor < p2.valor;
    }

    @Override
    public boolean menorIgualQue(Object op2) {
        Numero p2 = (Numero) op2;
        return valor <= p2.valor;
    }

    @Override
    public boolean mayorQue(Object op2) {
        Numero p2 = (Numero) op2;
        return valor > p2.valor;
    }

    @Override
    public boolean mayorIgualQue(Object op2) {
        Numero p2 = (Numero) op2;
        return valor >= p2.valor;
    }
}
