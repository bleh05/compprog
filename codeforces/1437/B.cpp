
// Problem: B. Reverse Binary Strings
// Contest: Codeforces - Educational Codeforces Round 97 (Rated for Div. 2)
// URL: https://codeforces.com/contest/1437/problem/B
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
  while (t-- > 0) {
    int n;
    cin >> n;
    string str;
    cin >> str;
    int a = 0;
    int b = 0;
    for (int i = 1; i < n; i++) {
      if (str[i] == str[i - 1]) {
        if (str[i] == '1') {
          a++;
        } else {
          b++;
        }
      }
    }
    cout << max(a, b) << endl;
  }
}