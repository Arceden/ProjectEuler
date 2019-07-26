#include <functional>

class Fibonnaci {
    private:
        int prev = 1;
        int tmp = 0;

    public:
        int term;
        Fibonnaci(){
            term = 0;
        }

        /**
         * Get next term from the Fibonnaci sequence
         */
        int next() {
            if (term == 0) {
                term = 1;
            } else if (term == 1) {
                term = 2;
            } else {
                tmp = term;
                term = prev + term;
                prev = tmp;
            }

            return term;
        }

        /**
         * Loop _n_ amount of times through the sequence
         */
        void loop(int amount, std::function<void(int)> callback) {
            for (int i=0; i<amount; i++) {
                next();
                callback(term);
            }
        }

        /**
         * Keep looping until the term has reached its limit
         */
        void loopUntilLimit(int limit, std::function<void(int)> callback) {
            while(next() < limit) {
                callback(term);
            }
        }
};