// 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
// What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

#include <iostream>

int start = 1,
    end = 20;

bool hasNoRemainders(int n) {
    for(int i=start;i<end;i++) {
        if (n%i!=0) return false;
    }
    return true;
}

main() {

    int i=0;
    while(!hasNoRemainders(++i)){};
    std::cout << i << " is evenly divisible by all of the numbers from " << start << " to " << end;

}