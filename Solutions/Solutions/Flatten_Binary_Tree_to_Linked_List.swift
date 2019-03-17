//
//  Flatten_Binary_Tree_to_Linked_List.swift
//  Solutions
//
//  Created by Steven McCracken on 7/28/18.
//  Copyright © 2018 Steven McCracken. All rights reserved.
//

import Foundation

class Flatten_Binary_Tree_to_Linked_List {
  func flatten(_ root: TreeNode?) {
    guard let root = root else {
      return
    }

    if let left = root.left {
      let right = root.right
      root.right = left
      var tracker = left
      while let moreRight = tracker.right {
        tracker = moreRight
      }

      tracker.right = right

      // root's left has been flattened to the right once, so move right to flatten more
      root.left = nil
      flatten(root.right)
    } else {
      // No more nodes to the left, flatten to the right
      flatten(root.right)
    }
  }
}
