
// Problem: C. Freelancer's Dreams
// Contest: Codeforces - Codeforces Round #335 (Div. 1)
// URL: https://codeforces.com/contest/605/problem/C
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef long double ld;
ld slope(pair<ld, ld> a, pair<ld, ld> b) {
  return (b.second - a.second) / (b.first - a.first);
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, a, b;
  cin >> n >> a >> b;
  ld maxa = 0;
  ld maxb = 0;
  map<ld, ld> mp = {};
  for (int i = 0; i < n; i++) {
    ld k = 0, f = 0;
    cin >> k >> f;
    if (mp.count(k)) {
      mp[k] = max(mp[k], f);
    } else
      mp[k] = f;
    maxa = max(maxa, k);
    maxb = max(maxb, f);
  }
  vector<pair<ld, ld>> chull = {};
  chull.push_back(make_pair(0, maxb));
  auto it = mp.begin();
  chull.push_back(*it);
  it++;
  int d = 2;
  for (; it != mp.end(); it++) {
    while (d >= 2) {
      ld slope1 = slope(chull[d - 2], chull[d - 1]);
      ld slope2 = slope(chull[d - 1], *it);
      // cout << slope1 << " " << slope2 << " " << d << endl;
      if (slope2 >= slope1) {
        chull.erase(chull.begin() + --d);
      } else
        break;
    }
    chull.push_back(*it);
    d++;
  }
  chull.push_back(make_pair(maxa, 0.0));
  int i = 1;
  for (; i < chull.size(); i++) {
    if (chull[i].second / chull[i].first <= 1.0 * b / a) {
      break;
    }
  }
  if (i == chull.size() - 1 || i == 1) {
    cout << setprecision(20) << max(a / maxa, b / maxb) << endl;
    exit(0);
  }
  ld l = chull[i - 1].first;
  ld r = chull[i].first;
  int dr = chull[i - 1].first;
  ld slopes = slope(chull[i - 1], chull[i]);
  while (r - l >= 1e-10) {
    ld mid = (l + r) / 2;
    ld ny = chull[i - 1].second + (mid - dr) * slopes;
    if (1.0 * b / a >= ny / mid) {
      r = mid;
    } else {
      l = mid;
    }
  }
  cout << setprecision(20)
       << max(a / l, b / (chull[i - 1].second + (l - dr) * slopes)) << endl;
}