
// Problem : I. Dating
// Contest : Codeforces - Bubble Cup X - Finals [Online Mirror]
// URL : https://codeforces.com/contest/852/problem/I
// Memory Limit : 64 MB
// Time Limit : 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)
#include <bits/stdc++.h>
using namespace std;
const int mxn = 1e5 + 4;
int n;
int in[mxn];
int out[mxn];
int ett[mxn*2];
int up[mxn][20];
int clr[mxn];
int wgt[mxn];
int block_size;

int freq[mxn];
vector<int> adjl[mxn];
int timer = 0;

void dfs(int n, int p) {
	in[n] = ++timer;
	ett[timer] = n; 
	up[n][0] = p;
	for(int i = 1; i < 20; i++) {
		up[n][i] = up[up[n][i-1]][i-1];
	}
	
	for(int x : adjl[n]) {
		if(x == p) continue;
		dfs(x, n);
	}
	out[n] = ++timer;
	ett[timer] = n;
}

bool isA(int x, int y) {
	return in[x] <= in[y] && out[x] >= out[y];
}

int lca(int u, int v) {
	if(isA(u, v)) 
		return u;
	if(isA(v, u))
		return v;
	for(int i = 19; i >= 0; i--) {
		if(!isA(up[u][i], v)) 
			u = up[u][i];
	}
	return up[u][0];
}

struct query{
	int l, r, p, o;
};
inline bool cmp(query &x, query &y) {
  int X = x.l / block_size;
  int Y = y.l / block_size;
  if (X != Y) {
    return X < Y;
  }
  return x.r < y.r;
}
 
int track[mxn * 3];
int main() {
	cin >> n;
	for(int i = 0; i < n; i++) {
		cin >> clr[i+1];
		clr[i+1] = clr[i+1] * 2 - 1;
	}
	set<int> cmpr = {};
	for(int i = 0; i < n; i++) {
		cin >> wgt[i+1];
		cmpr.insert(wgt[i+1]);
	}
	map<int, int> yeb = {};
	int c = 1;
	for(int x : cmpr) {
		yeb[x] = c++;
	}
	for(int i = 1; i <= n; i++) {
		wgt[i] = yeb[wgt[i]];
	}
	for(int i = 0; i < n - 1; i++) {
		int a, b;
		cin >> a >> b;
		adjl[a].push_back(b);
		adjl[b].push_back(a);
	}
	int q;
	cin >> q;
	dfs(1, 1);
	block_size = sqrt(timer);
	vector<query> qs;
	for(int i = 0; i < q; i++) {
		int l; int r; int o = -1;
		cin >> l >> r;
		if(in[l] > in[r]) {
			swap(l, r);
		}
		if(lca(l, r) == l) {
			l = in[l];
			r = in[r];
		}
		else {
			o = lca(l, r);
			l = out[l];
			r = in[r];
		}
		query q = {l, r, i, o};
		qs.push_back(q);
	}
	long long ans[q];
	sort(qs.begin(), qs.end(), cmp);
    int cur_l = 1;
    int cur_r = 0;
    long long ansd = 0;
    for (query q : qs) {
        while (cur_l > q.l) {
            cur_l--;
            if(!freq[ett[cur_l]]) {
            	track[clr[ett[cur_l]] * wgt[ett[cur_l]] + 150000]++;
            	ansd += track[-clr[ett[cur_l]] * wgt[ett[cur_l]] + 150000];
            	freq[ett[cur_l]] = 1;
            }
            else {
            	track[clr[ett[cur_l]] * wgt[ett[cur_l]] + 150000]--;
            	ansd -= track[-clr[ett[cur_l]] * wgt[ett[cur_l]] + 150000];
            	freq[ett[cur_l]] = 0;
            }
        }
        while (cur_r < q.r) {
            cur_r++;
            if(!freq[ett[cur_r]]) {
            	track[clr[ett[cur_r]] * wgt[ett[cur_r]] + 150000]++;
            	ansd += track[-clr[ett[cur_r]] * wgt[ett[cur_r]] + 150000];
            	freq[ett[cur_r]] = 1;
            }
            else {
            	track[clr[ett[cur_r]] * wgt[ett[cur_r]] + 150000]--;
            	ansd -= track[-clr[ett[cur_r]] * wgt[ett[cur_r]] + 150000];
            	freq[ett[cur_r]] = 0;
            }
        }
        while (cur_l < q.l) {
            if(!freq[ett[cur_l]]) {
            	track[clr[ett[cur_l]] * wgt[ett[cur_l]] + 150000]++;
            	ansd += track[-clr[ett[cur_l]] * wgt[ett[cur_l]] + 150000];
            	freq[ett[cur_l]] = 1;
            }
            else {
            	track[clr[ett[cur_l]] * wgt[ett[cur_l]] + 150000]--;
            	ansd -= track[-clr[ett[cur_l]] * wgt[ett[cur_l]] + 150000];
            	freq[ett[cur_l]] = 0;
            }
            cur_l++;
        }
        while (cur_r > q.r) {
            if(!freq[ett[cur_r]]) {
            	track[clr[ett[cur_r]] * wgt[ett[cur_r]] + 150000]++;
            	ansd += track[-clr[ett[cur_r]] * wgt[ett[cur_r]] + 150000];
            	freq[ett[cur_r]] = 1;
            }
            else {
            	track[clr[ett[cur_r]] * wgt[ett[cur_r]] + 150000]--;
            	ansd -= track[-clr[ett[cur_r]] * wgt[ett[cur_r]] + 150000];
            	freq[ett[cur_r]] = 0;
            }
            cur_r--;
        }
        if(q.o != -1) {
        	ansd += track[-clr[q.o] * wgt[q.o] + 150000];
        }
        ans[q.p] = ansd;
        if(q.o != -1) {
        	ansd -= track[-clr[q.o] * wgt[q.o] + 150000];
        }
    }
    for(long long x : ans) {
    	cout << x << endl;
    }
}