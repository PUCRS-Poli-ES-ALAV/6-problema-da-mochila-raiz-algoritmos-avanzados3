package distanciaDeEdicao;

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
        String inicial = "casa";
        String _final = "pai";

        resetCont();
        long start = System.nanoTime();
        int result = editDistanceBruteForce(inicial, _final, inicial.length(), _final.length());
        long finish = System.nanoTime();
        long timeElapsed = finish - start;
        System.out.println( " Edit"  + " | result: " + result  + " | Interactions: " + getContIter() + " | Time: " + timeElapsed + "ns");
    }


    static int min(int a, int b) {
        return (a < b) ? a : b;
    }

    public static int editDistanceBruteForce(String S, String T, int i, int j) {
        incrCont();

        if(i == 0 && j ==0){
            return 0;
        }

        if(i == 0){
            return j;
        }

        if(j == 0){
            return i;
        }

        if ( (i < T.length()) && (S.charAt(i) == T.charAt(i))){
            return editDistanceBruteForce(S, T, i-1, j-1 );
        }

        int sub = editDistanceBruteForce(S, T, i-1, j-1) + 1;
        int ins = editDistanceBruteForce(S, T, i, j-1) + 1;
        int del = editDistanceBruteForce(S, T, i-1, j) + 1;

        return min( min(sub,ins), del);
    }
}
