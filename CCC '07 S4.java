import java.util.*;

import java.io.*;
public class Test {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
       
	public static void main(String[] args) throws IOException{
            int N = readInt(),ways[] = new int[N+1];
            
            ArrayList<List<Integer>> possible = new ArrayList<>();
              for(int i =0; i< N+1; i++)  {
                possible.add(new ArrayList<>());
              
              }
            int a= readInt(),b= readInt();
            while(!(a==0 && b==0)){
                possible.get(b).add(a);
                a=readInt();b=readInt();
            }ways[1]=1;
            a=1;
            for(int i=1;i<=N;i++){
                for(int j=0;j<possible.get(i).size();j++){
                    ways[i]+=ways[possible.get(i).get(j)];
                
            }
            }System.out.println(ways[N]);
            
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
