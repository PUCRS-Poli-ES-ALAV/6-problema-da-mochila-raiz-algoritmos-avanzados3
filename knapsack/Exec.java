package knapsack;

import java.util.ArrayList;

public class Exec {
    private static long contIter;

    public static void resetCont(){
        contIter = 0;
    }
    public static void incrCont(){
        contIter++;
    }

    public static long getContIter() {
        return contIter;
    }

    public static void main(String[] args) {

        ArrayList<String> runs = new ArrayList();
        runs.add("Brute Force");
        runs.add("Dynamic");


        // --- Caso 1 Knapsack
        System.out.println("Pesos: 56, 59, 80, 64, 75, 17");
        System.out.println("Valores: 50, 50, 64, 46, 50, 05");
        runs.forEach((run)-> {
            int weights[] = new int[] { 56, 59, 80, 64, 75, 17 };
            int values[] = new int[] { 50, 50, 64, 46, 50, 05 };
            int capacity = 190;
            int numberOfItems = values.length;

            resetCont();
            long start = System.nanoTime();
            int result;
            if(run == "Dynamic") {
                result = knapsackDynamic(capacity, weights, values, numberOfItems);
            } else {
                result = knapsackBruteForce(capacity, weights, values, numberOfItems);
            }
            long finish = System.nanoTime();
            long timeElapsed = finish - start;
            System.out.println("Knapsack " + run + " | Itens: " + numberOfItems + "| Capacity: " + capacity +  " | result: " + result  + " | Interactions: " + getContIter() + " | Time: " + timeElapsed + "ns");
        });


        System.out.println("\n");
        System.out.println("\n");
        //  ----------------- Caso 2 Knapsack


        System.out.println("Pesos:  23, 31, 29, 44, 53, 38, 63, 85, 89, 82");
        System.out.println("Valores: 92, 57, 49, 68, 60, 43, 67, 84, 87, 72");
        runs.forEach((run)-> {
            int weights[] = new int[] { 23, 31, 29, 44, 53, 38, 63, 85, 89, 82 };
            int values[] = new int[] { 92, 57, 49, 68, 60, 43, 67, 84, 87, 72 };
            int capacity = 165;
            int numberOfItems = values.length;


            resetCont();
            long start = System.nanoTime();
            int result;
            if(run == "Dynamic") {
                result = knapsackDynamic(capacity, weights, values, numberOfItems);
            } else {
                result = knapsackBruteForce(capacity, weights, values, numberOfItems);
            }
            long finish = System.nanoTime();
            long timeElapsed = finish - start;
            System.out.println("Knapsack " + run + " | Itens: " + numberOfItems + "| Capacity: " + capacity   + " | result: " + result  + " | Interactions: " + getContIter() + " | Time: " + timeElapsed + "ns");
        });

        System.out.println("\n\n");

        //  ----------------- Caso 3 Knapsack
        System.out.println("Esse caso de teste possui mais itens, onde os itens são de peso menor quando comparado à capacidade da mochila. Nesse caso podemos ver a vantagem da programação dinamica.");
        System.out.println("Nos casos anteriores onde haviam menos itens e os pesos eram mais próximos à capacidade da mochila, a vantagem em usar programação dinamica não era evidente\n");

        System.out.println("Pesos: 3, 5, 6, 7 ,8, 9, 4, 7 ,8,  9, 5, 3, 2, 1,4, 4,5,1, 3, 5, 6, 7 ,8, 9, 4, 7 ,8, 9, 5, 3, 2, 1,4, 4,5,1");
        System.out.println("Valores: 5, 6, 7 ,8, 9, 4, 7 ,8,  9, 5, 3, 2, 1,4, 4,5,1, 5, 5, 6, 7 ,8, 9, 4, 7 ,8,  9, 5, 3, 2, 1,4, 4,5,1, 5");
        runs.forEach((run)-> {
            int weights[] = new int[] { 3, 5, 6, 7 ,8, 9, 4, 7 ,8,  9, 5, 3, 2, 1,4, 4,5,1, 3, 5, 6, 7 ,8, 9, 4, 7 ,8, 9, 5, 3, 2, 1,4, 4,5,1 };
            int values[] = new int[] { 5, 6, 7 ,8, 9, 4, 7 ,8,  9, 5, 3, 2, 1,4, 4,5,1, 5, 5, 6, 7 ,8, 9, 4, 7 ,8,  9, 5, 3, 2, 1,4, 4,5,1, 5};
            int capacity = 100;
            int numberOfItems = values.length;

            resetCont();
            long start = System.nanoTime();
            int result;
            if(run == "Dynamic") {
                result = knapsackDynamic(capacity, weights, values, numberOfItems);
            } else {
                result = knapsackBruteForce(capacity, weights, values, numberOfItems);
            }
            long finish = System.nanoTime();
            long timeElapsed = finish - start;
            System.out.println("Knapsack " + run + " | Itens: " + numberOfItems + "| Capacity: " + capacity   + " | result: " + result  + " | Interactions: " + getContIter() + " | Time: " + timeElapsed + "ns");
        });

        System.out.println("\n");
    }

    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    static int knapsackBruteForce(int capacity, int weights[], int values[], int numberOfItems) {
        incrCont();

        int index = numberOfItems - 1;

        if (numberOfItems == 0 || capacity == 0)
            return 0;

        if (weights[index] > capacity)
            return knapsackBruteForce(capacity, weights, values, index);
        else
            return max(
                    values[index] + knapsackBruteForce(capacity - weights[index], weights, values, index),
                    knapsackBruteForce(capacity, weights, values, index));
    }

    static int knapsackDynamic(int capacity, int weights[], int values[], int numberOfItems){
        int maxTab[][] = new int[numberOfItems + 1][capacity + 1];

        int weightsAux[] = new int[numberOfItems + 1];
        int valuesAux[] = new int[numberOfItems + 1];
        valuesAux[0] = 0;
        weightsAux[0] = 0;
        for (int i = 0; i < numberOfItems; i++) {
            maxTab[i][0] = 0;
            valuesAux[i + 1] = values[i];
            weightsAux[i + 1] = weights[i];

        }

        for (int i = 0; i < capacity; i++) {
            maxTab[0][i] = 0;
        }

        for (int i = 1; i <= numberOfItems; i++) {
            for (int j = 1; j <= capacity; j++) {
                incrCont();

                if (weightsAux[i] <= j) {
                    maxTab[i][j] = max(maxTab[i-1][j], valuesAux[i] + maxTab[i-1][j - weightsAux[i]]);
                } else {
                    maxTab[i][j] = maxTab[i-1][j];
                }
            }
        }

        return maxTab[numberOfItems][capacity];
    }
}