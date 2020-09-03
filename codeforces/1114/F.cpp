#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

const int mx = 4e5+5;

ll orseg[4*mx];
ll prodseg[4*mx];
ll lazyor[4*mx];
ll lazyprod[4*mx];
ll mod = 1e9 + 7;
ll primes[62];
ll inv[62];
int arr[mx];

int n, m;

ll binpow(ll a, ll b) {
	ll prod = 1;
	while(b > 0) {
		if(b & 1) prod = prod * a % mod;
		a = a * a % mod;
		b >>= 1;
	}
	return prod;
}


void buildOrSeg(int v, int tl, int tr) {
	if(tl == tr) {
		ll mask = 0;
		for(int i = 0; i < 62; i++) {
			if(arr[tl] % primes[i] == 0) {
				mask |= 1ll<<i;
			}
		}
		orseg[v] = mask;
	}
	else {
		int tm = (tl + tr) >> 1;
		buildOrSeg(v*2, tl, tm);
		buildOrSeg(v*2+1, tm+1, tr);
		orseg[v] = orseg[v*2] | orseg[v*2+1];
	}
}

void buildProdSeg(int v, int tl, int tr) {
	if(tl == tr) 
		prodseg[v] = arr[tl];
	else {
		int tm = (tl + tr) >> 1;
		buildProdSeg(v*2, tl, tm);
		buildProdSeg(v*2+1, tm+1, tr);
		prodseg[v] = prodseg[v*2] * prodseg[v*2+1] % mod;
	}
}

ll rangeOr(int v, int tl, int tr, int l, int r) {
	if(tr < l || tl > r)
		return 0;
	if(tl >= l && tr <= r){
		return orseg[v];
	}
	else {
		int tm = (tl + tr) >> 1;
		if(lazyor[v] != 0){
			orseg[2*v] |= lazyor[v];
			orseg[2*v+1] |= lazyor[v];
			lazyor[2*v] |= lazyor[v];
			lazyor[2*v+1] |= lazyor[v];
			lazyor[v] = 0;
		}
		return rangeOr(v*2, tl, tm, l, r) | rangeOr(v*2+1, tm+1, tr, l, r);
	}
}

ll rangeProd(int v, int tl, int tr, int l, int r) {
	if(tr < l || tl > r)
		return 1;
	if(tl >= l && tr <= r) {
		return prodseg[v];
	}
	else {
		int tm = (tl + tr) >> 1;
		if(lazyprod[v] != 1){
			prodseg[v*2] *= binpow(lazyprod[v], tm - tl + 1);
			prodseg[v*2] %= mod;
			lazyprod[2*v] *= lazyprod[v];
			lazyprod[2*v] %= mod;
			prodseg[v*2+1] *= binpow(lazyprod[v], tr - tm);
			prodseg[v*2+1] %= mod;
			lazyprod[2*v+1] *= lazyprod[v];
			lazyprod[2*v+1] %= mod;
			lazyprod[v] = 1;
		}
		return rangeProd(v*2, tl, tm, l, r) * rangeProd(v*2+1, tm+1, tr, l, r) % mod;
	}
}

void updateOr(int v, int tl, int tr, int l, int r, ll mask) {
	if(tr < l || tl > r)
		return;
	if(tl >= l && tr <= r) {
		orseg[v] |= mask;
		lazyor[v] |= mask;
	}
	else {
		int tm = (tl + tr) >> 1;
		if(lazyor[v] != 0){
			orseg[2*v] |= lazyor[v];
			orseg[2*v+1] |= lazyor[v];
			lazyor[2*v] |= lazyor[v];
			lazyor[2*v+1] |= lazyor[v];
			lazyor[v] = 0;
		}
		updateOr(v*2, tl, tm, l, r, mask);
		updateOr(v*2+1, tm+1, tr, l, r, mask);
		orseg[v] = orseg[v*2+1] | orseg[v*2];
	}
}
void updateProd(int v, int tl, int tr, int l, int r, int val) {
	if(tr < l || tl > r)
		return;
	if(tl >= l && tr <= r) {
		prodseg[v] *= binpow(val, tr - tl + 1);
		prodseg[v] %= mod;
		lazyprod[v] *= val;
		lazyprod[v] %= mod;
	}
	else {
		int tm = (tl + tr) >> 1;
		if(lazyprod[v] != 1){
			prodseg[v*2] *= binpow(lazyprod[v], tm - tl + 1);
			prodseg[v*2] %= mod;
			lazyprod[2*v] *= lazyprod[v];
			lazyprod[2*v] %= mod;
			prodseg[v*2+1] *= binpow(lazyprod[v], tr - tm);
			prodseg[v*2+1] %= mod;
			lazyprod[2*v+1] *= lazyprod[v];
			lazyprod[2*v+1] %= mod;
			lazyprod[v] = 1;
		}
		updateProd(v*2, tl, tm, l, r, val);
		updateProd(v*2+1, tm+1, tr, l, r, val);
		prodseg[v] = prodseg[v*2+1] * prodseg[v*2] % mod;
	}
}

int main() {
	for(int i = 0; i < 4*mx; i++) {
		prodseg[i] = 1;
		lazyprod[i] = 1;
	}
	for(int i = 0; i < mx; i++) arr[i] = 1;
    ios_base::sync_with_stdio(false); 
    cin.tie(NULL);    
	cin >> n >> m;
	for(int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	int ptr = 2;
	primes[0] = 2;
	primes[1] = 3;
	for(int i = 2; i < 300; i++) {
		for(int j = 2; j * j <= i; j++) {
			if(i % j == 0) break;
			if((j+1)*(j+1) > i) {
				primes[ptr++] = i;
			}
		}
	}
	for(int i = 0; i < 62; i++) {
		inv[i] = binpow(primes[i], mod - 2);
	}
	buildOrSeg(1, 0, mx - 1);
	buildProdSeg(1, 0, mx - 1);
	for(int i = 0; i < m; i++) {
		string ch;
		cin >> ch;
		if(ch.compare("TOTIENT") == 0) {
			int l, r;
			cin >> l >> r;
			l--; r--;
			ll mask = rangeOr(1, 0, mx - 1, l, r);
			ll prod = rangeProd(1, 0, mx - 1, l, r);
			for(int i = 0; i < 62; i++) {
				if(mask & (1ll<<i)) {
					prod *= primes[i] - 1;
					prod %= mod;
					prod *= inv[i];
					prod %= mod;
				}
			}
			cout << prod << "\n";
		}
		else {
			int l, r, k;
			cin >> l >> r >> k;
			l--; r--;
			ll mask = 0;
			for(int i = 0; i < 62; i++) {
				if(k % primes[i] == 0) {
					mask |= 1ll<<i;
				}
			}
			updateOr(1, 0, mx - 1, l, r, mask);
			updateProd(1, 0, mx - 1, l, r, k);
		}
	}
}