//
//  Flatten_Binary_Tree_to_Linked_ListTest.swift
//  SolutionsTests
//
//  Created by Steven McCracken on 7/28/18.
//  Copyright © 2018 Steven McCracken. All rights reserved.
//

import XCTest
@testable import Solutions

class Flatten_Binary_Tree_to_Linked_ListTest: XCTestCase {
  let solution = Flatten_Binary_Tree_to_Linked_List()
  func test1() {
    let root = TreeNode(1)
    root.left = TreeNode(2)
    root.left?.left = TreeNode(3)
    root.left?.right = TreeNode(4)
    root.right = TreeNode(5)
    root.right?.right = TreeNode(6)

    solution.flatten(root)
  }
}
