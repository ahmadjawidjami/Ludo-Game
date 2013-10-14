

import java.awt.Rectangle;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class PCCounter extends GameEngine implements Runnable {

	Rectangle Counter3;
	Rectangle Counter1;
	boolean pcCantMove;

	public PCCounter(Rectangle r, Rectangle r2) throws IOException {
		System.out.printf("%s", "jami");

		pcCantMove = false;
		FileWriter fr = new FileWriter("j.txt");

		this.Counter3 = r;
		this.Counter1 = r2;

	}

	public void startGame() {
		Counter3.x = 210;
		Counter3.y = 290;
	}

	public void run() {
		try {

			while (true) {

				Thread.sleep(2000);
				rolledNumber = rollDice();

				if (Counter3.x == 210 && Counter3.y == 200 && rolledNumber == 6) {
					startGame();
					pcStartedFromStaringPosition = true;
					continue;

				}

				if (pcStartedFromStaringPosition) {
					Thread.sleep(2000);
					houseNumberForCounter3 = move(houseNumberForCounter3,
							isThePathHorizontalForCounter3, Counter3,
							rolledNumber);
					isThePathHorizontalForCounter3 = getPathHorizontalState();
					Counter3 = getCounterCoordinates();
					if (Counter3.intersects(Counter1)) {
						houseNumberForCounter1 = 1;
						isThePathHorizontalForCounter1 = true;
						Counter1.x = 760;
						Counter1.y = 650;
						playerStartedFromStaringPosition = false;

					}

					if (houseNumberForCounter3 == 44) {
						LudoMain.situation = "Try Again";
						LudoMain.exitGame.setText(LudoMain.situation);
						JOptionPane.showMessageDialog(null,
								"Unfortunately you lost the game");
						LudoMain.frame1.setVisible(false);
						LudoMain.frame1 = null;
						LudoMain.messageFrame();
						LudoMain.a.stop();

					}

					if (rolledNumber != 6) {
						myTurn = true;
						LudoMain.a.suspend();
					}

				}

				if (houseNumberForCounter3 == 44) {
					LudoMain.situation = "Try Again";
					LudoMain.exitGame.setText(LudoMain.situation);
					JOptionPane.showMessageDialog(null,
							"Unfortunately you lost the game");
					LudoMain.frame1.setVisible(false);
					LudoMain.frame1 = null;
					LudoMain.messageFrame();
					LudoMain.a.stop();

				}

				if (pcStartedFromStaringPosition == false) {
					myTurn = true;
					LudoMain.a.suspend();

				}

			}
		} catch (Exception ex) {
		}

	}

}
