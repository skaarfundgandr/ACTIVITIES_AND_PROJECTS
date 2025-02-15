# Merge sort implementation in Python
def merge(array: list[int], left, mid, right):
    rightSize = mid - left + 1
    leftSize = right - mid
    # Create two subarrays from main array
    leftArray = [array[left + i] for i in range(rightSize)]
    rightArray = [array[mid + i + 1] for i in range(leftSize)]

    rightIndex = leftIndex = 0
    currentIndex = left
    # Sort step: Arranges the elements from lowest to highest
    while rightIndex < rightSize and leftIndex < leftSize:
        if leftArray[rightIndex] <= rightArray[leftIndex]:
            array[currentIndex] = leftArray[rightIndex]
            rightIndex += 1
        else:
            array[currentIndex] = rightArray[leftIndex]
            leftIndex += 1
        currentIndex += 1
    # Add remaining elements of left array back to main array if there is any
    while rightIndex < rightSize:
        array[currentIndex] = leftArray[rightIndex]
        currentIndex += 1
        rightIndex += 1
    # Add remaining elements of right array to main array if there is any
    while leftIndex < leftSize:
        array[currentIndex] = rightArray[leftIndex]
        currentIndex += 1
        leftIndex += 1

def mergeSort(array: list[int], left, right):
    if left < right:
        mid = left + (right - left) // 2 # Avoids stack overflow error if left is large
        # Recursively divide the array
        mergeSort(array, left, mid)
        mergeSort(array, mid + 1, right)
        # Merge and sort
        merge(array, left, mid, right)
# Test case
if __name__ == "__main__":
    array = [5, 3, 2, 7, 1, 9, 0, 8, 6]
    print(f"Unsorted:\n{array}\n")

    mergeSort(array, 0, len(array) - 1)

    print(f"Sorted:\n{array}")