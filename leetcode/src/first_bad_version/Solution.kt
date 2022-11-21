package first_bad_version

class Solution {



    open class VersionControl {
        fun isBadVersion(version: Int) : Boolean {
            return version == 4
        }
    }


    class Solution: VersionControl() {
        fun firstBadVersion(n: Int) : Int {
            var from = 1
            var to = n

            while (from < to) {
                val mid = from + (to - from) / 2

                if(isBadVersion(mid)) {
                    to = mid
                } else {
                    from = mid + 1
                }
            }

            return from
        }
    }
}