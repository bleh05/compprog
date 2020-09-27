
// Problem : A. k-Amazing Numbers
// Contest : Codeforces - Codeforces Round #673 (Div. 1)
// URL : https://codeforces.com/contest/1416/problem/0
// Memory Limit : 256 MB
// Time Limit : 1000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
	int t;
	cin >> t;
	while(t-- > 0) {
		int n; cin >> n;
		vector<int> intv[n+1];
		for(int i = 0; i <= n; i++) {
			intv[i].push_back(-1);
		}
		for(int i = 0; i < n; i++) {
			int c;
			cin >> c;
			intv[c].push_back(i);
		}
		for(int i = 0; i <= n; i++) {
			intv[i].push_back(n);
		}
		int ans[n + 1];
		for(int i = 0; i <= n; i++) {
			ans[i] = 1<<30;
		}
		for(int i = 1; i <= n; i++) {
			int maxd = intv[i][1] - intv[i][0];
			for(int j = 1; j < (int)intv[i].size() - 1; j++) {
				maxd = max(intv[i][j+1] - intv[i][j], maxd);
			}
			ans[maxd] = min(ans[maxd], i);
		}
		int ansd = ans[1];
		for(int i = 1; i <= n; i++) {
			ansd = min(ansd, ans[i]);
			if(ansd == 1<<30) cout << -1 << " ";
			else cout << ansd << " ";
		}
		cout << endl;
	}
}