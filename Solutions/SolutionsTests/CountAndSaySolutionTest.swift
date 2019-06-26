//
//  CountAndSaySolutionTest.swift
//  SolutionsTests
//
//  Created by Steven McCracken on 4/16/19.
//  Copyright © 2019 Steven McCracken. All rights reserved.
//

import XCTest
@testable import Solutions

class CountAndSaySolutionTest: XCTestCase {
  private var solution: CountAndSaySolution!
  override func setUp() {
    super.setUp()
    solution = CountAndSaySolution()
  }

  override func tearDown() {
    super.tearDown()
    solution = nil
  }

  func test1() {
    XCTAssertEqual(solution.countAndSay(1), "1")
  }

  func test2() {
    XCTAssertEqual(solution.countAndSay(2), "11")
  }

  func test3() {
    XCTAssertEqual(solution.countAndSay(3), "21")
  }

  func test4() {
    XCTAssertEqual(solution.countAndSay(4), "1211")
  }

  func test5() {
    XCTAssertEqual(solution.countAndSay(5), "111221")
  }
}
