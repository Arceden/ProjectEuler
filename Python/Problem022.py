l = list()

# Read the file and parse it into the global array
with open('Problem022.txt', 'r') as file:
    for line in file:
        l = line.replace('"', '').split(',')

# Sort the list in a descending order
l = sorted(l)

# Get the alphabetical score for a name
def getScore(name):
    # Get the worth of a single letter
    def letterScore(letter):
        return ord(letter)-64

    sum = 0
    for letter in name:
        sum += letterScore(letter)

    return sum


solution = 0
for key, name in enumerate(l):
    # Use the list index to use as multiplier
    solution += (key+1) * getScore(name)

# Solution
print("Solution: {}".format(solution))
