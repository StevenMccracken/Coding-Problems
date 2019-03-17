//
//  ViewController.swift
//  playground
//
//  Created by Steven McCracken on 12/18/18.
//  Copyright © 2018 Steven McCracken. All rights reserved.
//

import UIKit

private struct Constants {
  static let prompt = "Animation is"

  enum AnimationDuration: CaseIterable {
    case short
    case medium
    case long

    var value: Double {
      switch self {
      case .short:
        return 0.25
      case .medium:
        return 0.5
      case .long:
        return 1
      }
    }
  }
}

class ViewController: UIViewController {

  @IBOutlet weak var colorView: ColorView!
  @IBOutlet weak var durationButton: UIButton!

  private var currentAnimationDuration: Constants.AnimationDuration = .medium {
    didSet {
      colorView.animationDuration = currentAnimationDuration.value
    }
  }
  
  override func viewDidLoad() {
    super.viewDidLoad()
    colorView.colors = [.red, .blue, .green]
    colorView.animateColorTransition = true
    updateDuration(currentAnimationDuration)
  }

  @IBAction func toggleAnimation(_ sender: UISwitch) {
     colorView.animateColorTransition = sender.isOn
  }

  @IBAction func showDurationOptions(_ sender: UIButton) {
    let alert = UIAlertController(title: "Animation Duration", message: nil, preferredStyle: .actionSheet)
    alert.popoverPresentationController?.sourceView = sender
    alert.popoverPresentationController?.sourceRect = sender.bounds
    Constants.AnimationDuration.allCases.forEach { duration in
      let checkmark = duration == currentAnimationDuration ? " ✓" : ""
      let title = "\(duration.value) seconds\(checkmark)"
      let action = UIAlertAction(title: title, style: .default) { [weak self] _ in
        self?.updateDuration(duration)
      }

      alert.addAction(action)
    }

    alert.addAction(UIAlertAction(title: "Cancel", style: .cancel, handler: nil))
    present(alert, animated: true, completion: nil)
  }

  private func updateDuration(_ duration: Constants.AnimationDuration) {
    currentAnimationDuration = duration
    durationButton.setTitle("\(duration.value)", for: .normal)
  }
}
