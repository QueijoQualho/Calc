package calculadora.modelo;

import java.util.ArrayList;

import calculadora.modelo.Calculo.Calculo;

public class Menu {
    /* Attributes  */
    private int opcao;
    private ArrayList<Calculo> historico = new ArrayList<>();

    /* Get and Set */
    public int getOpcao() {
        return opcao;
    }

    public void setOpcao(int opcao) {
        this.opcao = opcao;
    }

    public void addHistorico(Calculo Calculo) {
        historico.add(Calculo);
    }

    /* Anothers methods */
    public void logo_historico() {
        System.out.println("  _   _   _         _                    _                ");
        System.out.println(" | | | | (_)  ___  | |_    ___    _ __  (_)   ___    ___  ");
        System.out.println(" | |_| | | | / __| | __|  / _ \\  | '__| | |  / __|  / _ \\ ");
        System.out.println(" |  _  | | | \\__ \\ | |_  | (_) | | |    | | | (__  | (_) |");
        System.out.println(" |_| |_| |_| |___/  \\__|  \\___/  |_|    |_|  \\___|  \\___/ ");
    }

    public void printHistorico() {
        for (int i = 0; i < historico.size(); i++) {
            System.out.println(historico.get(i));
        }
    }

}
