
// Problem: E. Carrots for Rabbits
// Contest: Codeforces - Codeforces Raif Round 1 (Div. 1 + Div. 2)
// URL: https://codeforces.com/contest/1428/problem/E
// Memory Limit: 256 MB
// Time Limit: 1000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
struct dd {
  ll s, occ, id;
  ll currsum(ll c) const {
    return (s % c) * ((s + c - 1) / c) * ((s + c - 1) / c) +
           (c - s % c) * (s / c) * (s / c);
  }
  ll calcdiff() const { return currsum(occ + 1) - currsum(occ); }
  bool operator()(const dd& a, const dd& b) const {
    if (a.calcdiff() == b.calcdiff()) {
      return a.id < b.id;
    }
    return a.calcdiff() < b.calcdiff();
  }
};
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, m;
  cin >> n >> m;
  set<dd, dd> s = {};
  ll arr[n];
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
    dd t = {arr[i], 1ll, i};
    s.insert({arr[i], 1ll, i});
  }
  for (int i = 0; i < m - n; i++) {
    dd c = *s.begin();
    s.erase(c);
    c.occ++;
    s.insert(c);
  }
  ll sum = 0;
  for (dd dx : s) {
    sum += dx.currsum(dx.occ);
  }
  cout << sum << endl;
}