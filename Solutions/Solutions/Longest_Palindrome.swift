//
//  Longest_Palindrome.swift
//  Solutions
//
//  Created by Steven McCracken on 7/28/18.
//  Copyright © 2018 Steven McCracken. All rights reserved.
//

import Foundation

class Longest_Palindrome {
  func longestPalindrome(_ s: String) -> Int {
    var counts = [Character: Int]()
    s.forEach {
      if let count = counts[$0] {
        counts[$0] = count + 1
      } else {
        counts[$0] = 1
      }
    }

    var odds = 0
    var evens = 0
    counts.forEach { (_, value) in
      if value % 2 == 0 {
        evens += value
      } else if value > 1 {
        odds += 1
        evens += (value - 1)
      } else {
        odds += 1
      }
    }

    return odds == 0 ? evens : evens + 1
  }
}
