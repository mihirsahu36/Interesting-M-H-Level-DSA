/*Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.*/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        cyclesort(nums);
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                list.add(i+1);
            }
        }
        return list;
    }
        public void cyclesort(int [] nums){
            int n = nums.length;
            int index  = 0;
            while(index<n){
                int element = nums[index];
                int corrposition = element - 1;
                if(nums[index] != nums[corrposition]){
                    swap(nums,index,corrposition);
                }
                else{
                    index++;
                }
            }
        }
        public void swap(int [] nums, int index1, int index2){
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
        }
    }
