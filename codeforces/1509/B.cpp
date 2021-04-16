
// Problem: B. TMT Document
// Contest: Codeforces - Codeforces Round #715 (Div. 2)
// URL: https://codeforces.com/contest/1509/problem/B
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
    int nt = 0;
    int nm = 0;
    int n;
    cin >> n;
    bool good = true;
    string str;
    cin >> str;
    for (int i = 0; i < n; i++) {
      if (str[i] == 'T')
        nt++;
      else
        nm++;
      if (nm > nt) good = false;
    }
    nm = nt = 0;
    reverse(str.begin(), str.end());
    for (int i = 0; i < n; i++) {
      if (str[i] == 'T')
        nt++;
      else
        nm++;
      if (nm > nt) good = false;
    }
    good &= (nm * 2 == nt);
    cout << (good ? "YES" : "NO") << endl;
  }
}