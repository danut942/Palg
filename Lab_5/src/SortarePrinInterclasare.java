public class SortarePrinInterclasare {

    /// Sorteaza vectorul a folosing metoda sortarii prin interclasare
    /// Complexitate 0(nlog(n))

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
}
