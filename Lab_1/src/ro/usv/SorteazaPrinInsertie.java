package ro.usv;

public class SorteazaPrinInsertie {

    // Sorteaza vectorul a folosind metoda
    // sortarii prin insertie.

    public static void Sorteaza(int [] a){

        for (int j = 1; j < a.length; j++){
            // cheia va fi inserata la locul potrivit
            // in subsirul a[0]..a[j-1] deja sortat
            int cheie = a[j];
            int i = j - 1;
            while (i >= 0 && a[i] > cheie){
                a [i+1] = a[i];
                i--;
            }
            a[i+1] = cheie;
        }
    }
}
