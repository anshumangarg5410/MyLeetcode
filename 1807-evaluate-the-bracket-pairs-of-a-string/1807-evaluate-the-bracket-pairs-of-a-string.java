class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        HashMap<String, String> map = new HashMap<>();

        int sizeKnow = knowledge.size();
        int sizeS = s.length();

        for(int i = 0; i < sizeKnow; i++) {
            map.put(knowledge.get(i).get(0), knowledge.get(i).get(1));
        }

        boolean insideABracket = false;

        for(int i = 0; i < sizeS; i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                insideABracket = true;
            }
            else if (ch == ')'){
                insideABracket = false;

                if(map.containsKey(temp.toString())) {
                    sb.append(map.get(temp.toString()));
                } 
                else {
                    sb.append('?');
                }

                insideABracket = false;
                temp.setLength(0);
            }
            else if (insideABracket) {
                temp.append(ch);
            }
            else {
                sb.append(ch);
            }

        }

        return sb.toString();
    }
}