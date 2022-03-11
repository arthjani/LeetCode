class Solution {
    public void moveZeroes(int[] nums) {
                
int lastzerofoundAt=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]!=0)
                nums[lastzerofoundAt++]=nums[i];
            
        }
        for(int i=lastzerofoundAt;i<nums.length;i++)
            nums[i]=0;
    }
}