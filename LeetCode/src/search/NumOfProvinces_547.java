package search;

import java.util.List;

public class NumOfProvinces_547 {

    boolean[]isVisited;

    public int findCircleNum(int[][] isConnected) {
        if (isConnected.length == 0){
            return 0;
        }

        isVisited = new boolean[isConnected.length];
        int count = 0;

        for (int i = 0; i < isConnected.length; i++){
            if (false == isVisited[i]){
                dfs(isConnected,i);
                count++;
            }
        }

        return count;
    }

    public void dfs(int[][] isConnected,int i){
        if (true == isVisited[i]){
            return;
        }
        isVisited[i] = true;
        for (int k = 0; k < isConnected[i].length; k++){
            if (isConnected[i][k] == 1){
                isConnected[i][k] = 0;
                dfs(isConnected,k);
            }
        }

    }

    public static void main(String[] args) {
        int[][]a = new int[][]{{1,0,0},{0,1,0},{0,0,1}};
        NumOfProvinces_547 provinces = new NumOfProvinces_547();
        int circleNum = provinces.findCircleNum(a);
        System.out.println(circleNum);
    }
}
