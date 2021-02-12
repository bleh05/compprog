
// Problem: B. Replace and Keep Sorted
// Contest: Codeforces - Codeforces Round #701 (Div. 2)
// URL: https://codeforces.com/contest/1485/problem/B
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, q, k;
  cin >> n >> q >> k;
  int arr[n];
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
  }
  int pref[n + 1];
  pref[0] = 0;
  for (int i = 0; i < n; i++) {
    pref[i + 1] = 0;
    if (i) pref[i + 1] += (arr[i] - arr[i - 1] - 1) + pref[i];
    if (i < n - 1) pref[i + 1] += (arr[i + 1] - arr[i] - 1);
  }
  for (int i = 0; i < q; i++) {
    int l, r;
    cin >> l >> r;
    int s = 0;
    if (l == 1)
      s += arr[0] - 1;
    else
      s += arr[l - 2];
    s += pref[r] - pref[l - 1];
    if (r == n)
      s += k - arr[n - 1];
    else
      s += k - arr[r] + 1;
    cout << s << endl;
  }
}