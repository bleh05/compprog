
// Problem: A - Divide a Cuboid
// Contest: AtCoder - AtCoder Grand Contest 004
// URL: https://atcoder.jp/contests/agc004/tasks/agc004_a
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int a, b, c;
  cin >> a >> b >> c;
  if ((a & 1) == 0 || (b & 1) == 0 || (c & 1) == 0) {
    cout << 0 << endl;
  } else {
    ll cr[3];
    cr[0] = a;
    cr[1] = b;
    cr[2] = c;
    sort(cr, cr + 3);
    cout << cr[0] * cr[1] << endl;
  }
}