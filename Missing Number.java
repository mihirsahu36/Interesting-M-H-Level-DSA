/*Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.*/
/*Logic: XOR Logic---> A XOR B XOR C == A XOR C XOR B and A XOR A == 0 and A XOR 0 == 0 so first XOR all number within range 0 to n 
where n is size of array nums then XOR teh given nums array then XOR the given nums XOR array with XOR of (0,n) range it will give the the number that is not preent in the given nums array.*/

class Solution {
    public int missingNumber(int[] nums) {
        int allXOR = 0;
        for(int i=0; i<=nums.length;i++){
            allXOR = allXOR ^ i;
        }
        for(int j:nums){
            allXOR = allXOR ^ j;

        }
        return allXOR;
    }
}
