public class DeterminaMaxim {
    int DeterminaMaxim(int [] a, int p, int q){
        // Determinarea valorii maxime prin metoda Divide et Impera
        // p si q sunt limitele intre care cautam valoarea maxima
        if (p == q){
            return a[p];
        } else {
            int mijloc = (p + q) / 2;
            int max1 = DeterminaMaxim(a, p, mijloc);
            int max2 = DeterminaMaxim(a, mijloc + 1, q);
            return max1 < max2 ? max2 : max1;
        }
    }
}
