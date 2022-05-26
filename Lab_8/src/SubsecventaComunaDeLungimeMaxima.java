import java.util.List;

import static java.lang.Math.max;

public class SubsecventaComunaDeLungimeMaxima {

    // LCS - Longest Common Subsequence
    public static int [][] LCS (int [] a, int n, int [] b, int m){
        n = a.length;
        m = b.length;
        int [][] lung = new int[n][m];

        // rezolvam subprobleme simple
        lung[0][0] = (a[0] == b[0]) ? 1 : 0;

        for(int j=1;j<m;j++){
            lung [0][j] = (a[0] == b[j]) ? 1 : lung [0][j-1];
        }
        for(int i=1;i<n;i++){
            lung[i][0] = (a[i] == b[0]) ? 1 : lung [i-1][0];
        }

        // completam matricea lung
        for(int i = 1; i<n;i++){
            for(int j = 1; j <m; j++){
                lung [i][j] = max (
                        (a[i] == b[j]) ? lung[i-1][j-1]+1 : lung [i-1][j-1],
                        max(lung[i - 1][j], lung[i][j - 1]));
            }
        }
        return lung;
    }

    // Tipareste subsecventa crescatoare comuna subsirurilor a si b
    public static void TiparesteLCS(int [] a, int n, int [] b,int m, int [][] lung){
        System.out.println("Lungimea maxima: " + lung[n-1][m-1]);
        System.out.print("Subsecventa este: ");
        int i = n-1;
        int j = m-1;
        while (i >= 0 && j >= 0){
            if (a[i] == b[j]){
                System.out.print(a[i] + " ");
                i = i-1;
                j = j-1;
            } else if (i-1 >= 0 && lung [i][j] == lung [i-1][j]){
                i = i-1;
            } else {
                j =j-1;
            }
        }
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {
//        in.txt
//        -------
//        11
//        7 6 5 2 8 2 8 1 4 7 10
//        7
//        6 9 2 1 8 9 7
//
//        out.txt
//        4
//        6 2 8 7



        int[] a = {7, 6, 5, 2, 8, 2, 8, 1, 4, 7, 10};
        int n = 11;
        int[] b = {6, 9, 2, 1, 8, 9, 7};
        int m = 7;
        int[][] rezultat = LCS(a, n, b, m);
        TiparesteLCS(a, n, b, m, rezultat);
    }
}
