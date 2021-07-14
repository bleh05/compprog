
// Problem: C. Manhattan Subarrays
// Contest: Codeforces - Educational Codeforces Round 111 (Rated for Div. 2)
// URL: https://codeforces.com/contest/1550/problem/C
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int chk(int a, int b, int c, int d) {
  if (abs(c - b) + abs(b - a) + d == abs(c - a))
    return 0;
  else
    return 1;
}
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
    ll ans = n + n - 1;
    for (int i = 0; i < n - 2; i++) {
      bool good = true;
      for (int j = 0; j < 3; j++) {
        for (int k = 0; k < 3; k++) {
          if (k == j) continue;
          for (int l = 0; l < 3; l++) {
            if (l == k || l == j) continue;
            if (chk(arr[i + j], arr[i + k], arr[i + l],
                    abs(abs(l - j) - (abs(l - k) + abs(k - j)))) == 0) {
              good = false;
            }
          }
        }
      }
      if (good) ans++;
    }
    for (int i = 0; i < n - 3; i++) {
      bool good = true;
      for (int j = 0; j < 4; j++) {
        for (int k = 0; k < 4; k++) {
          if (k == j) continue;
          for (int l = 0; l < 4; l++) {
            if (l == k || l == j) continue;
            if (chk(arr[i + j], arr[i + k], arr[i + l],
                    abs(abs(l - j) - (abs(l - k) + abs(k - j)))) == 0)
              good = false;
          }
        }
      }
      if (good) ans++;
    }
    cout << ans << "\n";
  }
}