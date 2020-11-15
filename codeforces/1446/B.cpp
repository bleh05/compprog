
// Problem: B. Catching Cheaters
// Contest: Codeforces - Codeforces Round #683 (Div. 1, by Meet IT)
// URL: https://codeforces.com/contest/1446/problem/B
// Memory Limit: 256 MB
// Time Limit: 1000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, m;
  cin >> n >> m;
  string strn, strm;
  cin >> strn >> strm;
  int dp[n + 1][m + 1];
  memset(dp, 0, sizeof(dp));
  int ans = 0;
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= m; j++) {
      if (strn[i - 1] != strm[j - 1])
        dp[i][j] = max(-2, dp[i - 1][j - 1] - 2);
      else {
        dp[i][j] = max(2, dp[i - 1][j - 1] + 2);
        ans = max(dp[i][j], ans);
      }
      dp[i][j] = max(dp[i - 1][j] - 1, dp[i][j]);
      dp[i][j] = max(dp[i][j - 1] - 1, dp[i][j]);
    }
    cout << endl;
  }
  cout << ans << endl;
}