
// Problem: C. Minimum Grid Path
// Contest: Codeforces - Educational Codeforces Round 106 (Rated for Div. 2)
// URL: https://codeforces.com/contest/1499/problem/C
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
    int n;
    cin >> n;
    ll costs[n];
    for (int i = 0; i < n; i++) cin >> costs[i];
    int leftUp = n;
    int leftDown = n;
    ll minc = 2e18;
    ll minUp = 1000000000ll;
    ll minDown = 1000000000ll;
    ll totc = 0;
    for (int i = 0; i < n; i++) {
      if (i & 1) {
        leftUp--;
        totc += costs[i];
        minUp = min(costs[i], minUp);
        minc = min(minc, totc + minUp * leftUp + minDown * leftDown);
      } else {
        leftDown--;
        totc += costs[i];
        minDown = min(costs[i], minDown);
        minc = min(minc, totc + minUp * leftUp + minDown * leftDown);
      }
    }
    cout << minc << endl;
  }
}