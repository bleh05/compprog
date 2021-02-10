
// Problem: B. Mike and Shortcuts
// Contest: Codeforces - Codeforces Round #361 (Div. 2)
// URL: https://codeforces.com/contest/689/problem/B
// Memory Limit: 256 MB
// Time Limit: 3000 ms
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
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
  }
  int ans[n];
  memset(ans, 0x3f, sizeof ans);
  ans[0] = 0;
  for (int i = 0; i < n; i++) {
    ans[i] = min(ans[i], ans[i - 1] + 1);
    ans[arr[i] - 1] = min(ans[arr[i] - 1], ans[i] + 1);
  }
  for (int i = n - 2; i >= 0; i--) {
    ans[i] = min(ans[i], ans[i + 1] + 1);
    ans[arr[i] - 1] = min(ans[arr[i] - 1], ans[i] + 1);
  }
  for (int i = 0; i < n; i++) {
    ans[i] = min(ans[i], ans[i - 1] + 1);
    ans[arr[i] - 1] = min(ans[arr[i] - 1], ans[i] + 1);
  }
  for (int i = n - 2; i >= 0; i--) {
    ans[i] = min(ans[i], ans[i + 1] + 1);
    ans[arr[i] - 1] = min(ans[arr[i] - 1], ans[i] + 1);
  }
  for (int i = 0; i < n; i++) {
    ans[i] = min(ans[i], ans[i - 1] + 1);
    ans[arr[i] - 1] = min(ans[arr[i] - 1], ans[i] + 1);
  }
  for (int i = n - 2; i >= 0; i--) {
    ans[i] = min(ans[i], ans[i + 1] + 1);
    ans[arr[i] - 1] = min(ans[arr[i] - 1], ans[i] + 1);
  }
  for (int i = 0; i < n; i++) {
    ans[i] = min(ans[i], ans[i - 1] + 1);
    ans[arr[i] - 1] = min(ans[arr[i] - 1], ans[i] + 1);
  }
  for (int i = n - 2; i >= 0; i--) {
    ans[i] = min(ans[i], ans[i + 1] + 1);
    ans[arr[i] - 1] = min(ans[arr[i] - 1], ans[i] + 1);
  }for (int i = 0; i < n; i++) {
    ans[i] = min(ans[i], ans[i - 1] + 1);
    ans[arr[i] - 1] = min(ans[arr[i] - 1], ans[i] + 1);
  }
  for (int i = n - 2; i >= 0; i--) {
    ans[i] = min(ans[i], ans[i + 1] + 1);
    ans[arr[i] - 1] = min(ans[arr[i] - 1], ans[i] + 1);
  }
  for (int i = 0; i < n; i++) {
    ans[i] = min(ans[i], ans[i - 1] + 1);
    ans[arr[i] - 1] = min(ans[arr[i] - 1], ans[i] + 1);
  }
  for (int i = n - 2; i >= 0; i--) {
    ans[i] = min(ans[i], ans[i + 1] + 1);
    ans[arr[i] - 1] = min(ans[arr[i] - 1], ans[i] + 1);
  }
  for (int i = 0; i < n; i++) {
    ans[i] = min(ans[i], ans[i - 1] + 1);
    ans[arr[i] - 1] = min(ans[arr[i] - 1], ans[i] + 1);
  }
  for (int i = n - 2; i >= 0; i--) {
    ans[i] = min(ans[i], ans[i + 1] + 1);
    ans[arr[i] - 1] = min(ans[arr[i] - 1], ans[i] + 1);
  }
  for (int i = 0; i < n; i++) {
    ans[i] = min(ans[i], ans[i - 1] + 1);
    ans[arr[i] - 1] = min(ans[arr[i] - 1], ans[i] + 1);
  }
  for (int i = n - 2; i >= 0; i--) {
    ans[i] = min(ans[i], ans[i + 1] + 1);
    ans[arr[i] - 1] = min(ans[arr[i] - 1], ans[i] + 1);
  }
  for (int x : ans) {
    cout << x << " ";
  }
  cout << "\n";
}