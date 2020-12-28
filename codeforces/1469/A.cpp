
// Problem: A. Regular Bracket Sequence
// Contest: Codeforces - Educational Codeforces Round 101 (Rated for Div. 2)
// URL: https://codeforces.com/contest/1469/problem/0
// Memory Limit: 512 MB
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
    string str;
    cin >> str;
    int k = (int)str.size();
    if (k % 2 == 1) {
      cout << "NO\n";
      continue;
    }
    if (str[0] == ')' || str[k - 1] == '(') {
      cout << "NO\n";
      continue;
    }
    cout << "YES\n";
  }
}