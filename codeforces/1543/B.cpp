
// Problem: B. Customising the Track
// Contest: Codeforces - Codeforces Round #730 (Div. 2)
// URL: https://codeforces.com/contest/1543/problem/B
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
    int n;
    cin >> n;
    ll sum = 0;
    for (int i = 0; i < n; i++) {
      int k;
      cin >> k;
      sum += k;
    }
    sum %= n;
    cout << sum * (n - sum) << endl;
  }
}