package programas;

import classes.Aeronave;
import classes.Piloto;
import classes.Voo;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppPilotos {
    private static final int MAX_PILOTOS = 100;
    private static final int MAX_AERONAVES = 50;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Piloto> pilotos = new ArrayList<>();
        List<Aeronave> aeronaves = new ArrayList<>();
        List<Voo> voos = new ArrayList<>();

        int opcao;
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar piloto");
            System.out.println("2 - Listar pilotos");
            System.out.println("3 - Localizar piloto pelo CPF");
            System.out.println("4 - Cadastrar aeronave");
            System.out.println("5 - Criar voo");
            System.out.println("6 - Listar voos");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    if (pilotos.size() >= MAX_PILOTOS) {
                        System.out.println("Capacidade máxima de pilotos atingida.");
                    } else {
                        System.out.print("Nome do piloto: ");
                        String nome = scanner.nextLine();
                        System.out.print("CPF do piloto: ");
                        String cpf = scanner.nextLine();
                        System.out.print("Breve do piloto: ");
                        String breve = scanner.nextLine();

                        try {
                            pilotos.add(new Piloto(nome, cpf, breve));
                            System.out.println("Piloto cadastrado com sucesso!");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Erro: " + e.getMessage());
                        }
                    }
                    break;
                case 2:
                    if (pilotos.isEmpty()) {
                        System.out.println("Não há pilotos cadastrados para exibir.");
                    } else {
                        for (Piloto piloto : pilotos) {
                            System.out.println(piloto);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Digite o CPF do piloto: ");
                    String cpfBusca = scanner.nextLine();
                    boolean encontrado = false;
                    for (Piloto piloto : pilotos) {
                        if (piloto.getCpf().equals(cpfBusca)) {
                            System.out.println("Piloto encontrado: " + piloto);
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Piloto não encontrado.");
                    }
                    break;
                case 4:
                    if (pilotos.isEmpty()) {
                        System.out.println("Não é possível cadastrar aeronaves sem pilotos cadastrados.");
                    } else if (aeronaves.size() >= MAX_AERONAVES) {
                        System.out.println("Capacidade máxima de aeronaves atingida.");
                    } else {
                        System.out.print("Modelo da aeronave: ");
                        String modelo = scanner.nextLine();
                        System.out.print("Número de série da aeronave: ");
                        String numeroSerie = scanner.nextLine();
                        aeronaves.add(new Aeronave(modelo, numeroSerie));
                        System.out.println("Aeronave cadastrada com sucesso!");
                    }
                    break;
                case 5:
                    if (pilotos.isEmpty() || aeronaves.isEmpty()) {
                        System.out.println("Não é possível criar voos sem pilotos ou aeronaves cadastrados.");
                    } else {
                        System.out.print("Digite o CPF do piloto: ");
                        String cpfPiloto = scanner.nextLine();
                        Piloto pilotoVoo = null;
                        for (Piloto piloto : pilotos) {
                            if (piloto.getCpf().equals(cpfPiloto)) {
                                pilotoVoo = piloto;
                                break;
                            }
                        }
                        if (pilotoVoo == null) {
                            System.out.println("Piloto não encontrado.");
                        } else {
                            System.out.print("Digite o número de série da aeronave: ");
                            String numeroSerieVoo = scanner.nextLine();
                            Aeronave aeronaveVoo = null;
                            for (Aeronave aeronave : aeronaves) {
                                if (aeronave.getNumeroSerie().equals(numeroSerieVoo)) {
                                    aeronaveVoo = aeronave;
                                    break;
                                }
                            }
                            if (aeronaveVoo == null) {
                                System.out.println("Aeronave não encontrada.");
                            } else {
                                System.out.print("Digite o destino do voo: ");
                                String destino = scanner.nextLine();
                                Voo voo = new Voo(pilotoVoo, aeronaveVoo, destino);
                                voos.add(voo);
                                System.out.println("Voo criado: " + voo);
                            }
                        }
                    }
                    break;
                case 6:
                    if (voos.isEmpty()) {
                        System.out.println("Não há voos cadastrados para exibir.");
                    } else {
                        for (Voo voo : voos) {
                            System.out.println(voo);
                        }
                    }
                    break;
                case 0:
                    System.out.println("Fim do programa!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
