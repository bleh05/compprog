
// Problem: A. Shifting Stacks
// Contest: Codeforces - Codeforces Round #703 (Div. 2)
// URL: https://codeforces.com/contest/1486/problem/0
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
    ll pre = 0;
    int dr = 0;
    for (int i = 0; i < n; i++) {
      int d;
      cin >> d;
      pre += d - i;
      if (pre < 0 && dr == 0) {
        cout << "NO" << endl;
        dr = 1;
      }
      if (i == n - 1 && dr == 0) cout << "YES" << endl;
    }
  }
}