
// Problem: D. 13th Labour of Heracles
// Contest: Codeforces - Good Bye 2020
// URL: https://codeforces.com/contest/1466/problem/D
// Memory Limit: 256 MB
// Time Limit: 2500 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

vector<int> g[100002];

int arr[100002];
vector<int> vr;
void dfs(int v, int p) {
  for (int x : g[v]) {
    if (x != p) {
      vr.push_back(arr[v]);
      dfs(x, v);
    }
  }
}

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    int n;
    cin >> n;
    ll sum = 0;
    for (int i = 1; i <= n; i++) {
      cin >> arr[i];
      sum += arr[i];
      g[i].clear();
    }
    for (int i = 1; i < n; i++) {
      int a, b;
      cin >> a >> b;
      g[a].push_back(b);
      g[b].push_back(a);
    }
    vr.clear();
    for (int i = 0; i <= n; i++)
      if (g[i].size() > 1) {
        dfs(i, 0);
        break;
      }
    if (vr.size()) vr.erase(vr.begin());
    sort(vr.begin(), vr.end());
    reverse(vr.begin(), vr.end());
    for (int i : vr) {
      cout << sum << " ";
      sum += i;
    }
    cout << sum << "\n";
  }
}