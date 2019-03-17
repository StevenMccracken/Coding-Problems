//
//  Number_of_Islands.swift
//  Solutions
//
//  Created by Steven McCracken on 7/28/18.
//  Copyright © 2018 Steven McCracken. All rights reserved.
//

import Foundation

class Number_of_Islands {
  func numIslands(_ grid: [[Character]]) -> Int {
    var count = 0
    var islands = grid
    for row in 0..<grid.count {
      for col in 0..<grid[row].count {
        if islands[row][col] == Character("1") {
          dfs(&islands, row, col)
          count += 1
        }
      }
    }


    return count
  }

  func dfs(_ grid: inout [[Character]], _ row: Int, _ col: Int) {
    if row < 0 || row >= grid.count { return }
    if col < 0 || col >= grid[0].count { return }
    if grid[row][col] != Character("1") { return }
    grid[row][col] = Character("0")

    dfs(&grid, row - 1, col)
    dfs(&grid, row, col + 1)
    dfs(&grid, row + 1, col)
    dfs(&grid, row, col - 1)
  }
}
