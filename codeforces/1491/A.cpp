#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, q;
  cin >> n >> q;
  int ct1 = 0, ct0 = 0;
  int arr[n];
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
    ct1 += arr[i] == 1;
    ct0 += arr[i] == 0;
  }
  for (int i = 0; i < q; i++) {
    int t, p;
    cin >> t >> p;
    if (t == 1) {
      p--;
      if (arr[p] == 1)
        ct0++, ct1--;
      else
        ct0--, ct1++;
      arr[p] = 1 - arr[p];
    } else {
      if (ct1 < p)
        cout << 0 << "\n";
      else
        cout << 1 << "\n";
    }
  }
}