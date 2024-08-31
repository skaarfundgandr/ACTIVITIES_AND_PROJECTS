print("Enter 10 numbers:")

nums = input().split()

for i in range(len(nums)):
    duplicate = False # 2, 4, 2 ,6

    for j in range(i):
        if nums[j] == nums[i]:
            duplicate = True
            break

    if not duplicate:
        print(nums[i], end=" ")
print()