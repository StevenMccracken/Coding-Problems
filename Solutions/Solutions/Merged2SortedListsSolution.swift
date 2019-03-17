//
//  Merged2SortedListsSolution.swift
//  Solutions
//
//  Created by Steven McCracken on 3/17/19.
//  Copyright © 2019 Steven McCracken. All rights reserved.
//

import Foundation

class Merge2SortedListsSolution {
  func mergeTwoLists(_ l1: ListNode?, _ l2: ListNode?) -> ListNode? {
    let head = ListNode(0)
    var tracker = head
    var l1 = l1
    var l2 = l2
    while let validL1 = l1, let validL2 = l2 {
      if validL1.val <= validL2.val {
        tracker.next = validL1
        l1 = validL1.next
      } else {
        tracker.next = validL2
        l2 = validL2.next
      }

      tracker = tracker.next!
    }

    tracker.next = l1 ?? l2
    return head.next
  }
}
