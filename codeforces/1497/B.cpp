
// Problem: B. M-arrays
// Contest: Codeforces - Codeforces Round #708 (Div. 2)
// URL: https://codeforces.com/contest/1497/problem/B
// Memory Limit: 256 MB
// Time Limit: 1000 ms
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
    int arr[m];
    memset(arr, 0, sizeof arr);
    for (int i = 0; i < n; i++) {
      int d;
      cin >> d;
      arr[d % m]++;
    }
    int sum = 0;
    for (int i = 0; i <= m / 2; i++) {
      if (i == 0) {
        sum += arr[i] > 0;
      } else {
        int mx = max(arr[i], arr[m - i]);
        int mn = min(arr[i], arr[m - i]);
        if (mx) sum++;
        sum += max(0, mx - mn - 1);
      }
    }
    cout << sum << endl;
  }
}