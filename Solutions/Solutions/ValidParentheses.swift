//
//  ValidParentheses.swift
//  Solutions
//
//  Created by Steven McCracken on 3/17/19.
//  Copyright © 2019 Steven McCracken. All rights reserved.
//

import Foundation

/// https://leetcode.com/problems/valid-parentheses/

class ValidParenthesesSolution {
  func isValid(_ string: String) -> Bool {
    // Handle base cases
    if string.isEmpty {
      return true
    }

    if string.count == 1 {
      return false
    }

    var stack = Stack<Character>()
    for character in string {
      if let lastElementReversed = stack.lastElement?.reversed, lastElementReversed == character {
        stack.pop()
      } else {
        stack.push(character)
      }
    }

    return stack.isEmpty
  }
}

private extension Character {
  private static let reversedDictionary: [Character: Character] = [
    "(": ")",
    "{": "}",
    "[": "]"
  ]

  var reversed: Character? {
    return Character.reversedDictionary[self]
  }
}
