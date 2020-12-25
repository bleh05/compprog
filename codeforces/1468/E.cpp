
// Problem: E. Four Segments
// Contest: Codeforces - 2020-2021 ICPC, NERC, Southern and Volga Russian
// Regional Contest (Online Mirror, ICPC Rules) URL:
// https://codeforces.com/contest/1468/problem/E Memory Limit: 512 MB Time
// Limit: 2000 ms Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    int arr[4];
    cin >> arr[0] >> arr[1] >> arr[2] >> arr[3];
    sort(arr, arr + 4);
    cout << arr[0] * arr[2] << endl;
  }
}