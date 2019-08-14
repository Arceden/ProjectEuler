/**
 * Custom linked list
 */

#include <functional>

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
        node<T> * getNode(int index);

    public:
        LinkedList<T>();
        void add(const T& item);
        void remove(int index);

        void forEach(std::function<void(T)> callback);
        void prepend(LinkedList<T> list);
        void distinct();

        int size();
        T get(int index);
};
