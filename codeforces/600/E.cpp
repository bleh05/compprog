
// Problem : E. Lomsat gelral
// Contest : Codeforces - Educational Codeforces Round 2
// URL : https://codeforces.com/contest/600/problem/E
// Memory Limit : 256 MB
// Time Limit : 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

const int mxn = 1e5 + 5;
map<int, int> maps[mxn];
vector<int> adjl[mxn];
ll ans[mxn];
int clr[mxn];
int mapd[mxn];
int acd[mxn];
ll sums[mxn];
int n;

void merge(int a,int b) {
	if(maps[mapd[a]].size() < maps[mapd[b]].size()) {
		swap(mapd[a], mapd[b]);
	}
	int c = mapd[a];
	for(auto it = maps[mapd[b]].begin(); it != maps[mapd[b]].end(); it++) {
		int val = it->first;
		int frq = it->second;
		maps[c][val] += frq;
		if(maps[c][val] > acd[c]) {
			acd[c] = maps[c][val];
			sums[c] = val;
		}
		else if(maps[c][val] == acd[c]) {
			sums[c] += val;
		}
	}
}

void dfs(int n, int p) {
	for(int x : adjl[n]) {
		if(x == p) continue;
		dfs(x, n);
		merge(n, x);
	}
	ans[n] = sums[mapd[n]];
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
	cin >> n;
	for(int i = 1; i <= n; i++) {
		cin >> clr[i];
		maps[i][clr[i]] = 1;
		mapd[i] = i;
		acd[i] = 1;
		sums[i] = clr[i];
	}
	for(int i = 0; i < n - 1; i++) {
		int a, b;
		cin >> a >> b;
		adjl[a].push_back(b);
		adjl[b].push_back(a);
	}
	dfs(1, 0);
	for(int i = 1; i <= n; i++) {
		cout << ans[i] << " ";
	}
	cout << endl;
}