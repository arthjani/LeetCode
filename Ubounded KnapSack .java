//Ubounded KnapSack 

import java.util.*;
import java.io.*;

public class Main{



	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int[] vals = new int[n];
		int[] wts = new int[n];
		for(int i=0;i<vals.length;i++){
			vals[i] = sc.nextInt();
		}
		for(int i=0;i<wts.length;i++){
			wts[i] = sc.nextInt();
			
		}
		int cap = sc.nextInt();

		int[] dp = new int[cap+1];
		dp[0]=0;
        int max=0;
		for(int bagCap=0;bagCap<=cap;bagCap++){
			for(int j=0;j<n;j++){
				if(bagCap >= wts[j]){
					int rBagCap = bagCap-wts[j];
					int rBagVals=dp[rBagCap];
					int totalBagVals = rBagVals + vals[j];
					if(totalBagVals>max){
						max=totalBagVals;
					}
			}
		}
		dp[bagCap]=max;
	}
	System.out.println(dp[cap]);
  }
}