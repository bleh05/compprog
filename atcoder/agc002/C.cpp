
// Problem: C - Knot Puzzle
// Contest: AtCoder - AtCoder Grand Contest 002
// URL: https://atcoder.jp/contests/agc002/tasks/agc002_c
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
  int arr[n];
  for (int i = 0; i < n; i++) cin >> arr[i];
  for (int i = 0; i < n - 1; i++) {
    if (arr[i] + arr[i + 1] >= k) {
      cout << "Possible" << endl;
      for (int j = 0; j < i; j++) {
        cout << j + 1 << "\n";
      }
      for (int j = n - 1; j > i; j--) {
        cout << j << "\n";
      }
      exit(0);
    }
  }
  cout << "Impossible" << endl;
}