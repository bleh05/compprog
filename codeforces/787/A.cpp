
// Problem: A. The Monster
// Contest: Codeforces - Codeforces Round #406 (Div. 2)
// URL: https://codeforces.com/contest/787/problem/A
// Memory Limit: 256 MB
// Time Limit: 1000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int a, b, c, d;
  cin >> a >> b >> c >> d;
  for (int i = max(b, d); i < 1e7; i++) {
    if ((i - b) % a == 0 && (i - d) % c == 0) {
      cout << i << endl;
      return 0;
    }
  }
  cout << -1 << endl;
}