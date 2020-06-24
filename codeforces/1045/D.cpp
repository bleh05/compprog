#include <bits/stdc++.h>
using namespace std;
const int N = 500001;
int n;
int father[N];
double p[N];
double sum_child[N];
struct edge{
	int to,nxt;
}tree[N << 1];
int head[N],cnt = 0;
void addedge(int u,int v){
	edge node = {v,head[u]};
	tree[head[u] = ++cnt] = node;
}
void dfs(int u,int fa){
	father[u] = fa;
	for(int i=head[u];i;i = tree[i].nxt){
		int v = tree[i].to;
		if(v != fa)dfs(v,u);
	}
}
double ans1 = 0.0,ans2 = 0.0;
void change(int u,double prob){
	if(u)sum_child[father[u]] += prob - p[u];
	ans1 += prob - p[u];
	ans2 += (prob - p[u]) * sum_child[u];
	if(u)ans2 += (prob - p[u]) * p[father[u]];
	p[u] = prob;
}
int main(){
	scanf("%d",&n);
	for(int i=0;i < n;i++)head[i] = 0;
	for(int i=0;i < n;i++)scanf("%lf",&p[i]);
	for(int i=1;i < n;i++){
		int u,v;
		scanf("%d%d",&u,&v);
		addedge(u,v),addedge(v,u);
	}
	dfs(0,-1);
	for(int i=0;i < n;i++)p[i] = 1.0 - p[i],ans1 += p[i];
	for(int i=1;i < n;i++)ans2 += p[i] * p[father[i]];
	for(int i=0;i < n;i++){
		for(int j=head[i];j;j = tree[j].nxt){
			int k = tree[j].to;
			if(k != father[i])sum_child[i] += p[k];
		}
	}
	int q;
	scanf("%d",&q);
	for(int i=1;i <= q;i++){
		int u;
		double p;
		scanf("%d%lf",&u,&p);
		change(u,1.0 - p);
		printf("%lf\n",ans1 - ans2);
	}
	return 0;
}