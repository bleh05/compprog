
// Problem : D1. Sage's Birthday (easy version)
// Contest : Codeforces - Codeforces Round #671 (Div. 2)
// URL : https://codeforces.com/contest/1419/problem/D1
// Memory Limit : 256 MB
// Time Limit : 1000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int mxn = 1e5+5;
int arr[mxn];
int n;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
	cin >> n;
	for(int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	sort(arr, arr + n);
	int ans[n];
	for(int i = 0; i < n - 1; i += 2) {
		ans[i + 1] = arr[i/2];
	}
	for(int i = 0; i < n; i += 2) {
		ans[i] = arr[n - i / 2 - 1];
	}
	cout << ((n - 1) >> 1) << endl;
	for(int i = 0; i < n; i++) {
		cout << ans[i] << " ";
	}
	cout << endl;
}