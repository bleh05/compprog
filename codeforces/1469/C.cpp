
// Problem: C. Building a Fence
// Contest: Codeforces - Educational Codeforces Round 101 (Rated for Div. 2)
// URL: https://codeforces.com/contest/1469/problem/C
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
    int arr[n];
    bool ok = true;
    for (int i = 0; i < n; i++) cin >> arr[i];
    int l = arr[0];
    int r = arr[0];
    for (int i = 1; i < n; i++) {
      l = max(l - m + 1, arr[i]);
      r = min(r + m - 1, arr[i] + m - 1);
      if (l > r) {
        cout << "NO\n";
        ok = false;
        break;
      }
    }
    if (ok) {
      if (l == arr[n - 1])
        cout << "YES\n";
      else {
        cout << "NO\n";
      }
    }
  }
}