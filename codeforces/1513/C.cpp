
// Problem: C. Add One
// Contest: Codeforces - Divide by Zero 2021 and Codeforces Round #714 (Div. 2)
// URL: https://codeforces.com/contest/1513/problem/C
// Memory Limit: 256 MB
// Time Limit: 1000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int mod = 1000000007;
  int dp[10][200001];
  dp[0][0] = dp[1][0] = dp[2][0] = dp[3][0] = dp[4][0] = dp[5][0] = dp[6][0] =
      dp[7][0] = dp[8][0] = dp[9][0] = 1;
  for (int i = 1; i < 200001; i++) {
    for (int j = 0; j < 10; j++) {
      if (j != 9)
        dp[j][i] = dp[j + 1][i - 1];
      else
        dp[j][i] = (dp[0][i - 1] + dp[1][i - 1]) % mod;
    }
  }
  int t;
  cin >> t;
  while (t--) {
    string str;
    int it;
    cin >> str >> it;
    int cnt = 0;
    for (char c : str) {
      cnt += dp[c - '0'][it];
      cnt %= mod;
    }
    cout << cnt << endl;
  }
}