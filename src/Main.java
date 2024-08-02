import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbersToSort = new ArrayList<>();
        run(numbersToSort);
    }

    public static void run(List<Integer> numbersToSort) {
        System.out.println("");
        sortList(numbersToSort, input("DIGITE O TAMANHO DA LISTA: ").nextInt(), input("DIGITE O VALOR MÁXIMO DE CADA NÚMERO DA LISTA: ").nextInt());
        boolean control = true;
        while (control) {
            int option = input(showMenu()).nextInt();
            control = executeOption(numbersToSort, option);
        }
    }

    public static boolean executeOption(List<Integer> numbersToSort, int option) {
        if (option == 1) {
            quicksort(numbersToSort, 0, numbersToSort.size() - 1);
            System.out.println(numbersToSort);
        } else if (option == 2) {
            int size = numbersToSort.size();
            quicksort(numbersToSort, 0, numbersToSort.size() - 1);
            opposite(numbersToSort, size);
            System.out.println(" " + numbersToSort);
        } else if (option == 3) {
            System.out.println(numbersToSort);
        } else if (option == 4) {
            System.out.println("Fim do programa.");
            return false;
        } else {
            System.out.println("Opção invalida.");
        }
        return true;
    }

    public static void opposite(List<Integer> numbersToSort, int size) {
        for (int index = 0; index < size / 2; index++) {
            int temporary = numbersToSort.get(index);
            numbersToSort.set(index, numbersToSort.get(size - 1 - index));
            numbersToSort.set(size - 1 - index, temporary);
        }
    }

    private static String showMenu() {
        return "\n====================================" +
                "\nEscolha sua opção: \n" +
                "1 para ver ordenar lista \n" +
                "2 para ver lista ao contrario \n" +
                "3 para ver lista desordenada \n" +
                "4 para sair" +
                "\n===================================";
    }

    public static void sortList(List<Integer> numbersToSort, int sizeList, int sizeNumbers) {
        for (int index = 0; index < sizeList; index++) {
            int randomNumbers = (int) (Math.random() * sizeNumbers);
            numbersToSort.add(randomNumbers);
        }
    }

    public static int partition(List<Integer> numbersToSort, int begin, int end) {
        int pivot = numbersToSort.get(begin);
        int index = begin + 1;
        int subIndex = end;

        while (index <= subIndex) {
            if (numbersToSort.get(index) <= pivot) {
                index++;

            } else {
                int temporary = numbersToSort.get(index);
                numbersToSort.set(index, numbersToSort.get(subIndex));
                numbersToSort.set(subIndex, temporary);
                subIndex--;
            }
        }
        numbersToSort.set(begin, numbersToSort.get(subIndex));
        numbersToSort.set(subIndex, pivot);
        return subIndex;
    }

    private static void quicksort(List<Integer> numbersToSort, int begin, int end) {

        if (begin < end) {

            int pivo = partition(numbersToSort, begin, end);

            quicksort(numbersToSort, begin, pivo - 1);
            quicksort(numbersToSort, pivo + 1, end);

        }
    }

    public static Scanner input(String message) {
        System.out.println(message);
        return new Scanner(System.in);
    }
}