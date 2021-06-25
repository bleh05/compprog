
// Problem: B. Pleasant Pairs
// Contest: Codeforces - Codeforces Round #728 (Div. 2)
// URL: https://codeforces.com/contest/1541/problem/B
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    int n;
    cin >> n;
    int arr[n + 1];
    int pos[2 * n + 1];
    memset(pos, 0x3f, sizeof pos);
    for (int i = 1; i <= n; i++) {
      cin >> arr[i];
      pos[arr[i]] = i;
    }
    ll cnt = 0;
    for (int i = 1; i <= 2 * n; i++) {
      for (int j = 1; j * j < i; j++) {
        if (i % j == 0) {
          int ind1 = j;
          int ind2 = i / j;
          if (pos[ind1] > n || pos[ind2] > n) continue;
          if (pos[ind1] + pos[ind2] == i) cnt++;
        }
      }
    }
    cout << cnt << endl;
  }
}