#include <iostream>
#include <functional>

/**
 * Custom linked list
 */

template <typename T>
struct node {
    T data;
    node *next;
};

template <typename T>
class LinkedList {
    private:
        LinkedList<T> *next;
        node<T> *head, *tail;

        node<T> * getNode(int index) {
            node<T> *tmp = head;

            while(index > 0) {
                tmp = tmp->next;
                index = index - 1;
            }

            return tmp;
        }

    public:
        LinkedList<T>() {
            head = NULL;
            tail = NULL;
        };

        /**
         * Add a new node to the LinkedList
         */
        void add(const T& item) {
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
        void forEach(std::function<void(T)> callback) {
            node<T> *pos = head;

            do {
                callback(pos->data);
            } while((pos = pos->next) != NULL);
        }

        /**
         * Get the size of the LinkedList
         */
        int size() {
            int sum = 0;

            forEach([&sum](int n){
                sum+=n;
            });

            return sum;
        }

        /**
         * Add the contents of the provided list to the tail of the current list
         */
        void prepend(LinkedList<T> list) {
            list.forEach([&](T item) {
                add(item);
            });
        };

        /**
         * Get the specified data from index
         */
        int get(int index) {
            return getNode(index)->data;
        }

        /**
         * Remove the specified node index
         */
        void remove(int index) {
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
        void distinct() {
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
};
