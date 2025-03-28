class Solution {
public:

    int reversee(int &x) {
        int reversed = 0;
        while (x != 0) {
            int digit = x % 10;  
            x /= 10;             
            
            if (reversed > INT_MAX / 10 || (reversed == INT_MAX / 10 && digit > 7)) return 0;
            if (reversed < INT_MIN / 10 || (reversed == INT_MIN / 10 && digit < -8)) return 0;
            
            reversed = reversed * 10 + digit; 
        }
        return reversed;
    }


    string add2num(string fst, string scd){
        string lar; string sml; string output;

        if (fst.size() > scd.size()) {
            lar = fst;
            sml = scd;
        } else {
            lar = scd;
            sml = fst;
        }
        
        int s1 = lar.size(); 
        int s2 = sml.size();
        
        while (s2 < s1) {
            sml.insert(0, "0");
            s2++;
        }

        int carry = 0;
        for(int i = s1-1; i>=0; i--){
            int sum = (lar[i] - '0') + (sml[i] - '0') + carry;
            output.insert(0, 1, (sum % 10) + '0');
            carry = sum / 10;
        }
        if (carry) output.insert(0, 1, carry + '0');

        return output;

    }

    string addfromvector(vector<string> arr) {
        string result = "0";
        for (string num : arr) {
            result = add2num(result, num);
        }

        while (result.size() > 1 && result[0] == '0') {
            result.erase(0, 1);
        }
        return result;
    }


    vector<string> multiplystrings(string big, string sml){
        //numbers ko reverse kra
        reverse(big.begin(), big.end());
        reverse(sml.begin(), sml.end());

        //size check kra
        int s1 = big.size();
        int s2 = sml.size();
        int s2ind = 0;

        vector<string> resultar; //main result wali array

        //main caluclation ka time

        int result = 0;
        int multiplier = 0;
        // while (s2ind < s2){
        //     int tempsum = 0; //line to line wale sum
        //     int carry = 0; //carry 
        //     //main kaam shuru
        //     for(int i = 0; i<s1; i++){
        //         int mult = (sml[s2ind] - '0') * (big[i] - '0');
        //         // cout << "prod: " << mult << " ";
        //             tempsum = tempsum * 10 + (mult+carry)%10;
        //             carry = mult/10;
        //     }
        //     // cout << tempsum << endl;
        //     s2ind++;
        //     result += reversee(tempsum) * pow(10, multiplier++);
        // }

        while (s2ind < s2){
            string tempsum = ""; //line to line wale sum
            int carry = 0; //carry 
            //main kaam shuru
            for (int i = 0; i < s1; i++) {
                int mult = (sml[s2ind] - '0') * (big[i] - '0') + carry;
                tempsum.push_back((mult % 10) + '0');
                carry = mult / 10;
            }
            if (carry > 0) tempsum.push_back(carry + '0');

            // cout << tempsum << endl;
            reverse(tempsum.begin(), tempsum.end());
            
            for(int i = 0; i<multiplier; i++) tempsum.push_back('0'); multiplier++;
            resultar.push_back(tempsum);
            // cout << tempsum << endl;
            s2ind++;
        }


        for (string i : resultar) cout << "--" << i << "--" << endl; cout << "---------" << endl;

        return resultar;
    }


    string multiply(string num1, string num2) {
        if (num1 == "0" || num2 == "0") return "0";
        // long long int first = stoll(num1);
        // long long int second = stoll(num2);
        // if (first > second) return addfromvector(multiplystrings(num1, num2));
        // else return addfromvector(multiplystrings(num2, num1));
        return addfromvector(multiplystrings(num1, num2));
    }



    //to be done again .. kaise pta nhi .. shayad 2 3 month baad .. ! :-) 
};