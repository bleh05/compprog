
// Problem: B - Box and Ball
// Contest: AtCoder - AtCoder Grand Contest 002
// URL: https://atcoder.jp/contests/agc002/tasks/agc002_b
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, m;
  cin >> n >> m;
  int arr[n];
  int red[n];
  for (int i = 0; i < n; i++) arr[i] = 1;
  memset(red, 0, sizeof red);
  red[0] = 1;
  for (int i = 0; i < m; i++) {
    int l, r;
    cin >> l >> r;
    l--;
    r--;
    arr[l]--;
    if (red[l]) red[r] = 1;
    arr[r]++;
    if (arr[l] == 0) red[l] = 0;
  }
  int c = 0;
  for (int x : red) {
    c += x;
  }
  cout << c << endl;
}