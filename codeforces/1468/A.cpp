/*
ID: varunra2
LANG: C++
TASK: a
*/

#include <bits/stdc++.h>
using namespace std;

#ifdef DEBUG
#include "lib/debug.h"
#define debug(...) cerr << "[" << #__VA_ARGS__ << "]:", debug_out(__VA_ARGS__)
#define debug_arr(...) \
  cerr << "[" << #__VA_ARGS__ << "]:", debug_arr(__VA_ARGS__)
#pragma GCC diagnostic ignored "-Wsign-compare"
//#pragma GCC diagnostic ignored "-Wunused-parameter"
//#pragma GCC diagnostic ignored "-Wunused-variable"
#else
#define debug(...) 42
#endif

#define EPS 1e-9
#define IN(A, B, C) assert(B <= A && A <= C)
#define INF (int)1e9
#define MEM(a, b) memset(a, (b), sizeof(a))
#define MOD 1000000007
#define MP make_pair
#define PB push_back
#define all(cont) cont.begin(), cont.end()
#define rall(cont) cont.end(), cont.begin()
#define x first
#define y second

const double PI = acos(-1.0);
typedef long long ll;
typedef long double ld;
typedef pair<int, int> PII;
typedef map<int, int> MPII;
typedef multiset<int> MSETI;
typedef set<int> SETI;
typedef set<string> SETS;
typedef vector<int> VI;
typedef vector<PII> VII;
typedef vector<VI> VVI;
typedef vector<string> VS;

#define rep(i, a, b) for (int i = a; i < (b); ++i)
#define trav(a, x) for (auto& a : x)
#define sz(x) (int)(x).size()
typedef pair<int, int> pii;
typedef vector<int> vi;
#pragma GCC diagnostic ignored "-Wsign-compare"
// util functions

struct segtree {
  int n;
  VI st;
  void init(int _n) {
    n = _n;
    st.assign(4 * n, 0);
  }

  void upd(int i, int x, int lo, int hi, int node) {
    if (hi == -1) hi = n - 1;
    if (hi < i || lo > i) return;
    if (lo == hi) {
      st[node] = x;
      return;
    }
    int mid = (lo + hi) / 2;
    upd(i, x, lo, mid, 2 * node + 1);
    upd(i, x, mid + 1, hi, 2 * node + 2);
    st[node] = max(st[2 * node + 1], st[2 * node + 2]);
  }

  int qry(int s, int e, int lo, int hi, int node) {
    if (hi == -1) hi = n - 1;
    if (hi < s || lo > e) return 0;
    if (lo >= s && hi <= e) return st[node];
    int mid = (lo + hi) / 2;
    return max(qry(s, e, lo, mid, 2 * node + 1),
               qry(s, e, mid + 1, hi, 2 * node + 2));
  }

  void upd(int ind, int val) { upd(ind, val, 0, n - 1, 0); }

  int qry(int l, int r) {
    if (l > r) return -2;
    return qry(l, r, 0, n - 1, 0);
  }
};

//[inds, msk]: {0, 7, 8, 9, 10, 11, 12, 13} 16257
// 9 1 14 1 1 7 4 10

int solve() {
  int n;
  cin >> n;
  VII vals(n);
  for (int i = 0; i < n; i++) {
    cin >> vals[i].x;
    vals[i].y = i;
  }

  VI pos(n);
  stack<int> st;
  for (int i = 0; i < n; i++) {
    while (!st.empty() and vals[st.top()].x <= vals[i].x) st.pop();
    if (st.empty())
      pos[i] = -1;
    else
      pos[i] = st.top();
    st.push(i);
  }

  segtree seg;
  seg.init(n);

  VI dp(n);
  auto cop = vals;
  sort(all(vals));

  for (int i = 0; i < n; i++) {
    int val = vals[i].x, ind = vals[i].y;
    int ps = pos[ind];
    dp[ind] = max(seg.qry(0, ps) + 2, seg.qry(ps + 1, ind) + 1);
    seg.upd(ind, dp[ind]);
  }

  int mx = -1;

  // debug(dp);

  for (int i = n - 1; i >= 0; i--) {
    if (mx > cop[i].x) dp[i]++;
    mx = max(mx, cop[i].x);
  }

  // debug(dp);

  return *max_element(all(dp));
}

int main() {
#ifndef ONLINE_JUDGE
  freopen("a.in", "r", stdin);
  freopen("a.out", "w", stdout);
#endif
  cin.sync_with_stdio(0);
  cin.tie(0);

  int t;
  cin >> t;
  while (t--) {
    cout << solve() << '\n';
  }

  return 0;
}
