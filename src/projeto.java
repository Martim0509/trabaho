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
        //Abre o menu principal
        do {
            System.out.println("---------------------------------------------------------------");
            System.out.println(menuPrincipal);
            System.out.println("---------------------------------------------------------------");
            opcao = scanner.next().charAt(0);
            switch (opcao) {

                // Abre o Submenu "Editar lista".

                case 'E':
                    System.out.println("---------------------------------------------------------------");
                    System.out.println(submenuE);
                    System.out.println("---------------------------------------------------------------");
                    opcao = scanner.next().charAt(0);


                    switch (opcao) {

                        //Insere um item para o fim da lista.

                        case 'I':
                            //Imprime o produto com a sua quantidade e o seu valor
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

                        //Troca a posição de dois itens a escola do utilizador.

                        case 'p':
                            System.out.println("Lista");
                            //Imprime a tabela
                            for (int i = 0; i < nItens; i++) {
                                System.out.printf("%d \t %s \n", (i + 1), nome[i]);

                            }
                            System.out.println("---------------------------------------------------------------");
                            System.out.println("Insira a posição para inserir o item:");
                            int posicao = scanner.nextInt();
                            scanner.nextLine();
                            if (posicao >= 0 && posicao < nItens && nItens < tamMax) {


                                // Desloca os itens para abrir espaço para o novo item
                                for (int i = nItens; i > posicao; i--) {
                                    System.out.println("Insira um novo item.");
                                    String itemPosicao = scanner.nextLine();
                                    nome[i] = nome[i - 1];

                                nome[posicao - 1] = itemPosicao;
                                nItens++;
                                    System.out.println("---------------------------------------------------------------");
                                    System.out.println("O item " + itemPosicao + " está agora na posição " + posicao + ".");
                                }
                            } else {
                                System.out.println("Posição inválida.");
                            }
                            break;

                        //Apaga o ultimo item da lista.

                        case 'A':
                            nItens--;
                            System.out.println("O item inserido por último foi retirado da lista.");
                            break;

                        //Apaga o item da posição que o utilizador escolher.

                        case 'n':
                            //Imprime a lista
                            System.out.println("Lista");
                            for (int i = 0; i < nItens; i++) {
                                System.out.printf("%d: \t %s \n", (i + 1), nome[i]);
                            }
                            //Imprime a posição escolhida
                            System.out.println("Insira a posição do item.");
                            int pos = scanner.nextInt();
                            //Remove o item da posição que o utilizador escolheu
                            if (pos >= 0 || pos < nItens) {
                                for (int i = pos - 1; i < nItens - 1; i++) {

                                    nome[i] = nome[i + 1];
                                    quanto[i] = quanto[i + 1];
                                    preco[i] = preco[i + 1];
                                    feito[i] = feito[i + 1];

                                }
                                nItens--;
                            }
                            //Imprime a posição em que o item foi removido
                            System.out.println("Item na posição " + pos + " removido");
                            break;

                        //Apaga os itens que estiverem de uma posição a outra que o utilizador escolher.

                        case 'a':
                            System.out.println("Apagar itens da posição m à n da lista.");

                            //Verifica se a lista tem algum item

                            if (nItens > 0) {
                                System.out.println("Insira a posição do primeiro item.");
                                int m = scanner.nextInt();

                                System.out.println("Insira a posição do ultimo item.");
                                int n = scanner.nextInt();

                                //Remove o itens entre as posições escolhidas pelo utilizador

                                if (m >= 0 || n < nItens || m <= n) {
                                    int removidos = n - m + 1;
                                    for (int i = m; i < nItens - removidos; i++) {
                                        nome[i] = nome[i + removidos];
                                        quanto[i] = quanto[i + removidos];
                                        preco[i] = preco[i + removidos];
                                        feito[i] = feito[i + removidos];
                                    }
                                    nItens -= removidos;

                                    //Imprime o intervalo em que os itens foram removidos

                                    System.out.println("Os itens da posição " + m + " à posição " + n + " foram removidos.");
                                } else {
                                    //imprime caso a posição seja invalida
                                    System.out.println("posições inválidas.");
                                }
                            } else {
                                //imprime caso a lista esteja vazia
                                System.out.println("A lista está vazia");
                            }

                            break;

                        //Mostra a lista com todos os itens que o utilizador inseriu.

                        case 'L':
                            //imprime a lista de produtos
                            System.out.println("---------------------------------------------------------------");
                            System.out.println("Lista de produtos");
                            System.out.printf("%s  %-25s  %-10s  %-8s %-8s\n", " ", "Item", "Quantidade", "Preço", "Comprado");
                            for (int i = 0; i < nItens; i++) {
                                for (i = 0; i < nItens; i++) {
                                    char marcado = feito[i] ? 'x' : ' ';
                                    System.out.printf("%d:  %-25s  %-10.2f  %-8.2f  %-8c\n", i, nome[i], quanto[i], preco[i], marcado);
                                }
                            }
                            break;

                        //Volta para o menu principal.

                        case 'v':
                            System.out.println("Voltar.");
                            break;
                    }
                    break;

                //Abre o submenu "Fazer compras".

                case 'F':
                    //imprime o submenuF
                    System.out.println("---------------------------------------------------------------");
                    System.out.println(submenuF);
                    System.out.println("---------------------------------------------------------------");
                    opcao = scanner.next().charAt(0);
                    switch (opcao) {

                        //Marca o primeiro item que estiver por comprar como comprado.
                        case 'M':
                            //imprime a lista de produtos
                            System.out.println("---------------------------------------------------------------");
                            System.out.printf("%s  %-25s  %-10s  %-8s %-8s\n", " ", "Item", "Quantidade", "Preço", "Comprado");
                            for (int i = 0; i < nItens; i++) {
                                char marcado = feito[i] ? 'x' : ' ';
                                System.out.printf("%d:  %-25s  %-10.2f  %-8.2f  %-8c\n", i, nome[i], quanto[i], preco[i], marcado);
                            }
                            //assinala o item como comprado
                            if (nItens > 0) {
                                for (int i = 0; i < nItens; i++) {
                                    if (!feito[i]) {
                                        feito[i] = true;
                                        System.out.println("\n" + nome[i] + " está assinalado como comprado.");
                                        break;
                                    }
                                }
                            } else {
                                //imprime caso a lista estaja vazia
                                System.out.println("A lista está vazia.");
                            }
                            //imprime a lista atualizada
                            System.out.println("---------------------------------------------------------------");
                            System.out.printf("%s  %-25s  %-10s  %-8s %-8s\n", " ", "Item", "Quantidade", "Preço", "Comprado");

                            for (int i = 0; i < nItens; i++) {
                                char marcado = feito[i] ? 'x' : ' ';
                                System.out.printf("%d:  %-25s  %-10.2f  %-8.2f  %-8c\n", i, nome[i], quanto[i], preco[i], marcado);
                            }

                            break;

                        //Desmarca o primeiro item comprado para por comprar.

                        case 'D':
                            //imprime a lista de produtos
                            System.out.println("---------------------------------------------------------------");
                            System.out.printf("%s  %-25s  %-10s  %-8s %-8s\n", " ", "Item", "Quantidade", "Preço", "Comprado");
                            for (int i = 0; i < nItens; i++) {
                                char marcado = feito[i] ? 'x' : ' ';
                                System.out.printf("%d:  %-25s  %-10.2f  %-8.2f  %-8c\n", i, nome[i], quanto[i], preco[i], marcado);
                            }
                            boolean primeiroItem = false;
                            //desmarca o primeiro item marcado como comprado
                            if (nItens > 0) {
                                for (int i = 0; i < nItens; i++) {
                                    if (feito[i]) {
                                        feito[i] = false;
                                        System.out.println("\n" + nome[i] + " está assinalado como por comprar.");
                                        primeiroItem = true;
                                        break;
                                    }
                                }
                            } else {
                                //imprime caso a lista esteja vazia
                                System.out.println("A lista está vazia.");
                            }
                            //imprime a lista atualizada
                            System.out.println("---------------------------------------------------------------");
                            System.out.printf("%s  %-25s  %-10s  %-8s %-8s\n", " ", "Item", "Quantidade", "Preço", "Comprado");
                            for (int i = 0; i < nItens; i++) {
                                char marcado = feito[i] ? 'x' : ' ';
                                System.out.printf("%d:  %-25s  %-10.2f  %-8.2f  %-8c\n", i, nome[i], quanto[i], preco[i], marcado);
                            }

                            break;

                        //Trocar estado do item pelo nome.

                        case 'n':
                            //imprime a lista
                            System.out.println("---------------------------------------------------------------");
                            System.out.println("Lista de produtos");
                            System.out.printf("%s  %-25s  %-10s  %-8s %-8s\n", " ", "Item", "Quantidade", "Preço", "Comprado");
                            for (int i = 0; i < nItens; i++) {
                                for (i = 0; i < nItens; i++) {
                                    char marcado = feito[i] ? 'x' : ' ';
                                    System.out.printf("%d:  %-25s  %-10.2f  %-8.2f  %-8c\n", i, nome[i], quanto[i], preco[i], marcado);
                                }
                            }
                            System.out.println("\nQual o nome do item que pretende mudar o estado?");
                            String item = scanner.next();
                            boolean estadoItem = false;
                            //muda o estado de um item pelo nome
                            for (int i = 0; i < nItens; i++) {
                                if (nome[i].length() > 0 && nome[i].charAt(0) == item.charAt(0)) {
                                    feito[i] = !feito[i];
                                    System.out.println("Mudança feita com sucesso!\n");

                                }

                            }
                            //imprime a lista atualizada
                            System.out.println("Lista de produtos");
                            System.out.printf("%s  %-25s  %-10s  %-8s %-8s\n", " ", "Item", "Quantidade", "Preço", "Comprado");
                            for (int i = 0; i < nItens; i++) {
                                for (i = 0; i < nItens; i++) {
                                    char marcado = feito[i] ? 'x' : ' ';
                                    System.out.printf("%d:  %-25s  %-10.2f  %-8.2f  %-8c\n", i, nome[i], quanto[i], preco[i], marcado);
                                }
                            }

                            break;

                        //Trocar estado do item pela posição.

                        case 'p':
                            //imprime a lista
                            System.out.println("---------------------------------------------------------------");
                            System.out.printf("%s  %-25s  %-10s  %-8s %-8s\n", " ", "Item", "Quantidade", "Preço", "Comprado");
                            for (int i = 0; i < nItens; i++) {
                                char marcado = feito[i] ? 'x' : ' ';
                                System.out.printf("%d:  %-25s  %-10.2f  %-8.2f  %-8c\n", i, nome[i], quanto[i], preco[i], marcado);
                            }
                            System.out.println("\nQual a posição do item a ser marcado ou desmarcado");
                            int pos = scanner.nextInt();
                            if (pos < 0 || pos >= nItens) {
                                //imprime caso a posição seja inválida
                                System.out.println("posição inválida");
                            } else {
                                //muda o estado do item pela posição
                                feito[pos] = !feito[pos];
                                String estado = feito[pos] ? "comprado" : "por comprar";
                                System.out.println(nome[pos] + " está agora " + estado + ".");
                            }
                            //imprime a tabela atualizada
                            System.out.println("---------------------------------------------------------------");
                            System.out.printf("%s  %-25s  %-10s  %-8s %-8s\n", " ", "Item", "Quantidade", "Preço", "Comprado");
                            for (int i = 0; i < nItens; i++) {
                                char marcado = feito[i] ? 'x' : ' ';
                                System.out.printf("%d:  %-25s  %-10.2f  %-8.2f  %-8c\n", i, nome[i], quanto[i], preco[i], marcado);
                            }
                            break;

                        //Abre um outro submenu "listar".

                        case 'L':
                            //imprime o submenuListar
                            System.out.println("---------------------------------------------------------------");
                            System.out.println(submenuListar);
                            System.out.println("---------------------------------------------------------------");
                            char Lista = scanner.next().charAt(0);

                            switch (Lista) {

                                //Mostra a lista com todos os itens que o utilizador inseriu.
                                case 't':
                                    //imprime a lista toda
                                    System.out.println("---------------------------------------------------------------");
                                    System.out.println("Todos os itens.");
                                    System.out.printf("%s  %-25s  %-10s  %-8s %-8s\n", " ", "Item", "Quantidade", "Preço", "Comprado");
                                    for (int i = 0; i < nItens; i++) {
                                        char marcado = feito[i] ? 'x' : ' ';
                                        System.out.printf("%d:  %-25s  %-10.2f  %-8.2f  %-8c\n", i, nome[i], quanto[i], preco[i], marcado);
                                    }
                                    break;

                                //Lista com todos os itens comprados.

                                case 'c':
                                    //imprime a lista dos itens comprados apenas
                                    System.out.println("---------------------------------------------------------------");
                                    System.out.println("Itens comprados.");
                                    System.out.printf(" %s  %-25s  %-10s %-8s %-8s\n", " ", "Item", "Quantidade", "Preço", "Comprado");
                                    for (int i = 0; i < nItens; i++) {
                                        char marcado = feito[i] ? 'x' : ' ';
                                        if (feito[i]) {
                                            System.out.printf("%d:  %-25s  %-10.2f  %-8.2f  %-8c\n", i, nome[i], quanto[i], preco[i], marcado);
                                        }
                                    }
                                    break;

                                //Lista com todos os itens por comprar.

                                case 'p':
                                    //imprime a lista do itens por comprar apenas
                                    System.out.println("---------------------------------------------------------------");
                                    System.out.println("Itens por comprar.");
                                    System.out.printf(" %s  %-25s  %-10s %-8s %-8s\n", " ", "Item", "Quantidade", "Preço", "Comprado");
                                    for (int i = 0; i < nItens; i++) {
                                        char marcado = feito[i] ? 'x' : ' ';
                                        if (!feito[i]) {
                                            System.out.printf("%d:  %-25s  %-10.2f  %-8.2f  %-8c\n", i, nome[i], quanto[i], preco[i], marcado);
                                        }
                                    }
                                    break;

                                default:
                                    //imprime caso n haja lista
                                    System.out.println("Opção inválida de listagem.");
                                    break;
                            }
                            break;

                        //Volta para o menu principal.

                        case 'v':
                            System.out.println("Voltar.");
                            break;
                    }
                    break;

                //Abre o submenu "Fazer contas".

                case 'c':
                    System.out.println(submenuC);
                    opcao = scanner.next().charAt(0);
                    switch (opcao) {

                        //Calcula quanto custa a lista toda.

                        case 'l':
                            System.out.println("---------------------------------------------------------------");
                            double quantocusta1 = 0;

                            for (int i = 0; i < nItens; i++) {
                                quantocusta1 = quantocusta1 + (quanto[i] * preco[i]);
                            }
                            System.out.println("A lista custa " + quantocusta1);
                            break;

                        //Calcula quanto já gastou.

                        case 'g':
                            System.out.println("---------------------------------------------------------------");
                            double gasto = 0;
                            for (int i = 0; i < nItens; i++) {
                                if (feito[i]) {
                                    gasto = gasto + (quanto[i] * preco[i]);
                                }

                            }
                            System.out.println("No total o utilizador gastou " + gasto);
                            break;

                        //Calcula o preço do que falta comprar.

                        case 'f':
                            System.out.println("---------------------------------------------------------------");
                            double faltacomprar = 0;
                            for (int i = 0; i < nItens; i++) {
                                if (!feito[i]) {
                                    faltacomprar = faltacomprar + (quanto[i] * preco[i]);
                                }
                            }
                            System.out.println("O valor do que falta comprar é " + faltacomprar);
                            break;

                        //Calcula o preço médio por item.

                        case 'm':
                            System.out.println("---------------------------------------------------------------");
                            System.out.println("Qual o preço médio por item?");
                            double mediatudo = 0;
                            double quantocustaa = 0;
                            if (nItens > 0) {
                                for (int i = 0; i < nItens; i++) {
                                    quantocustaa = quantocustaa + (quanto[i] * preco[i]);
                                    mediatudo = quantocustaa / nItens;
                                }
                            } else {
                                System.out.println("A lista está vazia!");
                            }
                            System.out.println("O preço medio por item é " + mediatudo);
                            break;

                    }
            }

            //Encerra o programa.

        } while (opcao != 'S');
        System.out.println("Encerrou o programa.");


    }
}



