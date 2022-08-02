// Longest Increasing Subsequence--Dynamic Programming


import java.util.*;
import java.io.*;

class Main{

	public static void solution(int[] arr){
     int[] dp = new int[arr.length];
     int result=0;
     for(int i=0;i<dp.length;i++){
        int max=0;
     	for(int j=0;j<i;j++){
          if(arr[j] <= arr[i]){
          	if(dp[j]>max){
          		max=dp[j];
          	}
          }
     	}
     	dp[i]=max+1;
     	if(dp[i]>result){
     		result=dp[i];
     	}
     }
     System.out.println(result);

	}
	public static void main(String[] args){
		Scanner sc  = new Scanner(System.in);

		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}

		solution(arr);
	}
}