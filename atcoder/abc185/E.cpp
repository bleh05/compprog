
// Problem: E - Sequence Matching
// Contest: AtCoder - AtCoder Beginner Contest 185
// URL: https://atcoder.jp/contests/abc185/tasks/abc185_e
// Memory Limit: 1024 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int dp[1002][1002];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, m;
  cin >> n >> m;
  int arr1[n];
  int arr2[m];
  for (int i = 0; i < n; i++) {
    cin >> arr1[i];
  }
  for (int i = 0; i < m; i++) {
    cin >> arr2[i];
  }
  memset(dp, 0x3f, sizeof dp);
  dp[0][0] = 0;
  for (int i = 0; i < 1002; i++) {
    dp[i][0] = dp[0][i] = i;
  }
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= m; j++) {
      if (i && j) {
        dp[i][j] =
            min(dp[i][j], dp[i - 1][j - 1] + (arr1[i - 1] != arr2[j - 1]));
      }
      if (i) {
        dp[i][j] = min(dp[i][j], dp[i - 1][j] + 1);
      }
      if (j) {
        dp[i][j] = min(dp[i][j], dp[i][j - 1] + 1);
      }
    }
  }
  cout << dp[n][m] << endl;
}