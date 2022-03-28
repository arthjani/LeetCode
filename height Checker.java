class Solution {
    public int heightChecker(int[] heights) {
        int[] arr= Arrays.copyOf(heights,heights.length);
        Arrays.sort(arr);
        int j=0;
        int count=0;
        for(int i : heights){
            if (i!=arr[j++])
            count++;
        }
        
        return count;
    }
}