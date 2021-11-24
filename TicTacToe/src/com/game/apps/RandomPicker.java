package com.game.apps;

import java.util.Scanner;

public class RandomPicker {
	final static char board[][] = new char[3][3];
	private static int moves[][] = new int[9][2];
	static char player1;
	static char player2;

	public static void initializeBoard() {
		int count = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = '-';
				moves[count][0] = i;
				moves[count][1] = j;
				count++;
			}
		}
	}

	static boolean isAvailable(int i, int j) {
		if (board[i][j] == '-')
			return true;
		return false;
	}

	public static int generateMove() {
		return ((int) (Math.random() * 10) % 9);
	}

	public static boolean isWinner(char player, int tempRow, int tempColumn) {
		int count = 0;
		for (int i = 0; i < 3; i++) {
			if (board[i][tempColumn] != player)
				break;
			if (board[i][tempColumn] == player) {
				count++;
			}
			if (count == 3)
				return true;
		}
		count = 0;
		for (int i = 0; i < 3; i++) {
			if (board[tempRow][i] != player)
				break;
			if (board[tempRow][i] == player) {
				count++;
			}
			if (count == 3)
				return true;
		}
		count = 0;
		for (int i = 0; i < 3; i++) {
			if (board[i][i] != player)
				break;
			if (board[i][i] == player) {
				count++;
			}
			if (count == 3)
				return true;

		}
		count = 0;

		for (int i = 0; i < 3; i++) {
			if (board[2 - i][i] != player)
				break;
			if (board[2 - i][i] == player) {
				count++;
			}
			if (count == 3)
				return true;

		}
		return false;
	}

	static void printWinner(char player) {
		System.out.println("Congratulations!!\n" + player + " wins the game");
	}

	public static void printBoard() {
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

		player2 = (option == 1) ? 'O' : 'X';
		player1 = (option == 1) ? 'X' : 'O';
		initializeBoard();
		int totalMoves = 0;
		char currentPLayer;
		int row;
		int column;
		while (totalMoves <= 9) {
			currentPLayer = player1;
			System.out.println("Enter the position");
			row = Integer.parseInt(scan.nextLine());
			column = Integer.parseInt(scan.nextLine());

			while (!isAvailable(row, column)) {
				System.out.println("Position already occupied! Please try again!!");
				row = Integer.parseInt(scan.nextLine());
				column = Integer.parseInt(scan.nextLine());
			}
			totalMoves++;
			board[row][column] = currentPLayer;
			if (isWinner(currentPLayer, row, column)) {
				printWinner(currentPLayer);
				break;
			}
//			printBoard();
			currentPLayer = player2;
			int aiTryPorition = generateMove();
			row = moves[aiTryPorition][0];
			column = row = moves[aiTryPorition][1];
//			System.out.println("position = " + aiTryPorition);
			while (!isAvailable(row, column)) {
//				System.out.println("position = " + aiTryPorition);
				aiTryPorition = generateMove();
				row = moves[aiTryPorition][0];
				column = moves[aiTryPorition][1];
			}

			totalMoves++;
			board[row][column] = currentPLayer;
			if (isWinner(currentPLayer, row, column)) {
				printBoard();
				printWinner(currentPLayer);
				break;
			}

			printBoard();
		}
	}

}
