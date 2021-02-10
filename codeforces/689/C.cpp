
// Problem: C. Mike and Chocolate Thieves
// Contest: Codeforces - Codeforces Round #361 (Div. 2)
// URL: https://codeforces.com/contest/689/problem/C
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
vector<ll> prime;
ll check(ll a) {
  ll sum = 0;
  for (ll i = 2; i < 200002; i++) {
    sum += a / (i * i * i);
  }
  return sum;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  ll l = 1, r = 1e17;
  ll goal;
  cin >> goal;
  while (r - l > 1) {
    ll mid = (l + r) >> 1;
    ll d = check(mid);
    if (d < goal)
      l = mid;
    else if (d >= goal)
      r = mid;
  }
  if (check(l) == goal)
    cout << l << endl;
  else if (check(r) == goal)
    cout << r << endl;
  else
    cout << -1 << endl;
}