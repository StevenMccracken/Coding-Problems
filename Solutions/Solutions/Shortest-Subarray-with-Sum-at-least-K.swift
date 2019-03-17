//
//  Shortest_Subarray_with_Sum_at_least_K.swift
//  Solutions
//
//  Created by Steven McCracken on 7/28/18.
//  Copyright © 2018 Steven McCracken. All rights reserved.
//

import Foundation

public class Shortest_Subarray_with_Sum_at_least_K {
  public func shortestSubarray2(_ nums: [Int], _ k: Int) -> Int {
    var minCount: Int?
    for i in 0..<nums.count {
      var sum = 0
      var count = 0
      for j in i..<nums.count {
        count += 1
        sum += nums[j]
        if sum >= k {
          if minCount == nil || count < minCount! {
            minCount = count
          }
        }
      }
    }

    return minCount ?? -1
  }

  public func shortestSubarray(_ nums: [Int], _ k: Int) -> Int {
    var results: [(Int, Int)] = Array(repeating: (0, 0), count: nums.count)
    for i in 0..<nums.count {
      for j in 0...i {
        if results[j].0 < k {
          results[j].1 += 1
          results[j].0 += nums[i]
        }
      }
    }

    let shortest = results.filter { $0.0 >= k }.min(by: { $0.1 < $1.1 })
    return shortest?.1 ?? -1
  }
}
