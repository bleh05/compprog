
// Problem: F. MEX Queries
// Contest: Codeforces - Educational Codeforces Round 23
// URL: https://codeforces.com/contest/817/problem/F
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

const int mx = 4e5 + 3;

int segt[mx * 4][2];
int lazy[mx * 8];
int lazyA[mx * 8];

void push(int v) {
  if (lazyA[v] == 1) {
    lazyA[2 * v] = 1;
    lazyA[2 * v + 1] = 1;
    segt[v][1] = segt[v][0] + segt[v][1];
    segt[v][0] = 0;
  }
  if (lazyA[v] == 2) {
    lazyA[2 * v] = 2;
    lazyA[2 * v + 1] = 2;
    segt[v][0] = segt[v][0] + segt[v][1];
    segt[v][1] = 0;
  }
  if (lazy[v] == -1) {
    lazy[2 * v] = -1;
    lazy[2 * v + 1] = -1;
  }
  if (lazy[v] == 1) {
    if (2 * v < mx * 2 && lazy[2 * v] == -1) {
      push(2 * v);
    }
    lazy[2 * v] ^= 1;
    if (2 * v + 1 < mx * 2 && lazy[2 * v + 1] == -1) {
      push(2 * v + 1);
    }
    lazy[2 * v + 1] ^= 1;
    swap(segt[v][0], segt[v][1]);
  }
  lazy[v] = 0;
  lazyA[v] = 0;
}

void init(int v, int tl, int tr) {
  if (tl == tr) {
    segt[v][0] = 1;
  } else {
    int mid = (tl + tr) >> 1;
    init(v * 2, tl, mid);
    init(v * 2 + 1, mid + 1, tr);
    segt[v][0] = segt[2 * v][0] + segt[2 * v + 1][0];
  }
}

int sum(int v, int tl, int tr, ll l, ll r) {
  push(v);
  if (l > tr || r < tl)
    return 0;
  else if (tl >= l && tr <= r) {
    return segt[v][1];
  } else {
    int mid = (tl + tr) >> 1;
    return sum(v * 2, tl, mid, l, r) + sum(v * 2 + 1, mid + 1, tr, l, r);
  }
}

void update1(int v, int tl, int tr, ll l, ll r) {
  push(v);
  if (l > tr || r < tl)
    return;
  else if (tl >= l && tr <= r) {
    lazyA[v] = 1;
    lazy[v] = -1;
    push(v);
  } else {
    int mid = (tl + tr) >> 1;
    update1(v * 2, tl, mid, l, r);
    update1(v * 2 + 1, mid + 1, tr, l, r);
    segt[v][1] = segt[2 * v][1] + segt[2 * v + 1][1];
    segt[v][0] = segt[2 * v][0] + segt[2 * v + 1][0];
  }
}

void update2(int v, int tl, int tr, ll l, ll r) {
  push(v);
  if (l > tr || r < tl)
    return;
  else if (tl >= l && tr <= r) {
    lazyA[v] = 2;
    lazy[v] = -1;
    push(v);
  } else {
    push(v);
    int mid = (tl + tr) >> 1;
    update2(v * 2, tl, mid, l, r);
    update2(v * 2 + 1, mid + 1, tr, l, r);
    segt[v][1] = segt[2 * v][1] + segt[2 * v + 1][1];
    segt[v][0] = segt[2 * v][0] + segt[2 * v + 1][0];
  }
}

void update3(int v, int tl, int tr, ll l, ll r) {
  push(v);
  if (l > tr || r < tl)
    return;
  else if (tl >= l && tr <= r) {
    push(v);
    lazy[v] ^= 1;
    push(v);
  } else {
    int mid = (tl + tr) >> 1;
    update3(v * 2, tl, mid, l, r);
    update3(v * 2 + 1, mid + 1, tr, l, r);
    segt[v][1] = segt[2 * v][1] + segt[2 * v + 1][1];
    segt[v][0] = segt[2 * v][0] + segt[2 * v + 1][0];
  }
}

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  init(1, 0, mx - 1);
  set<ll> v = {};
  v.insert(1);
  int q;
  cin >> q;
  ll qs[q][3];
  for (int i = 0; i < q; i++) {
    cin >> qs[i][0] >> qs[i][1] >> qs[i][2];
    v.insert(qs[i][1]);
    v.insert(qs[i][2]);
    v.insert(qs[i][2] + 1);
  }
  map<ll, int> mp = {};
  int k = 0;
  auto x = v.begin();
  vector<ll> vd = {};
  for (; x != v.end(); x++, k++) {
    mp.insert(make_pair(*x, k));
    vd.push_back(*x);
  }
  for (int i = 0; i < q; i++) {
    qs[i][1] = mp.find(qs[i][1])->second;
    qs[i][2] = mp.find(qs[i][2])->second;
  }
  for (int i = 0; i < q; i++) {
    if (qs[i][0] == 1) {
      update1(1, 0, mx - 1, qs[i][1], qs[i][2]);
    }
    if (qs[i][0] == 2) {
      update2(1, 0, mx - 1, qs[i][1], qs[i][2]);
    }
    if (qs[i][0] == 3) {
      update3(1, 0, mx - 1, qs[i][1], qs[i][2]);
    }
    if (sum(1, 0, mx - 1, 0, 0) == 0) {
      cout << 1 << endl;
    } else {
      int l = 0;
      int r = mx - 1;
      while (r - l > 1) {
        int mid = (l + r) >> 1;
        if (sum(1, 0, mx - 1, 0, mid) == mid + 1) {
          l = mid;
        } else {
          r = mid - 1;
        }
      }
      if (sum(1, 0, mx - 1, 0, r) == r + 1) {
        l = r;
      }
      cout << vd[l + 1] << endl;
    }
  }
}