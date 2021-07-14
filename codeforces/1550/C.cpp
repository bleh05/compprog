// Problem: C. Manhattan Subarrays
// Contest: Codeforces - Educational Codeforces Round 111 (Rated for Div. 2)
// URL: https://codeforces.com/contest/1550/problem/C
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)
 
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int chk(int a, int b, int c) {
  if (abs(c - b) + abs(b - a) == abs(c - a))
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
      if (chk(arr[i], arr[i + 1], arr[i + 2])) {
        ans++;
      }
    }
    for (int i = 0; i < n - 3; i++) {
      if (chk(arr[i], arr[i + 1], arr[i + 2]) &&
          chk(arr[i], arr[i + 1], arr[i + 3]) &&
          chk(arr[i + 1], arr[i + 2], arr[i + 3]) &&
          chk(arr[i], arr[i + 2], arr[i + 3])) {
        ans++;
      }
    }
    cout << ans << "\n";
  }
}