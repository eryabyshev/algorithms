
def frequency(word):
    result = dict()
    for i in word:
        if i in result:
            temp = result[i]
            result[i] = temp + 1
        else:
            result[i] = 1
    return result


def convertDictToList(dict):
    result = []
    for key, value in dict.items():
        result.append(Node(value, key))
    return result



class Node:
    def __init__(self, price, value):
        self.__price = price
        self.__value = value
        self.__left = None
        self.__right = None
        self.__parent = None
    def __init__(self, left, right):
        if(left.getPrice() >= right.getPrice()):
            self.__left = right
            self.__right = left
        else:
            self.__left = left
            self.__right = right
        self.__price = left.getPrice() + right.getPrice()
        self.__value = left.getValue() + right.getValue()
        left.setParent(self)
        right.setParent(self)


    def getLeft(self):
        return self.__left
    def setLeft(self, node):
        self.__left = node
    def getRight(self):
        return self.__right
    def setRight(self, node):
        self.__right = node
    def getPrice(self):
        return self.__price
    def getParent(self):
        return self.__parent
    def setParent(self, node):
        self.__parent = node
    def print(self):
        print(self.__value, self.__price)
    def getValue(self):
        return self.__value



def doThree(nodeList):
    pass


def doNode(left, right):
    return Node



word = input()

list = sorted(convertDictToList(frequency(word)), key=lambda x: x.getPrice(), reverse=True)

for i in list:
    i.print()

