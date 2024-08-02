import java.util.*;
//Estrutura QuickSort

public class Main {
    public static void main(String[] args) {
        //Parte da jay
      boolean control = true;
        while (control) {
            showMenu();
            int menu = getUserMenu();
            if (menu == 1) {
                quicksort(numbersToSort, 0, numbersToSort.size() - 1);
                System.out.println(numbersToSort);
            } else if (menu == 2) {
                int size = numbersToSort.size();
                quicksort(numbersToSort, 0, numbersToSort.size() - 1); //ordena
                for (int i = 0; i < size / 2; i++) { //percorre 
                    int temporaria = numbersToSort.get(i);
                    numbersToSort.set(i, numbersToSort.get(size - 1 - i));
                    numbersToSort.set(size - 1 - i, temporaria); //inverte 
                }
                System.out.println(" " +numbersToSort);
            } else if (menu == 3) {
                System.out.println("Fim do programa.");
                control = false; //finaliza
            } else {
                System.out.println("Opção invalida."); 
            }
        }
    }

    private static void showMenu(){
        System.out.println("Escolha sua opção: \n"+
                "1 para ver ordenar lista \n"+
                "2 para ver lista ao contrario \n"+
                "3 para sair");
    }

    private static int getUserMenu(){
        System.out.println("Escolha sua opção: ");
        while (!scanner.hasNextInt()){
            scanner.next();
        }
        return scanner.nextInt(); //retorna scanner quando dada opção invalida
    }
    
    public static int partition(List<Integer> numbersToSort, int begin, int end) { // numbersToSort = lista de numeros, begin = inicial, end= final
        //Parte Sami
        int pivot = numbersToSort.get(begin);
        int index = begin + 1;
        int subIndex = end; // criei um subindice p manipular os dados de end, pq alterar end diretamente tava dando bug em toda a ordenação


        while (index <= subIndex) {
            // erro lógico: deixar como < subindice tava ordenando tudo errado, uma metade ficava ordenada e outra nao
            if (numbersToSort.get(index) <= pivot) {
                index++;

            } else {
                int temporary = numbersToSort.get(index);
                numbersToSort.set(index, numbersToSort.get(subIndex)); // alterei p subIndice tudo q envolvia manipulaçao do end pq ou dava algum erro de exceçao ou ordenada tudo errado de novo, vou fazer um comparativo dos erros e deixar escrito num arquivo de texto explicando
                numbersToSort.set(subIndex, temporary);
                subIndex--;
            }
            // laço continua verificando os elementos seguintes da lista (begin + 2), (begin + 3), até chegar ao fim
        }
        numbersToSort.set(begin, numbersToSort.get(subIndex)); // valor do começo recebe o valor do final
        numbersToSort.set(subIndex, pivot); // valor do final recebe o valor do pivot
        return subIndex;
    }

    private static void quicksort(List<Integer> numbersToSort, int begin, int end) {
        //Parte Ali
        if (begin < end) {
            // Encontra a particão
            int pivo = partition(numbersToSort, begin, end);

            // Ordena as metades
            quicksort(numbersToSort, begin, pivo - 1);
            quicksort(numbersToSort, pivo + 1, end);
        }
    }
}
