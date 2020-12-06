
// Problem: A. Avoid Trygub
// Contest: Codeforces - Codeforces Global Round 12
// URL: https://codeforces.com/contest/1450/problem/0
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
    int n;
    cin >> n;
    string s;
    cin >> s;
    int k = 0;
    for (int i = 0; i < n; i++) {
      if (s[i] != 't') {
        cout << s[i];
        k++;
      }
    }
    for (int i = k; i < n; i++) {
      cout << 't';
    }
    cout << endl;
  }
}