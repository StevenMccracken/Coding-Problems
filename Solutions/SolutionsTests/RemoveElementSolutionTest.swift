//
//  RemoveElementSolutionTest.swift
//  SolutionsTests
//
//  Created by Steven McCracken on 3/18/19.
//  Copyright © 2019 Steven McCracken. All rights reserved.
//

import XCTest
@testable import Solutions

class RemoveElementSolutionTest: XCTestCase {
  private var solution: RemoveElementSolution!
  override func setUp() {
    super.setUp()
    solution = RemoveElementSolution()
  }

  func test1() {
    var numbers = [3, 2, 2, 3]
    let output = solution.removeElement(&numbers, 3)
    XCTAssertEqual(output, 2)
    XCTAssertFalse(numbers[0..<2].contains(3))
  }

  func test2() {
    var numbers = [0, 1, 2, 2, 3, 0, 4, 2]
    let output = solution.removeElement(&numbers, 2)
    XCTAssertEqual(output, 5)
    XCTAssertFalse(numbers[0..<5].contains(2))
  }
}
