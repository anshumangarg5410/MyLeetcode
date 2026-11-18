class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int steps = 0;
        int cc = capacity;

        for(int i = 0; i < plants.length; i++) {

            if (cc >= plants[i]) {
                cc -= plants[i];
                steps++;
            }
            else {
                steps += 2*(i+1);
                cc = capacity - plants[i];
                steps--;
            }
        }

        return steps;
    }
}