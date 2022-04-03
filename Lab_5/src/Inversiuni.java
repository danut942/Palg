public class Inversiuni {

    /// Calculeaza numarul de inversiuni pentru o permutare.
    /// Complexitate O(n^2).

    public static int NrInversiuni_1(int[] a) {
        int nr = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    nr++;
                }
            }
        }
        return nr;
    }

    /// Calculeaza numarul de inversiuni pentru o permutare
    /// folosind interclasarea.
    /// Complexitate O(nlog(n)).

    public static int NrInversiuni_2(int[] a, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            int nr1 = NrInversiuni_2(a, left, mid);
            int nr2 = NrInversiuni_2(a, mid + 1, right);
            int nr12 = Interclaseaza(a, left, mid, right);
            return nr1 + nr2 + nr12;
        }
        return 0;
    }

    /// <summary>
    /// Interclaseaza doua subsiruri ale sirului a
    /// si calculeaza numarul de inversiuni dintre
    /// perechi de elemente din primul si al doilea sir.
    /// </summary>
    private static int Interclaseaza(
            int[] a, int left, int mid, int right) {
        // contine numarul de inversiuni
        int nr = 0;
        // contine rezultatul interclasarii
        int[] rezultat = new int[right - left + 1];
        int k = 0;
        int i = left;
        int j = mid + 1;
        while (i <= mid && j <= right) {
            if (a[i] < a[j]) {
                rezultat[k++] = a[i++];
                // a[i] este mai mare decat toate
                // elementele pana la a[j] exclusiv
                nr += j - (mid + 1);
            } else rezultat[k++] = a[j++];
        }
        for (int t = i; t <= mid; t++) {
            rezultat[k++] = a[t];
            Ghid practic pentru analiza şi proiectarea algoritmilor.Aplicații în C#71
            // a[t] este mai mare decat toate
            // elementele din a[mid+1]..a[right]
            nr += right - (mid + 1) + 1;
        }
        for (int t = j; t <= right; t++)
            rezultat[k++] = a[t];
        for (int t = left; t <= right; t++)
            a[t] = rezultat[t - left];
        return nr;

    }