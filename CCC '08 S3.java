import java.util.*;
import java.io.*;
public class Test {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
  static int dp[][];
static boolean visited[][];
    public static void main(String [] args) throws IOException{
     int cases = readInt();
     for(int abba=0;abba<cases;abba++){
         int r = readInt(),c=readInt();
         char cur[][]=new char[r+1][c+1];
         boolean visited[][] = new boolean[r+1][c+1];
         int dp[][]=new int[r+1][c+1];
         for(int i=1;i<=r;i++){
             String temp = readLine();
             for(int j=0;j<c;j++){
                 cur[i][j+1]=temp.charAt(j);
                 dp[i][j+1]=-1;
             }
         }Queue<Integer>q = new LinkedList<>();
         q.add(101);visited[1][1]=true;dp[1][1]=1;
         while(!q.isEmpty()){
             int temp = q.poll(),a=temp/100,b=temp%100;
             if(cur[a][b]=='+'){
             if(a-1>0&&cur[a-1][b]!='*'&&!visited[a-1][b]){
                 visited[a-1][b]=true;
                 q.add(100*(a-1)+b);
                 dp[a-1][b]=dp[a][b]+1;
             }if(a+1<=r&&cur[a+1][b]!='*'&&!visited[a+1][b]){
                 visited[a+1][b]=true;
                 q.add(100*(a+1)+b);
                 dp[a+1][b]=dp[a][b]+1;
             }if(b-1>0&&cur[a][b-1]!='*'&&!visited[a][b-1]){
                 visited[a][b-1]=true;
                 q.add(100*(a)+b-1);
                 dp[a][b-1]=dp[a][b]+1;
             }if(b+1<=c&&cur[a][b+1]!='*'&&!visited[a][b+1]){
                 visited[a][b+1]=true;
                 q.add(100*(a)+b+1);
                 dp[a][b+1]=dp[a][b]+1;
             }
            }else if(cur[a][b]=='-'){
             if(b-1>0&&cur[a][b-1]!='*'&&!visited[a][b-1]){
                 visited[a][b-1]=true;
                 q.add(100*(a)+b-1);
                 dp[a][b-1]=dp[a][b]+1;
             }if(b+1<=c&&cur[a][b+1]!='*'&&!visited[a][b+1]){
                 visited[a][b+1]=true;
                 q.add(100*(a)+b+1);
                 dp[a][b+1]=dp[a][b]+1;
             }
            }else if(cur[a][b]=='|'){
                
             if(a-1>0&&cur[a-1][b]!='*'&&!visited[a-1][b]){
                 visited[a-1][b]=true;
                 q.add(100*(a-1)+b);
                 dp[a-1][b]=dp[a][b]+1;
             }if(a+1<=r&&cur[a+1][b]!='*'&&!visited[a+1][b]){
                 
                 visited[a+1][b]=true;
                 q.add(100*(a+1)+b);
                 dp[a+1][b]=dp[a][b]+1;
             }
            }
         }
             System.out.println(dp[r][c]);
         
         }
     }
    
    public static boolean bfs(ArrayList<Integer>graph[]){
           boolean visited[] = new boolean[27];
           int dp[]=new int[27];
           Arrays.fill(dp,Integer.MAX_VALUE);
           Queue<Integer> q = new LinkedList<>();
           q.add(1);visited[1]=true;
           while(!q.isEmpty()){
                        int temp = q.poll();
                        for(int i=0;i<graph[temp].size();i++){
                            if(!visited[graph[temp].get(i)]){
                                visited[graph[temp].get(i)]=true;
                                dp[graph[temp].get(i)]=dp[temp]+1;
                                q.add(graph[temp].get(i));
                            }
                        }
                    }
           return visited[2];
    }
       
    
   public static int gcdall(int a[]){
            int temp =a[0];
            for(int i=1;i<a.length;i++){
                temp=gcd(temp,a[i]);
            }return temp;
       
   }public static int gcd(int a,int b){
       if(a==0)return b; 
       return gcd(b % a, a); 
   }
    
    static int find(int d, int p[]) {
    	if(d != p[d]) p[d] = find(p[d], p);
    	return p[d];
    }
    static class pair implements Comparable<pair>{
    	int d; int w;
    	pair(int d0, int w0){ d=d0; w=w0; }
    	public int compareTo(pair x) {
    		return -Integer.compare(w, x.w);
    	}
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
	static String readLine () throws IOException {
		return br.readLine().trim();
	}
}
