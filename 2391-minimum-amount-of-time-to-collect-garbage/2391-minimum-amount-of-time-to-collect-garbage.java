class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int n = garbage.length;
        int ans = 0;
        for(int i = 1; i < travel.length; i++) travel[i] += travel[i-1];

        // paper
        int foundInd = 0;
        for (int i = n - 1; i >= 0; i--) {
            boolean found = false;
            for(int j = 0; j < garbage[i].length(); j++) {
                if (garbage[i].charAt(j) == 'P') {
                    found = true;
                    ans++;
                }
            }

            if (found == true) {
                foundInd = Math.max(foundInd, i);
            }

        }

        if (foundInd != 0) ans += travel[foundInd - 1];

        // metal
        foundInd = 0;
        for (int i = n - 1; i >= 0; i--) {
            boolean found = false;
            for(int j = 0; j < garbage[i].length(); j++) {
                if (garbage[i].charAt(j) == 'M') {
                    found = true;
                    ans++;
                }
            }

            if (found == true) {
                foundInd = Math.max(foundInd, i);
            }
        }

        if (foundInd != 0) ans += travel[foundInd - 1];

        //glass
        foundInd = 0;
        for (int i = n - 1; i >= 0; i--) {
            boolean found = false;
            for(int j = 0; j < garbage[i].length(); j++) {
                if (garbage[i].charAt(j) == 'G') {
                    found = true;
                    ans++;
                }
            }

            if (found == true) {
                foundInd = Math.max(foundInd, i);
            }
        }

        if (foundInd != 0) ans += travel[foundInd - 1];

        return ans;
    }
}