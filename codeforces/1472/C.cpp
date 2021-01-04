
// Problem: C. Long Jumps
// Contest: Codeforces - Codeforces Round #693 (Div. 3)
// URL: https://codeforces.com/contest/1472/problem/C
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    int n;
    cin >> n;
    int arr[n];
    for (int i = 0; i < n; i++) {
      cin >> arr[i];
    }
    int currsum = 1;
    int dp[n];
    int ans = 0;
    for (int i = n - 1; i >= 0; i--) {
      if (i + arr[i] >= n)
        dp[i] = arr[i];
      else
        dp[i] = arr[i] + dp[i + arr[i]];
      ans = max(dp[i], ans);
    }
    cout << ans << endl;
  }
}