import java.util.*;
import java.util.ArrayList;

class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        int n=maze.length;
        ArrayList<String> ans= new ArrayList<>();
        
        int [][]visited= new int[n][n];
        
        if(maze[0][0]==1){
        
        solve(0,0,maze,n,"",ans,visited);
        }
        return ans;
    }
    static void solve(int i,int j,int[][] maze,int n,String path,ArrayList<String> ans,int[][] visited){
        if(i==n-1&&j==n-1){
            ans.add(path);
            return;
        }
        visited[i][j]=1;
        int[] di={1,0,0,-1};
        int[] dj={0,-1,1,0};
        String move="DLRU";
        for(int k=0;k<4;k++){
            int nextI=i+di[k];
            int nextJ=j+dj[k];
            if(nextI>=0 &&nextI<n &&nextJ>=0&&nextJ<n&&visited[nextI][nextJ]==0&&maze[nextI][nextJ]==1){
                solve(nextI,nextJ,maze,n,path+move.charAt(k),ans,visited);
            }
        }
        visited[i][j]=0;
    }

    public static void main(String[] args) {
        int[][] maze = {
            {1,0,0,0},
            {1,1,0,1},
            {0,1,0,0},
            {1,1,1,1}
        };
        Solution s = new Solution();
        ArrayList<String> paths = s.ratInMaze(maze);
        if (paths.isEmpty()) System.out.println("No paths");
        else paths.forEach(System.out::println);
    }
}