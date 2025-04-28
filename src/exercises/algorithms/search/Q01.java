package exercises.algorithms.search;

// Crie um método de busca linear em uma estrutura de lista
// duplamente encadeada.

import datastructures.LinkedList;

import java.util.NoSuchElementException;

public class Q01 {

    private static <E> Object linearSearch(LinkedList<E> list, E target) {
        for (E e : list) {
            if (e.equals(target)) {
                return e;
            }
        }
        throw new NoSuchElementException("Elemento não encontrado.");
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(linearSearch(list, 5));
    }
}
