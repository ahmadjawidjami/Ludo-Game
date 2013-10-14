

import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

public class PlayerCounter extends GameEngine {

	boolean playerCantMove;

	Rectangle Counter1;
	Rectangle Counter3;
	Rectangle Dice;

	public PlayerCounter(Rectangle r, Rectangle r3, Rectangle d) {
		myTurn = false;
		playerCantMove = false;
		this.Counter1 = r;
		this.Counter3 = r3;
		this.Dice = d;

	}

	public void startGame() {
		Counter1.x = 760;
		Counter1.y = 400;
	}

	public void mouseClicked(MouseEvent e) {

		int mx = e.getX();
		int my = e.getY();
		if (mx > Dice.x && mx < Dice.x + Dice.width && my > Dice.y
				&& my < Dice.y + Dice.height) {
			if (myTurn == false)
				return;
			else {
				rolledNumber = rollDice();
				playerCantMove = false;
				if (rolledNumber != 6)
					myTurn = false;
				if (Counter1.x == 760 && Counter1.y == 650 && rolledNumber == 6) {
					startGame();
					myTurn = true;
					playerCantMove = true;
					playerStartedFromStaringPosition = true;

				}
			}

		}

		if (playerStartedFromStaringPosition == true) {

		}

		if (e.getX() - 55 <= Counter1.x && e.getX() >= Counter1.x
				&& e.getY() - 55 <= Counter1.y && e.getY() >= Counter1.y
				&& playerCantMove == false
				&& playerStartedFromStaringPosition == true) {

			houseNumberForCounter1 = move(houseNumberForCounter1,
					isThePathHorizontalForCounter1, Counter1, rolledNumber);

			isThePathHorizontalForCounter1 = getPathHorizontalState();
			Counter1 = getCounterCoordinates();
			if (Counter1.intersects(Counter3)) {
				houseNumberForCounter3 = 1;
				isThePathHorizontalForCounter3 = true;
				Counter3.x = 210;
				Counter3.y = 200;

				pcStartedFromStaringPosition = false;

			}
			if (rolledNumber != 6) {
				myTurn = false;
				// check = true;
				LudoMain.a.resume();
			}

			playerCantMove = true;
			if (houseNumberForCounter1 == 44) {
				LudoMain.situation = "Try Again";
				LudoMain.newGame.setText(LudoMain.situation);
				LudoMain.a.stop();
				JOptionPane.showMessageDialog(null,
						"Conguratulations! you won the game");
				LudoMain.frame1.setVisible(false);
				LudoMain.frame1 = null;
				LudoMain.messageFrame();

			}

			// return ;
		}

		if (playerStartedFromStaringPosition == false) {
			myTurn = false;
			// check = true;
			LudoMain.a.resume();
		}

	}

}
