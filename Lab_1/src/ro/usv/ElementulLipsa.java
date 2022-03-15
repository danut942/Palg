package ro.usv;

import java.io.*;

public class ElementulLipsa {

    //Varianta 1
    public static int valoareLipsa_v1(int[] a, int n) {
        System.out.println("first method");
        int v;
        for (v = 1; v <= n; v++) {
            boolean amGasit = false;
            for (int i = 0; i <= n - 2; i++) {
                if (a[i] == v) {
                    amGasit = true;
                    break;
                }
            }
            if (amGasit == false) {
                System.out.println(v);
            }
        }
        return 0;
    }

//    Varianta 2
    public static void valoareLipsa_v2(int[] a, int n) {
     System.out.println("second method");
        int[] prezent = new int[n];
        for (int i = 0; i <= n; i++) {
            prezent[i] = 0;
        }
        for (int i = 0; i <= n - 2; i++) {
            prezent[a[i] - 1] = 1;
        }
//        for (int i = 0; i <= 0; i++) {
//            if (prezent[i] == 0) {
//                System.out.println(i+1);
//                System.out.println(prezent[i+1]);
//            }
//        }
        return prezent[n+1]
//        return 0;
    }
    //Varianta 3
    public static int valoareLipsa_v3(int[] a, int n) {
        System.out.println("third method");
        int suma = 0;
        for (int i = 0; i <= n - 2; i++) {
            suma = suma + a[i];
        }
        System.out.println(n * (n + 1) / 2 - suma);
        return n * (n + 1) / 2 - suma;
    }

    public static void main(String[] args) throws FileNotFoundException {

        try {
            BufferedReader br = new BufferedReader(new FileReader("D:\\Facultate_2021_2022\\Palg\\Laborator1\\ElementLipsa\\in.txt"));

//            in.txt
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

            //
            System.out.println("------------------------------------------");

            long startTime, endTime;

            startTime = System.nanoTime();
            valoareLipsa_v1(nums, size);
            endTime = System.nanoTime();
            System.out.println("startTime = " + startTime);
            System.out.println("endtime = " + endTime);
            System.out.println("Duration = " + (endTime - startTime));
            System.out.println("------------------------------------------");

            startTime = System.nanoTime();
            valoareLipsa_v2(nums, size);
            endTime = System.nanoTime();
            System.out.println("startTime = " + startTime);
            System.out.println("endtime = " + endTime);
            System.out.println("Duration = " + (endTime - startTime));
            System.out.println("------------------------------------------");

            startTime = System.nanoTime();
            valoareLipsa_v3(nums, size);
            endTime = System.nanoTime();
            System.out.println("startTime = " + startTime);
            System.out.println("endtime = " + endTime);
            System.out.println("Duration = " + (endTime - startTime));
            System.out.println("------------------------------------------");

        } catch (Exception ex) {
            return;
        }
    }
}
