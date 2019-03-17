//
//  SafeArray.swift
//  Solutions
//
//  Created by Steven McCracken on 12/14/18.
//  Copyright © 2018 Steven McCracken. All rights reserved.
//

import Foundation

struct SafeArray<T> {
  private var tracker: Int = 0
  private var data: [T]
  private let queue = DispatchQueue(label: "SafeArray_\(T.self)_\(UUID().uuidString)", attributes: .concurrent)

  init(data: [T]) {
    self.data = data
  }
}

extension SafeArray: Sequence {
  typealias Iterator = SafeArray
}


extension SafeArray: IteratorProtocol {
  typealias Element = T

  mutating func next() -> T? {
    guard tracker < data.count else {
      return nil
    }

    defer {
      tracker = tracker + 1
    }

    return data[tracker]
  }
}
