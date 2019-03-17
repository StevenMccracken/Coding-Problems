//
//  Longest_PalindromeTest.swift
//  SolutionsTests
//
//  Created by Steven McCracken on 7/28/18.
//  Copyright © 2018 Steven McCracken. All rights reserved.
//

import XCTest
@testable import Solutions

class Longest_PalindromeTest: XCTestCase {
  let solution = Longest_Palindrome()

  func test1() {
    let result = solution.longestPalindrome("abccccdd")
    XCTAssertEqual(result, 7)
  }
}
