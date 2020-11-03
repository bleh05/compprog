
// Problem: A. The New Year: Meeting Friends
// Contest: Codeforces - Codeforces Round #375 (Div. 2)
// URL: https://codeforces.com/contest/723/problem/A
// Memory Limit: 256 MB
// Time Limit: 1000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int arr[3];
  cin >> arr[0] >> arr[1] >> arr[2];
  sort(arr, arr + 3);
  cout << arr[2] - arr[0] << endl;
}