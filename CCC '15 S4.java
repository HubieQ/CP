import java.util.*;
import java.io.*;
public class test2 {
        static int bit[];
	public static void main(String[]args)throws IOException{    
            int k=readInt(),n=readInt(),m=readInt();
            ArrayList<edge>graph[] = new ArrayList[n+1];
            for(int i=0;i<=n;i++){
                graph[i]=new ArrayList<>();
            }int dp[][]=new int[n+1][k+1];
            for(int i=0;i<=n;i++){
                for(int j=0;j<=k;j++){
                    dp[i][j]=1000000000;
                }
            }
            for(int i=0;i<m;i++){
                int a=readInt(),b=readInt(),time=readInt(),hull=readInt();
                graph[a].add(new edge(b,time,hull));
                graph[b].add(new edge(a,time,hull));
            }int a =readInt(),b=readInt();
            PriorityQueue<edge> pq = new PriorityQueue<>(new cmp());
            pq.add(new edge(a,0,0));
            for(int i=0;i<=k;i++)dp[a][i]=0;
            while(!pq.isEmpty()){
                edge p = pq.poll();
               
                int cur = p.loc,dis=p.dis,hull=p.hull;
              
                for(edge e:graph[cur]){
                    if(e.hull+hull<k&&dp[cur][hull]+e.dis<dp[e.loc][hull+e.hull]){
                        dp[e.loc][hull+e.hull]=dp[cur][hull]+e.dis;
                        pq.add(new edge(e.loc,dp[cur][hull]+e.dis,e.hull+hull));
                    }
                }
                
            }int ans = Integer.MAX_VALUE;
            for(int i=0;i<k;i++)ans=Math.min(ans,dp[b][i]);
            
            if(ans==1000000000)System.out.println(-1);
            else System.out.println(ans);
            
        }
        

    
        
        
	final private static int BUFFER_SIZE = 1 << 16;
	private static DataInputStream din = new DataInputStream(System.in);
	private static byte[] buffer = new byte[BUFFER_SIZE];
	private static int bufferPointer = 0, bytesRead = 0;
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
	public static String readLine() throws IOException {
		byte[] buf = new byte[64]; // line length
		int cnt = 0, c;
		while ((c = Read()) != -1) {
			if (c == '\n')
				break;
			buf[cnt++] = (byte) c;
		}
		return new String(buf, 0, cnt);
	}
	public static String read() throws IOException{
		byte[] ret = new byte[1024];
        int idx = 0;
        byte c = Read();
        while (c <= ' ') {
            c = Read();
        }
        do {
            ret[idx++] = c;
            c = Read();
        } while (c != -1 && c != ' ' && c != '\n' && c != '\r');
        return new String(ret, 0, idx);
	}
	public static int readInt() throws IOException {
		int ret = 0;
		byte c = Read();
		while (c <= ' ')
			c = Read();
		boolean neg = (c == '-');
		if (neg)
			c = Read();
		do {
			ret = ret * 10 + c - '0';
		} while ((c = Read()) >= '0' && c <= '9');

		if (neg)
			return -ret;
		return ret;
	}

	public static long readLong() throws IOException {
		long ret = 0;
		byte c = Read();
		while (c <= ' ')
			c = Read();
		boolean neg = (c == '-');
		if (neg)
			c = Read();
		do {
			ret = ret * 10 + c - '0';
		} while ((c = Read()) >= '0' && c <= '9');
		if (neg)
			return -ret;
		return ret;
	}

	public static double readDouble() throws IOException {
		double ret = 0, div = 1;
		byte c = Read();
		while (c <= ' ')
			c = Read();
		boolean neg = (c == '-');
		if (neg)
			c = Read();

		do {
			ret = ret * 10 + c - '0';
		} while ((c = Read()) >= '0' && c <= '9');

		if (c == '.') {
			while ((c = Read()) >= '0' && c <= '9') {
				ret += (c - '0') / (div *= 10);
			}
		}

		if (neg)
			return -ret;
		return ret;
	}

	private static void fillBuffer() throws IOException {
		bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
		if (bytesRead == -1)
			buffer[0] = -1;
	}

	private static byte Read() throws IOException {
		if (bufferPointer == bytesRead)
			fillBuffer();
		return buffer[bufferPointer++];
	}

	public void close() throws IOException {
		if (din == null)
			return;
		din.close();
	}

	static void print(Object o) {
		pr.print(o);
	}

	static void println(Object o) {
		pr.println(o);
	}

	static void flush() {
		pr.flush();
	}

	static void println() {
		pr.println();
	}

	static void exit() throws IOException {
		din.close();
		pr.close();
		System.exit(0);
	}public static class edge{
            int loc;int dis;int hull;
            edge(int loca,int disa,int hulla){
                loc = loca;
                dis = disa;
                hull = hulla;
            }
        }public static class cmp implements Comparator<edge>{
            public int compare(edge a,edge b){
                return a.dis-b.dis;
            }
        }
}
