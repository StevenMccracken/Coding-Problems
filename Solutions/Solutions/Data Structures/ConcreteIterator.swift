//
//  ConcreteIterator.swift
//  Solutions
//
//  Created by Steven McCracken on 3/17/19.
//  Copyright © 2019 Steven McCracken. All rights reserved.
//

import Foundation

protocol Iterator {
  associatedtype Element
  var hasNext: Bool { get }
  mutating func next() -> Element?
}

struct ConcreteIterator<T>: Iterator {
  typealias Element = T
  private let items: [T]
  private var index: Int = 0

  init(items: [T]) {
    self.items = items
  }

  var hasNext: Bool {
    return index < items.count
  }

  mutating func next() -> T? {
    defer {
      if hasNext {
        index = index + 1
      }
    }

    return hasNext ? items[index] : nil
  }
}
