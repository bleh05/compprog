/*
ID: varunra2
LANG: C++
TASK: j
*/

#include <bits/stdc++.h>
using namespace std;

#define int long long

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
int n, m, k;
vector<VII> adj;
VVI edgs;

void init() {
  adj.clear();
  adj.resize(n);
  edgs.clear();
  edgs.resize(m);
}

struct dsu {
  VI par;
  VI siz;

  int comps;

  void init(int n) {
    par.resize(n);
    siz.resize(n);
    for (int i = 0; i < n; i++) {
      par[i] = i;
      siz[i] = 1;
    }
    comps = n;
  }

  int find(int x) {
    while (par[x] != par[par[x]]) par[x] = par[par[x]];
    return par[x];
  }

  bool same(int x, int y) { return find(x) == find(y); }

  void merge(int x, int y) {
    x = find(x);
    y = find(y);
    if (same(x, y)) return;
    if (siz[x] < siz[y]) swap(x, y);
    par[y] = x;
    siz[x] += siz[y];
    comps--;
  }
};

int solve() {
  cin >> n >> m >> k;
  init();
  for (int i = 0; i < m; i++) {
    int u, v, w;
    cin >> u >> v >> w;
    u--, v--;
    edgs[i] = {w, u, v};
    adj[u].PB(MP(v, w));
    adj[v].PB(MP(u, w));
  }
  int cost = 0;

  dsu dsu1;
  dsu1.init(n);

  sort(all(edgs));

  int ind = -1;
  for (int i = 0; i < m and edgs[i][0] <= k; i++) {
    dsu1.merge(edgs[i][1], edgs[i][2]);
    cost = k - edgs[i][0];
    ind = i;
  }

  bool ok = dsu1.comps == 1;

  VVI edgs1;
  for (int i = ind + 1; i < m; i++) {
    edgs1.PB(edgs[i]);
    edgs1.back()[0] -= k;
  }

  int cost2 = 0;

  int frst;
  if (edgs1.empty())
    frst = INF;
  else
    frst = edgs1[0][0];

  cost = min(cost, frst);

  for (int i = 0; i < sz(edgs1); i++) {
    int u, v, w;
    u = edgs1[i][1], v = edgs1[i][2], w = edgs1[i][0];
    if (dsu1.same(u, v)) continue;
    dsu1.merge(u, v);
    cost2 += w;
  }

  if (ok) return cost;
  return cost2;
}

int32_t main() {
#ifndef ONLINE_JUDGE
  freopen("j.in", "r", stdin);
  freopen("j.out", "w", stdout);
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
