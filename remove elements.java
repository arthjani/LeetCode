class Solution {
    public int removeElement(int[] nums, int val) {

      //  Arrays.sort(nums);
        int j=0;
        for(int i : nums){
            if (i!=val){
                nums[j++]=i;
            }
           
        }
         return j;
    }
}

