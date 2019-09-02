#include <iostream>

uint64_t nextNumber(int n) {
    uint64_t sum = 0;
    
    while (n > 0) {
        uint64_t i = n%10;
        sum += i*i;
        n/=10;
    }

    return sum;
}

// _n_ is starting num
int getChain(int n) {
    do {
        n = nextNumber(n);
    } while (n != 89 && n != 1);

    return n;
}

main() {
    int LIMIT = 10000000;
    int sum = 0;

    for (int i=1; i<LIMIT; i++)
        if (getChain(i) == 89)
            sum++;

    std::cout << sum;
}