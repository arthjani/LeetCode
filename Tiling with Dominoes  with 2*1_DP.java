// Tiling with Dominoes  with 2*1 -- Dynamic Programming


import java.util.*;
import java.io.*;

public class Main{


	public static void main(String[] args) throws Exception{
		Scanner sc  = new Scanner(System.in);

		int n=sc.nextInt();
		int[] dp = new int[n+1];
		dp[1]=1;
		dp[2]=2;

		for(int i=3;i<dp.length;i++){
			dp[i]=dp[i-1]+dp[i-2];
		}
		System.out.println(dp[n]);
	}
}