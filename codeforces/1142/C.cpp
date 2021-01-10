
// Problem: C. U2
// Contest: Codeforces - Codeforces Round #549 (Div. 1)
// URL: https://codeforces.com/contest/1142/problem/C
// Memory Limit: 256 MB
// Time Limit: 1000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

struct pt {
  ll x, y;
};

bool cmp(pt a, pt b) { return a.x < b.x || (a.x == b.x && a.y < b.y); }

bool cw(pt a, pt b, pt c) {
  return a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y) < 0;
}

bool ccw(pt a, pt b, pt c) {
  return a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y) > 0;
}

void convex_hull(vector<pt>& a) {
  if (a.size() == 1) return;

  sort(a.begin(), a.end(), &cmp);
  pt p1 = a[0], p2 = a.back();
  vector<pt> up, down;
  up.push_back(p1);
  down.push_back(p1);
  for (int i = 1; i < (int)a.size(); i++) {
    if (i == a.size() - 1 || cw(p1, a[i], p2)) {
      while (up.size() >= 2 && !cw(up[up.size() - 2], up[up.size() - 1], a[i]))
        up.pop_back();
      up.push_back(a[i]);
    }
    if (i == a.size() - 1 || ccw(p1, a[i], p2)) {
      while (down.size() >= 2 &&
             !ccw(down[down.size() - 2], down[down.size() - 1], a[i]))
        down.pop_back();
      down.push_back(a[i]);
    }
  }

  a.clear();
  for (int i = 0; i < (int)up.size(); i++) a.push_back(up[i]);
}

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n;
  cin >> n;
  vector<pt> v;
  for (int i = 0; i < n; i++) {
    ll x, y;
    cin >> x >> y;
    y -= x * x;
    v.push_back({x, y});
  }
  convex_hull(v);
  set<int> mp;
  int c = 0;
  for (pt x : v) {
    if (mp.count(x.x)) {
      c++;
    }
    mp.insert(x.x);
  }
  cout << v.size() - 1 - c << endl;
}