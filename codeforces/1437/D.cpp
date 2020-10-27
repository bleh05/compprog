
// Problem: D. Minimal Height Tree
// Contest: Codeforces - Educational Codeforces Round 97 (Rated for Div. 2)
// URL: https://codeforces.com/contest/1437/problem/D
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
    int arr[n];
    for (int i = 0; i < n; i++) {
      cin >> arr[i];
    }
    int d = 1;
    int has[n];
    memset(has, 0, sizeof has);
    has[0] = 1;
    for (int i = 1; i < n;) {
      if (has[d - 1] == 0) d++;
      has[d - 1]--;
      i++;
      has[d]++;
      while (i < n && arr[i] > arr[i - 1]) {
        has[d]++;
        i++;
      }
    }
    cout << d << endl;
  }
}