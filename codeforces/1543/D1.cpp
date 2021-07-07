
// Problem: D1. RPD and Rap Sheet (Easy Version)
// Contest: Codeforces - Codeforces Round #730 (Div. 2)
// URL: https://codeforces.com/contest/1543/problem/D1
// Memory Limit: 256 MB
// Time Limit: 5000 ms
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
    int n, b;
    cin >> n >> b;
    int cxor = 0;
    for (int i = 0; i < n; i++) {
      cout << (cxor ^ i) << endl;
      cxor ^= (cxor ^ i);
      int verd;
      cin >> verd;
      if (verd == 1) break;
    }
  }
}