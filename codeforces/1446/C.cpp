
// Problem: C. Xor Tree
// Contest: Codeforces - Codeforces Round #683 (Div. 1, by Meet IT)
// URL: https://codeforces.com/contest/1446/problem/C
// Memory Limit: 256 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int minRem(vector<int> ar) {
  if (ar.size() == 0) return 0;
  if (ar.size() == 1) return 1;
  vector<int> ars[31];
  int d = 0;
  for (int i = 0; i < ar.size(); i++) {
    while ((1 << d) <= ar[i]) d++;
    ars[d].push_back(ar[i] ^ (1 << (d - 1)));
  }
  int res[31];
  for (int i = 0; i < 31; i++) {
    res[i] = minRem(ars[i]);
  }
  int ans = 0;
  int sum2 = 0;
  for (int i = 30; i >= 0; i--) {
    int c = 0;
    for (int j = 0; j < i; j++) {
      c += res[j];
    }
    ans = max(min(c, 1) + res[i] + sum2, ans);
    if (res[i] > 0) sum2++;
  }
  return ans;
}

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n;
  cin >> n;
  vector<int> arr;
  for (int i = 0; i < n; i++) {
    int d;
    cin >> d;
    arr.push_back(d);
  }
  sort(arr.begin(), arr.end());
  cout << n - minRem(arr) << endl;
}