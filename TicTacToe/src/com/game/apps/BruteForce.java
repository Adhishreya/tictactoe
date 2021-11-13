package com.game.apps;

import java.util.Scanner;

public class BruteForce {
	final char board[][] = new char[3][3];
	int totalMoves = 0;
	int count = 0;

	char currentState = 'Y';

	public void initializeBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++)
				board[i][j] = '-';
		}
	}

	boolean currentMove(char currentPlayer, int tempRow, int tempColumn)

	{
		System.out.println("count = " + count);

		for (int i = 0; i < tempRow; i++) {
			if (board[i][tempRow] != currentPlayer)
				break;
			if (board[i][tempColumn] == currentPlayer) {
				count++;

			}
			if (count == 2)
				return true;
		}
		count = 0;
		for (int i = 0; i < tempColumn; i++) {
			if (board[i][tempRow] != currentPlayer)
				break;
			if (board[tempRow][i] == currentPlayer) {
				count++;

			}
			if (count == 2)
				return true;

		}
		count = 0;
		for (int i = 0; i < tempRow; i++) {
			if (board[i][tempRow] != currentPlayer)
				break;
			if (board[i][i] == currentPlayer) {
				count++;

			}
			if (count == 2)
				return true;

		}
		count = 0;
		return false;
	}

	public void printBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++)
				System.out.print(board[i][j] + " ");
			System.out.println();
		}

	}

	public static void main(String[] args) {
		BruteForce game1 = new BruteForce();
		Scanner sc = new Scanner(System.in);
		System.out.println("do you want to continue");
		char cin = sc.nextLine().charAt(0);
		int row, column;
		game1.initializeBoard();
		while (cin != 'n') {
			game1.totalMoves++;
			System.out.println("Enter the option");
			row = Integer.parseInt(sc.nextLine());
			column = Integer.parseInt(sc.nextLine());

			if (game1.board[row][column] != '-') {
				System.out.println("Position already occupied! Please try again!!");
				row = Integer.parseInt(sc.nextLine());
				column = Integer.parseInt(sc.nextLine());
			}
			char player = sc.nextLine().charAt(0);
			game1.board[row][column] = player;
			game1.printBoard();
			boolean gOver = game1.currentMove(game1.board[row][column], row, column);
			if (gOver == true)
				System.out.println("Game Over !!" + game1.board[row][column] + " Won the match");
			else if (game1.totalMoves == 9) {
				System.out.println("Game Tied");
				break;
			} else
				System.out.println("Game continuing");
			System.out.println("do you want to continue");
			cin = sc.nextLine().charAt(0);
		}
	}
}
