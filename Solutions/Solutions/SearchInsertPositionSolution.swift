//
//  SearchInsertPositionSolution.swift
//  Solutions
//
//  Created by Steven McCracken on 4/9/19.
//  Copyright © 2019 Steven McCracken. All rights reserved.
//

import Foundation

/**
 https://leetcode.com/problems/search-insert-position/

 Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.

 Example 1:

 Input: [1,3,5,6], 5
 Output: 2
 Example 2:

 Input: [1,3,5,6], 2
 Output: 1
 Example 3:

 Input: [1,3,5,6], 7
 Output: 4
 Example 4:

 Input: [1,3,5,6], 0
 Output: 0
 */

struct SearchInsertPositionSolution {
  func searchInsert(_ nums: [Int], _ target: Int) -> Int {
    var low = 0
    var high = nums.count
    var mid = low
    while low < high {
      mid = low + (high - low) / 2
      if nums[mid] < target {
        low = mid + 1
      } else if nums[mid] > target {
        high = mid
      } else {
        break
      }
    }

    return low > mid ? low : mid
  }
}
