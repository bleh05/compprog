
// Problem: D. GCD of an Array
// Contest: Codeforces - Codeforces Round #705 (Div. 2)
// URL: https://codeforces.com/contest/1493/problem/D
// Memory Limit: 256 MB
// Time Limit: 2500 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
map<int, int> pfac(int b) {
  map<int, int> ans;
  for (int i = 2; i * i <= b; i++) {
    int c = 0;
    while (b % i == 0) {
      b /= i;
      c++;
    }
    if (c) ans[i] = c;
  }
  if (b > 1) ans[b]++;
  return ans;
}
int mod = 1000000007;
int bpow(ll n, ll m) {
  ll b = 1;
  while (m) {
    if (m & 1) b = b * n % mod;
    n = n * n % mod;
    m >>= 1;
  }
  return b;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, m;
  cin >> n >> m;
  map<int, multiset<int>> fac;
  map<int, int> facEle[n];
  for (int i = 0; i < n; i++) {
    int d;
    cin >> d;
    facEle[i] = pfac(d);
    for (auto x : facEle[i]) {
      fac[x.first].insert(x.second);
    }
  }
  ll gcd = 1;
  for (auto x : fac) {
    if (x.second.size() == n)
      gcd *= bpow(x.first, (*x.second.upper_bound(0))), gcd %= mod;
  }
  for (int i = 0; i < m; i++) {
    int ind, v;
    cin >> ind >> v;
    ind--;
    map<int, int> nfac = pfac(v);
    for (auto x : nfac) {
      auto omin = fac[x.first].upper_bound(0);
      int valOfOmin = *omin;
      if (fac[x.first].size() < n) valOfOmin = 0;
      if (facEle[ind].count(x.first)) {
        auto d = fac[x.first].lower_bound(facEle[ind][x.first]);
        fac[x.first].erase(d);
        fac[x.first].insert(facEle[ind][x.first] + x.second);
      } else {
        fac[x.first].insert(x.second);
      }
      facEle[ind][x.first] += x.second;
      auto nmin = fac[x.first].upper_bound(0);
      int valOfNmin = *nmin;
      if (fac[x.first].size() < n) valOfNmin = 0;
      gcd *= bpow(x.first, valOfNmin - valOfOmin);
      gcd %= mod;
    }
    cout << gcd << endl;
  }
}