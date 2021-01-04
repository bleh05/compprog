
// Problem: A. Cards for Friends
// Contest: Codeforces - Codeforces Round #693 (Div. 3)
// URL: https://codeforces.com/contest/1472/problem/A
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
    int w, h, c;
    cin >> w >> h >> c;
    int d = w * h;
    int r = 1;
    while (d % 2 == 0) {
      r *= 2;
      d /= 2;
    }
    if (r >= c)
      cout << "YES" << endl;
    else
      cout << "NO" << endl;
  }
}