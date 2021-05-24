
// Problem: B. Kavi on Pairing Duty
// Contest: Codeforces - Codeforces Round #722 (Div. 1)
// URL: https://codeforces.com/contest/1528/problem/B
// Memory Limit: 256 MB
// Time Limit: 1000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n;
  cin >> n;
  int dp[n + 1];
  memset(dp, 0, sizeof dp);
  dp[1] = 1;
  int mod = 998244353;
  ll sum = 1;
  int nfac[n + 1];
  memset(nfac, 0, sizeof nfac);
  for (int i = 1; i <= n; i++) {
    for (int j = i; j <= n; j += i) {
      nfac[j]++;
    }
  }
  for (int i = 2; i <= n; i++) {
    int d = nfac[i];
    ;
    dp[i] = (sum + d) % mod;
    sum += dp[i];
    sum %= mod;
  }
  cout << dp[n] << endl;
}