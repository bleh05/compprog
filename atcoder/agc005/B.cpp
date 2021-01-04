
// Problem: B - Minimum Sum
// Contest: AtCoder - AtCoder Grand Contest 005
// URL: https://atcoder.jp/contests/agc005/tasks/agc005_b
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n;
  cin >> n;
  set<int> s;
  s.insert(-1);
  s.insert(n);
  int place[n + 1];
  for (int i = 0; i < n; i++) {
    int c;
    cin >> c;
    place[c] = i;
  }
  ll sum = 0;
  for (int i = 1; i <= n; i++) {
    int l = *(--s.upper_bound(place[i]));
    int r = *(s.upper_bound(place[i]));
    sum += 1ll * (r - place[i]) * (place[i] - l) * i;
    s.insert(place[i]);
  }
  cout << sum << endl;
}