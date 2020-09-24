
// Problem : C2. Pokémon Army (hard version)
// Contest : Codeforces - Codeforces Round #672 (Div. 2)
// URL : https://codeforces.com/contest/1420/problem/C2
// Memory Limit : 256 MB
// Time Limit : 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int n, q;
const int mx = 3e5 + 3;
int arr[mx];
ll segt[mx * 4][4]; // 0 = start neg end neg, 1 = start neg end pos, 2 = start pos end neg, 3 = start pos end pos
void build(int v, int tl, int tr) {
	if(tl == tr) {
		segt[v][0] = -arr[tl];
		segt[v][3] = arr[tl];
		segt[v][1] = 1ll<<63 + 3;
		segt[v][2] = 1ll<<63 + 3;
	}
	else {
		int tm = (tl + tr) >> 1;
		build(v * 2, tl, tm);
		build(v*2+1, tm + 1, tr);
		segt[v][0] = max(segt[v*2][0] + segt[v*2+1][2], segt[v*2][1] + segt[v*2+1][0]);
		segt[v][0] = max(segt[v*2][0], max(segt[v][0], segt[v*2+1][0]));
		segt[v][1] = max(segt[v*2][0] + segt[v*2+1][3], segt[v*2][1] + segt[v*2+1][1]);
		segt[v][1] = max(segt[v*2][1], max(segt[v][1], segt[v*2+1][1]));
		segt[v][2] = max(segt[v*2][2] + segt[v*2+1][2], segt[v*2][3] + segt[v*2+1][0]);
		segt[v][2] = max(segt[v*2][2], max(segt[v][2], segt[v*2+1][2]));
		segt[v][3] = max(segt[v*2][2] + segt[v*2+1][3], segt[v*2][3] + segt[v*2+1][1]);
		segt[v][3] = max(segt[v*2][3], max(segt[v][3], segt[v*2+1][3]));
	}
}
void update(int v, int tl, int tr, int ind, int val) {
	if(tl > tr || tl > ind || tr < ind) {
		return;
	}
	if(tl == tr) {
		segt[v][0] = -val;
		segt[v][3] = val;
		segt[v][1] = 1ll<<63 + 3;
		segt[v][2] = 1ll<<63 + 3;
	}
	else {
		int tm = (tl + tr) >> 1;
		update(v * 2, tl, tm, ind, val);
		update(v*2+1, tm + 1, tr, ind, val);
		segt[v][0] = max(segt[v*2][0] + segt[v*2+1][2], segt[v*2][1] + segt[v*2+1][0]);
		segt[v][0] = max(segt[v*2][0], max(segt[v][0], segt[v*2+1][0]));
		segt[v][1] = max(segt[v*2][0] + segt[v*2+1][3], segt[v*2][1] + segt[v*2+1][1]);
		segt[v][1] = max(segt[v*2][1], max(segt[v][1], segt[v*2+1][1]));
		segt[v][2] = max(segt[v*2][2] + segt[v*2+1][2], segt[v*2][3] + segt[v*2+1][0]);
		segt[v][2] = max(segt[v*2][2], max(segt[v][2], segt[v*2+1][2]));
		segt[v][3] = max(segt[v*2][2] + segt[v*2+1][3], segt[v*2][3] + segt[v*2+1][1]);
		segt[v][3] = max(segt[v*2][3], max(segt[v][3], segt[v*2+1][3]));
	}
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
	int t;
	cin >> t;
	while(t-- > 0) {
		cin >> n >> q;
		for(int i = 0; i < n; i++) cin >> arr[i];
		build(1, 0, n - 1);
		cout << segt[1][3] << "\n";
		for(int i = 0; i < q; i++) {
			int l, r;
			cin >> l >> r;
			l--; r--;
			update(1, 0, n - 1, l, arr[r]);
			update(1, 0, n - 1, r, arr[l]);
			swap(arr[r], arr[l]);
			cout << segt[1][3] << "\n";
		}
		
	}
}