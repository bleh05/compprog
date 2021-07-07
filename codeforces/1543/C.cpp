
// Problem: C. Need for Pink Slips
// Contest: Codeforces - Codeforces Round #730 (Div. 2)
// URL: https://codeforces.com/contest/1543/problem/C
// Memory Limit: 256 MB
// Time Limit: 1000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef long double ld;
ld v;
ld total = 0;
ld ok = 0;
void rec(ld a, ld b, ld c, ld prob, int nums) {
  if (a < 0.000000001) a = 0;
  if (b < 0.000000001) b = 0;
  if (a == 0)
    ;
  else if (a <= v) {
    if (b == 0) {
      rec(0, 0, c + a, prob * a, nums + 1);
    } else {
      rec(0, b + a / 2, c + a / 2, prob * a, nums + 1);
    }
  } else {
    if (b == 0) {
      rec(a - v, 0, c + v, prob * a, nums + 1);
    } else {
      rec(a - v, b + v / 2, c + v / 2, prob * a, nums + 1);
    }
  }
  if (b == 0)
    ;
  else if (b <= v) {
    if (a == 0) {
      rec(0, 0, c + b, prob * b, nums + 1);
    } else {
      rec(a + b / 2, 0, c + b / 2, prob * b, nums + 1);
    }
  } else {
    if (a == 0) {
      rec(0, b - v, c + v, prob * b, nums + 1);
    } else {
      rec(a + v / 2, b - v, c + v / 2, prob * b, nums + 1);
    }
  }
  total += nums * c * prob;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    total = 0;
    ok = 0;
    ld a, b, c, d;
    cin >> a >> b >> c >> d;
    v = d;
    rec(a, b, c, 1, 1);
    cout << setprecision(10) << total << endl;
  }
}