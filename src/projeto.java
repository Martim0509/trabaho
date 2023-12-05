import java.util.Scanner;
import java.sql.SQLOutput;

public class projeto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tamMax = 100;
        String[] nome = new String[tamMax];
        double[] quanto = new double[tamMax];
        double[] preco = new double[tamMax];
        boolean[] feito = new boolean[tamMax];
        int nItens = 0;


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
                case 'e':
                case 'E':
                    System.out.println(submenuE);
                    opcao = scanner.next().charAt(0);

                        switch (opcao){
                            case 'i':
                                System.out.println("Inserir item no fim da lista.");
                                String novoItem = scanner.next();
                                nome[nItens] = novoItem;
                                System.out.println("O item inserido foi para o fim da lista.");
                                break;

                        case 'p':
                            for (int i = 0; i < nItens; i++) {
                                System.out.printf("%d \t %s \n", (i + 1), nome[i]);
                            }

                            System.out.println("Insira a posição do item.");
                            int posicao1 = scanner.nextInt() - 1;
                            if (posicao1 < 0 || posicao1 >= nItens) {
                                System.out.println("Posição inválida.");
                                return;}

                            System.out.println("Insira a posicao que pertende que fique esse item.");
                            int posicao2 = scanner.nextInt() - 1;
                            if (posicao2 < 0 || posicao2 >= nItens) {
                                System.out.println("Nova posição inválida.");
                                return;}

                            String subs = nome[posicao1];
                            nome[posicao1] = nome[posicao2];
                            nome[posicao2] = subs;

                            System.out.println("Lista atualizada:");
                            for (int i = 0; i < nItens; i++) {
                                System.out.printf("%d \t %s \n", (i + 1), nome[i]);
                            }



                            break;

                        case 'a':
                            System.out.println("Apagar último item inserido na lista.");
                            break;

                        case 'n':
                        case 'N':
                            System.out.println("Apagar item na posição (n) da lista.");
                            break;

                        case 'A':
                            System.out.println("Apagar itens da posição m à n da lista.");
                            break;

                            case 'l':
                                System.out.println("Listar todos os itens.");
                                break;

                        case 'v':
                            System.out.println("Voltar.");
                            break;
                    }
                    break;

                case 'f':
                case 'F':
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
                case 'C':
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



    }

