/*Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.*/

class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            if (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                int index = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
            } else {
                i++;
            }
        }
        
        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        
        return n + 1;
    }
}


class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int m = 1;
        for(int num:nums){
            if(num == m){
                m++;
                continue;
            }
        }
        return m;
    }
}

import java.util.HashSet;
class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (num > 0) {
                set.add(num);
            }
        }

        int m = 1;
        while (set.contains(m)) {
            m++;
        }

        return m;
    }
}
