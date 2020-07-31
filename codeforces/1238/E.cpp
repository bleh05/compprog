#include<bits/stdc++.h>
using namespace std;
 
const int M = 20;
int n, m, sum[1 << M][M];
long long dp[1 << M];
string s;
 
int main() {
	cin >> n >> m >> s;
	for (int i = 1; i < n; i++)
		if (s[i] ^ s[i - 1]) {
			sum[1 << s[i - 1] - 'a'][s[i] - 'a']++;
			sum[1 << s[i] - 'a'][s[i - 1] - 'a']++;
		}
	memset(dp, 63, sizeof dp), dp[0] = 0;
	for (int i = 1; i < 1 << m; i++)
		for (int j = 0; j < m; j++)
			sum[i][j] = sum[i ^ i & -i][j] + sum[i & -i][j];
	for (int i = 1; i < 1 << m; i++)
		for (int j = 0; j < m; j++)
			if (i >> j & 1) {
				long long cost = dp[i ^ 1 << j];
				for (int p = 0; p < m; p++)
					cost += i >> p & 1? sum[(1 << m) - 1 ^ i][p]: 0;
				dp[i] = min(dp[i], cost);
			}
	cout << dp[(1 << m) - 1];
}