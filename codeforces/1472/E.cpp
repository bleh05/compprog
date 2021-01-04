
// Problem: E. Correct Placement
// Contest: Codeforces - Codeforces Round #693 (Div. 3)
// URL: https://codeforces.com/contest/1472/problem/E
// Memory Limit: 256 MB
// Time Limit: 4000 ms
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
    int n;
    cin >> n;
    int ans[n];
    pair<int, int> coord1[n];
    map<int, pair<int, int>> mp;
    mp[-5] = {1000000005, 0};
    for (int i = 0; i < n; i++) {
      ans[i] = -1;
      int x, y;
      cin >> x >> y;
      coord1[i] = {x, y};
      while (true) {
        auto c = mp.upper_bound(x);
        if (c == mp.end()) break;
        if (c->second.first > y) {
          mp.erase(c);
        } else {
          break;
        }
      }
      if ((--mp.upper_bound(x))->second.first > y) mp[x] = {y, i};
    }

    for (int i = 0; i < n; i++) {
      if ((--mp.lower_bound(coord1[i].first))->second.first <
          coord1[i].second) {
        ans[i] = (--mp.lower_bound(coord1[i].first))->second.second + 1;
      } else if ((--mp.lower_bound(coord1[i].second))->second.first <
                 coord1[i].first) {
        ans[i] = (--mp.lower_bound(coord1[i].second))->second.second + 1;
      } else {
        ans[i] = -1;
      }
    }
    for (int x : ans) {
      cout << x << " ";
    }
    cout << endl;
  }
}