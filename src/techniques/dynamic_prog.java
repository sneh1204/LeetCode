package techniques;

import java.util.Arrays;

public class dynamic_prog {

    public static int ugly_numbers(int n){
        int[] ugly_nos = new int[n];
        int next_mul_2 = 2;
        int next_mul_3 = 3;
        int next_mul_5 = 5;
        int i2 = 0, i3 = 0, i5 = 0;
        int next_no = 1;
        ugly_nos[0] = 1;
        for(int i = 1; i < n; i++){
            next_no = Math.min(next_mul_2, Math.min(next_mul_3, next_mul_5));
            ugly_nos[i] = next_no;
            if(next_no == next_mul_2){
                ++i2;
                next_mul_2 = ugly_nos[i2] * 2;
            }if(next_no == next_mul_3){
                ++i3;
                next_mul_3 = ugly_nos[i3] * 3;
            }if(next_no == next_mul_5){
                ++i5;
                next_mul_5 = ugly_nos[i5] * 5;
            }
        }
        return next_no;
    }

    public static long catalan(int n){
        if(n <= 1) return n;
        long[] catalan = new long[n+1];
        catalan[0] = 1;
        for(int i = 1; i <= n; i++){
            for (int j = 0; j < i; j++){
                catalan[i] += catalan[j] * catalan[i-j-1];
            }
        }
        return catalan[n];
    }

    public static long fibonacci(int n){
        if(n <= 1) return n;
        long[] fibonacci = new long[n+2];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        for(int i = 2; i <= n; i++){
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
        }
        return fibonacci[n];
    }

    public static int[] dijkstra(int[][] graph, int start){
        int V = graph.length;
        int[] dist = new int[V];
        Boolean[] spt = new Boolean[V];
        for(int i = 0; i < V; i++){
            dist[i] = Integer.MAX_VALUE;
            spt[i] = false;
        }
        dist[start] = 0;
        for(int count = 0; count < V-1; count++){

            // min distance selection
            int min = Integer.MAX_VALUE, min_index = -1;
            for(int i = 0; i < V; i++){
                if(!spt[i] && min >= dist[i]){
                    min = dist[i];
                    min_index = i;
                }
            }

            int u = min_index;
            spt[u] = true;
            for (int v = 0; v < V; v++){
                if(!spt[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]){
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
        return dist;
    }

    public static int knapsack(int[] values, int[] weights, int weight){
        int[][] table = new int[values.length][weight+1];
        for(int i = 1; i < values.length; i++){
            for (int j = 1; j <= weight; j++){
                int not_taking = table[i-1][j];
                int taking = 0;
                if(weights[i] <= j)
                    taking = values[i] + table[i-1][j-weights[i]];
                table[i][j] = Math.max(taking, not_taking);
            }
        }
        return table[values.length - 1][weight];
    }

    public static int coin_change_2(int[] S, int N){
        int[][] table = new int[S.length+1][N+1];
        for(int i = 0; i <= S.length; i++)
            table[i][0] = 1;
        for(int i = 1; i <= S.length; i++){
            for(int j = 0; j <= N; j++){
                int not_taking = table[i-1][j];
                int taking = 0;
                if(S[i-1] <= j)
                    taking = table[i][j-S[i-1]];
                table[i][j] = taking + not_taking;
            }
        }
        return table[S.length][N];
    }

    public static void main(String[] args) {
//        System.out.println(knapsack(new int[]{1, 4, 5, 7}, new int[]{1, 3, 4, 5}, 7));
//        System.out.println(coin_change_2(new int[]{1, 2, 5}, 5));
//        System.out.println(ugly_numbers(150));
//        System.out.println(fibonacci(100));
//        System.out.println(catalan(5));

        int[][] graph = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        System.out.println(Arrays.toString(dijkstra(graph, 0)));
        
    }

}
