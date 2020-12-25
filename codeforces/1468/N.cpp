/*
ID: varunra2
LANG: C++
TASK: n
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

const string yes = "YES\n";
const string no = "NO\n";

string solve() {
  VI c(3), a(5);
  trav(x, c) cin >> x;
  trav(x, a) cin >> x;
  for (int i = 0; i < 3; i++) {
    c[i] -= a[i];
    if (c[i] < 0) return no;
  }
  int mn = min(c[0], a[3]);
  a[3] -= mn;
  c[0] -= mn;
  mn = min(c[1], a[4]);
  a[4] -= mn;
  c[1] -= mn;
  if (a[3] + a[4] <= c[2]) return yes;
  return no;
}

int32_t main() {
#ifndef ONLINE_JUDGE
  freopen("n.in", "r", stdin);
  freopen("n.out", "w", stdout);
#endif
  cin.sync_with_stdio(0);
  cin.tie(0);

  int t;
  cin >> t;
  while (t--) {
    cout << solve();
  }

  return 0;
}
