import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.*;
import java.util.Scanner;

public class CalculCombinari {

    //    public static int Combinari (int n, int k)
//    {
//        if (k == 0 || k == n){
//            return 1;
//        }
//        if (k == n-1){
//            return n;
//        }
//        int [] anterior = new int [k+1];
//        int [] curent = new int [k+1];
//        anterior[0]=1;
//        anterior[1]=1;
//        for (int i = 2; i<=n; i++)
//        {
//            int limit = Math.min(i - 1,k);
//            curent[0] = 1;
//            for (int j =1; j<= limit; j++){
//                curent[j] = anterior [j] + anterior [j-1];
//            }
//            if (i <= k){
//                curent[i] = 1;
//
//            }
//        }
//    }
    public static int Factorial(int n) {
        int p = 1;
        for (int i = 1; i <= n; i++) {
            p = p * i;
        }
        return p;
    }

    // Combinari 1
    public static int Combinari(int n, int k) {
        return Factorial(n) / (Factorial(k) * Factorial(n - k));
    }


    // Combinari 2
    public static int Combinari_2 (int n, int k){
        if(k==0){
            return 1;
        }
        if (n==k){
            return 1;
        }
        return Combinari_2(n-1,k) + Combinari (n-1, k-1);
    }

//    // Combinari 3
//    public static int Combinari_3 (int n, int k){
//        if (k == 0 || k == n){
//            return 1;
//        }
//        if (k == n-1){
//            return n;
//        }
//
//        int [] c = new int[n+1];
//    }

    // Combinari 4
    public static int Combinari_4 (int n, int k){
        if (k == 0 || k==n){
            return 1;
        }
        if (k == n-1){
            return n;
        }
        // alocam vectorii ant si curent
        int [] ant = new int [k+1];
        int [] curent = new int [k+1];
        ant[0] = 1;
        ant[1] = 1;

        for (int i = 2; i<=n;i++){
            curent[0] = 1;
            if (i <= k ) {
                curent [i] = 1;
            }
            for (int j=1; j <= Math.min(i-1, k);j++){
                curent[j] = ant[j] + ant [j-1];
            }

            // copie tabloul curent in ant
            for (int j=1; j<=k; j++){
                ant[j] = curent[j];
            }
        }
        return curent[k];
    }

    // LIS - Longest Increasing Sequence
    // Calculeaza vecoturl de lungimi aferent procedurii de calcul a
    // subsecventei crescatoare de lungime maxima

    public static int[] LIS (int [] a, int n){
        n = a.length;
        int [] lung = new int [n];
        lung[n-1] = 1;
        for (int i= n-2; i >= 0; i--){
            int max = 0;
            for (int j = i + 1; j <= n; j++){
                if (max < lung[j] && a[i] <= a[j])
                {
                    max = lung[j];
                }
            }
            lung[i] = max + 1;
        }
        return lung;
    }

    // Tipareste subsecventa crescatoare de lungime maxima
    public static void TiparesteLis (int[] a, int [] lung){
        int indexMax = 0;
        for (int i = 1; i< lung.length; i++){
            if (lung[i] > lung[indexMax]) {
                indexMax = i;
            }
        }
        System.out.println(a[indexMax] + ", ");
        for (int j = indexMax + 1; j < lung.length; j++)
        {
            if (lung[j] == lung[indexMax] - 1){
                if(a[indexMax] <= a[j]){
                    System.out.println(a[j] + ", ");
                    indexMax = j;
                }
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("D:\\###Facultate\\Palg\\Lab_6\\src\\in.txt"));

        while (sc.hasNextInt())
        {
            int n1 = sc.nextInt();
//            System.out.println("n1 = " + n1 );
            int n2 = sc.nextInt();
//            System.out.println("n2 = " + n2);

            // Combinari 1
//            int rezultat = Combinari (n1,n2);
//            System.out.println("combinari_1 |  " + rezultat);

            // Combinari 2
//            int rezultat = Combinari_2 (n1,n2);
//            System.out.println("combinari_2 |  " + rezultat);

            // Combinari 3
//            int rezultat = Combinari (n1,n2);
//            System.out.println("combinari_2 |  " + rezultat);

            // Combinari 4
//            int rezultat = Combinari_4 (n1,n2);
//            System.out.println("Combinari_4 |  " + rezultat);
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader("D:\\###Facultate\\Palg\\Lab_6\\src\\inLIS.txt"));

//          Numarul de elemente = prima linie
            int size = Integer.parseInt(br.readLine());
            int[] nums = new int[size];

//          Stocam a doua linie intr-un sir de string-uri
            String[] strNums = br.readLine().split("\\s+");

//          Facem conversia din string[] in int[]
            for (int i = 0; i < strNums.length; i++) {
                nums[i] = Integer.parseInt(strNums[i]);
            }
            br.close();

//            int LIS = LIS(nums, size);
//            System.out.println("Nr maxim = " + LIS);

        } catch (Exception ex) {
            return;
        }
    } // main


}
