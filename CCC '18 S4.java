import java.util.*;
import java.io.*;
public class test2 {
public static HashMap<Integer,Long>mp = new HashMap<>();
        public static long recur(int n){
            if(mp.containsKey(n)){
                return mp.get(n);
            }if(n==1)return 1;
            int i=2;long total=0;
            while(i<=n){
                long x = n/i,y=n/x;
                total += (y-i+1)*recur((int)x);
                i=(int)y+1;
            }mp.put(n,total);
            return mp.get(n);
            
        }
	public static void main(String[]args)throws IOException{    
           int n = readInt();
           System.out.println(recur(n));
          
            
        }


    
        
        
	final private static int BUFFER_SIZE = 1 << 16;
	private static DataInputStream din = new DataInputStream(System.in);
	private static byte[] buffer = new byte[BUFFER_SIZE];
	private static int bufferPointer = 0, bytesRead = 0;
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    
	
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

}
