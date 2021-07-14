#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    int k;
    cin >> k;
    k = (int)ceil(sqrt(k));
    cout << k << endl;
  }
}