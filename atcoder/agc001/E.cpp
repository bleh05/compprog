#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int mn = 4010, mod = 1e9 + 7;
ll dp[mn][mn];
ll fact[mn * 2];
ll inv[mn * 2];
ll ncr(int a, int b) {
  if (a == b) return 1;
  if (b == 0) return 1;
  if (a < b) return 0;
  ll prod = fact[a];
  prod *= inv[b];
  prod %= mod;
  prod *= inv[a - b];
  prod %= mod;
  return prod;
}
ll bpow(ll a, ll b) {
  ll prod = 1;
  while (b) {
    if (b & 1) prod = prod * a % mod;
    a = a * a % mod;
    b >>= 1;
  }
  return prod;
}

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n;
  cin >> n;
  int pts[n][2];
  fact[0] = 1;
  inv[0] = 1;
  for (int i = 1; i < mn * 2; i++) {
    fact[i] = fact[i - 1] * i % mod;
    inv[i] = bpow(fact[i], mod - 2);
  }
  for (int i = 0; i < n; i++) {
    int x, y;
    cin >> x >> y;
    dp[-x + 2003][-y + 2003]++;
    pts[i][0] = x;
    pts[i][1] = y;
  }
  for (int i = 0; i < 4007; i++) {
    for (int j = 0; j < 4007; j++) {
      dp[i][j] %= mod;
      dp[i + 1][j] += dp[i][j];
      dp[i][j + 1] += dp[i][j];
    }
  }
  ll ans = 0;
  for (int i = 0; i < n; i++) {
    ans += dp[pts[i][0] + 2003][pts[i][1] + 2003];
    ans -= ncr(2 * (pts[i][0] + pts[i][1]), 2 * pts[i][0]);
    ans %= mod;
    ans += mod;
    ans %= mod;
  }
  cout << ans * inv[2] % mod << endl;
}