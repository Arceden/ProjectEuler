/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. 
 * The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */

#include <iostream>
#include "Classes/LinkedList.cc"

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

/**
 * Solve with a Custom LinkedList class, because why not
 */
void solveWithClass() {
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
}

/**
 * Short and easy solve
 */
void solveEasy() {
    int sum = 0;
    int limit = 1000;

    for (int i=0; i<limit; i++)
        if (i % 3 == 0 || i % 5 == 0)
            sum += i;

    std::cout << "\nSum: " << sum;
}

int main() {

    solveWithClass();
    solveEasy();

    return 0;
}