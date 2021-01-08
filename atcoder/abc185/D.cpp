
// Problem: D - Stamp
// Contest: AtCoder - AtCoder Beginner Contest 185
// URL: https://atcoder.jp/contests/abc185/tasks/abc185_d
// Memory Limit: 1024 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int m, n;
  cin >> m >> n;
  vector<int> v;
  for (int i = 0; i < n; i++) {
    int k;
    cin >> k;
    v.push_back(k);
  }
  v.push_back(0);
  v.push_back(m + 1);
  int mdiff = 1000000000;
  sort(v.begin(), v.end());
  for (int i = 0; i < v.size() - 1; i++) {
    int c = v[i + 1] - v[i] - 1;
    if (c) mdiff = min(c, mdiff);
  }
  int sum = 0;
  for (int i = 0; i < v.size() - 1; i++) {
    int c = v[i + 1] - v[i] - 1;
    sum += (c + mdiff - 1) / mdiff;
  }
  cout << sum << endl;
}