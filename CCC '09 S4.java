import java.util.*;
import java.io.*;
public class test2 {
    public static class Edge implements Comparable<Edge>{
            int s,d;
            Edge(int sa,int da){
                s=sa;
                d=da;
            }public int compareTo(Edge e){
                return d-e.d;
            }
        }
    public static void main(String[] args) throws IOException {
        int n=readInt(),t=readInt(),dp2[][]=new int[n+1][n+1];
        for(int i=1;i<=n;i++)Arrays.fill(dp2[i],(int)1e9);
        for(int i=0;i<t;i++){
            int a=readInt(),b=readInt(),dis=readInt();
            dp2[a][b]=dis;
            dp2[b][a]=dis;
        }
        int k=readInt(),loc[]=new int[n+1];
        for(int i=0;i<k;i++){
            int a=readInt(),b=readInt();
            loc[a]=b;
        }int d = readInt(),dp[]=new int[n+1];boolean v[]=new boolean[n+1];
        Arrays.fill(dp,(int)1e9); dp[d]=0; 
        for(int i=1;i<=n;i++){
            int min = (int)1e9,num = (int)(1e9);
            for(int j=1;j<=n;j++)if(dp[j]<min&&!v[j]){
                num = j;
                min = dp[j];
            }if(num==(int)1e9)break;
             v[num]=true;
             for(int j=1;j<=n;j++){
                 if(!v[j]&&dp[j]>dp[num]+dp2[num][j])dp[j]=dp[num]+dp2[num][j];
             }
        }
        
        int ans = Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            if(loc[i]!=0)ans=Math.min(ans,dp[i]+loc[i]);
        }System.out.println(ans);
    }
        

    
        
        
	final private static int BUFFER_SIZE = 1 << 16;
	private static DataInputStream din = new DataInputStream(System.in);
	private static byte[] buffer = new byte[BUFFER_SIZE];
	private static int bufferPointer = 0, bytesRead = 0;
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        /*static boolean next_permutation(int a[],int L,int R){
            if(L==R)return false;
            int p = R-1,q=R;
            while(p>=L && a[p]>=a[p+1])p--;
            if(p<L)return false;
            while(a[q]<=a[p])q--;
            int tmp = a[p];a[p]=a[q];a[q]=tmp;
            for(int i=p+1,j=R;i<j;i++,j--){
                tmp=a[i];a[i]=a[j];a[j]=tmp;
            }return true;
        }*/
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
