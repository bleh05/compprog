
// Problem: A. Review Site
// Contest: Codeforces - Educational Codeforces Round 107 (Rated for Div. 2)
// URL: https://codeforces.com/contest/1511/problem/0
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n;
  cin >> n;
  while (n--) {
    int t, k = 0;
    cin >> t;
    while (t--) {
      int d;
      cin >> d;
      if (d == 1 || d == 3) k++;
    }
    cout << k << endl;
  }
}