/*
    145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
    Find the sum of all numbers which are equal to the sum of the factorial of their digits.
    Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 */

#include <iostream>

int factorial(int n) {
    if (n <= 1)
        return 1;

    return n * factorial(n-1);
}

int digitSum(int n) {
    int sum = 0;
    while (n > 0) {
        sum += factorial(n%10);
        n/=10;
    }
    return sum;
}

main() {
    int LIMIT = 100000;
    int sum = 0;

    for (int i=3; i<LIMIT; i++)
        if (digitSum(i) == i)
            sum += i;
    
    std::cout << sum;
}