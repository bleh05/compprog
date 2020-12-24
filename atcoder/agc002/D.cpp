
// Problem: D - Stamp Rally
// Contest: AtCoder - AtCoder Grand Contest 002
// URL: https://atcoder.jp/contests/agc002/tasks/agc002_d
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int N = 100003;
vector<int> g[N];
struct query {
  int a, b, z, i;
};

struct bound {
  int l, r;
  vector<query> qset;
};
int par[N];
int szCComp[N];
void initD() {
  for (int i = 0; i < N; i++) {
    par[i] = i;
    szCComp[i] = 1;
  }
}

int getset(int a) {
  if (par[a] == a) return a;
  return par[a] = getset(par[a]);
}

void uniset(int a, int b) {
  a = getset(a);
  b = getset(b);
  if (a != b) {
    szCComp[a] += szCComp[b];
    par[b] = a;
  }
}

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, m;
  cin >> n >> m;
  vector<pair<int, int>> edges;
  for (int i = 0; i < m; i++) {
    int a, b;
    cin >> a >> b;
    g[a].push_back(b);
    g[b].push_back(a);
    edges.push_back({a, b});
  }
  int q;
  cin >> q;
  vector<query> qs;
  for (int i = 0; i < q; i++) {
    int a, b, z;
    cin >> a >> b >> z;
    qs.push_back({a, b, z, i});
  }
  queue<bound> qu;
  initD();
  qu.push({0, m, qs});
  int ans[q];
  int currptr = 0;
  while (qu.size()) {
    bound b = qu.front();
    qu.pop();
    vector<query> v1;
    vector<query> v2;
    if (b.l >= b.r) {
      for (query x : b.qset) {
        ans[x.i] = min(b.l, b.r);
      }
      continue;
    }
    int X = (b.l + b.r) >> 1;
    if (currptr > X) {
      initD();
      currptr = 0;
    }
    for (; currptr <= X; currptr++) {
      uniset(edges[currptr].first, edges[currptr].second);
    }
    for (query qry : b.qset) {
      if (getset(qry.a) == getset(qry.b)) {
        if (szCComp[getset(qry.a)] >= qry.z)
          v1.push_back(qry);
        else
          v2.push_back(qry);
      } else {
        if (szCComp[getset(qry.a)] + szCComp[getset(qry.b)] >= qry.z)
          v1.push_back(qry);
        else
          v2.push_back(qry);
      }
    }
    qu.push({b.l, X, v1});
    qu.push({X + 1, b.r, v2});
  }
  for (int x : ans) cout << x + 1 << endl;
}