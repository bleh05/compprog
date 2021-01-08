
// Problem: A - ABC Preparation
// Contest: AtCoder - AtCoder Beginner Contest 185
// URL: https://atcoder.jp/contests/abc185/tasks/abc185_a
// Memory Limit: 1024 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int a, b, c, d;
  cin >> a >> b >> c >> d;
  cout << min(min(a, b), min(c, d)) << endl;
}