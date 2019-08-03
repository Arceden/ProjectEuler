// If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
// If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
//  NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. 
//  The use of "and" when writing out numbers is in compliance with British usage.

#include <iostream>
#include <string>

using namespace std;

string ones[10] = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
string tens[10] = {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
string special[10] = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
string steps[4] = {"", "teen", "hundred", "thousand"};

string numToWord(string n) {
    // Base case
    if (n.length() == 0) {
        return "";
    }

    // New query
    int q = (int)n[0] - 48;
    int t = (int)n[1] - 48; // Next step
    int f = (int)n[2] - 48; // Next-next step
    int step_size = 1;
    string num;

    switch(n.length() % 4) {
        case 1:
            // Ones
            num = ones[q];
            break;
        case 2:
            // Tens
            if (q == 1){
                num = special[t];
                step_size++;
            } else {
                num = tens[q];
            }

            break;
        case 3:
            if (q != 0) {
                num = ones[q] + steps[2];
                if (t != 0 || f != 0) {
                    num += "and";
                }
            }
            break;
        case 0:
            num = ones[q] + steps[3];
            break;
    }

    return num + numToWord(n.substr(step_size));
}

string numToWord(int n) {
    return numToWord(to_string(n));
}

string rangeToWords(int start, int end) {
    string sequence = "";

    for(int i=start; i<=end; i++) {
        sequence += numToWord(i);
    }

    return sequence;
}

main() {
    
    string sequence = rangeToWords(1, 1000);

    cout << "\nNumber sequence: " << sequence;
    cout << "\nAmount of characters: " << sequence.length();

}
