#include <functional>

class Fibonnaci {
    private:
        int number;
        int prev;

    public:
        int term;
        Fibonnaci();
        int next();
        int getTerm(int term);
        void loop(int amount, std::function<void(int)> callback);
        void loopUntilLimit(uint64_t limit, std::function<void(int)> callback);
};