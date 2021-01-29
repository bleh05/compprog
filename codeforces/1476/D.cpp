
// Problem: D. Journey
// Contest: Codeforces - Educational Codeforces Round 103 (Rated for Div. 2)
// URL: https://codeforces.com/contest/1476/problem/D
// Memory Limit: 512 MB
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
    string str;
    cin >> str;
    int lalt[n];
    int ralt[n];
    lalt[0] = 1;
    for (int i = 1; i < n; i++) {
      if (str[i] == str[i - 1])
        lalt[i] = 1;
      else
        lalt[i] = lalt[i - 1] + 1;
    }
    ralt[n - 1] = 1;
    for (int i = n - 2; i >= 0; i--) {
      if (str[i] == str[i + 1])
        ralt[i] = 1;
      else
        ralt[i] = ralt[i + 1] + 1;
    }
    for (int i = 0; i <= n; i++) {
      int mx = 0;
      if (i && str[i - 1] == 'L') mx += lalt[i - 1];
      if (i < n && str[i] == 'R') mx += ralt[i];
      cout << mx + 1 << " ";
    }
    cout << endl;
  }
}