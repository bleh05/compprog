
// Problem: B. Fair Division
// Contest: Codeforces - Codeforces Round #693 (Div. 3)
// URL: https://codeforces.com/contest/1472/problem/B
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
    for (int i = 0; i < n; i++) cin >> arr[i];
    int sum = 0;
    int cnt1 = 0;
    int cnt2 = 0;
    for (int x : arr) {
      sum += x;
      if (x == 1)
        cnt1++;
      else
        cnt2++;
    }
    if (cnt2 & 1 && cnt1 < 2 || sum % 2 == 1) {
      cout << "NO" << endl;
    } else {
      cout << "YES" << endl;
    }
  }
}