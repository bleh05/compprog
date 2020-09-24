
// Problem : A. Cubes Sorting
// Contest : Codeforces - Codeforces Round #672 (Div. 2)
// URL : https://codeforces.com/contest/1420/problem/A
// Memory Limit : 256 MB
// Time Limit : 1000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int n;
int arr[100000];
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int t;
    cin >> t;
    while(t-- > 0) {
		cin >> n;
		for(int i = 0; i < n; i++) cin >> arr[i];	
		for(int i = 0; i < n - 1; i++) {	
			if(arr[i] <= arr[i + 1]) {
				cout << "YES" << "\n";
				break;
			}
			if(i == n - 2) {
				cout << "NO" << "\n";
			}
		}
	}
}