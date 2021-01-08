#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

ll dp[5002][5002];
ll dp2[5002][5002];
const int mod = 1e9 + 7;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, k, q;
  cin >> n >> k >> q;
  for (int i = 1; i <= n; i++) dp[0][i] = 1;
  for (int i = 1; i <= k; i++) {
    for (int j = 1; j <= n; j++) {
      dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
      if (dp[i][j] >= mod) dp[i][j] -= mod;
    }
  }
  ll tt[n + 3];
  memset(tt, 0, sizeof tt);
  for (int i = 1; i <= n; i++) {
    for (int j = 0; j <= k; j++) {
      tt[i] = (tt[i] + dp[k - j][i] * dp[j][i]) % mod;
    }
  }
  int sm = 0;
  int arr[n];
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
    sm = (sm + tt[i + 1] * arr[i]) % mod;
  }
  for (int i = 0; i < q; i++) {
    int ind;
    cin >> ind;
    int nval = 0;
    cin >> nval;
    sm = (sm + (nval - arr[ind - 1]) * tt[ind]) % mod;
    if (sm < 0) sm += mod;
    arr[ind - 1] = nval;
    cout << sm << "\n";
  }
}