/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. 
 * The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */

#include <iostream>
#include "ArrayList.h"
#include "LinkedList.h"

int * getMultiples(int n) {
    // ArrayList a = ArrayList();
    LinkedList<int> a = LinkedList<int>();

    for(int i=0;i<=n;i++) {
        a.add(i);
    }

    a.getList();
}

int main() {
    getMultiples(16);
    return 0;
}