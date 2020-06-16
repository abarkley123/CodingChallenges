package main.java;

public class Leetcode797 {

        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            List<List<Integer>> ret = new ArrayList<>();
            if (graph == null || graph.length == 0) return ret;

            dfs(graph, ret, 0, new ArrayList<>(Arrays.asList(0)));
            return ret;
        }

        public void dfs(int[][] graph, List<List<Integer>> ret, int pos, List<Integer> l) {
            if (pos == graph.length - 1) {
                ret.add(new ArrayList<>(l));
                return;
            }

            for (int nei : graph[pos]) {
                l.add(nei);
                dfs(graph, ret, nei, l);
                l.remove(l.size() - 1);
            }

        }

}
