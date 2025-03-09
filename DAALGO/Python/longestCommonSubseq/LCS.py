def LCS(str1: str, str2: str) -> int:
    table = [0] * len(str1) # Initialize a list of size of str1 to zeroes

    res = 0
    # Iterate through the characters in str2
    for c in str2:
        currLength = 0
        # Iterates through the values in the table
        for idx, value in enumerate(table):
            if currLength < value:
                currLength = value
            elif c == str1[idx]:
                table[idx] = currLength + 1
                res = max(res, currLength + 1) # set res as the largest of both results
    return res
# Test case
if __name__ == "__main__":
    x = "ABCBDAB"
    y = "BDCAB"

    print(LCS(x, y))