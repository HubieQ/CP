import java.io.*;

import java.util.*;
 public class Test {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
        static int max,houses[];
    public static void main(String[] args) throws IOException {
        int h=readInt();houses = new int[h];
        for(int i=0;i<h;i++)houses[i]=readInt();
        Arrays.sort(houses);
        int k=readInt();
        int hi=1000000,lo=-1;
        if(k>=h){
            System.out.println(0);
            return;
        }
        while(hi>lo+1){
            int mid = (hi+lo)/2;
            if(check(mid)>k){
                lo=mid;
            }else hi = mid;
        }System.out.println(hi);
       
    }public static int check(int l){
        int d = l*2,ans=houses.length;
        for(int i=0;i<houses.length&&houses[i]<=d+houses[0];i++){
        int end = houses[i],hoses=1;
            for(int j=i+1;j<houses.length&&houses[i]+1000000>houses[j]+d;j++){
                if(end<houses[j]){
                    end=houses[j]+d;
                    hoses++;
                }
            }ans=Math.min(ans,hoses);
        }return ans;
    }
        
  
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong () throws IOException {
		return Long.parseLong(next());
	}static char readCharacter () throws IOException {
                return next().charAt(0);
        }
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}
	static double readDouble () throws IOException {
		return Double.parseDouble(next());
	}
	static String readLine () throws IOException {
		return br.readLine().trim();
	}        
}
