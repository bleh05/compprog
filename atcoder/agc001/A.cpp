
// Problem: A - BBQ Easy
// Contest: AtCoder - AtCoder Grand Contest 001
// URL: https://atcoder.jp/contests/agc001/tasks/agc001_a
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
  int arr[2 * n];
  for (int i = 0; i < 2 * n; i++) {
    cin >> arr[i];
  }
  sort(arr, arr + 2 * n);
  int sum = 0;
  for (int i = 0; i < n; i++) {
    sum += arr[i * 2];
  }
  cout << sum << endl;
}