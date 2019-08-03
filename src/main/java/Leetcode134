    class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int i = -1, j = 0, k = 0;
        outerloop: while (++i < gas.length) {
            k = 0;
            j = i;
            if (gas[i] >= cost[i]) {
                int total = gas[i] - cost[i];
                while (++j < gas.length) {
                    total += (gas[j] - cost[j]);
                    if (total < 0) continue outerloop;
                }
                
                while (k < i) {
                    total += (gas[k] - cost[k++]);
                    if (total < 0) continue outerloop;
                }
                
                return i;
            }
        }
        
        return -1;
    }
}
