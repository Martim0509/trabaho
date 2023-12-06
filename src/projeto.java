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
            System.out.println("---------------------------------------------------------------");
            System.out.println(menuPrincipal);
            System.out.println("---------------------------------------------------------------");
            opcao = scanner.next().charAt(0);
            switch (opcao) {
                case 'E':
                    System.out.println("---------------------------------------------------------------");
                    System.out.println(submenuE);
                    System.out.println("---------------------------------------------------------------");
                    opcao = scanner.next().charAt(0);


                    switch (opcao) {
                        case 'I':
                            System.out.println("Insira um produto.");
                            String novoProduto = scanner.next();
                            nome[nItens] = novoProduto;
                            System.out.println("Indique a sua quantidade.");
                            double quantidade = scanner.nextDouble();
                            quanto[nItens] = quantidade;
                            System.out.println("Insira o valor do produto.");
                            double valorProduto = scanner.nextDouble();
                            preco[nItens] = valorProduto;
                            nItens++;
                            break;

                        case 'p':
                            System.out.println("Lista");
                            for (int i = 0; i < nItens; i++) {
                                System.out.printf("%d \t %s \n", (i + 1), nome[i]);


                            }
                            System.out.println("---------------------------------------------------------------");
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

                            System.out.println("---------------------------------------------------------------");
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
                            System.out.println("Lista");
                            for (int i = 0; i < nItens; i++) {
                                System.out.printf("%d \t %s \n", (i + 1), nome[i]);
                            }

                            System.out.println("Insira a posição do item.");
                            int pos = scanner.nextInt();

                            if (pos >= 0 || pos < nItens) {
                                for (int i = pos - 1; i < nItens - 1; i++) {

                                    nome[i] = nome[i + 1];
                                    quanto[i] = quanto[i + 1];
                                    preco[i] = preco[i + 1];
                                    feito[i] = feito[i + 1];

                                }
                                nItens--;
                            }
                            System.out.println("Item na posição " + pos + " removido");
                            break;

                        case 'a':
                            System.out.println("Apagar itens da posição m à n da lista.");


                            if (nItens > 0) {
                                System.out.println("Insira a posição do primeiro item.");
                                int m = scanner.nextInt();
                                System.out.println("Insira a posição do ultimo item.");
                                int n = scanner.nextInt();


                                if (m >= 0 || n < nItens || m <= n) {
                                    int removidos = n - m + 1;
                                    for (int i = m; i < nItens - removidos; i++) {
                                        nome[i] = nome[i + removidos];
                                        quanto[i] = quanto[i + removidos];
                                        preco[i] = preco[i + removidos];
                                        feito[i] = feito[i + removidos];
                                    }
                                    nItens -= removidos;
                                    System.out.println("Os itens da posição " + m + " à posição " + n + " foram removidos.");
                                } else {
                                    System.out.println("posições inválidas.");
                                }
                            } else {
                                System.out.println("A lista está vazia");
                            }

                            break;

                        case 'L':
                            System.out.println("---------------------------------------------------------------");
                            System.out.println("Lista de produtos");
                            System.out.printf("%s  %-25s  %-10s  %-8s %-8s\n", " ", "Item", "Quantidade", "Preço", "Comprado");
                            for (int i = 0; i < nItens; i++) {
                                for (i = 0; i < nItens; i++) {
                                    char marcado = feito[i] ? 'x' : ' ';
                                    System.out.printf(" %d  %-25s  %-10.2f  %-8.2f  %-8c\n", i, nome[i], quanto[i], preco[i], marcado);
                                }
                            }
                            break;
                        case 'v':
                            System.out.println("Voltar.");
                            break;
                    }
                    break;

                case 'F':
                    System.out.println("---------------------------------------------------------------");
                    System.out.println(submenuF);
                    System.out.println("---------------------------------------------------------------");
                    opcao = scanner.next().charAt(0);
                    switch (opcao) {
                        case 'M':
                            System.out.println("---------------------------------------------------------------");
                            System.out.printf("%s  %-25s  %-10s  %-8s %-8s\n", " ", "Item", "Quantidade", "Preço", "Comprado");
                            for (int i = 0; i < nItens; i++) {
                                char marcado = feito[i] ? 'x' : ' ';
                                System.out.printf(" %d  %-25s  %-10.2f  %-8.2f  %-8c\n", i, nome[i], quanto[i], preco[i], marcado);
                            }
                            if (nItens > 0) {
                                for (int i = 0; i < nItens; i++) {
                                    if (!feito[i]) {
                                        feito[i] = true;
                                        System.out.println("\n"+nome[i] + " está assinalado como comprado.");
                                        break;
                                    }
                                }
                            } else {
                                System.out.println("A lista está vazia.");
                            }
                            System.out.println("---------------------------------------------------------------");

                            System.out.printf("%s  %-25s  %-10s  %-8s %-8s\n", " ", "Item", "Quantidade", "Preço", "Comprado");

                            for (int i = 0; i < nItens; i++) {
                                char marcado = feito[i] ? 'x' : ' ';
                                System.out.printf(" %d  %-25s  %-10.2f  %-8.2f  %-8c\n", i, nome[i], quanto[i], preco[i], marcado);
                            }

                            break;

                        case 'D':
                            System.out.println("---------------------------------------------------------------");
                            System.out.printf("%s  %-25s  %-10s  %-8s %-8s\n", " ", "Item", "Quantidade", "Preço", "Comprado");
                            for (int i = 0; i < nItens; i++) {
                                char marcado = feito[i] ? 'x' : ' ';
                                System.out.printf(" %d  %-25s  %-10.2f  %-8.2f  %-8c\n", i, nome[i], quanto[i], preco[i], marcado);
                            }
                            boolean primeiroItem = false;
                            if (nItens > 0) {
                                for (int i = 0; i < nItens; i++) {
                                    if (feito[i]) {
                                        feito[i] = false;
                                        System.out.println("\n"+ nome[i] + " está assinalado como por comprar.");
                                        primeiroItem = true;
                                        break;
                                    }
                                }
                            } else {
                                System.out.println("A lista está vazia.");
                            }
                            System.out.println("---------------------------------------------------------------");
                            System.out.printf("%s  %-25s  %-10s  %-8s %-8s\n", " ", "Item", "Quantidade", "Preço", "Comprado");
                            for (int i = 0; i < nItens; i++) {
                                char marcado = feito[i] ? 'x' : ' ';
                                System.out.printf(" %d  %-25s  %-10.2f  %-8.2f  %-8c\n", i, nome[i], quanto[i], preco[i], marcado);
                            }

                            break;

                        case 'n':
                            System.out.println("---------------------------------------------------------------");
                            System.out.println("Lista de produtos");
                            System.out.printf("%s  %-25s  %-10s  %-8s %-8s\n", " ", "Item", "Quantidade", "Preço", "Comprado");
                            for (int i = 0; i < nItens; i++) {
                                for (i = 0; i < nItens; i++) {
                                    char marcado = feito[i] ? 'x' : ' ';
                                    System.out.printf(" %d  %-25s  %-10.2f  %-8.2f  %-8c\n", i, nome[i], quanto[i], preco[i], marcado);
                                }
                            }
                            System.out.println("\nQual o nome do item que pretende mudar o estado?");
                            String item = scanner.next();
                            boolean estadoItem = false;

                            for (int i=0; i < nItens; i++) {
                                if (nome[i].length() > 0 && nome[i].charAt(0) == item.charAt(0)) {
                                    feito[i] = !feito[i];
                                    System.out.println("Mudança feita com sucesso!\n");

                                }

                            }
                            System.out.println("Lista de produtos");
                            System.out.printf("%s  %-25s  %-10s  %-8s %-8s\n", " ", "Item", "Quantidade", "Preço", "Comprado");
                            for (int i = 0; i < nItens; i++) {
                                for (i = 0; i < nItens; i++) {
                                    char marcado = feito[i] ? 'x' : ' ';
                                    System.out.printf(" %d  %-25s  %-10.2f  %-8.2f  %-8c\n", i, nome[i], quanto[i], preco[i], marcado);
                                }
                            }

                            break;

                        case 'p':
                            System.out.println("---------------------------------------------------------------");
                            System.out.printf("%s  %-25s  %-10s  %-8s %-8s\n", " ", "Item", "Quantidade", "Preço", "Comprado");
                            for (int i = 0; i < nItens; i++) {
                                char marcado = feito[i] ? 'x' : ' ';
                                System.out.printf(" %d  %-25s  %-10.2f  %-8.2f  %-8c\n", i, nome[i], quanto[i], preco[i], marcado);
                            }
                            System.out.println("\nQual a posição do item a ser marcado ou desmarcado");
                            int pos =scanner.nextInt();
                            if(pos<0 || pos >=nItens){
                                System.out.println("posição inválida");
                            }else{
                                feito[pos]= !feito[pos];
                                String estado = feito[pos] ? "comprado" : "por comprar";
                                System.out.println(nome[pos] + " está agora " + estado + ".");
                            }
                            System.out.println("---------------------------------------------------------------");
                            System.out.printf("%s  %-25s  %-10s  %-8s %-8s\n", " ", "Item", "Quantidade", "Preço", "Comprado");
                            for (int i = 0; i < nItens; i++) {
                                char marcado = feito[i] ? 'x' : ' ';
                                System.out.printf(" %d  %-25s  %-10.2f  %-8.2f  %-8c\n", i, nome[i], quanto[i], preco[i], marcado);
                            }
                            break;

                        case 'L':
                            System.out.println("---------------------------------------------------------------");
                            System.out.println(submenuListar);
                            System.out.println("---------------------------------------------------------------");
                            char Lista = scanner.next().charAt(0);

                            switch (Lista) {
                                case 't':
                                    System.out.println("---------------------------------------------------------------");
                                    System.out.println("Todos os itens.");
                                    System.out.printf("%s  %-25s  %-10s  %-8s %-8s\n", " ", "Item", "Quantidade", "Preço", "Comprado");
                                    for (int i = 0; i < nItens; i++) {
                                        char marcado = feito[i] ? 'x' : ' ';
                                        System.out.printf("%d:  %-25s  %-10.2f  %-8.2f  %-8c\n", i, nome[i], quanto[i], preco[i], marcado);
                                    }
                                    break;

                                case 'c':
                                    System.out.println("---------------------------------------------------------------");
                                    System.out.println("Itens comprados.");
                                    System.out.printf(" %s  %-25s  %-10s %-8s %-8s\n", " ", "Item", "Quantidade", "Preço", "Comprado");
                                    for (int i = 0; i < nItens; i++) {
                                        char marcado = feito[i] ? 'x' : ' ';
                                        if (feito[i]) {
                                            System.out.printf("%d:  %-25s  %-10.2f  %-8.2f  %-8c\n", i, nome[i], quanto[i], preco[i],marcado);
                                        }
                                    }
                                    break;
                                case 'p':
                                    System.out.println("---------------------------------------------------------------");
                                    System.out.println("Itens por comprar.");
                                    System.out.printf(" %s  %-25s  %-10s %-8s %-8s\n", " ", "Item", "Quantidade", "Preço", "Comprado");
                                    for (int i = 0; i < nItens; i++) {
                                        char marcado = feito[i] ? 'x' : ' ';
                                        if (!feito[i]) {
                                            System.out.printf(" %d  %-25s  %-10.2f  %-8.2f  %-8c\n", i, nome[i], quanto[i], preco[i],marcado);
                                        }
                                    }
                                    break;

                                default:
                                    System.out.println("Opção inválida de listagem.");
                                    break;
                            }
                            break;

                        case 'v':
                            System.out.println("Voltar.");
                            break;
                    }
                    break;


                case 'c':
                    System.out.println(submenuC);
                    opcao = scanner.next().charAt(0);
                    switch (opcao) {
                        case 'l':
                            System.out.println("---------------------------------------------------------------");
                            double quantocusta1 = 0;

                            for(int i = 0; i < nItens; i++){
                                quantocusta1 = quantocusta1+(quanto[i]*preco[i]);
                            }
                            System.out.println("A lista custa "+quantocusta1);
                            break;
                        case 'g':
                            System.out.println("---------------------------------------------------------------");
                            double gasto = 0;
                            for(int i = 0; i < nItens; i++){
                               if(feito[i]){
                                   gasto = gasto+(quanto[i]*preco[i]);
                               }

                            }
                            System.out.println("No total o utilizador gastou "+gasto);
                            break;
                        case 'f':
                            System.out.println("---------------------------------------------------------------");
                            double faltacomprar = 0;
                            for(int i = 0; i < nItens; i++){
                                if(!feito[i]) {
                                    faltacomprar = faltacomprar + (quanto[i] * preco[i]);
                                }
                            }
                            System.out.println("O valor do que falta comprar é "+faltacomprar);
                            break;

                        case 'm':
                            System.out.println("---------------------------------------------------------------");
                            System.out.println("Qual o preço médio por item?");
                            double mediatudo = 0;
                            double quantocustaa = 0;
                            if(nItens>0){
                                for(int i =0;  i < nItens; i++) {
                                    quantocustaa = quantocustaa + (quanto[i] * preco[i]);
                                    mediatudo = quantocustaa / nItens;
                                }
                            }else {
                                System.out.println("A lista está vazia!");
                            }
                            System.out.println("O preço medio por item é " +mediatudo );
                            break;

                    }
            }


        } while (opcao != 'S');
        System.out.println("Encerrou o programa.");


    }
}



