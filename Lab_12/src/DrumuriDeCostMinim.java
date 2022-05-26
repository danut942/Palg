    //  #8 Grafuri:
    //  Drumuri de cost minim


    import java.io.BufferedReader;
    import java.io.File;
    import java.io.FileReader;
    import java.util.Scanner;

    public class DrumuriDeCostMinim {

        public DrumuriDeCostMinim(int[][] mat) {
        }

        // Determina costul minim al drumurilor dintre oricare
    // Roy Floyd Warshall
    public static int [][] RoyFloydWarshall (int[][] c)
    {
        int n = c.length;
        int [][] costMinim = new int [n][n];
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                costMinim[i][j] = c[i][j];
            }
        }
        for (int k=0;k<n;k++) {
            for (int i=0; i<n;i++) {
                for (int j=0;j<n;j++){
                    if (i != j && i != k && j !=k){
                        if (costMinim[i][j] > costMinim [i][k] + costMinim [k][j]){
                            costMinim [i][j] = costMinim [i][k] + costMinim [k][j];
                        }
                    }
                }
            }
        }
        return costMinim;
    }

    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(new File("D:\\###Facultate\\Palg\\Lab_12\\src\\in.txt"));

            System.out.println("test");
            // Prima linie
            // n - nr de noduri
            int nrNoduri = sc.nextInt();
            System.out.println("nr noduri = " + nrNoduri);
            // m - muchii
            int nrMuchii = sc.nextInt();
            System.out.println("nr muchii = "+ nrMuchii);

            int [][] mat = new int [nrNoduri][nrNoduri];

            for (int k=0;k<nrMuchii;k++){
                int i = sc.nextInt();
                int j = sc.nextInt();
                int c = sc.nextInt();

                mat[i][j] = c;
                mat[j][i] = c;
            }
            for (int i = 0; i < nrNoduri; i++){
                for (int j =0 ; j < nrNoduri; j++)
                {
                    System.out.print(mat[i][j] + " ");
                }
                System.out.println();
            }

        // de apelat row floyd warshall

        } catch (Exception ex) {
            return;
        }
    }
}
