print("Enter 10 numbers:")

nums = input().split()

for i in range(len(nums)):
    duplicate = False

    for j in range(i):
        if nums[j] == nums[i]:
            duplicate = True
            break

    if not duplicate:
        print(nums[i], end=" ")
print()