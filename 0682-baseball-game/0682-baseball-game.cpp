class Solution {
public:
    int calPoints(vector<string>& operations) {
        stack<int> score;
        for(string i : operations) {
            if (i == "C") score.pop();
            else if (i == "D") score.push(score.top() * 2);
            else if (i == "+") {
                int neew = 0;
                neew += score.top();
                score.pop();
                int temp =  score.top();
                score.push(neew);
                neew += temp; 
                score.push(neew);
            }
            else score.push(stoi(i));
        }

        int result = 0;
        while(score.size() > 0){
            result += score.top();
            score.pop();
        }
        return result;

    }
};