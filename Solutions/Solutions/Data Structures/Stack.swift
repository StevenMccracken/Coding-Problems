//
//  Stack.swift
//  Solutions
//
//  Created by Steven McCracken on 3/17/19.
//  Copyright © 2019 Steven McCracken. All rights reserved.
//

import Foundation

struct Stack<Element> {
  private var elements: [Element] = []

  var lastElement: Element? {
    return elements.last
  }

  var isEmpty: Bool {
    return elements.isEmpty
  }

  mutating func push(_ element: Element) {
    elements.append(element)
  }

  @discardableResult mutating func pop() -> Element? {
    return elements.popLast()
  }
}
