import java.io.*;
import java.util.*;





public class A {

	
	static int maxN=(int)2e9;
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		PrintWriter out=new PrintWriter(System.out);
		int n=sc.nextInt();
		String s="LMW";
		int [][]a=new int [3][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<3;j++)
				a[j][i]=sc.nextInt();
		int n1=n/2,n2=n-n1;
		HashMap<Long,pair>map=new HashMap<Long, pair>();
		for(int msk=(int) Math.pow(3, n1)-1;msk>=0;msk--)
		{
			int x=msk;
			int []z=new int [3];
			
			for(int i=0;i<n1;i++)
			{
				int bit=x%3;
				x=x/3;
				for(int j=0;j<3;j++)
					if(j!=bit)
						z[j]+=a[j][i];
				
			}
			long hash=hash(z[1]-z[0],z[2]-z[0]);
			pair p=new pair(msk,z[0]);
			if(!map.containsKey(hash) || map.get(hash).z0<z[0])
				map.put(hash,p);
			
		}
		int max=-1,best1=-1,best2=-1;
		for(int msk=(int) (Math.pow(3, n2)-1);msk>=0;msk--)
		{
			int []z=new int [3];
			int x=msk;
			for(int i=0;i<n2;i++)
			{
				int bit=x%3;
				x=x/3;
				for(int j=0;j<3;j++)
					if(j!=bit)
						z[j]+=a[j][i+n1];
			}
			long hash=hash(z[0]-z[1],z[0]-z[2]);
			pair p=map.getOrDefault(hash, null);
			if(p!=null)
			{
				if(best1==-1 || z[0]+p.z0>max)
				{
					best1=p.msk;
					best2=msk;
					max=z[0]+p.z0;
				}	
					
			}
		
			
		}
		if(best1==-1)
			out.println("Impossible");
		else
		{
			
			int x=best1;
			for(int i=0;i<n1;i++)
			{
				int bit=x%3;
				x=x/3;
				for(int j=0;j<3;j++)
					if(j!=bit) {
						out.print(s.charAt(j));
						
					}
				out.println();
			}
			x=best2;
			for(int i=0;i<n2;i++)
			{
				int bit=x%3;
				x=x/3;
				for(int j=0;j<3;j++)
					if(j!=bit) {
						out.print(s.charAt(j));
						
					}
				out.println();
			}
			
		}
		out.close();

	

	}
	static class pair
	{
		int msk,z0;
		pair(int a,int b){
			msk=a;
			z0=b;
		}
	}
	static long hash(long x1,long x2)
	{
		x1+=maxN/2;
		x2+=maxN/2;
		
		return x1*maxN+x2;
	}
	static long []unHash(long hash)
	{
		long []ans=new long [2];
		ans[0]=hash/maxN-maxN/2;
		ans[1]=hash%maxN-maxN/2;
		return ans;
	}
	static class Scanner
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s)
		{
			br = new BufferedReader(new InputStreamReader(s));
		}

		public Scanner(String s) throws FileNotFoundException
		{
			br = new BufferedReader(new FileReader(new File((s))));
		}

		public String next() throws IOException
		{
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException
		{
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException
		{
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException
		{
			return br.readLine();
		}

		public double nextDouble() throws IOException
		{ return Double.parseDouble(next()); }	
	}
}