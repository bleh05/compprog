
// Problem: C - Duodecim Ferra
// Contest: AtCoder - AtCoder Beginner Contest 185
// URL: https://atcoder.jp/contests/abc185/tasks/abc185_c
// Memory Limit: 1024 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
ll dp[202][13];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n;
  cin >> n;
  dp[0][0] = 1;
  for (int i = 1; i <= n; i++) {
    for (int j = 0; j < min(i, 12); j++) {
      dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
    }
  }
  cout << dp[n][11] << endl;
}