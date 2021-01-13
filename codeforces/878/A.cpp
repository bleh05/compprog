
// Problem: A. Short Program
// Contest: Codeforces - Codeforces Round #443 (Div. 1)
// URL: https://codeforces.com/contest/878/problem/A
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int a = 1023;
  int b = 0;
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    char x;
    int v;
    cin >> x >> v;
    if (x == '|') a |= v, b |= v;
    if (x == '&') a &= v, b &= v;
    if (x == '^') a ^= v, b ^= v;
  }
  int an = 1023;
  int orr = 0;
  int xo = 0;
  for (int i = 0; i < 10; i++) {
    if ((a & (1 << i))) {
      if ((b & (1 << i))) {
        orr |= (1 << i);
      }
    } else {
      if ((b & (1 << i))) {
        xo |= (1 << i);
      } else {
        an ^= (1 << i);
      }
    }
  }
  cout << 3 << endl;
  cout << "& " << an << endl;
  cout << "| " << orr << endl;
  cout << "^ " << xo << endl;
}