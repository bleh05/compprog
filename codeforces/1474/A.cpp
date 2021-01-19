
// Problem: A. Puzzle From the Future
// Contest: Codeforces - Codeforces Round #696 (Div. 2)
// URL: https://codeforces.com/contest/1474/problem/0
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
    string str;
    cin >> str;
    int last = 0;
    for (int i = 0; i < n; i++) {
      if (last == 0 && str[i] == '0')
        cout << 1, last = 1;
      else if (last == 1 && str[i] == '0')
        cout << 0, last = 0;
      else if (last == 2 && str[i] == '0')
        cout << 1, last = 1;
      else if (last == 0 && str[i] == '1')
        cout << 1, last = 2;
      else if (last == 1 && str[i] == '1')
        cout << 1, last = 2;
      else if (last == 2 && str[i] == '1')
        cout << 0, last = 1;
    }
    cout << endl;
  }
}