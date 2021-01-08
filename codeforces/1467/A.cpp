// Problem: A. Wizard of Orz
// Contest: Codeforces - Codeforces Round #695 (Div. 2)
// URL: https://codeforces.com/contest/1467/problem/0
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
    string str = "9876543210";
    int c = false;
    for (int i = 0; i < n; i++) {
      if (c) {
        cout << (++c) % 10;
      } else {
        int a = (str[(i + 9) % 10] - '0' + 1) % 10;
        int b = str[i % 10] - '0';
        if (a > b) c = a;
        cout << max(a, b);
      }
    }
    cout << endl;
  }
}