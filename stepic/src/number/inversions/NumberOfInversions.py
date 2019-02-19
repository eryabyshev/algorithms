

def read_input_date():
    input()
    array = input().split(" ")
    return array

def main():
    merger = Merge()
    print(merger.get_number_of_inversions(read_input_date()))


class Merge:
    def __int__(self):
        self.__number_of_inversion = 0

    def __merge(self, left, right):
        result = []
        left_counter = 0
        right_counter = 0
        for i in range(len(left) + len(right)):
            if right_counter == len(right) or (left_counter < len(left) and int(left[left_counter]) <= int(right[right_counter])):
                result.append(left[left_counter])
                left_counter += 1
            else:
                self.__number_of_inversion += len(left) - left_counter
                result.append(right[right_counter])
                right_counter += 1
        return result

    def sort(self, array):
        if len(array) == 1:
            return array
        mid = len(array) // 2
        left = array[:mid]
        right = array[mid:]
        left = self.sort(left)
        right = self.sort(right)
        return self.__merge(left, right)

    def get_number_of_inversions(self, array):
        self.__number_of_inversion = 0
        self.sort(array)
        return self.__number_of_inversion


main()