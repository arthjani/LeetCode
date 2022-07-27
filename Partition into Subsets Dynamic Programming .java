
//Partition into Subsets Dynamic Programming 

import java.util.*;
import java.io.*;

public class Main{


	public static void main(String[] args) throws Exception{
		Scanner sc  = new Scanner(System.in);

		int n=sc.nextInt();
		int k=sc.nextInt();

		int[][]dp = new int[k+1][n+1];

		for(int t=1;t<=k;t++){ //Team
			for(int p=1;p<=n;p++){ // People
				if(p<t){
					dp[t][p]=0;
				}
				 else if(t==p){
					dp[t][p]=1;
				}
				else {
					dp[t][p]=(dp[t][p-1]*t) + dp[t-1][p-1];
				}


				
			}
		}
		System.out.println(dp[k][n]);

	}
}
