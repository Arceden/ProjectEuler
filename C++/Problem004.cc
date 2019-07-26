// A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
// Find the largest palindrome made from the product of two 3-digit numbers.

#include <iostream>
#include <string>
#include <math.h>

/**
 * Recursive strategy to check if it is a palindrome
 */
bool isPalindrome(std::string item) {
    if (item.length() <= 1) {
        return true;
    } else if (item[0] == item[item.length()-1]) {
        return isPalindrome(item.substr(1, item.length()-2));
    } else {
        return false;
    }
}

main() {

    int highest = 0;
    int digits = 3,
        limit = pow(10, digits);

    // Loop through all posibilities with (x * y)
    for (int x=0; x<limit; x++) {
        for (int y=0; y<limit; y++) {
            int mul = x*y;

            // If this is higher than the current highscore, check if palindrome
            if (mul > highest) {
                std::string str = std::to_string(mul);

                if (isPalindrome(str)) {
                    highest = mul;
                }
            }

        }
    }

    std::cout << "Highest " << digits << " digits palindrome: " << highest;
}