#include <functional>
#include "Fibonnaci.h"

Fibonnaci::Fibonnaci() {
    term = 0;
    number = 1;
    prev = 1;
}

/**
 * Get the number corresponding number from the term
 * (WIP)
 */
int Fibonnaci::getTerm(int term) {
    if (term == 1 || term == 2) 
        return 1;
    else 
        return 0;       
}

/**
 * Get next term from the Fibonnaci sequence
 */
int Fibonnaci::next() {
    term ++;

    if (term == 1 || term == 2)
        return (number = 1);

    int tmp = number;
    number = prev + number;
    prev = tmp;

    return number;
}

/**
 * Loop _n_ amount of times through the sequence
 */
void Fibonnaci::loop(int amount, std::function<void(int)> callback) {
    for (uint64_t i=0; i<amount; i++) {
        callback(next());
    }
}

/**
 * Keep looping until the term has reached its limit
 */
void Fibonnaci::loopUntilLimit(uint64_t limit, std::function<void(int)> callback) {
    while(next() < limit) {
        callback(number);
    }
}
