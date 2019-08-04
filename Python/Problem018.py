# Project Euler Problem 018
# https://projecteuler.net/problem=18

# List for numbers
numbers = list()

# Insert the numbers into a 2 dimensional list
with open('Problem018.txt', 'r') as file:
    for line in file:
        res = line.strip().split(" ")

        # Convert list of strings into a list of integers
        res = list(map(int, res))

        # Add the current list into the parent list
        numbers.append(res)


# Probably the best method is to go from bottom to top
# For testing also go from top to bottom

# First, do stupid way (pick first best choice)
# Keep index position to go left
# Increment index to go right
def top_down_first_best_choice(number_list, print_steps=False):
    index = 0   # Position
    s = 0       # Sum
    for y in number_list:
        if s == 0:
            pass
        else:
            if y[index] > y[index + 1]:
                pass
            else:
                index += 1
        if print_steps:
            print("STEP {}: {}".format(len(y), index))
        s += y[index]
    return s


# Secondly, start from bottom
# This uses a recursive sub-method which checks the weight of a path
# The higher the weight, the better the path
def from_below_first_best_choice(number_list, start_depth, pos_depth, print_steps=False, debug=False):
    index = 0
    s = 0

    # Reverse list to start from bottom
    number_list = number_list[::-1]

    # Find best route from index with depth _n_
    # If debug is enabled, it will show all cases
    def sumRoute(pos, layer, depth):

        # Base cases
        if layer == (len(number_list)-1) or depth == 0:
            if debug:
                print("XX\tBase case!\tLayer: {} of {}\tDepth: {}".format(layer, len(number_list)-1, depth))
            return 0

        # Out of bounds
        if pos < 0 or pos > len(number_list[layer])-1:
            return 0

        # Retreive number
        current = number_list[layer][pos]
        if debug:
            print("X\t", current)

        # Go left and right
        left = sumRoute(pos - 1, layer + 1, depth - 1)
        right = sumRoute(pos, layer + 1, depth - 1)

        layer += 1
        if left > right:
            return current + left
        else:
            return current + right

    # Find best starting point
    # Go through half the list depth
    highest = 0
    for idx, val in enumerate(number_list[0]):
        i = sumRoute(idx, 0, start_depth)
        if i>highest:
            index = idx
            highest = i

    # Result
    res = 0

    # Loop through the layers
    for layer, y in enumerate(number_list):

        # Get current position number
        cur = y[index]

        # Add number to the sum
        res += cur
        print("Current {}".format(cur))

        # Move
        if index != 0 and layer != len(number_list):
            # Show left and right weight
            left = sumRoute(index-1, layer+1, pos_depth)
            right = sumRoute(index, layer+1, pos_depth)

            print("Left weight: {}\tRight weight: {}\n".format(left, right))

            # Choose next step
            if left >= right:
                index -= 1

    return res


# print(top_down_first_best_choice(numbers, True))
print(from_below_first_best_choice(numbers, len(numbers)/8, len(numbers)/4, True))
