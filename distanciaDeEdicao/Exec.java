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

        String s1_inicial = "Casablanca";
        String s1_final = "Portentoso";

        String s2_inicial = "Maven, a Yiddish word meaning accumulator of knowledge, began as an attempt to " +
                "simplify the build processes in the Jakarta Turbine project. There were several" +
                " projects, each with their own Ant build files, that were all slightly different." +
                "JARs were checked into CVS. We wanted a standard way to build the projects, a clear "+
                "definition of what the project consisted of, an easy way to publish project information" +
                "and a way to share JARs across several projects. The result is a tool that can now be" +
                "used for building and managing any Java-based project. We hope that we have created " +
                "something that will make the day-to-day work of Java developers easier and generally help " +
                "with the comprehension of any Java-based project.";

        String s2_final = "This post is not about deep learning. But it could be might as well. This is the power of " +
                "kernels. They are universally applicable in any machine learning algorithm. Why you might" +
                "ask? I am going to try to answer this question in this article." +
                "Go to the profile of Marin Vlastelica Pogančić" +
                "Marin Vlastelica Pogančić Jun";

        resetCont();
        long start = System.nanoTime();
        int result = editDistanceBruteForce(inicial, _final, inicial.length(), _final.length());
        long finish = System.nanoTime();
        long timeElapsed = finish - start;
        System.out.println( "Edit Distance Brute Force | Initial String Length: " + inicial.length()  + " | Final String Length: " + _final.length()  + " | Cost/Result: " + result  + " | Interactions: " + getContIter() + " | Time: " + timeElapsed + "ns");

        resetCont();
        start = System.nanoTime();
         result = editDistanceBruteForce(s1_inicial, s1_final, s1_inicial.length(), s1_final.length());
         finish = System.nanoTime();
         timeElapsed = finish - start;
        System.out.println( "Edit Distance Brute Force | Initial String Length: " + s1_inicial.length()  + " | Final String Length: " + s1_final.length()  + " | Cost/Result: " + result  + " | Interactions: " + getContIter() + " | Time: " + timeElapsed + "ns");

//
//        resetCont();
//        start = System.nanoTime();
//        result = editDistanceBruteForce(s2_inicial, s2_final, s2_inicial.length(), s2_final.length());
//        finish = System.nanoTime();
//        timeElapsed = finish - start;
//        System.out.println( "Edit Distance Brute Force"  + " | result: " + result  + " | Interactions: " + getContIter() + " | Time: " + timeElapsed + "ns");

        System.out.println("\n");


        resetCont();
        start = System.nanoTime();
        result = editDistanceDynamic(inicial, _final);
        finish = System.nanoTime();
        timeElapsed = finish - start;
        System.out.println( "Edit Distance Dynamic | Initial String Length: " + inicial.length()  + " | Final String Length: " + _final.length()  + " | Cost/Result: " + result  + " | Interactions: " + getContIter() + " | Time: " + timeElapsed + "ns");


        resetCont();
        start = System.nanoTime();
        result = editDistanceDynamic(s1_inicial, s1_final);
        finish = System.nanoTime();
        timeElapsed = finish - start;
        System.out.println( "Edit Distance Dynamic | Initial String Length: " + s1_inicial.length()  + " | Final String Length: " + s1_final.length()  + " | Cost/Result: " + result  + " | Interactions: " + getContIter() + " | Time: " + timeElapsed + "ns");


        resetCont();
        start = System.nanoTime();
        result = editDistanceDynamic(s2_inicial, s2_final);
        finish = System.nanoTime();
        timeElapsed = finish - start;
        System.out.println( "Edit Distance Dynamic | Initial String Length: " + s2_inicial.length()  + " | Final String Length: " + s2_final.length()  + " | Cost/Result: " + result  + " | Interactions: " + getContIter() + " | Time: " + timeElapsed + "ns");
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

    public static int editDistanceDynamic(String A, String B) {
        int m = A.length();
        int n = B.length();

        int matriz[][] = new int[m + 1][n + 1];
        matriz[0][0] = 0;
        for (int i = 1; i <= m ; i++) {
              incrCont();
              matriz[i][0] = (matriz[i - 1][0] + 1);
        }

        for (int i = 1; i <= n ; i++) {
            incrCont();
            matriz[0][i] = (matriz[0][i - 1] + 1);
        }

        int extra;
        for (int i = 1; i <= m ; i++) {
            for (int j = 1; j <= n; j++) {
                incrCont();

                if (A.charAt(i - 1) == B.charAt(j - 1) )
                    extra = 0;
                else
                    extra = 1;

                matriz[i][j] = min((matriz[i-1][j] + 1), min(matriz[i][j-1] +1, (matriz[i-1][j-1] + extra)));

            }
        }

        return matriz[m][n];
    }
}
