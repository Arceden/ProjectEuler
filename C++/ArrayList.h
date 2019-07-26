#include <iostream>

class ArrayList {
    public:
        ArrayList();
        void add(int num);
        int * getList(void);
    private:
        int size;
        int list[];
};

ArrayList::ArrayList(void) {
    size = 0;
}

void ArrayList::add(int num) {
    std::cout << "Im adding " << num << "\n";
}

int * ArrayList::getList(void) {
    return list;
}