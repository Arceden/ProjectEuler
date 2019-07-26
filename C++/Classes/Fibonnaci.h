#include <functional>

class Fibonnaci {
    private:
        int prev;
        int tmp;

    public:
        int term;
        Fibonnaci();
        int next();
        void loop(int amount, std::function<void(int)> callback);
        void loopUntilLimit(int limit, std::function<void(int)> callback);
};