
// Problem: B. GCD Length
// Contest: Codeforces - Educational Codeforces Round 107 (Rated for Div. 2)
// URL: https://codeforces.com/contest/1511/problem/B
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
    int a, b, c;
    cin >> a >> b >> c;
    int d = 1;
    for (int f = 1; f < c; f++) d *= 10;
    int e = 3;
    for (; int(log(e) / log(10)) < a - c;) {
      e *= 3;
    }
    int f = 7;
    for (; int(log(f) / log(10)) < b - c;) {
      f *= 7;
    }
    cout << e * d << " " << f * d << endl;
  }
}