from bisect import bisect_left

def search_recursive(array, element):
    return __search(array, 0, len(array) - 1, element)

def search_loop(array, element):
    left = 0
    right = len(array) - 1
    while left <= right:
        middle = int(left + (right - left)/2)
        if array[middle] == element:
            return middle + 1
        elif array[middle] > element:
            right = middle - 1
        else:
            left = middle + 1
    return -1

def search_loop_2(array, element):
    start = 0
    finish = len(array) - 1
    while start <= finish:
        middle = (start + finish) // 2
        if element < array[middle]:
            finish = middle - 1
        elif element > array[middle]:
            start = middle + 1
        else:
            return middle + 1
    else:
        return -1

def binary_search(a, x, lo=0, hi=None):
    hi = hi if hi is not None else len(a)
    pos = bisect_left(a, x, lo, hi)
    return (pos + 1 if pos != hi and a[pos] == x else -1)

def __search(array, start, finish, element):
    if start >= finish:
        return -1
    middle = int((finish - start)/2) + 1
    if int(array[middle]) == int(element):
        return str(int(middle) + 1)
    elif int(array[middle]) > int(element):
        return __search(array, 0, middle - 1, element)
    else:
        return __search(array, middle + 1, finish, element)

def __ifTwoElements(array, a, b, element):
    if array[a] == element:
        return a
    if array[b] == element:
        return b
    return -2

data = input()
elements = int(data.split(' ')[0])
array = data.split(' ')[1:]
data = input()
count_for_search = int(data.split(' ')[0])
elsements_for_search = data.split(' ')[1:]

for i in elsements_for_search:
    print(binary_search(array, i), sep=' ', end=' ', flush=True)






