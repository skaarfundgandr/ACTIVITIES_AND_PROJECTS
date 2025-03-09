def binarySearch(arr: list[int], target, left, right) -> int:
    mid = (right + left) // 2

    if right >= left:
        if target > arr[mid]: # Recursively search on the right if target is larger than the midpoint
            return binarySearch(arr, target, mid + 1, right)
        elif target < arr[mid]: # Recursively search on the left if target is smaller than the midpoint
            return binarySearch(arr, target, left, mid - 1)
        else: # Element is found on the middle index
            return mid
    else: # Element does not exist on the list if right is now greater or equal to the left
        return -1
# Test condition
if __name__ == "__main__":
    array = [1, 2, 3, 4, 5, 9, 10]

    print(f"Element found at index: {binarySearch(array, 8, 0, len(array) - 1)}")