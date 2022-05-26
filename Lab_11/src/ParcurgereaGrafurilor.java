import java.util.List;
import java.util.Queue;

public class ParcurgereaGrafurilor {

    public static List<Integer> BF(int[] a, int nodStart) {
        //memoreaza ordinea nodurilor in BF
        List<Integer> ordineBF = new List<Integer>();

        //vectorul vizitat
        int n = a.length();
        int[] vizitat = new int[n];
        Array.Clear(vizitat, 0, n);

        // nodul de start este primul adaugat in coada
        Queue<int> coada = new Queue<int>();
        coada.Enqueue(nodStart);
        vizitat[nodStart] = 1;

        // parcurgerea BF
        while (coada.Count > 0) {
            int nodCurent = coada.Dequeue();
            ordineBF.Add(nodCurent);
            for (int i = 0; i < n; i++)
                if (a[nodCurent,i] ==1 && vizitat[i] == 0)
            {
                coada.Enqueue(i);
                vizitat[i] = 1;

            }
        }
        return ordineBF;
    }

    /// <summary>
/// Implementeaza parcurgerea Depth-First pentru
/// un graf neorientat reprezentat prin matricea
/// de adiacenta.
/// Complexitate: O(n^2).
/// Intoarce lista nodurilor care pot fi atinse din
/// nodul de start in ordinea DF.
/// </summary>
/// <param name="a"></param>
    public static List<int> DF(int[,]a, int nodStart) {
// memoreaza ordinea nodurilor in DF
        List<int> ordineDF = new List<int>();
// vectorul vizitat
        int n = a.GetLength(0);
        int[] vizitat = new int[n];
        Array.Clear(vizitat, 0, n);
// nodul de start este primul adaugat in stiva
        Stack<int> stack = new Stack<int>();
        stack.Push(nodStart);
        vizitat[nodStart] = 1;
        ordineDF.Add(nodStart);
        while (stack.Count > 0) {
            int nodCurent = stack.Peek();
            bool found = false;
            for (int i = 0; i < n; i++)
                if (a[nodCurent,i] ==1 && vizitat[i] == 0)
            {
                stack.Push(i);
                ordineDF.Add(i);
                vizitat[i] = 1;
                found = true;
                break;

            }
            if (!found) stack.Pop();
        }
        return ordineDF;
    }
}