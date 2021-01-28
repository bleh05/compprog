
// Problem: C. Mahmoud and a Message
// Contest: Codeforces - Codeforces Round #396 (Div. 2)
// URL: https://codeforces.com/contest/766/problem/C
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int mod = 1e9 + 7;
int dp[1002][1002][27];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n;
  cin >> n;
  string str;
  cin >> str;
  int arr[27];
  for (int i = 0; i < 26; i++) {
    cin >> arr[i];
  }
  arr[26] = 10000;
  int maxsub = 0;
  dp[0][0][26] = 1;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j <= i; j++) {
      for (int k = 0; k < 27; k++) {
        if (j + 1 <= arr[k] && j + 1 <= arr[str[i] - 'a'] && dp[i][j][k]) {
          if (arr[str[i] - 'a'] < arr[k]) {
            dp[i + 1][j + 1][str[i] - 'a'] += dp[i][j][k];
            dp[i + 1][j + 1][str[i] - 'a'] %= mod;
          } else {
            dp[i + 1][j + 1][k] += dp[i][j][k];
            dp[i + 1][j + 1][k] %= mod;
          }
          maxsub = max(j + 1, maxsub);
        }
        dp[i + 1][1][str[i] - 'a'] += dp[i][j][k];
        dp[i + 1][1][str[i] - 'a'] %= mod;
      }
    }
  }
  int mcover = 1;
  int csub = 0;
  int currmin = 10000;
  for (int i = 0; i < n; i++) {
    csub++;
    currmin = min(currmin, arr[str[i] - 'a']);
    if (currmin < csub) currmin = arr[str[i] - 'a'], csub = 1, mcover++;
  }
  ll sum = 0;
  for (int i = 0; i <= 1000; i++) {
    for (int j = 0; j < 26; j++) {
      sum += dp[n][i][j];
      sum %= mod;
    }
  }
  cout << sum * 500000004 % mod << "\n" << maxsub << "\n" << mcover << "\n";
}