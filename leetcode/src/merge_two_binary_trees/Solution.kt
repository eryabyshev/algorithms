package merge_two_binary_trees

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null


    companion object {
        fun fromArray(ar: Array<Int?>): TreeNode {
            val root = TreeNode(ar[0]!!)
            ar.drop(1).forEach { fill(it, root) }
            return root
        }

        private fun fill(value: Int?, root: TreeNode?): TreeNode? {
            if(value == null) {
                return null
            }

            if(root == null) {
                return TreeNode(value)
            }

            if (value < root.`val`) {
                root.left = fill(value, root.left)
            } else if (value > root.`val`) {
                root.right = fill(value, root.right);
            }
            return root;
        }

        fun toArray(root: TreeNode): Array<Int?> {
            val result = mutableListOf<Int?>()
            result.add(root.`val`)
            addInArray(root, result)
            return result.toTypedArray()
        }

        private fun addInArray(root: TreeNode?, list: MutableList<Int?>) {
            if(root == null) {
                return
            }

            list.add(root.left?.`val`)
            list.add(root.right?.`val`)

            addInArray(root.left, list)
            addInArray(root.right, list)
        }

    }

}



class Solution {
    fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
        if(root1 == null) {
            return root2
        }
        if(root2 == null) {
            return root1
        }
        root1.`val` = root1.`val` + root2.`val`
        root1.left = mergeTrees(root1.left, root2.left)
        root1.right = mergeTrees(root1.right, root2.right)
        return root1
    }
}


fun main() {


    Solution().mergeTrees(
        TreeNode.fromArray(arrayOf(1,3,2,5)),
        TreeNode.fromArray(arrayOf(1,3,2,5)),
    )?.let { TreeNode.toArray(it) }.let { println(it?.joinToString(",")) }







//    TreeNode.fromArray(arrayOf(2,1,3,null,4,null,7))
//        .let { TreeNode.toArray(it) }
//        .let { println(it.joinToString(",")) }



}
