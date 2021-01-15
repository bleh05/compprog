
// Problem: A. Neko Finds Grapes
// Contest: Codeforces - Codeforces Round #554 (Div. 2)
// URL: https://codeforces.com/contest/1152/problem/A
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int m;
  int n;
  cin >> n >> m;
  int a = 0;
  int b = 0;
  int c = 0;
  int d = 0;
  for (int i = 0; i < n; i++) {
    int rr;
    cin >> rr;
    if (rr & 1)
      a++;
    else
      b++;
  }
  for (int i = 0; i < m; i++) {
    int rr;
    cin >> rr;
    if (rr & 1)
      c++;
    else
      d++;
  }
  cout << min(a, d) + min(c, b) << endl;
}