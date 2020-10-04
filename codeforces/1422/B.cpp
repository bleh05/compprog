#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    int n, m;
    cin >> n >> m;
    int arr[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        cin >> arr[i][j];
      }
    }
    ll c = 0;
    for (int i = 0; i < n / 2; i++) {
      for (int j = 0; j < m / 2; j++) {
        int arrd[] = {arr[i][j], arr[n - i - 1][j], arr[i][m - j - 1],
                      arr[n - i - 1][m - j - 1]};
        sort(arrd, arrd + 4);
        c += 0ll + arrd[3] + arrd[2] - arrd[1] - arrd[0];
      }
    }
    if (n % 2) {
      for (int j = 0; j < m / 2; j++) {
        c += abs(arr[n / 2][j] - arr[n / 2][m - j - 1]);
      }
    }
    if (m % 2) {
      for (int j = 0; j < n / 2; j++) {
        c += abs(arr[j][m / 2] - arr[n - j - 1][m / 2]);
      }
    }
    cout << c << endl;
  }
}