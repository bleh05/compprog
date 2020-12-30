
// Problem: F. Euclid's nightmare
// Contest: Codeforces - Good Bye 2020
// URL: https://codeforces.com/contest/1466/problem/F
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int mxn = 5e5 + 2;
int mod = 1e9 + 7;
int ok[mxn];
int vis[mxn];
set<int> g[mxn];
int par[mxn];
int gets(int v) {
  if (par[v] == v)
    return v;
  else
    return par[v] = gets(par[v]);
}
void uset(int a, int b) {
  a = gets(a);
  b = gets(b);
  if (a != b) par[b] = a;
}
void dfs(int v, int p) {
  for (int x : g[v]) {
    if (g[x].count(v)) g[x].erase(v);
    if (x == p) continue;
    if (ok[x] == 1) {
      ok[x] = ok[v];
      dfs(x, v);
    }
  }
  g[v].clear();
}
int dfs2(int v, int p) {
  int s = 1;
  if (vis[v]) return 0;
  vis[v] = 1;
  for (int x : g[v]) {
    if (x == p) continue;
    s += dfs2(x, v);
  }
  return s;
}
ll fact[mxn];
ll finv[mxn];
ll bpow(ll a, ll b) {
  ll prod = 1;
  while (b) {
    if (b & 1) prod = prod * a % mod;
    a = a * a % mod;
    b >>= 1;
  }
  return prod;
}
ll nevn(int r) {
  ll t = 0;
  for (int i = 2; i <= r; i += 2) {
    t += fact[r] * finv[i] % mod * finv[r - i] % mod;
    t %= mod;
  }
  return t + 1;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, m;
  cin >> n >> m;
  vector<int> out;
  memset(ok, 0, sizeof ok);
  for (int i = 0; i < mxn; i++) {
    fact[i] = max(1ll, fact[i - 1] * i) % mod;
    finv[i] = bpow(fact[i], mod - 2);
    par[i] = i;
  }
  set<ll> alr;
  for (int i = 0; i < n; i++) {
    int d;
    cin >> d;
    if (d == 1) {
      int f;
      cin >> f;
      if (ok[f] < 2) {
        ok[f] = i + 3;
        dfs(f, -1);
        out.push_back(i + 1);
      }
    } else {
      int a, b;
      cin >> a >> b;
      if ((ok[a] <= 1 || ok[b] <= 1) && gets(a) != gets(b)) {
        g[a].insert(b);
        g[b].insert(a);
        ok[a] = max(max(ok[a], 1), ok[b]);
        ok[b] = max(max(ok[a], 1), ok[b]);
        if (ok[a] > 1) {
          dfs(a, b);
          dfs(b, a);
        }
        uset(a, b);
        out.push_back(i + 1);
      }
    }
  }
  ll sum = 1;
  ll d = 1;
  for (int i = 0; i <= m; i++) {
    if (ok[i] > 1 && vis[i] == 0) {
      sum += d;
      d *= 2;
    }
    if (ok[i] == 1 && vis[i] == 0) {
      int r = nevn(dfs2(i, 0));
      sum += d * (r - 1) % mod;
      d *= r;
    }
    d %= mod;
    sum %= mod;
  }
  cout << sum % mod << " " << out.size() << endl;
  for (int x : out) {
    cout << x << " ";
  }
  cout << endl;
}