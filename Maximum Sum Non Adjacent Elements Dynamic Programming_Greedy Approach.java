// Maximum Sum Non Adjacent Elements Dynamic Programming | Greedy Approach

import java.util.*;
import java.io.*;


public class Main{



	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] arr = new int[n];

		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}
		int incl=arr[0];
		int excl=0;

		for(int i=1;i<arr.length;i++){
			int newIncl = arr[i]+ excl; 
			int newExcl = Math.max(incl,excl);

			incl = newIncl;
			excl = newExcl;

		}

		System.out.println(Math.max(incl,excl));
	}
}