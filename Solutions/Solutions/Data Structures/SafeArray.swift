//
//  SafeArray.swift
//  Solutions
//
//  Created by Steven McCracken on 12/14/18.
//  Copyright © 2018 Steven McCracken. All rights reserved.
//

import Foundation

class SafeArray<Element>: Sequence, IteratorProtocol {

  private var items: [Element]
  private var iteratorIndex: Int = 0
  private let queue = DispatchQueue(label: UUID().uuidString, attributes: .concurrent)

  init(items: [Element]) {
    self.items = items
  }

  // MARK: - IteratorProtocol

  func next() -> Element? {
    defer {
      iteratorIndex = iteratorIndex + 1
    }

    return iteratorIndex < count ? self[iteratorIndex] : nil
  }

  var count: Int {
    var itemsCount: Int!
    queue.sync {
      itemsCount = self.items.count
    }

    return itemsCount
  }

  subscript(index: Int) -> Element {
    get {
      var item: Element!
      queue.sync {
        item = self.items[index]
      }

      return item
    }
    set {
      queue.async(flags: .barrier) {
        self.items[index] = newValue
      }
    }
  }
}
