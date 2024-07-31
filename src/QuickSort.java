import java.util.*;

public class QuickSort {
    public static void main(String[] args) {

    }

    public static int partition(List<Integer> numbersToSort, int begin, int end) {
        // begin eh p pegar o indice de comparaçao inicial da lista e end p saber até onde ela vai

        int pivot = numbersToSort.get(begin); // pivot vai começar no indice de comparaçao inicial

        // index vai ser uma variável pra acessar o índice seguinte ao começo do pivot
        // (se o pivot for 5 e o numero seguinte for 2, index vai comparar do 2 até o fim da lista
        for (int index = begin + 1; index < end; index++) {

            // se determinado numero da lista (após o pivot) for <= ao pivot, incrementar o index
            if (numbersToSort.get(index) <= pivot) index++;
                // se determinado numero da lista (após o pivot) for > que o pivot, decrementar até onde vai a lista
                // (isso pra particionar a lista de modo que os numeros <= ao pivot sejam divididos à esquerda
                // e os numeros > que o pivot sejam divididos à direita (pq se decrementa end vai manter ele na extremidade
                // direita da lista)
            else if (numbersToSort.get(end) > pivot) end--;
                // se determinado numero da lista na posiçao do index for maior do que o pivot
                // ou se determinado numero da lista ao fim dela for menor do que o pivot
            else {
                int temporary = numbersToSort.get(index); // criar uma variável temporária que vai armazenar o valor da posiçao do index
                numbersToSort.set(index, numbersToSort.get(end));   // pegar o valor da posiçao index e trocar com o valor
                // da posiçao final da lista
                numbersToSort.set(end, temporary); // o valor da posiçao final da lista recebe o da posiçao inicial que a variavel temporaria armazenou

                // exemplo: 5   3   7   8   2
                // 5 eh pivot, 3 (index) eh menor que 5, então a variavel temporaria recebe 3 (index),
                // index (3) passa a valer 2 (end) e 2 passa a valer 3 (que tava armazenada no index)
            }

            // laço continua verificando os elementos seguintes da lista (begin + 2), (begin + 3), até chegar ao fim
        }
        numbersToSort.set(begin, end); // valor do começo recebe o valor do final
        numbersToSort.set(end, pivot); // valor do final recebe o valor do pivot

        return end;
    }
}