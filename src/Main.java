import java.util.*;
//Estrutura QuickSort

public class Main {
    public static void main(String[] args) {
        //Parte da jay
        List<Integer> numbersToSort = Arrays.asList( //Geramento do vetor comos numeros
         4, 3, 2, 5, 1, 3, 2, 9, 0, 2);

        System.out.println(numbersToSort);
        quicksort(numbersToSort, 0, numbersToSort.size() - 1);
        System.out.println(numbersToSort);
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
