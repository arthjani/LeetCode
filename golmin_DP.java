// goldmine DP

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
              Scanner sc = new Scanner(System.in);
       
       int n = sc.nextInt();
       int m = sc.nextInt();
       int[][] grid = new int[n][m];

       for(int i = 0;i<grid.length;i++){
              for(int j=0;j<grid[0].length;j++){
                     grid[i][j]=sc.nextInt();
              }
        
       }
       int[][] dp = new int[n][m];
       for(int j=grid[0].length-1;j>=0;j--){
         for(int i=grid.length-1;i>=0;i--){
              if(j==grid[0].length-1){
                     dp[i][j]=grid[i][j];
              }else if(i==0){
                     dp[i][j]=grid[i][j]+Math.max(dp[i][j+1],dp[i+1][j+1]);

              }else if(i==grid.length-1){
                     dp[i][j]=grid[i][j]+Math.max(dp[i][j+1],dp[i-1][j+1]);

              }else{
                     dp[i][j]=grid[i][j]+Math.max(dp[i][j+1],Math.max(dp[i+1][j+1],dp[i-1][j+1]));

              }
                      }
               }
               int max=dp[0][0];
               for(int i=1;i<dp.length;i++){
                     if(dp[i][0]>max){
                            max=dp[i][0];
                     }
               }
               System.out.println(max);

    }
       
}