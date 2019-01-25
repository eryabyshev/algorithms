from enum import Enum
class Comand(Enum):
    INSERT = 1
    EXTRACT_MAX = 2

    @staticmethod
    def comand_fabric(input):
        if 'Insert' in input:
            return Comand.INSERT
        else:
            return Comand.EXTRACT_MAX

class Heap:
    def __init__(self):
        self.__array = []

    def __left_sone(self, i):
        return 2 * i + 1

    def __right_sone(self, i):
        return self.__left_sone(i) + 1

    def __sift_down(self, i):
        while self.__left_sone(i) < len(self.__array):
            left = self.__left_sone(i)
            right = self.__right_sone(i)
            j = left
            if right > len(self.__array) and self.__array[right] > self.__array[left]:
                j = right
            if self.__array[i] >= self.__array[j]:
                break
            self.__swap(self.__array[i], self.__array[j])
            i = j

    def __sift_up(self, i):
        while self.__array[i] > self.__array[int((i - 1) / 2)]:
            temp = self.__array[int((i - 1) / 2)]
            self.__array[int((i - 1)) / 2] = self.__array[i]
            self.__array[int((i - 1)) / 2] = temp
            i = int((i - 1) / 2)

    def __swap(self, a, b):
        temp = b
        b = a
        a = temp

    def __insert(self, element):
        element = int(element)
        self.__array.append(element)
        if len(self.__array) == 1:
            return
        self.__sift_up(len(self.__array) - 1)

    def __extract_max(self):
        max = self.__array[0]
        self.__array[0] = self.__array[len(self.__array) - 1]
        self.__array.pop()
        self.__sift_down(0)
        return max

    def do_command(self, comand):
        comand_type = Comand.comand_fabric(comand)
        if comand_type == Comand.EXTRACT_MAX:
            print(self.__extract_max())
        else:
            self.__insert(comand.split(' ')[1])


def main():
    count = input()
    heap = Heap()
    for i in range(int(count)):
        heap.do_command(input())


main()