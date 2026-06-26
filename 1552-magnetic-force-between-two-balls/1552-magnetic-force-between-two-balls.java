class Solution {

  public boolean checker(int[] position, int minDist, int k) {
        int magForce = k - 1;
        int lastPlaced = 0;
        
        for(int i = 1; i < position.length && magForce > 0; i++) {
            if (position[i] - position[lastPlaced] >= minDist) {
                magForce--;
                lastPlaced = i;
            }
        }
        
        if (magForce == 0) return true;
        
        return false;
    }

    public int maxDistance(int[] position, int m) {
       Arrays.sort(position);
        
        int start = 1, end = position[position.length  - 1] - position[0];
        int ans = 0;
        
        while (start <= end) {
            int mid = start + (end - start)/2;
            
            if (checker(position, mid, m)) {
                ans = mid;
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        
        return ans;
    }
}