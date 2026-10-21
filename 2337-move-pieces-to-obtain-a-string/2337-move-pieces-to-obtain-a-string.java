class Solution {
    public boolean canChange(String start, String target) {
        int i = 0, j = 0;
        int len = start.length();
        int orig = 0;
        int targ = 0;

        for(int k = 0; k < len; k++) {
            if (start.charAt(k) != '_') orig++;
            if (target.charAt(k) != '_') targ++;
        }

        if (orig != targ) return false;

        while (i < len && j < len) {
            while (i < len && start.charAt(i) == '_') i++;
            while (j < len && target.charAt(j) == '_') j++;

            if (i >= len && j >= len) return true;
            else if (i >= len || j >= len) return false;

            char targCrnt = target.charAt(j);
            char starCrnt = start.charAt(i);

            if (targCrnt != starCrnt) return false;

            if (targCrnt == 'L') {
                if (j > i) return false;
            }
            else if (targCrnt == 'R') {
                if (j < i) return false;
            }

            if (targCrnt == starCrnt) {
                i++;
                j++;
            }

        }

        // return i >= len && j >= len;
        return true;
    }
}

