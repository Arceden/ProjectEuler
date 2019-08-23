/*
    Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:
        1634 = 1^4 + 6^4 + 3^4 + 4^4
        8208 = 8^4 + 2^4 + 0^4 + 8^4
        9474 = 9^4 + 4^4 + 7^4 + 4^4
    As 1 = 1^4 is not a sum it is not included.
    The sum of these numbers is 1634 + 8208 + 9474 = 19316.
    Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
*/

#include <iostream>

/**
 * Calculate n^pow
 */
uint64_t power(int n, int pow) {
    uint64_t s = n;
    for (int i=0; i<pow-1; i++)
        s *= n;

    return s;
}

/**
 * Calculate the power of every digits and return the sum of all power calculations
 */
uint64_t getPowerDigits(int n, int pow) {
    uint64_t s = 0;
    while (n>0) {
        s += power(n%10, pow);
        n/=10;
    }

    return s;
}

main() {
    uint32_t limit = 100000000;
    int pow = 5;
    int sum = 0;

    for (uint64_t i=2; i<limit; i++) {
        int n = getPowerDigits(i, pow);
        if (n == i) {
            sum += i;
            std::cout << n << "\n";
        }
    }

    std::cout << "\nSum: " << sum;
}