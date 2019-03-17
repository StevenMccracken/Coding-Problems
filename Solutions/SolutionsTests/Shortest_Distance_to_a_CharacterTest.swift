//
//  Shortest_Distance_to_a_CharacterTest.swift
//  SolutionsTests
//
//  Created by Steven McCracken on 7/29/18.
//  Copyright © 2018 Steven McCracken. All rights reserved.
//

import XCTest
@testable import Solutions

class Shortest_Distance_to_a_CharacterTest: XCTestCase {
  let solution = Shortest_Distance_to_a_Character()

  func test1() {
    let result = solution.shortestToChar("loveleetcode", Character("e"))
    let expected = [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
    XCTAssertEqual(result.count, expected.count)
    for i in 0..<result.count {
      XCTAssertEqual(result[i], expected[i])
    }
  }
}
