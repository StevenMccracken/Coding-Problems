//
//  SearchInsertPositionSolutionTest.swift
//  SolutionsTests
//
//  Created by Steven McCracken on 4/9/19.
//  Copyright © 2019 Steven McCracken. All rights reserved.
//

import XCTest
@testable import Solutions

/**
 Example 1:

 Input: [1,3,5,6], 5
 Output: 2
 Example 2:

 Input: [1,3,5,6], 2
 Output: 1
 Example 3:

 Input: [1,3,5,6], 7
 Output: 4
 Example 4:

 Input: [1,3,5,6], 0
 Output: 0
 */

class SearchInsertPositionSolutionTest: XCTest {
  private var input: [Int]!
  private var solution: SearchInsertPositionSolution!
  override func setUp() {
    super.setUp()
    input = [1, 3, 5, 6]
    solution = SearchInsertPositionSolution()
  }

  override func tearDown() {
    super.tearDown()
    input = nil
    solution = nil
  }

  func test1() {
    XCTAssertEqual(solution.searchInsert(input, 5), 2)
  }

  func test2() {
    XCTAssertEqual(solution.searchInsert(input, 2), 1)
  }

  func test3() {
    XCTAssertEqual(solution.searchInsert(input, 7), 4)
  }

  func test4() {
    XCTAssertEqual(solution.searchInsert(input, 0), 0)
  }
}
