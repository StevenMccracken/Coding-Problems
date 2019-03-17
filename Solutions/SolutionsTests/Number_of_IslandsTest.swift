//
//  Number_of_IslandsTest.swift
//  SolutionsTests
//
//  Created by Steven McCracken on 7/28/18.
//  Copyright © 2018 Steven McCracken. All rights reserved.
//

import XCTest
@testable import Solutions

class Number_of_IslandsTest: XCTestCase {
  let solution = Number_of_Islands()
  func test1() {
    let grid = [
      [Character("1"),Character("1"),Character("1"),Character("1"),Character("0")],
      [Character("1"),Character("1"),Character("0"),Character("1"),Character("0")],
      [Character("1"),Character("1"),Character("0"),Character("0"),Character("0")],
      [Character("0"),Character("0"),Character("0"),Character("0"),Character("0")],
    ]

    let result = solution.numIslands(grid)
    XCTAssertEqual(result, 1)
  }
}
