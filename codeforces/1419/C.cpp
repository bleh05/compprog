
// Problem : C. Killjoy
// Contest : Codeforces - Codeforces Round #671 (Div. 2)
// URL : https://codeforces.com/contest/1419/problem/C
// Memory Limit : 256 MB
// Time Limit : 1000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
	int t;
	cin >> t;
	while(t-- > 0) {
		int n; int x;
		cin >> n >> x;
		int arr[n];
		bool good = true;
		bool bad = false;
		int sum = 0;
		for(int i = 0; i < n; i++) {
			cin >> arr[i];
			sum += arr[i] - x;
			if(arr[i] != x) {
				good = false;
			}
			if(arr[i] == x) {
				bad = true;
			}
		}
		if(good) {
			cout << 0 << endl;
			continue;
		}
		if(sum == 0 || bad) {
			cout << 1 << endl;
		}
		else {
			cout << 2 << endl;
		}
	}
}