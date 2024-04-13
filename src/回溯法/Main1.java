package 回溯法;

import java.util.ArrayList;
import java.util.List;

public class Main1 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> track = new ArrayList<>();
        backtrack(1, n, k, track, res);
        return res;
    }

    public void backtrack(int start, int n, int k, List<Integer> track, List<List<Integer>> res) {
        //终止条件终止条件
        if (track.size() == k) {
            res.add(new ArrayList<>(track));
            return;
        }
        //单层搜索逻辑
        for (int i = start; i <= n; i++) {
            track.add(i);
            backtrack(i + 1, n, k, track, res);
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        Main1 main1 = new Main1();
        System.out.println(main1.combine(4, 2));

    }
}
