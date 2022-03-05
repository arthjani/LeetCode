class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median;
        int fal = nums1.length;      
       int sal = nums2.length; 
       int[] result = new int[fal + sal];  
     System.arraycopy(nums1, 0, result, 0, fal);  
     System.arraycopy(nums2, 0, result, fal, sal);  
       
    // System.out.println(Arrays.toString(result));
       Arrays.sort(result);
         //System.out.println(result);
        
     // get count of scores
     int totalElements = result.length;
     // check if total number of scores is even
     if (totalElements % 2 == 0) {
        int sumOfMiddleElements = result[totalElements / 2] +
                                  result[totalElements / 2 - 1];
        // calculate average of middle elements
        median = ((double) sumOfMiddleElements) / 2;
     } else {
        // get the middle element
        median = (double) result[result.length / 2];
  }
  return median;
    }
    
}
