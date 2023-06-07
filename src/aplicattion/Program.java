package aplicattion;

import entities.Funcionario;
import entities.FuncionarioTerceiro;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);


        do {

            System.out.print("BEM VINDO AO SISTEMA, DIGITE 1 PARA INICIAR OU 0 PARA SAIR: ");
            int opStart = sc.nextInt();
            if (opStart == 1) {

                List<Funcionario> list = new ArrayList<>();
                System.out.print("ENTRE COM O NÚMERO DE FUNCIONÁRIOS: ");
                int n = sc.nextInt();

                for (int i = 1; i <= n; i++) {
                    System.out.println("DADOS DO FUNCIONÁRIO #: " + i);
                    System.out.print("FUNCIONÁRIO TERCERIZADO(S/N): ");
                    char ch = sc.next().charAt(0);
                    System.out.print("NOME: ");
                    sc.nextLine();
                    String nome = sc.nextLine().toUpperCase();
                    System.out.print("QUANTIDADE DE HORAS: ");
                    int horas = sc.nextInt();
                    System.out.print("VALOR POR HORA: ");
                    double valorPorHora = sc.nextDouble();
                    if (ch == 's' || ch == 'S') {
                        System.out.print("DIGITE O VALOR ADICIONAL: ");
                        double valorAdicional = sc.nextDouble();
                        Funcionario funcionario = new FuncionarioTerceiro(nome, horas, valorPorHora, valorAdicional);
                        list.add(funcionario);
                    } else if (ch == 'n' || ch == 'N') {
                        Funcionario funcionario = new Funcionario(nome, horas, valorPorHora);
                        list.add(funcionario);
                    } else {
                        System.out.println();
                        System.out.println("OPÇÃO INVÁLIDA");
                    }
                }

                System.out.println();
                System.out.println("PAGAMENTOS: ");
                for (Funcionario funcionario : list) {
                    System.out.println(funcionario.getNome() +
                            "- R$ " + String.format("%.2f", funcionario.pagamento()));
                }
                System.out.println();
            } else if (opStart == 0) {
                System.exit(0);
                sc.close();
            } else {
                System.out.println();
                System.out.print("OPÇÃO INVÁLIDA!!!");
                System.out.println();
            }
        } while (true);
    }
}
