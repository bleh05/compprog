
// Problem: B. Not Afraid
// Contest: Codeforces - Codeforces Round #406 (Div. 2)
// URL: https://codeforces.com/contest/787/problem/B
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, m;
  cin >> n >> m;
  for (int i = 0; i < m; i++) {
    set<int> s;
    int d;
    cin >> d;
    for (int j = 0; j < d; j++) {
      int f;
      cin >> f;
      s.insert(f);
    }
    bool ok = false;
    for (int x : s) {
      if (s.count(-x)) {
        ok = true;
      }
    }
    if (!ok) {
      cout << "YES" << endl;
      return 0;
    }
  }
  cout << "NO" << endl;
}