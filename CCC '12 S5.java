import java.util.*;

import java.io.*;
public class Test {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
       
	public static void main(String[] args) throws IOException{
            int R = readInt(),C = readInt(),grid[][]=new int[R+1][C+1];
            boolean[][]cages = new boolean[R+1][C+1];
            grid[1][1]=1;
            int number = readInt();
            for(int i=0;i<number;i++){
                int a = readInt(),b = readInt();
                cages[a][b]= true;
            }for(int i =1;i<=R;i++){
                for(int j=1;j<=C;j++){
                    if(!cages[i][j]){
                        grid[i][j]+=grid[i-1][j]+grid[i][j-1];
                    }
                }
            }System.out.println(grid[R][C]);
            
            
        }
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong () throws IOException {
		return Long.parseLong(next());
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}
	static double readDouble () throws IOException {
		return Double.parseDouble(next());
	}
	static char readCharacter () throws IOException {
		return next().charAt(0);
	}
	static String readLine () throws IOException {
		return br.readLine().trim();
	}
}
