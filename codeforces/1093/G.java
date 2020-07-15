//created by Whiplash99
import java.io.*;
import java.util.Arrays;

public class G
{
    private static final int MAX=Integer.MAX_VALUE, MIN=Integer.MIN_VALUE;
    private static int[] pow;
    private static class Segtree
    {
        int N, K, max[][], min[][];
        Segtree(int NN, int KK, int[][] a)
        {
            int lim=pow[KK];
            N=NN; max=new int[4*N][lim]; min=new int[4*N][lim]; K=KK;
            for(int i=0;i<N;i++) Arrays.fill(max[i],MIN);
            for(int i=0;i<N;i++) Arrays.fill(min[i],MAX);
            for(int mask=lim/2;mask<lim;mask++) build(0,0,N-1,a,mask);
        }
        void build(int i, int l, int r, int[][] a, int mask)
        {
            if(l==r)
            {
                int val=0;
                for(int j=0;j<K;j++) val+=((pow[j]&mask)>0)? a[l][j]:(-1*a[l][j]);
                max[i][mask]=min[i][mask]=val;
                return;
            }
            int m=(l+r)/2;
            build(i*2+1,l,m,a,mask);
            build(i*2+2,m+1,r,a,mask);
            min[i][mask]=Math.min(min[i*2+1][mask],min[i*2+2][mask]);
            max[i][mask]=Math.max(max[i*2+1][mask],max[i*2+2][mask]);
        }
        void update(int pos, int mask, int val){update(0,0,N-1,pos,mask,val);}
        void update(int i, int l, int r, int pos, int mask, int val)
        {
            if(l==r){min[i][mask]=max[i][mask]=val; return;}
            int m=(l+r)/2;
            if(pos<=m) update(i*2+1,l,m,pos,mask,val);
            else update(i*2+2,m+1,r,pos,mask,val);
            min[i][mask]=Math.min(min[i*2+1][mask],min[i*2+2][mask]);
            max[i][mask]=Math.max(max[i*2+1][mask],max[i*2+2][mask]);
        }
        int minimum(int a, int b, int mask){return minimum(0,0,N-1,a,b,mask);}
        int minimum(int i, int l, int r, int a, int b, int mask)
        {
            if(r<a||b<l) return MAX;
            if(a<=l&&r<=b) return min[i][mask];
            int m=(l+r)/2;
            int minL=minimum(i*2+1,l,m,a,b,mask);
            int minR=minimum(i*2+2,m+1,r,a,b,mask);
            return Math.min(minL,minR);
        }
        int maximum(int a, int b, int mask){return maximum(0,0,N-1,a,b,mask);}
        int maximum(int i, int l, int r, int a, int b, int mask)
        {
            if(r<a||b<l) return MIN;
            if(a<=l&&r<=b) return max[i][mask];
            int m=(l+r)/2;
            int maxL=maximum(i*2+1,l,m,a,b,mask);
            int maxR=maximum(i*2+2,m+1,r,a,b,mask);
            return Math.max(maxL,maxR);
        }
    }
    public static void main(String[] args) throws IOException
    {
        Reader reader=new Reader();

        int i,N;

        N=reader.nextInt();
        int K=reader.nextInt();

        pow=new int[K+5]; pow[0]=1;
        for(i=1;i<=K;i++) pow[i]=(pow[i-1]*2);

        int[][] a=new int[N][K];
        for(i=0;i<N;i++)
        {
            for(int j=0;j<K;j++) a[i][j]=reader.nextInt();
        }

        Segtree ST=new Segtree(N,K,a);

        int Q=reader.nextInt();
        StringBuilder sb=new StringBuilder();
        int[] b=new int[K];

        while(Q-->0)
        {
            int type=reader.nextInt();

            if(type==1)
            {
                int pos=reader.nextInt()-1;
                for(i=0;i<K;i++) b[i]=reader.nextInt();
                for(int mask=pow[K]/2;mask<pow[K];mask++)
                {
                    int val=0;
                    for(int j=0;j<K;j++) val+=((pow[j]&mask)>0)? b[j]:(-1*b[j]);
                    ST.update(pos,mask,val);
                }
            }
            else
            {
                int l=reader.nextInt()-1;
                int r=reader.nextInt() -1;

                int ans = MIN;
                for (int mask = pow[K]/2; mask < pow[K]; mask++)
                {
                    int max = ST.maximum(l,r,mask);
                    int min = ST.minimum(l,r,mask);
                    ans = Math.max(ans, max - min);
                }
                sb.append(ans).append("\n");
            }
        }
        System.out.println(sb);
    }
    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;private DataInputStream din;private byte[] buffer;private int bufferPointer, bytesRead;
        public Reader(){din=new DataInputStream(System.in);buffer=new byte[BUFFER_SIZE];bufferPointer=bytesRead=0;
        }public Reader(String file_name) throws IOException{din=new DataInputStream(new FileInputStream(file_name));buffer=new byte[BUFFER_SIZE];bufferPointer=bytesRead=0;
        }public String readLine() throws IOException{byte[] buf=new byte[64];int cnt=0,c;while((c=read())!=-1){if(c=='\n')break;buf[cnt++]=(byte)c;}return new String(buf,0,cnt);
        }public int nextInt() throws IOException{int ret=0;byte c=read();while(c<=' ')c=read();boolean neg=(c=='-');if(neg)c=read();do{ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');if(neg)return -ret;return ret;
        }public long nextLong() throws IOException{long ret=0;byte c=read();while(c<=' ')c=read();boolean neg=(c=='-');if(neg)c=read();do{ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');if(neg)return -ret;return ret;
        }public double nextDouble() throws IOException{double ret=0,div=1;byte c=read();while(c<=' ')c=read();boolean neg=(c=='-');if(neg)c = read();do {ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');if(c=='.')while((c=read())>='0'&&c<='9')ret+=(c-'0')/(div*=10);if(neg)return -ret;return ret;
        }private void fillBuffer() throws IOException{bytesRead=din.read(buffer,bufferPointer=0,BUFFER_SIZE);if(bytesRead==-1)buffer[0]=-1;
        }private byte read() throws IOException{if(bufferPointer==bytesRead)fillBuffer();return buffer[bufferPointer++];
        }public void close() throws IOException{if(din==null) return;din.close();}
    }
}