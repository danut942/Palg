package ro.usv;

import java.io.*;

public class ElementulLipsa {

    // Varianta 1
    // Fiecare valoare este cautata in tabloul unidimensiunal.
    // Algoritmul se incheie atunci cand nu gasim o valoare in tablou.

    public static int valoareLipsa_v1(int[] a, int n) {
        System.out.println("Varianta 1");
        int v;
        // Pentru fiecare valoare posibila v
        for (v = 1; v <= n; v++) {
            boolean amGasit = false;
            // Cautam aparitia lui v in tabloul A
            for (int i = 0; i <= n - 2; i++) {
                if (a[i] == v) {
                    amGasit = true;
                    break;
                }
            }
            // Valoarea v lipseste din sir?
            if (amGasit == false) {
                return v;
            }
        }
        return 0;
    }

    // Varianta 2
    // Folosim un tablou suplimentar  unde vom memora prezenta valorii
    // folosind valori binari 0/1. (0 -> lipsa elementului / 1 -> valoarea i este prezenta)

    public static int valoareLipsa_v2(int[] a, int n) {
        System.out.println("Varianta 2");

        // Alocam memorie pentru tabloul prezent
        int[] prezent = new int[n];
        // Initializam tabloul de prezenta cu 0
        for (int i = 0; i <= n-1; i++) {
            prezent[i] = 0;
        }
        // Pentru fiecare valoare din multimea A
        // memoram prezenta ei in tabloul prezent
        for (int i = 0; i <= n - 2; i++) {
            prezent[a[i] - 1] = 1;
        }
        // Cautam elementul lipsa
        for (int i = 0; i <= n - 1; i++) {
            if (prezent[i] == 0) {
                return i + 1;
            }
        }
        return 0;
    }

    //Varianta 3
    // Calculam suma elementelor multimii A
    // Cunoscand suma primelor n numere naturale = n*(n+1)/2
    // Se efectueaza diferenta pentru a gasi elementul lipsa
    // n*(n+1)/2-suma

    public static int valoareLipsa_v3(int[] a, int n) {
        System.out.println("Varianta 3");
        // Calculam suma elementelor multimii A
        int suma = 0;
        for (int i = 0; i <= n-2; i++) {
            suma = suma + a[i];
        }
        // Determinam elementul lipsa
        return n * (n + 1) / 2 - suma;
    }

    public static void main(String[] args) throws FileNotFoundException {

        try {
            BufferedReader br = new BufferedReader(new FileReader("D:\\###Facultate\\Palg\\Lab_1\\src\\ro\\usv\\ElementulLipsa_in.txt"));

//            ElementulLipsa_in.txt
//            ---------
//            6
//            5 1 6 3 2
//            ---------

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

            long startTime, endTime;

            // Elementul lipsa Varianta 1
            System.out.println("------------------------------------------");
            startTime = System.nanoTime();
            int elementLipsa_v1 = valoareLipsa_v1(nums, size);
            System.out.println("Elementul lipsa: " + elementLipsa_v1);
            endTime = System.nanoTime();
            System.out.println("Durata = " + (endTime - startTime));
            System.out.println("------------------------------------------");

            // Elementul lipsa Varianta 2
            startTime = System.nanoTime();
            int elementLipsa_v2 = valoareLipsa_v2(nums, size);
            System.out.println("Elementul lipsa: " + elementLipsa_v2);
            endTime = System.nanoTime();
            System.out.println("Durata = " + (endTime - startTime));
            System.out.println("------------------------------------------");

            // Elementul lipsa Varianta 3
            startTime = System.nanoTime();
            int elementLipsa_v3 = valoareLipsa_v3(nums, size);
            System.out.println("Elementul lipsa: " + elementLipsa_v3);
            endTime = System.nanoTime();
            System.out.println("Durata = " + (endTime - startTime));
            System.out.println("------------------------------------------");

        } catch (Exception ex) {
            return;
        }
    }
}
