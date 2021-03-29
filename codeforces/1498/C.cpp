
// Problem: C. Planar Reflections
// Contest: Codeforces - CodeCraft-21 and Codeforces Round #711 (Div. 2)
// URL: https://codeforces.com/contest/1498/problem/C
// Memory Limit: 256 MB
// Time Limit: 1000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int dp[1001][1001][2];
int mod = 1000000007;
int f(int a, int b, int maxa, int d) {
  if (a > maxa) return 1;
  if (b == 1) return 1;
  if (a == 0) return 1;
  if (dp[a][b][d]) return dp[a][b][d];
  if (d == 1)
    return dp[a][b][d] =
               (f(a + 1, b, maxa, d) + f(a - 1, b - 1, maxa, d ^ 1)) % mod;
  else {
    return dp[a][b][d] =
               (f(a + 1, b - 1, maxa, d ^ 1) + f(a - 1, b, maxa, d)) % mod;
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    memset(dp, 0, sizeof dp);
    int a, b;
    cin >> a >> b;
    cout << f(a, b, a, 0) << endl;
  }
}