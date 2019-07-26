#include <iostream>

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

    public:
        LinkedList<T>();
        void add(const T& item);
        void getList(callback);
};

template <typename T>
LinkedList<T>::LinkedList() {
    head = NULL;
    tail = NULL;
}

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

template <typename T>
void LinkedList<T>::getList(LinkedList callback) {
    node<T> *pos = head;

    do {
        std::cout << "Data: " << pos->data << "\n";
    } while((pos = pos->next) != NULL);
}