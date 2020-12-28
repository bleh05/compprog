
// Problem: C - BBuBBBlesort!
// Contest: AtCoder - AtCoder Grand Contest 003
// URL: https://atcoder.jp/contests/agc003/tasks/agc003_c
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
  int arr[n];
  int arr2[n];
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
    arr2[i] = arr[i];
  }
  sort(arr2, arr2 + n);
  map<int, int> mp;
  for (int i = 0; i < n; i++) {
    mp[arr[i]] = i;
  }
  int cnt = 0;
  for (int i = 1; i < n; i += 2) {
    cnt += (i - mp[arr2[i]]) % 2 != 0;
  }
  cout << cnt << endl;
}