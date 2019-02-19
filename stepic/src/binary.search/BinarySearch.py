import sys

def main():
    reader = (map(int, line.split()) for line in sys.stdin)
    n, *array = next(reader)
    k, *find = next(reader)
    for query in find:
        print(finf_position(array, query), end=" ")


def finf_position(array, find):
    left, right = 0, len(array) - 1

    while left <= right:
        mid = (left + right) // 2
        if find < array[mid]:
            right = mid - 1
        elif find > array[mid]:
            left = mid + 1
        else:
            return mid + 1

    return -1

main()