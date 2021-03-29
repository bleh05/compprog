
// Problem: A. GCD Sum
// Contest: Codeforces - CodeCraft-21 and Codeforces Round #711 (Div. 2)
// URL: https://codeforces.com/contest/1498/problem/0
// Memory Limit: 256 MB
// Time Limit: 1000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
ll gcd(ll a, ll b) { return a == 0 ? b : gcd(b % a, a); }
int sumdg(ll a) {
  int t = 0;
  while (a) {
    t += a % 10;
    a /= 10;
  }
  return t;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    ll c;
    cin >> c;
    while (true) {
      if (gcd(c, sumdg(c)) > 1) {
        cout << c << "\n";
        break;
      }
      c++;
    }
  }
}