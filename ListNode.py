class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def printList(self, head: ListNode):
        cur, listStr = head, "["
        while cur:
            listStr = listStr + str(cur.val) + ","
            cur = cur.next
        listStr = listStr.strip(",")
        listStr = listStr + "]"
        print(listStr)

    def reverseList(self, head: ListNode) -> ListNode:
        cur, prev = head, None
        while cur:
            cur.next, prev, cur = prev, cur, cur.next
        return prev

    def swapPairs(self, head: ListNode) -> ListNode:
        soldier = ListNode(0)
        prev, prev.next = soldier, head
        while prev.next and prev.next.next:
            first = prev.next
            second = first.next
            prev.next, second.next, first.next, prev = second, first, second.next, first
        return soldier.next

    def hasCycle(self, head: ListNode) -> ListNode:
        slow = fast = head
        while fast and fast.next:
            fast, slow = fast.next.next, slow.next
            if fast is slow:
                return True
        return False


class Test:
    def testReverseList(self):
        print("testReverseList start...")
        initList = self.genList(10)
        Solution.printList(None, initList)
        reverseList = Solution.reverseList(None, initList)
        Solution.printList(None, reverseList)
        print("testReverseList end...")

    def testSwapPairs(self):
        print("testSwapPairs start...")
        initList = self.genList(10)
        Solution.printList(None, initList)
        swapPairsList = Solution.swapPairs(None, initList)
        Solution.printList(None, swapPairsList)
        print("testSwapPairs end...")

    def testHasCycle(self):
        print("testHasCycle start...")
        initList = self.genList(10)
        Solution.printList(None, initList)
        hasCycle = Solution.hasCycle(None, initList)
        print(hasCycle)
        initList = self.genCycleList(10)
        #Solution.printList(None, initList)
        hasCycle = Solution.hasCycle(None, initList)
        print(hasCycle)
        print("testHasCycle end...")

    def genList(self, count):
        head = ListNode(0)
        cur = head
        for i in range(count):
            cur.next = ListNode(i + 1)
            cur = cur.next
        return head

    def genCycleList(self, count):
        head = ListNode(0)
        cur = head
        for i in range(count - 1):
            cur.next = ListNode(i + 1)
            cur = cur.next
        cur.next = head
        return head


if __name__ == "__main__":
    test = Test()
    test.testReverseList()
    test.testSwapPairs()
    test.testHasCycle()
