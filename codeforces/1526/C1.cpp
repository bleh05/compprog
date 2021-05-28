
// Problem: C1. Potions (Easy Version)
// Contest: Codeforces - Codeforces Round #723 (Div. 2)
// URL: https://codeforces.com/contest/1526/problem/C1
// Memory Limit: 256 MB
// Time Limit: 1000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  map<int, int> pairs;

  int n;
  cin >> n;
  int arr[n];
  for (int i = 0; i < n; i++) cin >> arr[i];
  ll dp[n + 1][n + 1];
  int can[n + 1][n + 1];
  memset(can, 0, sizeof can);
  can[0][0] = 1;
  for (int i = 0; i <= n; i++) can[i][0] = 1;
  int ans = 0;
  memset(dp, 0, sizeof dp);
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= i; j++) {
      if (dp[i - 1][j - 1] + arr[i - 1] >= 0 && can[i - 1][j - 1]) {
        can[i][j] = 1;
        dp[i][j] = max(dp[i][j], dp[i - 1][j - 1] + arr[i - 1]);
        ans = max(ans, j);
      }
      if (can[i - 1][j] && !can[i][j]) {
        can[i][j] = 1;
        dp[i][j] = dp[i - 1][j];
      }
      dp[i][j] = max(dp[i - 1][j], dp[i][j]);
    }
  }
  cout << ans << endl;
}