def binarySearch(target: int, array: list[int]) -> int:
    mid = left = 0
    right = len(array) - 1

    while left <= right:
        mid = (right + left) // 2

        if array[mid] < target:
            left = mid + 1
        elif array[mid] > target:
            right = mid - 1
        else:
            return mid

    return -1

if __name__ == "__main__":
    # Test condition
    array = [1, 2, 3, 4, 5, 7, 10]

    print(f"Element found at index: {binarySearch(10, array)}")