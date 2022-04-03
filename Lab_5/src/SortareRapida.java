public class SortareRapida {

    // Sorteaza vectoru a folosing algoritmul
    // sortarii rapide.
    // Complexitate: 0(nlog(n)) in cazul mediu.
    // 0(n^2) in cazul cel mai defavorabil.

    public static void Sorteaza(int [] a,int left, int right)
    {
        int i = left;
        int j = right;
        int x = a[(i+j) / 2];
        do {
            // Imparte elementele dintre indicii left si right
            // in doua subsecvente in functie de x
            while (a[i] < x){
                i++;
            }
            while (x < a[j]){
                j--;
            }
            if (i <= j){
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        } while (i <= j);
        // Rezolva subproblemele
        if (left < j){
            Sorteaza (a,left, j);
        }
        if (i < right){
            Sorteaza(a, i, right);
        }
    }
}
