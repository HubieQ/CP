import java.io.*;
import java.util.*;
 public class Test {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
        static int ds[];
        public static int findset(int d){
            if(d!=ds[d])return ds[d] = findset(ds[d]);
            else return d;
        }
    	public static void main(String[] args) throws IOException {
    	int G = readInt(), P = readInt();
    	ds = new int[G+1];
    	for(int i=1;i<=G;i++)ds[i]=i;
    	for(int i=0;i<P;i++){
        	int max = readInt();
        	int g = findset(max);
        if(g==0){
            System.out.println(i);
            return;
        }
        ds[g]=ds[g-1];
    	}System.out.println(P);
     
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
