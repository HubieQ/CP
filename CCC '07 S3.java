import java.util.*;
import java.io.*;

public class Test {
    public static class Pair{
        int f, s;
            Pair(int fa,int sa){
            f=fa;s=sa;
        }
    }
    public static void main(String[] args) throws IOException{
        int n = readInt();ArrayList<Integer>graph[] = new ArrayList[10000];
        for(int i=0;i<10000;i++){
            graph[i]=new ArrayList<>();
        }for(int i=0;i<n;i++){
            graph[readInt()].add(readInt());
        }int a = readInt(),b=readInt();
        while(a!=0&&b!=0){
            Queue<Integer>q = new LinkedList<>();
            boolean visited[] = new boolean[10000];
            int dp[] = new int[10000],dp2[]=new int[10000];
            Arrays.fill(dp,Integer.MAX_VALUE);Arrays.fill(dp2,Integer.MAX_VALUE);
            dp[a]=0;dp2[b]=0;
            q.add(a);visited[a]=true;
            while(!q.isEmpty()){
                int cur = q.poll();
                for(int i: graph[cur]){
                    if(!visited[i]){
                        visited[i]=true;
                        dp[i]=dp[cur]+1;
                        q.add(i);
                    }
                }
            }Arrays.fill(visited,false); visited[b]=true; q.add(b);
            while(!q.isEmpty()){
                int cur = q.poll();
                for(int i: graph[cur]){
                    if(!visited[i]){
                        visited[i]=true;
                        dp2[i]=dp2[cur]+1;
                        q.add(i);
                    }
                }
            }if(dp[b]==Integer.MAX_VALUE||dp2[a]==Integer.MAX_VALUE){
                System.out.println("No");
            }else System.out.println("Yes "+(dp[b]-1));
            a=readInt();b=readInt();
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
