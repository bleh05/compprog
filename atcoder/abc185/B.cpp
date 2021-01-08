
// Problem: B - Smartphone Addiction
// Contest: AtCoder - AtCoder Beginner Contest 185
// URL: https://atcoder.jp/contests/abc185/tasks/abc185_b
// Memory Limit: 1024 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int ch, n, end;
  cin >> ch >> n >> end;
  int och = ch;
  int last = 0;
  for (int i = 0; i < n; i++) {
    int l, r;
    cin >> l >> r;
    ch -= l - last;
    if (ch <= 0) {
      cout << "No" << endl;
      exit(0);
    }
    ch += r - l;
    last = r;
    ch = min(och, ch);
  }
  ch -= end - last;

  if (ch <= 0) {
    cout << "No" << endl;
    exit(0);
  }
  cout << "Yes" << endl;
}