class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        stack<int> myst;
        for(int i = 0; i<tokens.size(); i++){
            if (tokens[i] != "+" && tokens[i] != "-" && tokens[i] != "*" && tokens[i] != "/"){
                myst.push(stoi(tokens[i]));
            }
            else {
                int y = myst.top(); myst.pop();
                int x = myst.top(); myst.pop();
                if (tokens[i] == "+") myst.push(x + y);
                else if (tokens[i] == "+") myst.push(x + y);
                else if (tokens[i] == "-") myst.push(x - y);
                else if (tokens[i] == "/") myst.push(x / y);
                else if (tokens[i] == "*") myst.push(x * y);
                else continue;
            }
        }
        cout << myst.top() << endl;
        return myst.top();

    }
};