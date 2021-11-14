package com.game.apps;

import java.util.Scanner;

public class AutomaticBlocking {
	int count = 0;
	final char board[][] = new char[3][3];
	char player1, player2;
	int totalCount = 0;

	public void initializeBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++)
				board[i][j] = '-';
		}
	}

	boolean isAvailable(int tempRow, int tempColumn) {
		if (board[tempRow][tempColumn] == '-')
			return true;
		return false;
	}

	boolean currentMove(char currentPlayer, int tempRow, int tempColumn) {
		for (int i = 0; i < 3; i++) {
//			if (board[i][tempColumn] != currentPlayer)
//				break;
			if (board[i][tempColumn] == currentPlayer) {
				count++;

			}
			if (count == 3)
				return true;
//			else if (count == 2)
//				return true;
		}
		count = 0;
		for (int i = 0; i < 3; i++) {
//			if (board[i][tempRow] != currentPlayer)
//				break;
			if (board[tempRow][i] == currentPlayer) {
				count++;

			}
			if (count == 3)
				return true;

		}
		count = 0;
		for (int i = 0; i < 3; i++) {
//			if (board[i][i] != currentPlayer)
//				break;
			if (board[i][i] == currentPlayer) {
				count++;

			}
			if (count == 3)
				return true;

		}
		count = 0;
		return false;
	}

	void blocking(char aiPlayer, int tempRow, int tempColumn) {
		// checking oponent's move and possible chances of blocking the opponent
//		boolean possible = currentMove(player1, tempRow, tempColumn);
//		if (possible)
//			System.out.println("Possible");

		if (tempRow + 1 < 3 && isAvailable(tempRow + 1, tempColumn))
			board[tempRow + 1][tempColumn] = player2;
		else if (tempColumn + 1 < 3 && isAvailable(tempRow, tempColumn + 1))
			board[tempRow][tempColumn + 1] = player2;
		else if (tempRow - 1 >= 0 && isAvailable(tempRow - 1, tempColumn))
			board[tempRow - 1][tempColumn] = player2;
		else if (tempColumn - 1 >= 0 && isAvailable(tempRow, tempColumn - 1))
			board[tempRow][tempColumn - 1] = player2;
		else if (tempColumn + 1 < 3 && tempRow + 1 < 3 && isAvailable(tempRow + 1, tempColumn + 1))
			board[tempRow + 1][tempColumn + 1] = player2;
		else if (tempColumn - 1 >= 0 && tempRow - 1 >= 0 && isAvailable(tempRow - 1, tempColumn - 1))
			board[tempRow - 1][tempColumn - 1] = player2;

	}

	public void printBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++)
				System.out.print(board[i][j] + " ");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Choose the option to play!\n1.X\n2.O");
		int option = Integer.parseInt(scan.nextLine());
		AutomaticBlocking auto = new AutomaticBlocking();
		auto.player2 = (option == 1) ? 'O' : 'X';
		auto.player1 = (option == 1) ? 'X' : 'O';
		auto.initializeBoard();
		int row;
		int column;
		while (auto.totalCount != 9) {
			System.out.println("Enter the option");
			row = Integer.parseInt(scan.nextLine());
			column = Integer.parseInt(scan.nextLine());

			if (auto.board[row][column] != '-') {
				System.out.println("Position already occupied! Please try again!!");
				row = Integer.parseInt(scan.nextLine());
				column = Integer.parseInt(scan.nextLine());
				auto.totalCount++;
			}
			auto.board[row][column] = auto.player1;
			auto.blocking(auto.player2, row, column);
			auto.printBoard();
			boolean gOver = auto.currentMove(auto.board[row][column], row, column);
			if (gOver == true)
				System.out.println("Game Over !!" + auto.board[row][column] + " Won the match");
			else if (auto.totalCount == 9) {
				System.out.println("Game Tied");
				break;
			}
		}

	}

}
