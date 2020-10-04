
// Problem: A. Fence
// Contest: Codeforces - Codeforces Round #675 (Div. 2)
// URL: https://codeforces.com/contest/1422/problem/0
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
    ll a, b, c;
    cin >> a >> b >> c;
    cout << a + b + c - 1 << endl;
  }
}