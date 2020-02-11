import java.util.*;

import java.io.*;
public class Test {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
      
	public static void main(String[] args) throws IOException{
       int boards = readInt();
       int ans1=0,ans2=0;
       int[]lengths = new int[2001];
       int[]lengthssum = new int[4001];
       for(int i=0;i<boards;i++){
           int temp = readInt();
           lengths[temp]++;
       }
       for(int i =1;i<2001;i++){
           if(lengths[i]>0){
           for(int j =i;j<2001;j++){
               
                   if(i==j)lengthssum[i+j]+=lengths[i]/2;
                   else if(lengths[j]>0){
                       lengthssum[i+j]+=Math.min(lengths[i],lengths[j]);
                   }
               
       }
           }
       
        } for(int i=1;i<4001;i++){
            if(lengthssum[i]> ans1){
                ans2=1;
                ans1 = lengthssum[i];
            }else if(lengthssum[i]==ans1){
                ans2++;
            }
        }System.out.println(ans1 +" "+ans2) ; 
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
