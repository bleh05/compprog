
// Problem: B. A Leapfrog in the Array
// Contest: Codeforces - Codeforces Round #469 (Div. 1)
// URL: https://codeforces.com/contest/949/problem/B
// Memory Limit: 512 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
ll solve(ll k, int par, ll tsz) {
  if ((k & 1) == par) {
    return k / 2 + par;
  }
  if (tsz & 1) {
    return tsz / 2 + 1 + solve(k >> 1, 0, tsz / 2);
  } else {
    return tsz / 2 + solve(k >> 1, 1, tsz / 2);
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  ll n, q;
  cin >> n >> q;
  for (int i = 0; i < q; i++) {
    ll c;
    cin >> c;
    ll cleft = n;
    ll ind = 0;
    cout << solve(c, 1, n) << endl;
  }
}