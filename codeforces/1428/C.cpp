
// Problem: C. ABBB
// Contest: Codeforces - Codeforces Raif Round 1 (Div. 1 + Div. 2)
// URL: https://codeforces.com/contest/1428/problem/C
// Memory Limit: 256 MB
// Time Limit: 1000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t;
  while (t-- > 0) {
    string s;
    cin >> s;
    int n = s.size();
    int arr[n][2];
    memset(arr, 0, sizeof(arr));
    vector<int> vs = {};
    for (int i = 0; i < n; i++) {
      if (i > 0) {
        arr[i][0] += arr[i - 1][0];
        arr[i][1] += arr[i - 1][1];
      }
      if (s[i] == 'A') {
        arr[i][0]++;
        vs.push_back(0);
      }
      if (s[i] == 'B') {
        if (vs.size() == 0) {
          arr[i][1]++;
          vs.push_back(1);
        } else if (arr[i][0] > 0 && *(--vs.end()) == 0) {
          arr[i][0]--;
          vs.erase(--vs.end());
        } else if (arr[i][1] > 0 && *(--vs.end()) == 1) {
          arr[i][1]--;
          vs.erase(--vs.end());
        } else {
          arr[i][1]++;
          vs.push_back(1);
        }
      }
    }
    cout << arr[n - 1][0] + arr[n - 1][1] << endl;
  }
}