
// Problem: C. New Game Plus!
// Contest: Codeforces - Codeforces Round #687 (Div. 1, based on Technocup 2021
// Elimination Round 2) URL: https://codeforces.com/contest/1456/problem/C
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, k;
  cin >> n >> k;
  multiset<ll> s = {};
  vector<int> v = {};
  vector<int> pos = {};
  ll d = 0;
  ll sum = 0;
  for (int i = 0; i < n; i++) {
    int c;
    cin >> c;
    if (c < 0) {
      v.push_back(c);
    } else {
      pos.push_back(c);
    }
  }
  sort(v.begin(), v.end());
  sort(pos.begin(), pos.end());
  reverse(pos.begin(), pos.end());
  reverse(v.begin(), v.end());
  for (int x : pos) {
    sum += d;
    d += x;
  }
  s.insert(d);
  for (int i = 0; i < k; i++) {
    s.insert(0);
  }
  for (int x : v) {
    auto rr = --s.lower_bound(1e18);
    s.erase(rr);
    sum += *rr;
    ll kk = *rr + x;
    s.insert(kk);
  }
  cout << sum << endl;
}