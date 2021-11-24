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
		for (int i = 0; i < 3; i++) {
			if (board[i][tempColumn] != currentPlayer)
				break;
			if (board[i][tempColumn] == currentPlayer) {
				count++;

			}
			if (count == 3)
				return true;
		}
		count = 0;
		for (int i = 0; i < 3; i++) {
			if (board[i][tempRow] != currentPlayer)
				break;
			if (board[tempRow][i] == currentPlayer) {
				count++;

			}
			if (count == 3)
				return true;

		}
		count = 0;
		for (int i = 0; i < 3; i++) {
			if (board[i][i] != currentPlayer)
				break;
			if (board[i][i] == currentPlayer) {
				count++;

			}
			if (count == 3)
				return true;

		}
		count = 0;

		for (int i = 0; i < 3; i++) {
			if (board[2 - i][i] != currentPlayer)
				break;
			if (board[2 - i][i] == currentPlayer) {
				count++;

			}
			if (count == 3)
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
		int row;
		int column;
		game1.initializeBoard();
		while (game1.totalMoves != 9) {
			game1.totalMoves++;
			System.out.println("Enter the position");
			row = Integer.parseInt(sc.nextLine());
			column = Integer.parseInt(sc.nextLine());

			if (game1.board[row][column] != '-') {
				System.out.println("Position already occupied! Please try again!!");
				row = Integer.parseInt(sc.nextLine());
				column = Integer.parseInt(sc.nextLine());
			}
			System.out.println("option:X or O");
			char player = sc.nextLine().charAt(0);
			game1.board[row][column] = player;
			game1.printBoard();
			boolean gOver = game1.currentMove(game1.board[row][column], row, column);
			if (gOver == true) {
				System.out.println("Game Over !!" + game1.board[row][column] + " Won the match");
				break;
			} else if (game1.totalMoves == 9) {
				System.out.println("Game Tied");
				break;
			} else
				System.out.println("Game continuing");
//			System.out.println("do you want to continue");
//			cin = sc.nextLine().charAt(0);
		}
	}
}
