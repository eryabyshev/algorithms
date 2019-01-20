

def workWithInputData():
    enter = input()
    count = enter.split(' ')[0]
    lenght = enter.split(' ')[1]

    map = {}
    for i in range(int(count)):
        next = input()
        key = next.split(':')[0].strip()
        value = next.split(':')[1].strip()
        map[key] = value

    code = input()
    return map, code




class Node:
    def __init__(self, value):
        self.__value = value
        self.__left = None
        self.__right = None
        self.__parent = None

    def getValue(self):
        return self.__value
    def getLeft(self):
        return self.__left
    def getRight(self):
        return self.__right
    def getParent(self):
        return self.__parent
    def setParent(self, node):
        self.__parent = node
    def setLeft(self, node):
        self.__left = node
    def setRight(self, node):
        self.__right = node


class Three:
    def __init__(self, map):
        self.__root = Node('')
        self.__doThree(map)


    def __doThree(self, map):
        for key, value in map.items():
            self.__add(Node(key), value)

    def __addLetterInThree(self, parentNode, targetNode, pref):
        if(pref == '0'):
            parentNode.setLeft(targetNode)
        else:
            parentNode.setRight(targetNode)

    def __add(self, node, code):
        tempNode = self.__root
        for i in range(len(code) - 1):
            if(code[i] == '0'):
                if tempNode.getLeft() == None:
                    tempNode.setLeft(Node(''))
                tempNode = tempNode.getLeft()
            else:
                if tempNode.getRight() == None:
                    tempNode.setRight(Node(''))
                tempNode = tempNode.getRight()
        self.__addLetterInThree(tempNode, node, code[-1])

    def deciptCode(self, code):
        result = ''
        node = self.__root
        for i in code:
            if i == '0':
                node = node.getLeft()
            else:
                node = node.getRight()
            if len(node.getValue()) == 1:
                result += node.getValue()
                node = self.__root
        return result



map, code = workWithInputData()

three = Three(map)
result = three.deciptCode(code)
print(result)