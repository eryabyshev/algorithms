def read_input_date():
    input()
    array = input().split(" ")
    return array



def main():
    array = read_input_date()
    num_of_inv = merge_sort(array)
    print(num_of_inv)


def merge_sort(array, inv=0):
    if len(array) == 1:
        return 0
    if(len(array) > 1):
        mid = len(array) // 2
        left_part = array[:mid]
        right_part = array[mid:]
        left = merge_sort(left_part, inv)
        right = merge_sort(right_part, inv)

        i = 0
        j = 0
        k = 0
        track = 0
        while i < len(left_part) and j < len(right_part):
            if left_part[i] <= right_part[j]:
                array[k] = left_part[i]
                track += 1
                i += 1
                k += 1

            else:
                array[k] = right_part[j]
                inv = inv + (len(left_part) - track)
                j += 1
                k += 1

        while i < len(left_part):
            array[k] = left_part[i]
            i += 1
            k += 1

        while j < len(right_part):
            array[k] = right_part[j]
            j += 1
            k += 1
        return inv + left + right

main()

# 5
#
# 1 2 3 5 4