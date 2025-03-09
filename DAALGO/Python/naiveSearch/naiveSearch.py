def naiveSearch(text: str, pattern: str) -> list[int]:
    for i in range(len(text)):
        if len(text) < i + len(pattern): # End loop if length of remaining letters is less than length of pattern
            break
        for j in range(len(pattern)): # Sliding window solution
            if text[i + j] != pattern[j]:
                i += j # Increment i by the letters checked to prevent rechecking
                break
            if j == len(pattern) - 1:
                return [i, j + i]
    return [] # Return empty list if pattern start and end indeces are not found
# Test case
if __name__ == "__main__":
    text = "ABCDEFG"
    pattern = "EFG"

    print(naiveSearch(text, pattern))