import java.util.*;
import java.io.*;
public class test2 {
         static int dis[];
       public static int findset(int n){
           if(n!=dis[n])return dis[n]=findset(dis[n]);
           return n;
       }
    public static void main(String[] args) throws IOException {
        int m=readInt(),n=readInt(),k=readInt(),dp[][]=new int[m+1][n+1];
        for(int i=0;i<k;i++){
            int x=readInt()-1,y=readInt()-1,r=readInt(),b=readInt();
            for(int j=Math.max(0,x-r);j<=Math.min(n-1,x+r);j++){
                int add = (int)Math.floor(Math.sqrt(r*r-(j-x)*(j-x)));
                dp[Math.max(0,y-add)][j]+=b;
                dp[Math.min(y+add+1,m)][j]-=b;
            }
        }
        int max=0,count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i>0){
                    dp[i][j]+=dp[i-1][j];
                }if(dp[i][j]==max)count++;
                else if(dp[i][j]>max){
                    max=dp[i][j];
                    count=1;
                }
            }
        }System.out.println(max);
        System.out.println(count);
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
