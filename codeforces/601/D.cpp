
// Problem: D. Acyclic Organic Compounds
// Contest: Codeforces - Codeforces Round #333 (Div. 1)
// URL: https://codeforces.com/contest/601/problem/D
// Memory Limit: 512 MB
// Time Limit: 3000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int nr;
vector<int> adjl[300002];
ll hash1[300002];
ll hash2[300002];
ll tot[300002];
int arr[300002];
int mod = 1e9 + 9;
string str;
void dfs(int n, int p) {
  for (int x : adjl[n]) {
    if (x == p) continue;
    hash1[x] = 31 * hash1[n] + str[x] - 'a' + 1;
    hash1[x] %= mod;
    hash2[x] = 61 * hash2[n] + str[x] - 'a' + 1;
    hash2[x] %= mod;
    tot[x] = hash1[x] * (1e9 + 10) + hash2[x];
    dfs(x, n);
  }
}
int ans[300002];
set<ll> sts[300002];
void dfs2(int n, int p) {
  for (int x : adjl[n]) {
    if (x == p) continue;
    dfs2(x, n);
    if (sts[x].size() > sts[n].size()) {
      swap(sts[x], sts[n]);
    }
    for (ll z : sts[x]) {
      sts[n].insert(z);
    }
  }
  sts[n].insert(tot[n]);
  ans[n] = sts[n].size() + arr[n];
}

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> nr;
  for (int i = 0; i < nr; i++) {
    cin >> arr[i];
  }
  cin >> str;
  for (int i = 0; i < nr - 1; i++) {
    int a, b;
    cin >> a >> b;
    a--;
    b--;
    adjl[a].push_back(b);
    adjl[b].push_back(a);
  }
  hash1[0] = str[0] - 'a' + 1;
  hash2[0] = str[0] - 'a' + 1;
  tot[0] = hash1[0] * (1e9 + 10) + hash2[0];
  dfs(0, 0);
  dfs2(0, 0);
  int a = 0;
  int b = 0;
  for (int i = 0; i < nr; i++) {
    if (ans[i] == a) {
      b++;
    } else if (ans[i] > a) {
      a = ans[i];
      b = 1;
    }
  }
  cout << a << endl << b << endl;
}