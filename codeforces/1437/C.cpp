
// Problem: C. Chef Monocarp
// Contest: Codeforces - Educational Codeforces Round 97 (Rated for Div. 2)
// URL: https://codeforces.com/contest/1437/problem/C
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int q;
  cin >> q;
  while (q--) {
    int n;
    cin >> n;
    int arr[n];
    for (int i = 0; i < n; i++) {
      cin >> arr[i];
    }
    sort(arr, arr + n);
    int dp[n * 2][n + 1];
    memset(dp, 0x3f, sizeof dp);
    int minans = 1 << 31 - 1;
    for (int i = 0; i < n * 2; i++) {
      dp[i][0] = 0;
      for (int j = 1; j <= min(i, n); j++) {
        int mind = 1 << 31 - 1;
        for (int k = 0; k < i; k++) {
          mind = min(dp[k][j - 1], mind);
        }
        dp[i][j] = mind + abs(arr[j - 1] - i);
        if (j == n) {
          minans = min(minans, dp[i][j]);
        }
      }
    }
    cout << minans << endl;
  }
}