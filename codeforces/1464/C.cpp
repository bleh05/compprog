
// Problem: C. Poman Numbers
// Contest: Codeforces - Codeforces Round #692 (Div. 1, based on Technocup 2021
// Elimination Round 3) URL: https://codeforces.com/contest/1464/problem/C
// Memory Limit: 256 MB
// Time Limit: 1000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n;
  ll t;
  cin >> n >> t;
  string str;
  cin >> str;
  ll rd = 0;
  rd -= 1 << (str[n - 2] - 'a');
  rd += 1 << (str[n - 1] - 'a');
  for (char c = 'z'; c >= 'a'; c--) {
    for (int i = 0; i < n - 2; i++) {
      if (str[i] == c) {
        if (rd < t)
          rd += 1 << (c - 'a');
        else
          rd -= 1 << (c - 'a');
      }
    }
  }
  cout << (rd == t ? "Yes" : "No") << endl;
}