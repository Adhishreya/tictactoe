package com.apps.ui;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ui_1 {
	static JButton button = null;
	static char currentPlayer;
	static int index;
	static int totalMoves = 0;
	static Integer row, column;
	final static char board[][] = new char[3][3];
	private static int moves[][] = new int[9][2];
	static char winner = '-';

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

	public static boolean isWinner(char player, int tempRow, int tempColumn) {
//		System.out.println(
//				"executed" + "\nCurrent PLayer = " + player + "\nRow = " + tempRow + "\nColumn = " + tempColumn);
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
//			System.out.println("count = " + count);
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

	public static void printBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++)
				System.out.print(board[i][j] + " ");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		initializeBoard();

		char player[] = new char[] { 'X', 'O' };
		index = (int) (Math.random() * 10) % 2;
		currentPlayer = player[index];
		JLabel layer = new JLabel();
		layer.setBounds(80, 80, 100, 50);
		frame.add(layer);
		for (int i = 1; i < 4; i++) {
			for (int j = 1; j < 4; j++) {
				JButton button1 = new JButton("");
				button1.putClientProperty("row", i);
				button1.putClientProperty("column", j);
				button1.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						button1.setText("" + currentPlayer + "");
						index = (index + 1) % 2;
						currentPlayer = player[index];
						button1.setEnabled(false);

						row = (Integer) button1.getClientProperty("row");
						column = (Integer) button1.getClientProperty("column");

						board[row - 1][column - 1] = button1.getText().charAt(0);

						totalMoves++;
						if (isWinner(button1.getText().charAt(0), row - 1, column - 1)) {
							printBoard();
							winner = currentPlayer;
							System.out.println("Winner is = " + winner);
							layer.setText("Congratulations !!" + winner);
							return;
						} else if (totalMoves >= 9) {
							layer.setText("Game Tied !!");
							return;
						}

					}
				});
				if (winner != '-') {
					System.out.println("Winner is = " + winner);
					return;
				}
				button1.setBounds(100 + (j * 50), 100 + (i * 50), 50, 50);
				frame.add(button1);
			}
		}

		frame.setSize(450, 450);

		frame.setLayout(null);
		frame.setVisible(true);
	}
}
