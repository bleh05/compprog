
// Problem: D - Number of Multisets
// Contest: AtCoder - AtCoder Regular Contest 107
// URL: https://atcoder.jp/contests/arc107/tasks/arc107_d
// Memory Limit: 1024 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int mod = 998244353;
int n, k;
ll dp[3002][3002];
ll solve(int x, int y) {
  if (x == 0 ^ y == 0 || x < y) return 0;
  if (dp[x][y]) return dp[x][y];
  dp[x][y] = (solve(x - 1, y - 1) + solve(x, y * 2)) % mod;
  return dp[x][y];
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, k;
  cin >> n >> k;
  dp[1][1] = 1;
  dp[0][0] = 1;
  cout << solve(n, k);
}