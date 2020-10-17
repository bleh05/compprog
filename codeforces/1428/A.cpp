
// Problem: A. Box is Pull
// Contest: Codeforces - Codeforces Raif Round 1 (Div. 1 + Div. 2)
// URL: https://codeforces.com/contest/1428/problem/0
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
  while (t-- > 0) {
    int x1, y1, x2, y2;
    cin >> x1 >> y1 >> x2 >> y2;
    int sum = 0;
    if (x1 != x2) {
      sum += abs(x1 - x2);
    }
    if (y1 != y2) {
      sum += abs(y1 - y2);
    }
    if (x1 != x2 && y1 != y2) sum += 2;
    cout << sum << endl;
  }
}