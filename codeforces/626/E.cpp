
// Problem : E. Simple Skewness
// Contest : Codeforces - 8VC Venture Cup 2016 - Elimination Round
// URL : https://codeforces.com/contest/626/problem/E
// Memory Limit : 256 MB
// Time Limit : 3000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int mxn = 2e5+5;
int n;
int arr[mxn];
ll pref[mxn];
int main() {
	cin >> n;
	for(int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	sort(arr, arr+n);
	for(int i = 0; i < n; i++) {
		pref[i+1] = pref[i] + arr[i];
	}
	int maxind = 0;
	int maxst = 0;
	ll nummax = 0;
	ll denomax = 1;
	for(int i = 0; i < n; i++) {
		int l = 0;
		int r = min(n-i-1, i);
		while(r - l > 5) {
			int m1 = l + (r - l) / 3;
			int m2 = r - (r - l) / 3;
			ll sum1 = (pref[n] - pref[n - m1] + arr[i] + pref[i] - pref[i - m1]) * (m2 * 2 + 1);
			ll sum2 = (pref[n] - pref[n - m2] + arr[i] + pref[i] - pref[i - m2]) * (m1 * 2 + 1);
			if(sum1 < sum2) {
				l = m1;
			}
			else {
				r = m2;
			}
		}
		int currst = 0;
		ll currnum = 0;
		ll currdeno = 1;
		l = max(0, l - 5);
		for(; l <= min(r + 5, min(n - i - 1, i)); l++) {
			ll num = (pref[n] - pref[n - l] + arr[i] + pref[i] - pref[i - l]);
			ll deno = (l * 2.0 + 1);
			if(num * currdeno > currnum * deno) {
				currst = l;
				currnum = num;
				currdeno = deno;
			}
		}
		if((currnum - arr[i] * currdeno) * denomax > nummax * currdeno) {
			nummax = currnum - arr[i] * currdeno;
			denomax = currdeno;
			maxst = currst;
			maxind = i;
		}
	}
	cout << (maxst * 2 + 1) << endl;
	for(int i = maxind - maxst; i <= maxind; i++) 
		cout << arr[i] << " ";
	for(int i = n - maxst; i < n; i++) {
		cout << arr[i] << " ";
	} 
	cout << endl;
}