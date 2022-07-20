/*
Graph connection problems
*/


import java.util.*;
import java.io.*;

public class Solution {
    public static class Edges{
        int v;
        int n;
       
        Edges(int v,int n){
            this.v=v;
            this.n=n;
        }
        
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int k=Integer.parseInt(br.readLine());
        ArrayList<Edges>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int e=0;e<k;e++){
            String line = br.readLine();
            String[] sArr=line.split(" ");
            int v1=Integer.parseInt(sArr[0]);
            int v2=Integer.parseInt(sArr[1]);
            
            graph[v1].add(new Edges(v1,v2));
            graph[v2].add(new Edges(v2,v1));
        }
            
            ArrayList<ArrayList<Integer>> result =new ArrayList<>();
            boolean[] visited =new boolean[n];
            for(int v=0;v<n;v++){
                if(visited[v]==false){
                    ArrayList<Integer> comp = new ArrayList<>();
                    drawTree(graph,visited,v,comp);
                    result.add(comp);
                }
            }
            System.out.println(result);
   }      

   public static void drawTree(ArrayList<Edges>[] graph,boolean[] visited,
                              int src,ArrayList<Integer> comp){
        visited[src]=true;
        comp.add(src);
        for(Edges ed : graph[src]){
            if(visited[ed.n]==false){
             drawTree(graph,visited,ed.n,comp);
            }
               }
                              }
   
  }