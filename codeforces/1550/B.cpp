
// Problem: B. Maximum Cost Deletion
// Contest: Codeforces - Educational Codeforces Round 111 (Rated for Div. 2)
// URL: https://codeforces.com/contest/1550/problem/B
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
    int n, a, b;
    cin >> n >> a >> b;
    string str;
    cin >> str;
    ll tot = a * n;
    if (b < 0) {
      tot += b;
      int s = 0, t = 0;
      if (str[0] == '0')
        s++;
      else
        t++;
      for (int i = 1; i < n; i++) {
        if (str[i] != str[i - 1]) {
          if (str[i] == '0')
            s++;
          else
            t++;
        }
      }
      tot += min(s, t) * b;
    } else
      tot += n * b;
    cout << tot << endl;
  }
}