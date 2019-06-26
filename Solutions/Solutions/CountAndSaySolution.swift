//
//  CountAndSaySolution.swift
//  Solutions
//
//  Created by Steven McCracken on 4/16/19.
//  Copyright © 2019 Steven McCracken. All rights reserved.
//

import Foundation

struct CountAndSaySolution {
  func countAndSay(_ n: Int) -> String {
    var previousCount = "1"
    (1..<n).forEach { _ in
      let count = countCharacters(in: previousCount)
      previousCount = count.reduce("", { (result, countInfo) in
        let (character, count) = countInfo
        return "\(result)\(count)\(character)"
      })
    }

    return previousCount
  }

//  "111221"

  private func countCharacters(in string: String) -> [(Character, Int)] {
    var count: Int = 0
    var previousChar: Character? = string.first
    var counts: [(Character, Int)] = []
    string.forEach { character in
      if character == previousChar {
        count += 1
      } else if let char = previousChar {
        counts.append((char, count))
        count = 0
        previousChar = nil
      }

      previousChar = character
    }

  }
}
