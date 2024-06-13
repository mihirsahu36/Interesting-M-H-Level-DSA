/*Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. 
You may return the combinations in any order.
The same number may be chosen from candidates an unlimited number of times. 
Two combinations are unique if the frequency of at least one of the chosen numbers is different.
The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.*/

class Solution {
    private List<List<Integer>> ans;

    private void solve(int i, int[] arr, List<Integer> temp, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        if (target < 0 || i == arr.length) {
            return;
        }

        solve(i + 1, arr, temp, target);    //not taking the current element, element next to current is taken

        temp.add(arr[i]);
        solve(i, arr, temp, target - arr[i]);    //current element is taken
        temp.remove(temp.size() - 1);
    }

    public List<List<Integer>> combinationSum(int[] arr, int target) {
        ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(0, arr, temp, target);
        return ans;
    }
}
