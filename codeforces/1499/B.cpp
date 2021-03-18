
// Problem: B. Binary Removals
// Contest: Codeforces - Educational Codeforces Round 106 (Rated for Div. 2)
// URL: https://codeforces.com/contest/1499/problem/B
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
    string str;
    cin >> str;
    int s = 10000, e = -1;
    for (int i = 0; i < str.size() - 1; i++) {
      if (str[i] == '1' && str[i + 1] == '1') s = min(s, i);
      if (str[i] == '0' && str[i + 1] == '0') e = max(e, i);
    }
    if (s > e)
      cout << "YES\n";
    else
      cout << "NO\n";
  }
}