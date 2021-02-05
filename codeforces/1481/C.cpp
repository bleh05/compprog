
// Problem: C. Fence Painting
// Contest: Codeforces - Codeforces Round #699 (Div. 2)
// URL: https://codeforces.com/contest/1481/problem/C
// Memory Limit: 256 MB
// Time Limit: 2000 ms
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
    int n, m;
    cin >> n >> m;
    int ca[n];
    for (int i = 0; i < n; i++) cin >> ca[i];
    int cb[n];
    for (int i = 0; i < n; i++) cin >> cb[i];
    set<int> needs[n + 2];
    int ookay[n + 2];
    memset(ookay, 0, sizeof ookay);
    vector<int> ans;
    bool good = true;
    for (int i = 0; i < n; i++) {
      if (ca[i] != cb[i]) {
        needs[cb[i]].insert(i + 1);
      } else {
        ookay[ca[i]] = i + 1;
      }
    }
    int currptr = 0;
    for (int i = 0; i < m; i++) {
      int p;
      cin >> p;
      if (needs[p].size()) {
        auto dd = needs[p].lower_bound(0);
        ookay[p] = *dd;
        for (; currptr <= i; currptr++) {
          ans.push_back(*dd);
        }
        needs[p].erase(dd);
        good = true;
      } else {
        if (ookay[p] == 0)
          good = false;
        else {
          for (; currptr <= i; currptr++) {
            ans.push_back(ookay[p]);
          }
          good = true;
        }
      }
    }
    for (int i = 0; i < n + 2; i++) {
      good = good & (needs[i].size() == 0);
    }
    if (good) {
      cout << "YES\n";
      for (int x : ans) cout << x << " ";
      cout << "\n";
    } else
      cout << "NO\n";
  }
}