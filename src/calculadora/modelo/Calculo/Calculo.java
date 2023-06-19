package calculadora.modelo.Calculo;

public class Calculo {
    /* Attributes */
    private int n1;
    private int n2;
    private double resul;
    private char operador;

    /* GET and SET */
    public int getN1() {
        return n1;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public int getN2() {
        return n2;
    }

    public void setN2(int n2) {
        this.n2 = n2;
    }

    public char getOperador() {
        return operador;
    }

    public void setOperador(char operador) {
        this.operador = operador;
    }

    public double getResul() {
        return resul;
    }

    /* Calculo */
    public void setResul(double d) {
        this.resul = d;
    }

    /* Anothers methods */
    public void logo() {
        System.out.println(" _____         _               _             _                     ");
        System.out.println("/  __ \\       | |             | |           | |                    ");
        System.out.println("| /  \\/  __ _ | |  ___  _   _ | |  __ _   __| |  ___   _ __   __ _ ");
        System.out.println("| |     / _` || | / __|| | | || | / _` | / _` | / _ \\ | '__| / _` |");
        System.out.println("| \\__/\\| (_| || || (__ | |_| || || (_| || (_| || (_) || |   | (_| |");
        System.out.println(" \\____/ \\__,_||_| \\___| \\__,_||_| \\__,_| \\__,_| \\___/ |_|    \\__,_|");
    }

    /* Retorna os atributos como String */
    @Override

    public String toString() {
        /* Caso rais */
        if (operador == '√') {
            return "Raiz(" + n1 + ")" + " = " + resul;
        } else {
            return n1 + " " + operador + " " + n2 + " = " + resul;
        }
    }
}
