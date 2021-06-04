
// Problem: C. Unstable String
// Contest: Codeforces - Educational Codeforces Round 110 (Rated for Div. 2)
// URL: https://codeforces.com/contest/1535/problem/C
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
    int mode = 0;
    int prequest = 0;
    int prefix = 0;
    int n = str.size();
    ll sum = 0;
    for (int i = 0; i < n; i++) {
      if (str[i] == '?') {
        prequest++;
        prefix++;
      } else {
        if (mode == 0) {
          if (str[i] - '0' == i % 2)
            prefix++;
          else
            prefix = prequest + 1, mode = 1;
          prequest = 0;
        } else {
          if (str[i] - '0' == (i + 1) % 2)
            prefix++;
          else
            prefix = prequest + 1, mode = 0;
          prequest = 0;
        }
      }
      sum += prefix;
    }
    cout << sum << endl;
  }
}