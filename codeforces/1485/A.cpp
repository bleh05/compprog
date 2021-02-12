
// Problem: A. Add and Divide
// Contest: Codeforces - Codeforces Round #701 (Div. 2)
// URL: https://codeforces.com/contest/1485/problem/0
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
    ll a, b;
    cin >> a >> b;
    ll mn = 100000000;
    for (int i = b; i <= b + 5; i++) {
      if (i == 1) continue;
      ll c = i - b + 1;
      ll k = i;
      while (k <= a) k *= i, c++;
      mn = min(c, mn);
    }
    cout << mn << "\n";
  }
}