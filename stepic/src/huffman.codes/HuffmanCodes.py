
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
        result.append(Node(price=value, value=key))
    return result



class Node:
    def __init__(self, price=None, value=None, left=None, right=None):
        if(price != None and value != None):
            self.__price = price
            self.__value = value
            self.__left = None
            self.__right = None
            self.__parent = None
        if(left != None and right != None):
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
        self.__visited = False


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
    def getParentNode(self):
        return self.__parent
    def setParent(self, node):
        self.__parent = node
    def print(self):
        print(self.__value, self.__price)
    def getValue(self):
        return self.__value
    def visited(self):
        if(self.getLeft() == None and self.getRight() == None):
            self.__visited = True
            return
        if(self.getLeft().isVisited and self.getRight().isVisited()):
            self.__visited = True
    def isVisited(self):
        return self.__visited

def doThree(nodeList):
    if(len(nodeList) == 1):
        return nodeList
    nodeList.sort(key=lambda x: x.getPrice(), reverse=True)
    node = Node(left=nodeList.pop(len(nodeList) - 1), right=nodeList.pop(len(nodeList) - 1))
    nodeList.append(node)
    doThree(nodeList)
    return nodeList


def printCodesForEachLetter(root, letter):
    pass


def visitNode(node, code, map, pref):
    if(not node.isVisited()):
        node.visited()
        code.append(pref)
        if(node.getLeft() == None and node.getRight() == None):
            map[node.getValue()] = str(code).strip('[]').replace(', ', '')
            code.pop()
            node = node.getParentNode()
        else:
            searchInThree(node, code, map)
        return node, map, code
    return node.getParentNode(), map, code

def searchInThree(root, code=[], map = {}):
    #left
    node = root.getLeft()
    node, map, code = visitNode(node, code, map, 0)
    #right
    node = node.getRight()
    node, map, code = visitNode(node, code, map, 1)
    node.visited()
    if(len(code) > 0):
        code.pop()
        map = searchInThree(node.getParentNode(), code, map)
    return map

word = input()
three = doThree(convertDictToList(frequency(word)))
map = searchInThree(three[0])
a = 10

#list = sorted(convertDictToList(frequency(word)), key=lambda x: x.getPrice(), reverse=True)

# for i in list:
#     i.print()

