
// Problem: C. Okabe and Boxes
// Contest: Codeforces - Codeforces Round #420 (Div. 2)
// URL: https://codeforces.com/contest/821/problem/C
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
  int ans = 0;
  int curr = 1;
  set<int> v;
  int bad = 0;
  for (int i = 0; i < 2 * n; i++) {
    string str;
    cin >> str;
    if (str[0] == 'a') {
      int vd;
      cin >> vd;
      v.insert(vd);
      if (*v.lower_bound(0) < vd) bad = *v.lower_bound(0);
    } else {
      if (curr == bad) ans++, bad = 0;
      v.erase(curr++);
    }
  }
  cout << ans << endl;
}