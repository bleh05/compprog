
// Problem: A - Simple Math
// Contest: AtCoder - AtCoder Regular Contest 107
// URL: https://atcoder.jp/contests/arc107/tasks/arc107_a
// Memory Limit: 1024 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  ll a, b, c;
  cin >> a >> b >> c;
  c = c * (c + 1) / 2 % 998244353;
  b = b * (b + 1) / 2 % 998244353;
  a = a * (a + 1) / 2 % 998244353;
  cout << c * b % 998244353 * a % 998244353;
}