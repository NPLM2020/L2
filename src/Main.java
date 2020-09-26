import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int task;
        boolean cycle = true;

        while (cycle) {
            System.out.println("Enter the task 1 - 7 for test or 0 for exit:");
            task = scanner.nextInt();
            switch (task) {
                case 0: {
                    cycle = false;
                    break;
                }

                case 1: {
                    System.out.println("Task #1:");
                    executeTask1();
                    break;
                }

                case 2: {
                    System.out.println("Task #2:");
                    executeTask2();
                    break;
                }

                case 3: {
                    System.out.println("Task #3:");
                    executeTask3();
                    break;
                }

                case 4: {
                    System.out.println("Task #4:");
                    executeTask4();
                    break;
                }

                case 5: {
                    System.out.println("Task #5:");
                    executeTask5();
                    break;
                }

                case 6: {
                    System.out.println("Task #6:");
                    executeTask6();
                    break;
                }

                case 7: {
                    System.out.println("Task #7:");
                    executeTask7();
                    break;
                }

                default: {
                    break;
                }

            }

            System.out.println();

        }

    }

    static String getArrayAsString(int[] array) {
        StringBuilder arrayAsString = new StringBuilder();
        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                if (i != array.length - 1) arrayAsString.append(array[i]).append(", ");
                else arrayAsString.append(array[i]);
            }
        }
        return arrayAsString.toString();
    }

    // Task1
    static void executeTask1() {

        int[] task1Array = new int[10];
        for (int i = 0; i < task1Array.length; i++) {
            task1Array[i] = new Random().nextInt(2);
        }

        System.out.println(String.format("Array before: {%s}.", getArrayAsString(task1Array)));

        // Замена 0 на 1, а 1 на 0
        for (int i = 0; i < task1Array.length; i++) {
            if (task1Array[i] == 0) task1Array[i] = 1;
            else task1Array[i] = 0;
        }

        System.out.println(String.format("Array after: {%s}.", getArrayAsString(task1Array)));
    }

    // Task2
    static void executeTask2() {
        int[] task2Array = new int[8];
        int increment = 3;
        // Заполнение элементов массива числами через инкремент
        for (int i = 1; i < task2Array.length; i++) {
            task2Array[i] = task2Array[i - 1] + increment;
        }
        System.out.println(String.format("Array after: {%s}.", getArrayAsString(task2Array)));
    }

    // Task3
    static void executeTask3() {
        System.out.println("Array before: {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1}.");
        int[] task3Array = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        String arrayAsString = "";
        for (int i = 0; i < task3Array.length; i++) {
            // Умножение элементов со значением < 6 на 2
            if (task3Array[i] < 6) task3Array[i] = task3Array[i] * 2;
        }
        System.out.println(String.format("Array after: {%s}.", getArrayAsString(task3Array)));
    }

    // Task4
    static void executeTask4() {
        int size = 5;
        int[][] task4Array = new int[size][size];
        System.out.println("Result:");
        for (int i = 0; i < task4Array.length; i++) {
            // Заполнение главной диагонали
            task4Array[i][i] = 1;
            // Заполнение противоположной диагонали
            int index = task4Array.length - 1 - i;
            task4Array[i][index] = 1;
            for (int j = 0; j < task4Array[i].length; j++) {
                System.out.print(task4Array[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Task5
    static void executeTask5() {
        int[] task5Array = new int[10];
        int maxValue;
        int minValue;

        for (int i = 0; i < task5Array.length; i++) {
            task5Array[i] = new Random().nextInt(100);

        }

        System.out.println(String.format("Array after: {%s}.", getArrayAsString(task5Array)));

        // Поиск минимального и максимального
        maxValue = task5Array[0];
        minValue = task5Array[0];
        for (int j : task5Array) {
            if (j > maxValue) maxValue = j;
            else if (j < minValue) minValue = j;
        }
        System.out.println(String.format("Max item: %s.", maxValue));
        System.out.println(String.format("Min item: %s.", minValue));
    }

    // Task6
    static void executeTask6() {
        int[] task6Array = new int[4];


        for (int i = 0; i < task6Array.length; i++) {
            task6Array[i] = new Random().nextInt(3);

        }
        System.out.println(String.format("Array: {%s}.", getArrayAsString(task6Array)));
        // Проверка баланса
        System.out.println(String.format("Is balanced: %s.", checkArrayBalance(task6Array)));
    }

    static boolean checkArrayBalance(int[] array) {

        if (array != null && array.length > 1) {
            int sumRight = 0;
            int sumLeft = array[0];

            // Получаем сумму всех элементов кроме 0-го
            for (int i = 1; i < array.length; i++) {
                sumRight = sumRight + array[i];
            }

            // Проверяем баланс
            if (sumLeft > sumRight) return false;
            if (sumLeft == sumRight) return true;


            // Если баланса нет, то проходим по массиву от 1-го до предпоследнего элемента - сравниваем и изменяем правую и левую суммы
            for (int i = 1; i < array.length - 1; i++) {
                sumRight = sumRight - array[i];
                sumLeft = sumLeft + array[i];
                // Проверяем баланс
                if (sumLeft > sumRight) return false;
                if (sumLeft == sumRight) return true;
            }

        }

        return false;
    }

    // Task7
    static void executeTask7() {
        int[] task7Array;
        int size;
        int shift;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter array's size:");
        size = scanner.nextInt();
        if (size > 0) task7Array = new int[size];
        else {
            System.out.println("Wrong size!");
            return;
        }

        for (int i = 0; i < task7Array.length; i++) {
            task7Array[i] = new Random().nextInt(100);
        }

        System.out.println(String.format("Array before: {%s}.", getArrayAsString(task7Array)));

        System.out.println("Enter the shift:");
        shift = scanner.nextInt();

        task7Array = shiftArrayItems(task7Array, shift);

        System.out.println(String.format("Array after: {%s}.", getArrayAsString(task7Array)));
    }

    // Простой сдвиг массива Task7
    static int[] shiftArrayItems(int[] array, int shift) {
        if (array != null) {
            int shiftReduced;
            int buffer;

            if (shift > 0) {
                shiftReduced = shift % array.length;
            } else {
                shiftReduced = array.length + shift % array.length;
            }

            while (shiftReduced > 0) {
                buffer = array[array.length - 1];
                for (int i = array.length - 2; i >= 0; i--) {
                    array[i + 1] = array[i];
                }
                array[0] = buffer;
                shiftReduced--;
            }

            return array;
        }
        return null;
    }

}



