// Print All Longest Increasing Subsequences Dynamic Programming

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Main{

	public static class Pair{
		int len;
		int index;
		int val;
		String path;

		Pair(int len,int index,int val,String path){
			this.len=len;
			this.index=index;
			this.val=val;
			this.path=path;
		}
	}

     public static void solution(int[] arr){
     	int[] dp = new int[arr.length];
     	int oMax =0;
     	for(int i=0;i<dp.length;i++){
     		int max=0;
     		for(int j=0;j<i;j++){
     			if(arr[j]<=arr[i]){
     				if(dp[j]>max)
     				max=dp[j];
     			}
     		}
     		dp[i]=max+1;
     		if(dp[i]>oMax){
     			oMax=dp[i];
     		}
     	}
     	System.out.println(oMax);

     	ArrayDeque<Pair> queue = new ArrayDeque<>();
     	for(int i=0;i<dp.length;i++){
     		if(oMax==dp[i]){
     			queue.offer(new Pair(oMax,i,arr[i],arr[i]+""));
     		}
     	}
        

        while(!queue.isEmpty()){
        	 Pair rem = queue.removeFirst(); 

        	 if(rem.len == 1){
        	 	System.out.println(rem.path);
        	 }

        	 for(int i=0;i<rem.index;i++){
        	 	if(dp[i] == rem.len -1  && arr[i]<= rem.val){
        	 		queue.offer(new Pair(dp[i],i,arr[i],arr[i]+ "->" + rem.path));
        	 	}
        	 }
        }

     }


	public static void main(String[] args){

     Scanner sc = new Scanner(System.in);
      int n =sc.nextInt();
      int[] arr = new int[n];
      for(int i=0;i<n;i++){
      	arr[i]=sc.nextInt();
      }
      solution(arr);
	}
}