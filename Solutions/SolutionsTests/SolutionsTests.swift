//
//  SolutionsTests.swift
//  SolutionsTests
//
//  Created by Steven McCracken on 7/28/18.
//  Copyright © 2018 Steven McCracken. All rights reserved.
//

import XCTest
@testable import Solutions

class SolutionsTests: XCTestCase {
  func testShortestSubarray1() {
    let result = Shortest_Subarray_with_Sum_at_least_K().shortestSubarray([1], 1)
    XCTAssertEqual(result, 1)
  }

  func testShortestSubarray2() {
    let result = Shortest_Subarray_with_Sum_at_least_K().shortestSubarray([77,19,35,10,-14], 19)
    XCTAssertEqual(result, 1)
  }

  func testShortestSubarray3() {
    let result = Shortest_Subarray_with_Sum_at_least_K().shortestSubarray([2,-1,2], 3)
    XCTAssertEqual(result, 3)
  }

  func testShortestSubarray4() {
    let result = Shortest_Subarray_with_Sum_at_least_K().shortestSubarray([48,99,37,4,-31], 140)
    XCTAssertEqual(result, 2)
  }

  func testShortestSubarray5() {
    let result = Shortest_Subarray_with_Sum_at_least_K().shortestSubarray([17,85,93,-45,-21], 150)
    XCTAssertEqual(result, 2)
  }

  func testShortestSubarray6() {
    let result = Shortest_Subarray_with_Sum_at_least_K().shortestSubarray([56,-21,56,35,-9], 61)
    XCTAssertEqual(result, 2)
  }
}
