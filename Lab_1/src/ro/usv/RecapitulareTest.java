package ro.usv;

import java.io.BufferedReader;
import java.io.FileReader;

public class RecapitulareTest {

    // Element Lipsa

    int ValoareLipsa_v1(int[] a, int n) {
        for (int v = 1; v <= n; v++) {
            //cautam aparitia lui v in tabloul [] a
            boolean amGasit = false;
            for (int i = 0; i <= n - 2; i++) {
                if (a[i] == v) {
                    amGasit = true;
                    break;
                }
            }
            //daca valoarea lipseste din sir
            if (amGasit == false) {
                return v;
            }
        }
        return 0;
    }


    // Determinare maxim (divide et impera)

    int DeterminaMaxim(int [] a,int p, int q){
        if (p==q){
            return a[p];
        } else {
            int m = (p + q) / 2;
            int max1 = DeterminaMaxim(a,p,m);
            int max2 = DeterminaMaxim(a,m+1,q);
            return max1 < max2 ? max2 : max1;

        }
    }


    // Sortarea prin insertie

    public static void Sorteaza(int[] a) {
        for (int j = 1; j < a.length; j++) {
            // cheia va fi inserata la locul potrivit
            // in subsirul a[0] .. a[j-1] deja sortat
            int cheie = a[j];
            int i = j - 1;
            while (i >= 0 && a[i] > cheie) {
                a[i + 1] = a[i];
                i--;
            }
            a[i + 1] = cheie;
        }
    }


    // Cautare binara recursiv

    public static int CautareBinaraRecursiv(int[] a, int left, int right, int x) {
        if (left > right) {
            return -1; // x nu se afla in sir
        }
        int mid = (left + right) / 2;
        if (a[mid] == x) {
            return mid;
        }
        if (a[mid] < x) {
            return CautareBinaraRecursiv(a, mid + 1, right, x);
        } else {
            return CautareBinaraRecursiv(a, left, mid - 1, x);
        }
    }


    // Cautare binara iterativ

    public static int CautareBinaraIterativ(int[] a, int x) {
        int p = 0;
        int q = a.length - 1;
        while (p <= q) {
            int mid = (p + q) / 2;
            if (a[mid] == x) {
                return mid;
            }
            if (a[mid] < x) {
                p = mid + 1;
            } else {
                q = mid - 1;
            }
        }
        return -1; //x nu se afla in sir
    }


    // Cautarea unei sume

    public static int Suma(int[] a, int n, int x) {
        for (int i = 0; i <= n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                // testam perechea (i,j)
                if (a[i] + a[j] == x) {
                    return a[i] + a[j];
                    break;
                }
            }
        }
        return -1; // nu exista solutie
    }


    // Sortarea prin interclasare

    private static void Interclaseaza(int[] a, int left, int mid, int right) {

        //va contine rezultatul interclasarii
        int[] rezultat = new int[right - left + 1];
        int k = 0;

        //parcurge simultan vectorii a[p,m] si a[m+1 .. q]
        int i = left;
        int j = mid + 1;
        while (i <= mid && j <= right) {
            if (a[i] == a[j]) {
                rezultat[k++] = a[i++];
                rezultat[k++] = a[j++];
            } else {
                if (a[i] < a[j]) {
                    rezultat[k++] = a[i++];
                } else {
                    rezultat[k++] = a[j++];
                }
            }
        }
        //au mai ramas elemente in a[p..m]?
        for (int t = i; t <= mid; t++) {
            rezultat[k++] = a[t];
        }

        // mai mai ramas elemente in a[m+1..q]?
        for (int t = j; t <= right; t++) {
            rezultat[k++] = a[t];
        }

        //cope rezultatul interclasarii in a[p..q]
        for (int t = left; t <= right; t++) {
            a[t] = rezultat[t - left];
        }
    }


    // Sortarea rapida

    public static void Sorteaza(int[] a, int left, int right) {
        int i = left;
        int j = right;
        int x = a[(i + j) / 2];
        do {
            // Imparte elementele dintre indicii left si right
            // in doua subsecvente in functie de x
            while (a[i] < x) {
                i++;
            }
            while (x < a[j]) {
                j--;
            }
            if (i <= j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        } while (i <= j);
        // Rezolva subproblemele
        if (left < j) {
            Sorteaza(a, left, j);
        }
        if (i < right) {
            Sorteaza(a, i, right);
        }
    }


    // Citire si afisare din fisier

        BufferedReader br = new BufferedReader(new FileReader("D:\\###Facultate\\Palg\\Lab_1\\src\\ro\\usv\\ElementulLipsa_in.txt"));

        int size = Integer.parseInt(br.readLine());
        int[] nums = new int[size];
        String[] strNums = br.readLine().split("\\s+");

        for (int i = 0; i < strNums.length; i++) {
            nums[i] = Integer.parseInt(strNums[i]);
        }
        br.close();

}
