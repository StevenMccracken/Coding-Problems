//
//  Implement_strStr.swift
//  Solutions
//
//  Created by Steven McCracken on 7/29/18.
//  Copyright © 2018 Steven McCracken. All rights reserved.
//

import Foundation

class Implement_strStr {
  func strStr(_ haystack: String, _ needle: String) -> Int {
    if needle.trimmingCharacters(in: .whitespacesAndNewlines).isEmpty {
      return 0
    }

    if haystack == needle {
      return 0
    }

    var i = 0
    while (i + needle.count) <= haystack.count{
      let start = haystack.index(haystack.startIndex, offsetBy: i)
      let end = haystack.index(start, offsetBy: needle.count)
      if String(haystack[start..<end]) == needle {
        return i
      }

      i += 1
    }

    return -1
  }
}
