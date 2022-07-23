// Minimum Path Sum -- leetcode 46

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
       for(int i=dp.length-1;i>=0;i--){
              for(int j=dp[0].length-1;j>=0;j--){
                     if(i==dp.length-1 && j==dp[0].length-1){
                            dp[i][j]=grid[i][j];

                     }else if(i==dp.length-1){
                            dp[i][j]=dp[i][j+1]+grid[i][j];

                     }else if(j==dp[0].length-1){
                            dp[i][j]=dp[i+1][j]+grid[i][j];

                     }else{
                            dp[i][j]=Math.min(dp[i+1][j],dp[i][j+1])+grid[i][j];
                     }
              }
       }
       System.out.println(dp[0][0]);
       }
       
}