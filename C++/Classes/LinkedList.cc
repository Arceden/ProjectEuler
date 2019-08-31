#include "LinkedList.h"
#include <functional>

/**
 * LinkedList implementation
 */

/**
 * Private methods
 * ===============
 */
template <typename T>
node<T> * LinkedList<T>::getNode(int index) {
    node<T> *tmp = head;

    while(index > 0) {
        tmp = tmp->next;
        index = index - 1;
    }

    return tmp;
};

/**
 * Public methods
 * ===============
 */
template <typename T>
LinkedList<T>::LinkedList(){
    head = NULL;
    tail = NULL;
}

/**
 * Add a new node to the LinkedList
 */
template <typename T>
void LinkedList<T>::add(const T& item) {
    node<T> *tmp = new node<T>;
    tmp->data = item;
    tmp->next = NULL;

    if (head == NULL) {
        head = tmp;
        tail = tmp;
    } else {
        tail->next = tmp;
        tail = tail->next;
    }
}

/**
 * Loop through all nodes and send all data through the callback function
 */
template <typename T>
void LinkedList<T>::forEach(std::function<void(T)> callback) {
    node<T> *pos = head;

    if (pos == NULL)
        return;

    do {
        callback(pos->data);
    } while((pos = pos->next) != NULL);
}

template <typename T>
bool LinkedList<T>::contains(T query) {
    if (size() == 0)
        return false;

    bool res = false;

    forEach([&query, &res](T item) {
        if (query == item)
            res = true;
    });

    return res;
}

template <typename T>
int LinkedList<T>::occurance(T query) {
    if (size() == 0)
        return 0;

    int sum = 0;

    forEach([&query, &sum](T item) {
        if (query == item)
            sum++;
    });

    return sum;
}

/**
 * Get the size of the LinkedList
 */
template <typename T>
int LinkedList<T>::size() {
    int sum = 0;

    forEach([&sum](int n){
        sum++;
    });

    return sum;
}

/**
 * Add the contents of the provided list to the tail of the current list
 */
template <typename T>
void LinkedList<T>::prepend(LinkedList<T> list) {
    list.forEach([&](T item) {
        add(item);
    });
};

/**
 * Get the specified data from index
 */
template <typename T>
T LinkedList<T>::get(int index) {
    return getNode(index)->data;
}

/**
 * Remove the specified node index
 */
template <typename T>
void LinkedList<T>::remove(int index) {
    node<T> *parent;
    node<T> *new_next = getNode(index+1);

    // Check if index is head
    if (index < 1) {
        parent = head;
    } else {
        parent = getNode(index-1);
    }

    // Check if index is tail
    if (index >= size()) {
        tail = NULL;
    }


    parent->next = new_next;
}

/**
 * Remove all duplicate entries
 */
template <typename T>
void LinkedList<T>::distinct() {
    // Parent position, Child position
    int ppos = 0, cpos = 0;
    node<T> *parent = head;

    // Loop through all parent values
    do {
        node<T> *child = parent;

        // Loop through all child values
        while((child = child->next) != NULL) {
            cpos++;

            if (parent->data == child->data) {
                child = parent;     // Go back to parent to continue
                remove(cpos);       // Remove duplicate entry
                break;
            }
        };

        ppos++;
        cpos = ppos;
    }
    while((parent = parent->next) != NULL);
}