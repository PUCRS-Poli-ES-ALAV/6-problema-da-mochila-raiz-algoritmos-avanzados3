import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Exec {
    private static long contIter;

    public static void resetCont(){
        contIter = 0;
    }
    public static void incrCont(){
        contIter++;
    }
    public void incrCont(long i){
        contIter += i;
    }

    public static long getContIter() {
        return contIter;
    }

    public static ArrayList<Double> fiboElements = new ArrayList<Double>();

    public static void main(String[] args) {
        // Exercício 1.1 - Knapsack Brute Force

        int weights[] = new int[] { 56, 59, 80, 64, 75, 17 };
        int values[] = new int[] { 50, 50, 64, 46, 50, 05 };

        int capacity = 190;
        int numberOfItems = values.length;
        resetCont();
        long start = System.nanoTime();
        int result = knapsackBruteForce(capacity, weights, values, numberOfItems);
        long finish = System.nanoTime();
        long timeElapsed = finish - start;

        System.out.println("Knapsack Brute Force | Itens: " + numberOfItems + " | result: " + result  + " | Interactions: " + getContIter() + " | Time: " + timeElapsed + "ns");

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

}