
// Problem : D. Searchlights
// Contest : Codeforces - Grakn Forces 2020
// URL : https://codeforces.com/contest/1408/problem/D
// Memory Limit : 256 MB
// Time Limit : 1000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
	int n, m;
	cin >> n >> m;
	int rob[n][2];
	int sea[m][2];
	for(int i = 0; i < n; i++) {
		cin >> rob[i][0];
		cin >> rob[i][1];
	}
	for(int i = 0; i < m; i++) {
		cin >> sea[i][0];
		cin >> sea[i][1];
	}
	vector<vector<int>> evnts(1000002);
	multiset<int> dd = {};
	int c = -1;
	for(int i = 0; i < n; i++) {
		for(int j = 0; j < m; j++) {
			if(rob[i][0] <= sea[j][0]) {
				c++;
				dd.insert(max(sea[j][1] - rob[i][1] + 1, 0));
				evnts[sea[j][0] - rob[i][0]+1].push_back(max(sea[j][1] - rob[i][1] + 1, 0));
			}
		}
	}
	if((int)dd.size() == 0) {
		cout << 0 << endl; return 0;
	}
	int mn = *--dd.end();
	for(int i = 1; i < 1000002; i++) {
		for(int j = 0; j < (int)evnts[i].size(); j++) {
			c--;
			auto it = dd.lower_bound(evnts[i][j]);
			dd.erase(it);
		}
		if((int)dd.size() > 0) {
			mn = min(*--dd.end() + i, mn);
		}
		else mn = min(i, mn);
	}
	cout << mn << endl;
}