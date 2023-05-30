import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("Длина вашего массива: ");
        int lengthMass = in.nextInt();
        int[] sortArr = new int[lengthMass];
        for (int i = 0; i < lengthMass; i++) {
            System.out.printf("Число номер %d: ", i);
            sortArr[i] = in.nextInt();
        }
        System.out.println("Выберите порядок сортировки:");
        System.out.println("1. По возрастанию");
        System.out.println("2. По убыванию");
        int choice = in.nextInt();

        if (choice == 1) {
            bubbleSort(sortArr, (a, b) -> a - b); // Сортировка по возрастанию
        } else if (choice == 2) {
            bubbleSort(sortArr, (a, b) -> b - a); // Сортировка по убыванию
        } else {
            System.out.println("Неверный выбор порядка сортировки.");
            return;
        }
        System.out.println(Arrays.toString(sortArr));
    }
    public static void bubbleSort(int[] sortArr, SortComparator comparator) {
        for (int i = 0; i < sortArr.length - 1; i++) {
            for (int j = 0; j < sortArr.length - i - 1; j++) {
                if (comparator.compare(sortArr[j], sortArr[j + 1]) > 0) {
                    int swap = sortArr[j];
                    sortArr[j] = sortArr[j + 1];
                    sortArr[j + 1] = swap;
                }
            }
        }
    }
    interface SortComparator {
        int compare(int a, int b);
    }
}