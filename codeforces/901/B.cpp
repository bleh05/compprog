#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <stack>
#include <vector>

using namespace std;
vector < int > a,b,t;
int main()
{
    int N,x,ok,i;
    a.push_back(1);
    b.push_back(0);
    scanf("%d",&N);

    for(i=0;i<N;i++)
    {
        ok=1;
        t.clear();
        t.push_back(0);
        for(auto j:a) t.push_back(j);
        x=0;
        for(auto j:b)
        {
            t[x]+=j;
            if(abs(t[x])>=2) ok=0;
            x++;
        }

        if(!ok)
        {
            x=0;
            for(auto j:t)
            {
                if(x) t[x]-=2*a[x-1];
                x++;
            }

        }

        b=a;
        a=t;
    }

    printf("%d\n",a.size()-1);
    for(auto i:a) printf("%d ",i*a[N]);
    printf("\n");

    printf("%d\n",b.size()-1);
    for(auto i:b) printf("%d ",i*b[N-1]);
    printf("\n");
    return 0;
}
