class Item:
    def __init__(self, weight, value):
        self.weight = weight
        self.value = value
# Convert a list of weights and values into a list of Items
def itemize(weights: list[float], values: list[float]) -> list[Item]:
    if len(weights) != len(values):
        raise ValueError("Size of both lists must be equal!")

    items: list[Item] = []
    for i in range(len(weights)):
        items.append(Item(weights[i], values[i]))

    return items
# Main logic
def knapsack(capacity: float, itemList: list[Item]) -> float:
    itemList.sort(key=lambda item: item.value / item.weight, reverse=True) # Sorts the items in reverse by value per weight
    currentWeight: float = 0
    finalValue: float = 0
    numberOfItems = len(itemList)
    # Loop through the Item List
    for i in range(numberOfItems):
        # Take the largest item if the item's weight is smaller than the capacity
        if currentWeight + itemList[i].weight <= capacity:
            currentWeight += itemList[i].weight
            finalValue += itemList[i].value
        # Otherwise, only take part of the item
        else:
            finalValue += itemList[i].value / itemList[i].weight * (capacity - currentWeight)
            break

    return finalValue
# Helper function: call only this function
def fractionalKnapsack(capacity, weights: list[float], values: list[float]) -> float:
    items = itemize(weights, values)
    return knapsack(capacity, items)

if __name__ == "__main__":
    weights = [10, 20, 30]
    values = [60, 100, 120]
    capacity = 50

    try:
        solution = fractionalKnapsack(capacity, weights, values)
        print(solution)
    except ValueError as e:
        print(e)