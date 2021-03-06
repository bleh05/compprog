
// Problem: A. Anti-knapsack
// Contest: Codeforces - Codeforces Round #705 (Div. 2)
// URL: https://codeforces.com/contest/1493/problem/0
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
    vector<int> v;
    int x, y;
    cin >> x >> y;
    for (int i = y + 1; i <= x; i++) v.push_back(i);
    for (int i = (y + 1) / 2; i < y; i++) {
      v.push_back(i);
    }
    cout << v.size() << "\n";
    for (int x : v) cout << x << " ";
    cout << "\n";
  }
}