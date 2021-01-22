package backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueen_51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        List<String> result = new ArrayList<>();
        boolean[] rows = new boolean[n];
        boolean[] cols = new boolean[n];
        boolean[] ldias = new boolean[2*n - 1];
        boolean[] rdias = new boolean[2*n - 1];

        backtracking(results,result,0,rows,cols,ldias,rdias,n);

        return results;

    }

    public void backtracking(List<List<String>> results, List<String> result, int row,boolean[] rows, boolean[] cols, boolean[] ldias, boolean[] rdias, int n){

        if (row == n){
            results.add(new ArrayList<>(result));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (rows[row] || cols[i] || ldias[row + i] || rdias[row + n - i -1]){
                continue;
            }

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j == i){
                    sb.append("Q");
                }else {
                    sb.append(".");
                }
            }
            String value = sb.toString();
            result.add(value);
            rows[row] = cols[i] = ldias[row + i] = rdias[row + n - i -1] = true;

            backtracking(results, result, row + 1, rows, cols, ldias, rdias, n);

            result.remove(value);
            rows[row] = cols[i] = ldias[row + i] = rdias[row + n - i -1] = false;
        }

    }

    public static void main(String[] args) {
        NQueen_51 queen = new NQueen_51();
        List<List<String>> lists = queen.solveNQueens(4);
        for (List<String> list : lists){
            for (String s : list){
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

}
