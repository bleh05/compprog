
// Problem: B. Bad Boy
// Contest: Codeforces - Codeforces Round #726 (Div. 2)
// URL: https://codeforces.com/contest/1537/problem/B
// Memory Limit: 256 MB
// Time Limit: 1000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    int a, b, c, d;
    cin >> a >> b >> c >> d;
    vector<pair<int, int>> vp;
    vp.push_back({1, b});
    vp.push_back({1, 1});
    vp.push_back({a, 1});
    vp.push_back({a, b});
    int maxa = 0;
    int maxb = 0;
    ll maxdist = 0;
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        ll dist = 0;
        dist += abs(c - vp[i].first) + abs(d - vp[i].second);
        dist +=
            abs(vp[i].first - vp[j].first) + abs(vp[i].second - vp[j].second);
        dist += abs(vp[j].first - c) + abs(vp[j].second - d);
        if (dist > maxdist) {
          maxa = i;
          maxb = j;
          maxdist = dist;
        }
      }
    }
    cout << vp[maxa].first << " " << vp[maxa].second << " " << vp[maxb].first
         << " " << vp[maxb].second << endl;
  }
}