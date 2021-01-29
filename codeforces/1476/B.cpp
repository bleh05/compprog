
// Problem: B. Inflation
// Contest: Codeforces - Educational Codeforces Round 103 (Rated for Div. 2)
// URL: https://codeforces.com/contest/1476/problem/B
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
    int n, m;
    cin >> n >> m;
    ll arr[n];
    for (int i = 0; i < n; i++) {
      cin >> arr[i];
    }
    ll sum = arr[0];
    ll ans = 0;
    for (int i = 1; i < n; i++) {
      ll d = (arr[i] * 100 + m - 1) / m;
      if (d > sum) {
        ans += d - sum;
        sum = d;
      }
      sum += arr[i];
    }
    cout << ans << endl;
  }
}