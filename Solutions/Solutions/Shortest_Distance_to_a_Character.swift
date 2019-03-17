//
//  Shortest_Distance_to_a_Character.swift
//  Solutions
//
//  Created by Steven McCracken on 7/29/18.
//  Copyright © 2018 Steven McCracken. All rights reserved.
//

import Foundation

public class Shortest_Distance_to_a_Character {
  public func shortestToChar(_ str: String, _ char: Character) -> [Int] {
    var distances = Array(repeating: 0, count: str.count)
    var chars = [Int]()
    for i in 0..<str.count {
      let index = str.index(str.startIndex, offsetBy: i)
      if Character(String(str[index...index])) == char {
        chars.append(i)
      }
    }

    for i in 0..<str.count {
      let index = str.index(str.startIndex, offsetBy: i)
      let charAtIndex = Character(String(str[index...index]))
      if charAtIndex == char {
        continue
      }

      var min = Int.max
      chars.forEach {
        let distance = abs($0 - i)
        if distance < min {
          min = distance
        }
      }

      distances[i] = min
    }

    return distances
  }
}
