class Solution {
public:
    int minimumRounds(vector<int>& tasks) {
        sort(tasks.begin(), tasks.end());
        int countsd = 1, crnt = tasks[0], ans = 0, rounds = 0;
        if (tasks.size() == 1) return -1;

        // for (int i : tasks) cout << i << " ";
        // cout << endl;

        for (int i = 1; i < tasks.size(); i++) {

            if (tasks[i] != crnt) {
                // cout << "group = " << crnt << " count = " << countsd << endl;
                if (countsd == 1) return -1;
                ans += (countsd/3) + ((countsd%3)!=0);
                crnt = tasks[i];
                countsd = 1;
            }
            else {
                countsd++;
            }
        }

        // cout << "group = " << crnt << " count = " << countsd << endl;
        if (countsd == 1) return -1;
        ans += (countsd/3) + ((countsd%3)!=0);

        return ans;
    }
};