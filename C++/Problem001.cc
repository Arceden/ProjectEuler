/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. 
 * The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */

#include <iostream>
#include "LinkedList.h"

/**
 * Get multiples from below _n_
 */
LinkedList<int> getMultiples(int step, int max) {
    LinkedList<int> list = LinkedList<int>();

    for(int i=step;i<max;i+=step) {
        list.add(i);
    }

    return list;
}

int main() {
    const int MAX = 1000;

    // Get all multiples
    LinkedList<int> list = getMultiples(3, MAX);
    LinkedList<int> list2 = getMultiples(5, MAX);

    // Make it into one big list
    list.prepend(list2);

    // Remove duplicates
    list.distinct();

    // Get sum of numbers
    int sum = 0;
    list.forEach([&sum](int num){
        sum += num;
    });

    std::cout << "\nSum: " << sum;

    return 0;
}