#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t; while (t--) {
    int l, r;
    cin >> l >> r;
    if (r / l >= 2) {
      cout << "NO" << endl;
    } else
      cout << "YES" << endl;
  }
}