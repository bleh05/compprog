
// Problem: C. No More Inversions
// Contest: Codeforces - Educational Codeforces Round 102 (Rated for Div. 2)
// URL: https://codeforces.com/contest/1473/problem/C
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
    int n, k;
    cin >> n >> k;
    int perm[k];
    memset(perm, 0, sizeof perm);
    int ptr = 0;
    for (int i = 0; i < k; i++) {
      perm[ptr++] = i + 1;
    }
    reverse(perm + k * 2 - n - 1, perm + k);
    for (int i = 0; i < k; i++) {
      cout << perm[i] << " ";
    }
    cout << "\n";
  }
}