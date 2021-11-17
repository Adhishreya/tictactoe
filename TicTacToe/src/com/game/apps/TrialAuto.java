package com.game.apps;

public class TrialAuto {
	int board[][] = new int[3][3];
	static int bestScore = Integer.MIN_VALUE;
	char player1;
	char player2;

	public static void main(String[] args) {
		System.out.println(bestScore);
	}

	public void initializeBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++)
				board[i][j] = '-';
		}
	}

	public void aiTurn() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == '-') {
					bestScore = Math.max(bestScore, minimax(i, j, true));
				}
			}
		}
	}

	public int minimax(int i, int j, boolean maximize) {
		return -1;
	}

}
