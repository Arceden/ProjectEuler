/*
    The number 3797 has an interesting property. 
    Being prime itself, it is possible to continuously remove digits from left to right, 
     and remain prime at each stage: 3797, 797, 97, and 7. 
    Similarly we can work from right to left: 3797, 379, 37, and 3.
    Find the sum of the only eleven primes that are both truncatable from left to right and right to left.
    NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
 */

#include <iostream>

bool isPrime(int n) {
    if (n == 1)
        return false;
    
    if (n == 2)
        return true;

    if (n % 2 == 0)
        return false;

    for(int i=3; i<n; i+=2) {
        if (n % i == 0)
            return false;
    }

    return true;
}

unsigned int destroyFirstDigit(int n) {
    if (n < 10)
        return 0;
    
    return n%10 + destroyFirstDigit(n/10) * 10;
}

// Had to call it something
bool isMegaPrime(int n) {
    // Check left-right
    int l = n;
    int r = n;
    while (l > 0) {
        if (!isPrime(l))
            return false;
        
        l/=10;
    }

    // Check right-left
    while (r > 0) {
        if (!isPrime(r))
            return false;
        
        r = destroyFirstDigit(r);
    }

    return true;
}

main() {
    int hits = 0;
    int sum = 0;
    int i = 9;
    
    while (hits < 11) {
        if (isMegaPrime(i)) {
            sum+=i;
            hits++;    
        }
        i++;
    }

    std::cout << sum;
}