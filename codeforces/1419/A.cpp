
// Problem : A. Digit Game
// Contest : Codeforces - Codeforces Round #671 (Div. 2)
// URL : https://codeforces.com/contest/1419/problem/0
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
	while(t-- > 0 ) {
		int n;
		cin >> n;
		string s;
		cin >> s;
		if(n & 1) {
			for(int i = 0; i < n; i += 2) {
				if((s[i] - '0') & 1) {
					cout << 1 << endl;
					break;
				}
				if(i == n - 1) {
					cout << 2 << endl;
				}
			}
		}
		else {
			for(int i = 1; i < n; i += 2) {
				if(((s[i] - '0') & 1) == 0) {
					cout << 2 << endl;
					break;
				}
				if(i == n - 1) {
					cout << 1 << endl;
				}
			}
		}
	}
}