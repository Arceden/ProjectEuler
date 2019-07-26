// The prime factors of 13195 are 5, 7, 13 and 29.
// What is the largest prime factor of the number 600851475143 ?

#include <iostream>
#include <math.h>
#include "LinkedList.h"

class Prime {
    private:
        int64_t n;
        LinkedList<int> factor_list;

    public:
        Prime(int64_t query) {
            n = query;
        }

        void getFactors() {
            factor_list = LinkedList<int>();
            std::cout << n;
        }
};

main() {
    // int64_t query = 13195;
    // int64_t query = 600851475143;

    int64_t query = 98;

    Prime prime = Prime(query);
    prime.getFactors();

}