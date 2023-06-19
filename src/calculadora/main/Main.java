package calculadora.main;

/* Bibliotecas */
import java.util.InputMismatchException;
import java.util.Scanner;

import calculadora.modelo.Menu;
import calculadora.modelo.Calculo.Calculo;
import calculadora.modelo.Calculo.Divisao;
import calculadora.modelo.Calculo.Multiplicao;
import calculadora.modelo.Calculo.Raiz;
import calculadora.modelo.Calculo.Soma;
import calculadora.modelo.Calculo.Subtracao;

public class Main {
    public static void main(String[] args) {
        /* Variaveis */
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();

        /* Inicio */

        do {
            Calculo calc = new Calculo();
            calc.logo();

            /* Validação de dados */
            while (true) {
                try {
                    System.out.println("Informe o primeiro numero:");
                    calc.setN1(sc.nextInt());

                    System.out.println("Informe o operador: (- + / * r)");
                    System.out.println("r = raiz");
                    calc.setOperador(sc.next().charAt(0));

                    /* Validação Char */
                    if (calc.getOperador() != '+' && calc.getOperador() != '-' && calc.getOperador() != '/'
                            && calc.getOperador() != '*' && calc.getOperador() != 'r') {
                        throw new Exception("Operador inválido. Digite novamente");
                    }

                    /* Caso Raiz */
                    if (!(calc.getOperador() == 'r')) {
                        System.out.println("Informe o segundo numero:");
                        calc.setN2(sc.nextInt());

                        /* Validação Divisão por 0 */
                        if (calc.getOperador() == '/' && calc.getN2() == 0) {
                            throw new Exception("Impossivel dividir por 0. Digite novamente");
                        }
                    } else {
                        /* Define r como √ */
                        calc.setOperador('√');
                    }

                    if (calc.getN1() < 0 && calc.getOperador() == '√') {
                        throw new Exception("Não existe raiz negativa");
                    } 

                    break;

                } catch (InputMismatchException e) {
                    System.out.println(String.format("Erro: Valor inválido. Digite novamente"));
                    sc.next();
                } catch (Exception k) {
                    System.out.println("Erro: " + k.getMessage());
                }
            }

            /* Objetos calc */
            Divisao divi = new Divisao();
            Multiplicao mult = new Multiplicao();
            Soma soma = new Soma();
            Subtracao sub = new Subtracao();
            Raiz raiz = new Raiz();

            /* Resultado */
            switch (calc.getOperador()) {
                case '*':
                    calc.setResul(mult.Multiplicar(calc.getN1(), calc.getN2()));
                    break;
                case '+':
                    calc.setResul(soma.Somar(calc.getN1(), calc.getN2()));
                    break;
                case '-':
                    calc.setResul(sub.Subtrair(calc.getN1(), calc.getN2()));
                    break;
                case '/':
                    calc.setResul(divi.Div(calc.getN1(), calc.getN2()));
                    break;
                case '√':
                    calc.setResul(raiz.RaizQuadrada(calc.getN1()));

            }

            if (!(calc.getOperador() == '√')) {
                System.out.printf("Resultado: %d %c %d = %.0f %n", calc.getN1(), calc.getOperador(), calc.getN2(),
                        calc.getResul());
            } else {
                System.out.printf("Raiz(%d) = %.1f %n", calc.getN1(), calc.getResul());
            }

            /* Adicionando conta no Historico */
            menu.addHistorico(calc);

            /* Menu */

            do {
                /* Validacao de dados */
                while (true) {
                    try {
                        System.out.println("+-----------------------+");
                        System.out.println("| 1. Fechar programa    |");
                        System.out.println("| 2. Fazer outra conta  |");
                        System.out.println("| 3. Acessar historico  |");
                        System.out.println("+-----------------------+");

                        menu.setOpcao(sc.nextInt());
                        if (menu.getOpcao() > 3 || menu.getOpcao() < 1) {
                            throw new Exception("Não existe essa opção. Digite novamente");
                        }
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println(String.format("Erro: Valor inválido. Digite novamente."));
                        sc.next();
                        continue;
                    } catch (Exception j) {
                        System.out.println("Erro: " + j.getMessage());
                    }

                }

                /* Execução da opção */
                menu.opcoes(menu.getOpcao());

            } while (menu.getRepetirMenu());

        } while (menu.getRepetir());

        sc.close();

    }

}
