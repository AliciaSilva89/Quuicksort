import java.util.*;
//Estrutura QuickSort

public class Main {
    public static void main(String[] args) {
        //Parte da jay
        List<Integer> numbersToSort = Arrays.asList( //Geramento do vetor comos numeros
                12, 47, 5, 23, 38, 1, 14, 50, 32, 9,
                45, 7, 19, 26, 36, 10, 28, 3, 34, 22,
                4, 43, 16, 27, 48, 8, 31, 11, 25, 39,
                18, 46, 6, 29, 40, 2, 35, 21, 44, 13,
                17, 49, 20, 33, 15, 37, 30, 41, 24, 42);
        quicksort(numbersToSort, 0, numbersToSort.size());
        System.out.println(numbersToSort);
    }

    public static int partition(List<Integer> numbersToSort, int begin, int end) { // numbersToSort = lista de numeros, begin = inicial, end= final
        //Parte Sami
        int pivot = numbersToSort.get(begin); // pivot vai começar no indice de comparaçao inicial

        for (int index = begin + 1; index < end; index++) {
            if (numbersToSort.get(index) <= pivot){
                index++;
            }else if (numbersToSort.get(end) > pivot){
                end--;
            }else {
                int temporary = numbersToSort.get(index);
                numbersToSort.set(index, numbersToSort.get(end));
                numbersToSort.set(end, temporary);
            }
            // laço continua verificando os elementos seguintes da lista (begin + 2), (begin + 3), até chegar ao fim
        }
        numbersToSort.set(begin, end); // valor do começo recebe o valor do final
        numbersToSort.set(end, pivot); // valor do final recebe o valor do pivot
        return end;
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
