package ro.usv;

import java.io.*;

public class DeterminaMaxim {

    // Determinarea valorii maxime
    // Fie o multime de dimensiune n.
    // Sa se gaseasca elementul de valoare maxima

    public static int DeterminaMaxim(int[] a, int n) {
        int max = a[0];
        for (int i = 1; i <= n - 1; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }
        return max;
    }

    public static void main(String[] args) throws FileNotFoundException {

        try {
            BufferedReader br = new BufferedReader(new FileReader("D:\\###Facultate\\Palg\\Lab_1\\src\\ro\\usv\\DeterminaMaxim_in.txt"));

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

            int maxim = DeterminaMaxim(nums, size);
            System.out.println("Nr maxim = " + maxim);

        } catch (Exception ex) {
            return;
        }
    }
}


