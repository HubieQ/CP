import java.util.*;
import java.io.*;
public class test2 {
 public static boolean pho[],visited[];
 public static ArrayList<Integer>graph[];
 public static int start,max;
	public static void main(String[]args)throws IOException{    
            int n=readInt(),m=readInt(); pho=new boolean[n];visited=new boolean[n];start=0;max=0;
            graph=new ArrayList[n];
            for(int i=0;i<m;i++){
                int temp=readInt();
                start=temp;
                pho[temp]=true;
            }visited[start]=true;
            for(int i=0;i<n;i++)graph[i]=new ArrayList<>();
            for(int i=0;i<n-1;i++){
                int x=readInt(),y=readInt();
                graph[x].add(y);
                graph[y].add(x);
            }dfs(start,0);
            visited=new boolean[n];
            visited[start]=true;
            dfs2(start,0);
            int path =0;
            for(int i=0;i<n;i++){
                if(pho[i])path++;
            }System.out.println(2*(path-1)-max);
           
        }public static boolean dfs(int cur,int dis){
            if(dis>max&&pho[cur]){
                start=cur;
                max=dis;
            }for(int temp:graph[cur]){
                if(!visited[temp]){
                   
                    visited[temp]=true;
                    if (dfs(temp,dis+1)) pho[cur]=true;
                }
            }return pho[cur];
        }public static void dfs2(int cur,int dis){
            max=Math.max(max,dis);
            for(int temp:graph[cur]){
                if(pho[temp]&&!visited[temp]){
                    visited[temp]=true;
                    dfs2(temp,dis+1);
                }
            }
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
	}
}
