import java.util.Scanner;

public class projeto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tamMax = 100;
        String[] nome = new String[tamMax];
        double[] quanto = new double[tamMax];
        double[] preco = new double[tamMax];
        boolean[] feito = new boolean[tamMax];
        int nItens = 0;


        String novalista []  ;


        String menuPrincipal = "(E)ditar lista.\n"
                + "(F)azer compras.\n"
                + "Fazer (c)ontas.\n"
                + "(S)air";

        String submenuE = "(I)nserir item no fim da lista.\n"
                + "Inserir item na (p)osição n da lista.\n"
                + "(A)pagar último item inserido na lista.\n"
                + "Apagar item na posição (n) da lista.\n"
                + "(A)pagar itens da posição m à n da lista.\n"
                + "(L)istar todos os itens.\n"
                + "(V)oltar.";

        String submenuF = "(M)arcar primeiro item por comprar.\n"
                + "(D)esmarcar primeiro item comprado.\n"
                + "Trocar estado por (n)ome.\n"
                + "Trocar estado por (p)osição.\n"
                + "(L)istar.\n"
                + "(V)oltar.";

        String submenuListar = "Listar (t)odos os itens.\n"
                + "Listar itens (c)omprados.\n"
                + "Listar itens (p)or comprar.";
        String submenuC = "Quanto custa a (l)ista?\n"
                + "Quanto já (g)astei?\n"
                + "Quanto custa o que (f)alta comprar?\n"
                + "Qual o preço (m)édio por item?";


        char opcao;

        do {
            System.out.println(menuPrincipal);
            opcao = scanner.next().charAt(0);
            switch (opcao) {
                case 'E':
                    System.out.println(submenuE);
                    opcao = scanner.next().charAt(0);

                    switch (opcao) {
                        case 'I':
                            System.out.println("Insira um produto.");
                            String novoProduto = scanner.next();
                            nome[nItens] = novoProduto;
                            System.out.println("Indique a sua quantidade.");
                            double quantidade = scanner.nextDouble();
                            System.out.println("Insira o valor do produto.");
                            double valorProduto = scanner.nextDouble();
                            nItens++;
                            break;

                        case 'p':
                            for (int i = 0; i < nItens; i++) {
                                System.out.printf("%d \t %s \n", (i + 1), nome[i]);
                            }

                            System.out.println("Insira a posição do item.");
                            int posicao1 = scanner.nextInt() - 1;
                            if (posicao1 < 0 || posicao1 >= nItens) {
                                System.out.println("Posição inválida.");
                                return;
                            }

                            System.out.println("Insira a posicao que pertende que fique esse item.");
                            int posicao2 = scanner.nextInt() - 1;
                            if (posicao2 < 0 || posicao2 >= nItens) {
                                System.out.println("Nova posição inválida.");
                                return;
                            }

                            String subs = nome[posicao1];
                            nome[posicao1] = nome[posicao2];
                            nome[posicao2] = subs;

                            System.out.println("Lista atualizada:");
                            for (int i = 0; i < nItens; i++) {
                                System.out.printf("%d \t %s \n", (i + 1), nome[i]);
                            }
                            break;

                        case 'A':
                            nItens--;
                            System.out.println("O item inserido por último foi retirado da lista.");
                            break;

                        case 'n':
                            for (int i = 0; i < nItens; i++) {
                                System.out.printf("%d \t %s \n", (i + 1), nome[i]);}

                            System.out.println("Insira a posição do item.");
                            int pos = scanner.nextInt();

                            if (pos >= 0|| pos < nItens) {
                                for (int i = pos; i < nItens - 1; i++) {

                                    nome[i] = nome[i + 1];
                                    quanto[i] = quanto[i + 1];
                                    preco[i] = preco[i + 1];
                                    feito[i] = feito[i + 1];

                                }
                                nItens--;
                            }
                                System.out.println("Item na posição " + pos + " removido");

                        case 'a':
                            System.out.println("Apagar itens da posição m à n da lista.");
                            break;

                        case 'L':
                            System.out.println(submenuListar);
                            char Lista = scanner.next().charAt(0);
                            switch (Lista) {
                                case 't':
                                    System.out.println("Listar todos os itens.");
                                    for (int i = 0; i < nItens; i++) {
                                        System.out.printf("%d \t %s \t % \t % \n", (i + 1), nome[i], , );
                                    }
                                    break;
                                case 'c':
                                    System.out.println("Listar itens comprados");
                                    break;
                                case 'p':
                                    System.out.println("Listar itens por comprar");
                                    break;
                            }
                            break;


                        case 'v':
                            System.out.println("Voltar.");
                            break;
                    }
                    break;

                case 'f':
                    System.out.println(submenuF);
                    switch (opcao) {
                        case 'm':
                            System.out.println();
                            break;

                        case 'd':
                            System.out.println();
                            break;

                        case 'n':
                            System.out.println();
                            break;

                        case 'p':
                            System.out.println();
                            break;

                        case 'l':
                            System.out.println();
                            break;

                        case 'v':
                            System.out.println();
                            break;
                    }
                    break;


                case 'c':
                    System.out.println(submenuC);
                    switch (opcao) {
                        case 'l':
                            System.out.println();
                            break;

                        case 'g':
                            System.out.println();
                            break;

                        case 'f':
                            System.out.println();
                            break;

                        case 'm':
                            System.out.println();
                            break;
                    }
                    break;

            }

        }
        while (opcao != 's' && opcao != 'S');
        System.out.println("Encerrou o programa.");


    }
}



