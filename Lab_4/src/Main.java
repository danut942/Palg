import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Main {

    // Determinarea valorii maxime
    public static int DeterminaMaxim(int[] a, int p, int q) {
        if (p == q) {
            return a[p];
        } else {
            int m = (p + q) / 2;
            int max1 = DeterminaMaxim(a, p, m);
            int max2 = DeterminaMaxim(a, m + 1, q);
            return max1 < max2 ? max2 : max1;
        }
    }

    //Cautare element
    public static int cauta(int[] a, int n, int x) {
        for (int i = 1; i < n - 1; i++) {
            if (a[i] == x) {
                return i;
            }
        }
        return -1;
    }

    // Cautare binara
    public static int CautareBinara(int[] a, int p, int q, int x) {
        if (p > q) {
            return -1;
        }
        int m = (p + q) / 2;
        if (a[m] == x) {
            return m;
        } else {
            if (a[m] < x) {
                return CautareBinara(a, m + 1, q, x);
            } else {
                return CautareBinara(a, p, m - 1, x);
            }
        }
    }

    // Cautare binara - Iterativ
    public static int CautaBinarIterativ(int[] a, int n, int x) {
        int p = 0;
        int q = n - 1;
        while (p <= q) {
            int m = (p + q) / 2;
            if (a[m] == x) {
                return m;
            }
            if (a[m] < x) {
                p = m + 1;
            } else {
                q = m - 1;
            }
        }
        return -1;
    }

    // Cautare binara - Recursiv
    public static int CautaBinar_Recursiv(int [] a,int left,int right,int x){
        if(left>right){
            return -1;
        }
        int mid = (left + right)/2;
        if(a[mid] == x){
            return mid;
        }
        if(a[mid] < x){
            return CautaBinar_Recursiv(a,mid + 1,right,x);
        } else {
            return CautaBinar_Recursiv(a,left,mid - 1,x);
        }
    }

    // Elementul suma
    public static int Suma (int [] a, int n, int x){
        for(int i=0;i<=n-2;i++){
            for(int j=i+1;j<=n-1;j++){
                if(a[i] + a[j] == x){
                    System.out.println(a[i] + " " + a[j]);
                    break;
                }
            }
        }

    }
    // Elementul suma 2
    public static int Suma_2 (int [] a, int n, int x){
        for(int i=0;i<=n-1;i++){
            int j = CautareBinara(a,0,n-1,x-a[i]);
            if(j !=-1 && j !=i){
                System.out.println(a[i]+ " "+ a[j] );
                break;
            }
        }
    }

    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new FileReader("D:\\###Facultate\\Palg\\Lab_4\\src\\CautareBinara_in.txt"));

            int size = Integer.parseInt(br.readLine());
            int[] nums = new int[size];
            String[] strNums = br.readLine().split("\\s+");

            for (int i = 0; i < strNums.length; i++) {
                System.out.println("nums["+i+"]" + " = " + Integer.parseInt(strNums[i]));
                nums[i] = Integer.parseInt(strNums[i]);
            }
            br.close();

            // in.txt
            System.out.println("--------------------------------------------------------------");
            System.out.println("in.txt");
            System.out.println("7");
            System.out.println("8 7 5 3 13 1 2");
            System.out.println("--------------------------------------------------------------");

            // Determinarea valorii maxime
            System.out.println("Determinarea valorii maxime dintr-o mulțime de numere întregi:");
            int maxim = DeterminaMaxim(nums, 0, nums.length - 1);
            System.out.println(maxim);
            System.out.println("--------------------------------------------------------------");

            // CautareBinara_in.txt
            System.out.println("CautareBinara_in.txt");
            System.out.println("7");
            System.out.println("1 2 3 3 5 7 8");
            System.out.println("7");
            System.out.println("--------------------------------------------------------------");

            //Cauta - cauta pozitia elementului
            System.out.println("Cautare element");
            int pozitiaElementului = cauta(nums, size, 7);
            System.out.println(pozitiaElementului);
            System.out.println("--------------------------------------------------------------");

            //CautareBinara
            System.out.println("Cautare binara");
            int pozitiaElementuluiCb = CautareBinara(nums, 0, nums.length - 1, 7);
            System.out.println(pozitiaElementuluiCb);
            System.out.println("--------------------------------------------------------------");

            //CautareBinara - Iterativ
            System.out.println("Cautare binara - Iterativ");
            int pozitiaElementuluiCbi = CautaBinarIterativ(nums, size, 7);
            System.out.println(pozitiaElementuluiCbi);
            System.out.println("--------------------------------------------------------------");

        } catch (Exception ex) {
            return;

        }
    }
}
//
//SAPT 4 -
//Sapt 5 - sortari
//sapt 6 - test
//- test in 2 serii
//
//----- Test
//Citire din fisier
//Alg
//Afisare in fisier
//-------