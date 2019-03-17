//
//  ColorView.swift
//  playground
//
//  Created by Steven McCracken on 12/18/18.
//  Copyright © 2018 Steven McCracken. All rights reserved.
//

import UIKit

class ColorView: UIView {

  /// The colors that the view shows
  var colors: [UIColor] = [] {
    didSet {
      if colors.isEmpty {
        fatalError("Colors cannot be empty")
      }

      currentColorIndex = 0
    }
  }

  /// The state tracker for the list of colors. Updates `backgroundColor`, so set on main thread
  private var currentColorIndex: Int = 0 {
    didSet {
      updateBackgroundForCurrentIndex()
    }
  }

  /**
   Whether or not the transition between colors is animated. Default is `true`
   - note: Changing this property will have immediate effects
   */
  @IBInspectable var animateColorTransition: Bool = true

  /**
   The duration for the transition animation. Default is `0.5`
   - note: This property is ignored when `animateColorTransition` is `false`
   */
  @IBInspectable var animationDuration: Double = 0.5

  // MARK: - Init

  init(colors: [UIColor]) {
    super.init(frame: .zero)
    self.colors = colors
    commonInit()
  }

  init(frame: CGRect, colors: [UIColor]) {
    super.init(frame: frame)
    self.colors = colors
    commonInit()
  }

  override init(frame: CGRect) {
    fatalError("Must supply initial colors. Use init(frame:colors:)")
  }

  required init?(coder aDecoder: NSCoder) {
    super.init(coder: aDecoder)
    commonInit()
  }

  private func commonInit() {
    let tapGestureRecognizer = UITapGestureRecognizer(target: self, action: #selector(changeColor))
    addGestureRecognizer(tapGestureRecognizer)
    isUserInteractionEnabled = true
    if !colors.isEmpty {
      currentColorIndex = 0
    }
  }
}

// MARK: - Actions

extension ColorView {
  @objc private func changeColor() {
    let newIndex = currentColorIndex + 1
    if newIndex < colors.count {
      currentColorIndex = newIndex
    } else {
      currentColorIndex = 0
    }
  }
}

extension ColorView {
  private func updateBackgroundForCurrentIndex() {
    defer {
      backgroundColor = colors[currentColorIndex]
    }

    guard animateColorTransition else {
      return
    }

    let transition = CATransition()
    transition.type = .push
    transition.subtype = .fromLeft
    transition.fillMode = .removed
    transition.duration = animationDuration
    transition.timingFunction = CAMediaTimingFunction(name: .easeInEaseOut)
    layer.add(transition, forKey: "slideInFromLeftTransition")
  }
}
