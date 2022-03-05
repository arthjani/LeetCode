class Solution {
    public int searchInsert(int[] nums, int target) {
        int result = 0;
        
        if(nums.length==1 && target>nums[0]){
            return 1;
        }
        
        for(int i=0;i<nums.length-1;i++){
            if(target == nums[i]){
                result =  i;
                break;
            }else if(target>nums[i] && target<=nums[i+1]){
                result = i+1;
                break;
            }else if(target>nums[i+1] && (nums.length-1==i+1)){
                result= nums.length;
                break;
            }else if(target<nums[i] && i==0){
                result =  0;
                break;
            }else if(target>nums[i] && target>nums[i+1]){
                continue;
            }
        }
        
        return result;
        
    }
}

//or

pivot = (right + left) >>> 1;

//or

class Solution {
  public int searchInsert(int[] nums, int target) {
    int pivot, left = 0, right = nums.length - 1;
    while (left <= right) {
      pivot = left + (right - left) / 2;
      if (nums[pivot] == target) return pivot;
      if (target < nums[pivot]) right = pivot - 1;
      else left = pivot + 1;
    }
    return left;
  }
}