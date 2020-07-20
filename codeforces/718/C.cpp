#include<set>
#include<map>
#include<deque>
#include<queue>
#include<stack>
#include<cmath>
#include<ctime>
#include<bitset>
#include<string>
#include<vector>
#include<cstdio>
#include<cstdlib>
#include<cstring>
#include<climits>
#include<complex>
#include<iostream>
#include<algorithm>
#define ll long long
using namespace std;

const int maxn = 210000;
const int mod = 1e9+7;
inline void add(int &a,const int &b){a+=b;if(a>=mod)a-=mod;}

struct mat
{
	int a[2][2];
	mat(){memset(a,0,sizeof a);}
	friend inline mat operator +(const mat &x,const mat &y)
	{
		mat re;
		for(int i=0;i<2;i++)for(int j=0;j<2;j++) re.a[i][j]=(x.a[i][j]+y.a[i][j])%mod;
		return re;
	}
	friend inline mat operator *(const mat &x,const mat &y)
	{
		mat re;
		for(int i=0;i<2;i++) for(int j=0;j<2;j++)
			for(int k=0;k<2;k++) add(re.a[i][k],(ll)x.a[i][j]*y.a[j][k]%mod);
		return re;
	}
}one,trans,M[maxn];
mat PW(int k)
{
	mat re=one,x=trans;
	for(;k;k>>=1,x=x*x) if(k&1)
		re=re*x;
	return re;
}

struct segment
{
	mat seg[maxn<<2],flag[maxn<<2];
	int ok[maxn<<2];
	int lx,rx; mat c;
	void build(const int x,const int l,const int r)
	{
		ok[x]=0,flag[x]=one;
		if(l==r) { seg[x]=M[l]; return; }
		int mid=l+r>>1,lc=x<<1,rc=lc|1;
		build(lc,l,mid); build(rc,mid+1,r);
		seg[x]=seg[lc]+seg[rc];
	}
	void pushdown(int x)
	{
		if(!ok[x]) return;
		ok[x]=0; mat fl=flag[x]; flag[x]=one;
		int lc=x<<1,rc=lc|1;
		seg[lc]=seg[lc]*fl,flag[lc]=flag[lc]*fl,ok[lc]=1;
		seg[rc]=seg[rc]*fl,flag[rc]=flag[rc]*fl,ok[rc]=1;
	}
	void upd(const int x,const int l,const int r)
	{
		if(rx<l||r<lx) return;
		if(lx<=l&&r<=rx) { ok[x]=1,flag[x]=flag[x]*c,seg[x]=seg[x]*c; return; }
		pushdown(x);
		int mid=l+r>>1,lc=x<<1,rc=lc|1;
		upd(lc,l,mid); upd(rc,mid+1,r);
		seg[x]=seg[lc]+seg[rc];
	}
	int query(const int x,const int l,const int r)
	{
		if(rx<l||r<lx) return 0;
		if(lx<=l&&r<=rx) return seg[x].a[0][0];
		pushdown(x);
		int mid=l+r>>1;
		return (query(x<<1,l,mid)+query(x<<1|1,mid+1,r))%mod;
	}
}seg;

int n,m;
int a[maxn];

int main()
{
	//freopen("tmp.in","r",stdin);
	//freopen("tmp.out","w",stdout);
	
	one.a[0][0]=one.a[1][1]=1;
	trans.a[0][0]=trans.a[0][1]=1;
	trans.a[1][0]=1;
	
	scanf("%d%d",&n,&m);
	for(int i=1;i<=n;i++) 
	{
		scanf("%d",&a[i]);
		M[i]=one*PW(a[i]-1);
	}seg.build(1,1,n);
	while(m--)
	{
		int tcase; scanf("%d%d%d",&tcase,&seg.lx,&seg.rx);
		if(tcase==1)
		{
			int x; scanf("%d",&x);
			seg.c=PW(x);
			seg.upd(1,1,n);
		}
		else printf("%d\n",seg.query(1,1,n));
	}
	
	return 0;
}
