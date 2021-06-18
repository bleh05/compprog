
// Problem: A. Arithmetic Array
// Contest: Codeforces - Codeforces Round #726 (Div. 2)
// URL: https://codeforces.com/contest/1537/problem/0
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
    int d = 0;
    for (int i = 0; i < n; i++) {
      int k;
      cin >> k;
      d += k;
    }
    if (d < n)
      cout << 1 << endl;
    else
      cout << d - n << endl;
  }
}