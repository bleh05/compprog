#include <iostream>
#include <sstream>
#include <string>
#include <vector>
#include <deque>
#include <queue>
#include <set>
#include <map>
#include <algorithm>
#include <functional>
#include <utility>
#include <cmath>
#include <cstdlib>
#include <ctime>
#include <cstdio>

using namespace std;

#define REP(i,n) for((i)=0;(i)<(int)(n);(i)++)
#define foreach(c,itr) for(__typeof((c).begin()) itr=(c).begin();itr!=(c).end();itr++)

typedef long long ll;

bool win(ll A, ll B){
    if(A == 0 || B == 0) return false;
    if(A > B) swap(A,B);
    if(!win(A,B%A)) return true;
    ll N = B / A;
    ll MOD = A + 1;
    return ((N % MOD) % 2 == 0);
}

int main(void){
    int T,t;
    ll A,B;
    
    cin >> T;
    REP(t,T){
        cin >> A >> B;
        bool ans = win(A,B);
        cout << (ans ? "First" : "Second") << endl;
    }
    
    return 0;
}
