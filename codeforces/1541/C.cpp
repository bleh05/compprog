
// Problem: C. Great Graphs
// Contest: Codeforces - Codeforces Round #728 (Div. 2)
// URL: https://codeforces.com/contest/1541/problem/C
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
    sort(arr, arr + n);
    ll sumcnt = 0;
    ll ans = 0;
    for (int i = 1; i < n; i++) {
      ans += arr[i] - arr[i - 1];
      ans -= 1ll * arr[i] * i - sumcnt;
      sumcnt += arr[i];
    }
    cout << ans << endl;
  }
}