class Solution {

    public void bt (int[] canditates, int target, List<List<Integer>> ans, int sum, int i, List<Integer> temp) {
        if (sum == target) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        if (sum > target) {
            return;
        }

        for(; i < canditates.length; i++) {
            temp.add(canditates[i]);
            bt(canditates, target, ans, sum + canditates[i], i, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        bt(candidates, target, ans, 0, 0, temp);

        return ans;
    }
}