class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        // multiset<int> queuee;
        deque<int> queuee;
        vector<int> ans;

        //using mulitset
        // int end = 0;
        // for (end; end < k; end++) {
        //     queuee.insert(nums[end]);
        // }
        // int start = 0;
        // for (end; end < nums.size(); end++, start++) {
        //     ans.push_back(*queuee.rbegin());

        //     // for (int i : queuee) cout << i << " ";
        //     // cout << endl;

        //     auto erasee = queuee.find(nums[start]);
        //     queuee.erase(erasee);
        //     queuee.insert(nums[end]);

        // }

        // // for (int i : queuee) cout << i << " ";
        // // cout << endl;

        // ans.push_back(*queuee.rbegin());

        //using deque

        for (int i = 0; i < nums.size(); i++) {

            if (!queuee.empty() && queuee.front() == i - k) queuee.pop_front();
            while (!queuee.empty() && nums[queuee.back()] < nums[i]) queuee.pop_back();
            queuee.push_back(i);

            if (i >= k - 1) ans.push_back(nums[queuee.front()]);
        }


        return ans;
    }
};