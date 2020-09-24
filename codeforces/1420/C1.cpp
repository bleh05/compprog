
// Problem : C1. Pokémon Army (easy version)
// Contest : Codeforces - Codeforces Round #672 (Div. 2)
// URL : https://codeforces.com/contest/1420/problem/C1
// Memory Limit : 256 MB
// Time Limit : 2000 ms
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
		int n;
		cin >> n;
		int q; cin >> q;
		int arr[n];
		ll dp[n][2];
		for(int i = 0; i < n; i++) {
			cin >> arr[i];
		}
		dp[0][0] = arr[0];
		dp[0][1] = 1ll << 63;
		for(int i = 1; i < n; i++) {
			dp[i][0] = max(dp[i-1][0], max(dp[i-1][1], 0ll) + arr[i]);
			dp[i][1] = max(dp[i-1][1], dp[i-1][0] - arr[i]);
		}
		cout << dp[n-1][0] << endl;
	}
}