package 回溯法.矩阵的路径;

public class Main {

    //矩阵中的路径
    public boolean combine(char[][] matrix, String word) {
        boolean visited[][] = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (dfs(matrix, word, i, j, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] matrix, String word, int i, int j, int k, boolean visited[][]) {
        //终止条件终止条件
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] != word.charAt(k)) {
            return false;
        }
        if (k == word.length()-1) {
            return true;
        }
        visited[i][j] = true;
        boolean res = dfs(matrix, word, i + 1, j, k + 1, visited) ||
                dfs(matrix, word, i - 1, j, k + 1, visited) ||
                dfs(matrix, word, i, j + 1, k + 1, visited) ||
                dfs(matrix, word, i, j - 1, k + 1, visited);
        visited[i][j] = false;

        return res;

    }

    public static void main(String[] args) {
        Main main1 = new Main();
        System.out.println(main1.combine(new char[][]{{'a', 'b', 'c'},{'d', 'e', 'f'},{'g','h','i'}},"befi"));

    }
}
