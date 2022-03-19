class Solution {
    public void duplicateZeros(int[] arr) {
       
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        
        int arrLen= arr.length;
        
        for(int i=0; i<arr.length;i++){
            arr1.add(arr[i]);
            if (arr[i]==0){
            arr1.add(0);
            }
            
        }
       // System.out.println(arr1);
        arr2 = arr1.subList(0,arrLen);
        for (int i= 0; i<arr2.size();i++){
            arr[i] = arr2.get(i);
        }
       // System.out.println(arr);
        
        
    }
}