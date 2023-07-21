import java.util.*;
/*
Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins,
how many ways can we make the change? The order of coins doesn’t matter.
For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}.
So output should be 4. For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}.
So the output should be 5.
f(S,3,4)
f(S,2,4) = f(S,1,4) + f(S,2,2)               +f(S,3,1)
           f(S,0,4) + f(S,1,3)                f(S,2,1) + f(S,3,-2)
           0 +        f(S,0,3) + f(S,1,2)     f(S,1,1) + f(S,2,-1)
                        0 +      f(S,0,2) + f(S,1,1)
                                  0 + f(S,0,1) + f(S,1,0)
                                      0 + 1
*/

public class CoinChange {

    public static int findWaysRecursion(int S[], int m, int n){
        //Total = S[], m-1, n + S[], m, n-Sm
        if(n == 0)
            return 1;
        if(n<0)
            return 0;
        if(m<=0 && n>0)
            return 0;
        return findWaysRecursion(S, m-1, n) + findWaysRecursion(S, m, n-S[m-1]);
    }

    public static int findWaysDP(int S[], int m, int n){
        int[][] data = new int[m][n+1];
        //Fill the first row
        int j = 0;
        data[0][0] = 1;
        for(int i=1; i<=n;i++){
            if(i%S[j] == 0)
                data[j][i] = 1;
            else
                data[j][i] = 0;
        }
        //Fill the first column
        for(int i=1; i<m;i++){
            data[i][j] = 1;
        }
        //Fill remaining
        for(int i=1; i<m; i++){
            for(j=1; j<=n; j++){
                if(j < S[i])
                    data[i][j] = data[i-1][j];
                else{
                    data[i][j] = data[i-1][j] + data[i][j-S[i]];
                }
            }
        }
        return data[m-1][n];
    }

    public static int coinChangeWays(int[] arr, int m, int n){
        int [][] coins = new int[m][n+1];
        //Fill the i=0 column. Target = 0, coins[i][0]=1
        for (int i=0; i<m;i++){
            coins[i][0] = 1;
        }

        //Fill the first row. Target = 0 to n. coins[0][j] = n%arr[0]
        for(int i=1; i<=n; i++){
            if(i%arr[0] == 0){
                coins[0][i] = 1;
            }
        }

        //Fill the remaing array
        for(int i=1; i<m; i++){
            for(int j=1; j<=n;j++){
                //If target is less than coin value, copy the value from upper element
                if(j<arr[i]){
                    coins[i][j] = coins[i-1][j];
                }
                else{
                    coins[i][j] = coins[i-1][j] + coins[i][j-arr[i]];
                }
            }
        }
        return coins[m-1][n];
    }

    //Return minimum number of coins to make a change.
    public static int minimumCoins(int[] arr, int m, int n){
        int [][] coins = new int[m][n+1];
        for (int i=0; i<m;i++){
            coins[i][0] = 0;
        }
        //Fill the first row
        for(int i=1; i<=n;i++){
            if(i%arr[0] == 0){
                coins[0][i] = i / arr[0];
            }
        }
        //Fill the remaining array
        for(int i=1; i<m;i++){
            for(int j=1; j<=n; j++){
                if(j<arr[i]){
                    coins[i][j] = coins[i-1][j];
                }
                else{
                    coins[i][j] = Math.min(coins[i-1][j], 1+coins[i][j-arr[i]]);
                }
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<=n; j++){
                System.out.println(coins[i][j]);
            }
        }
        return coins[m-1][n];

    }

    public static void main(String[] args){
        int arr[] = {2,3, 5};
        int m = arr.length;
        //System.out.println(findWaysRecursion(arr, m, 5));
        //System.out.println(findWaysDP(arr, m, 5));
        //System.out.println(coinChangeWays(arr, m, 12));
        System.out.println(minimumCoins(arr, m, 10));
    }
}
