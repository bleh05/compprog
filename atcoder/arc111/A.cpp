
// Problem: A - Simple Math 2
// Contest: AtCoder - AtCoder Regular Contest 111
// URL: https://atcoder.jp/contests/arc111/tasks/arc111_a
// Memory Limit: 1024 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

ll bpow(ll a, ll mod) {
  ll prod = 1;
  ll c = 10;
  while (a) {
    if (a & 1) prod = prod * c % mod;
    c = c * c % mod;
    a >>= 1;
  }
  return prod;
}

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  ll n, m;
  cin >> n >> m;
  ll c = bpow(n, m * m);
  cout << c / m % m << endl;
}