//
//  RemovedSortedArrayDuplicatesSolutionTest.swift
//  SolutionsTests
//
//  Created by Steven McCracken on 3/17/19.
//  Copyright © 2019 Steven McCracken. All rights reserved.
//

import XCTest
@testable import Solutions

class RemovedSortedArrayDuplicatesSolutionTest: XCTestCase {
  private var solution: RemovedSortedArrayDuplicatesSolution!
  override func setUp() {
    super.setUp()
    solution = RemovedSortedArrayDuplicatesSolution()
  }

  func test1() {
    var numbers = [1, 1, 2]
    let output = solution.removeDuplicates(&numbers)
    XCTAssertEqual(output, 2)
    XCTAssertEqual(numbers, [1, 2])
  }

  func test2() {
    var numbers = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
    let output = solution.removeDuplicates(&numbers)
    XCTAssertEqual(output, 5)
    XCTAssertEqual(numbers, [0, 1, 2, 3, 4])
  }
}
