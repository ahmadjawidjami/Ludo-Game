

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

public class GameEngine {
	public boolean check;
	static boolean myTurn = false;
	static int rolledNumber;
	static boolean playerStartedFromStaringPosition;
	static boolean pcStartedFromStaringPosition;
	Image dice1, dice2, dice3, dice4, dice5, dice6;
	// public static LudoMain l = new LudoMain();
	static boolean isThePathHorizontalForCounter1;
	static int houseNumberForCounter1;

	static boolean isThePathHorizontalForCounter3;
	static int houseNumberForCounter3;

	public GameEngine() {
		check = false;

		playerStartedFromStaringPosition = false;
		pcStartedFromStaringPosition = false;

		isThePathHorizontalForCounter1 = true;
		houseNumberForCounter1 = 1;

		isThePathHorizontalForCounter3 = true;
		houseNumberForCounter3 = 1;

	}

	boolean isThePathHorizontal;
	// temporary
	Rectangle Counter;
	int kPixel = 55;
	int movedNumber = 1;

	public void paint(Graphics g) {
		dice1 = new ImageIcon("dice1.png").getImage();
		dice2 = new ImageIcon("dice2.png").getImage();
		dice3 = new ImageIcon("dice3.png").getImage();
		dice4 = new ImageIcon("dice4.png").getImage();
		dice5 = new ImageIcon("dice5.png").getImage();
		dice6 = new ImageIcon("dice6.png").getImage();

		if (rolledNumber == 6)
			g.drawImage(dice6, 100, 450, null);

		if (rolledNumber == 5)
			g.drawImage(dice5, 100, 450, null);

		if (rolledNumber == 4)
			g.drawImage(dice4, 100, 450, null);
		if (rolledNumber == 3)
			g.drawImage(dice3, 100, 450, null);
		if (rolledNumber == 2)
			g.drawImage(dice2, 100, 450, null);
		if (rolledNumber == 1)
			g.drawImage(dice1, 100, 450, null);

	}

	public void setPathHorizontalState(boolean isThePathHorizontal) {
		this.isThePathHorizontal = isThePathHorizontal;
	}

	public boolean getPathHorizontalState() {
		return this.isThePathHorizontal;
	}

	public void setCounterCoordinates(Rectangle Counter) {
		this.Counter = Counter;
	}

	public Rectangle getCounterCoordinates() {
		return this.Counter;
	}

	public int move(int houseNumber, boolean isThePathHorizontal,
			Rectangle Counter, int rolledNumber) {
		// rolledNumber = rollDice();
		movedNumber = 1;
		if (44 - houseNumber < rolledNumber) {
			// System.out.println("returned " + (44-houseNumber));
			setPathHorizontalState(isThePathHorizontal);
			setCounterCoordinates(Counter);
			return houseNumber;
		}

		while (true) {

			while (Counter.x <= 760 && Counter.x > 430 && Counter.y >= 400
					&& Counter.y <= 620 && houseNumber <= 39) {

				while (movedNumber <= rolledNumber
						&& isThePathHorizontal == true && houseNumber <= 39) {
					Counter.x += -kPixel;
					movedNumber++;
					houseNumber++;
					if (Counter.x == 540 && Counter.y == 400
							|| Counter.x == 540 && Counter.y == 620
							|| Counter.x == 430 && Counter.y == 620) {
						isThePathHorizontal = false;
						break;
					}

				}

				while (movedNumber <= rolledNumber
						&& isThePathHorizontal == false) {

					if (Counter.x == 430 && Counter.y == 620)
						break;

					Counter.y += kPixel;
					movedNumber++;
					houseNumber++;
					if (Counter.x == 540 && Counter.y == 400
							|| Counter.x == 540 && Counter.y == 620
							|| Counter.x == 430 && Counter.y == 620) {
						isThePathHorizontal = true;
						break;
					}

				}

				if (movedNumber > rolledNumber) {
					setPathHorizontalState(isThePathHorizontal);
					setCounterCoordinates(Counter);
					return houseNumber;
				}

			}

			while (Counter.y <= 620 && Counter.y > 290 && Counter.x <= 430
					&& Counter.x >= 210 && houseNumber <= 39) {

				while (movedNumber <= rolledNumber
						&& isThePathHorizontal == true) {

					if (Counter.x == 210 && Counter.y == 290)
						break;

					Counter.x += -kPixel;
					movedNumber++;
					houseNumber++;
					if (Counter.x == 430 && Counter.y == 400
							|| Counter.x == 210 && Counter.y == 400
							|| Counter.x == 210 && Counter.y == 290) {
						isThePathHorizontal = false;
						break;
					}

				}

				while (movedNumber <= rolledNumber
						&& isThePathHorizontal == false && houseNumber <= 39) {
					Counter.y += -kPixel;
					movedNumber++;
					houseNumber++;
					if (Counter.x == 430 && Counter.y == 400
							|| Counter.x == 210 && Counter.y == 400
							|| Counter.x == 210 && Counter.y == 290) {
						isThePathHorizontal = true;

						break;
					}

				}

				if (movedNumber > rolledNumber) {
					setPathHorizontalState(isThePathHorizontal);
					setCounterCoordinates(Counter);
					return houseNumber;
				}

			}

			while (Counter.x >= 210 && Counter.x < 540 && Counter.y <= 290
					&& Counter.y >= 70 && houseNumber <= 39) {

				while (movedNumber <= rolledNumber
						&& isThePathHorizontal == true && houseNumber <= 39) {
					Counter.x += kPixel;
					movedNumber++;
					houseNumber++;
					if (Counter.x == 430 && Counter.y == 290
							|| Counter.x == 430 && Counter.y == 70
							|| Counter.x == 540 && Counter.y == 70) {
						isThePathHorizontal = false;

						break;
					}

				}

				while (movedNumber <= rolledNumber
						&& isThePathHorizontal == false) {

					// if(pathChangedTo == 9 )
					if (Counter.x == 540 && Counter.y == 70)
						break;
					Counter.y += -kPixel;
					movedNumber++;
					houseNumber++;
					if (Counter.x == 430 && Counter.y == 290
							|| Counter.x == 430 && Counter.y == 70
							|| Counter.x == 540 && Counter.y == 70) {
						isThePathHorizontal = true;

						break;
					}

				}

				if (movedNumber > rolledNumber) {
					setPathHorizontalState(isThePathHorizontal);
					setCounterCoordinates(Counter);
					return houseNumber;
				}

			}

			while (Counter.y >= 70 && Counter.y < 400 && Counter.x >= 540
					&& Counter.x <= 760 && houseNumber <= 39) {

				while (movedNumber <= rolledNumber
						&& isThePathHorizontal == true) {
					if (Counter.x == 760 && Counter.y == 345)
						break;
					Counter.x += kPixel;
					movedNumber++;
					houseNumber++;
					if (Counter.x == 540 && Counter.y == 290
							|| Counter.x == 760 && Counter.y == 290
							|| Counter.x == 760 && Counter.y == 400) {
						isThePathHorizontal = false;

						break;
					}

				}

				while (movedNumber <= rolledNumber
						&& isThePathHorizontal == false && houseNumber <= 39) {
					Counter.y += kPixel;
					movedNumber++;
					houseNumber++;
					if (Counter.x == 540 && Counter.y == 290
							|| Counter.x == 760 && Counter.y == 290
							|| Counter.x == 760 && Counter.y == 400) {
						isThePathHorizontal = true;

						break;
					}

				}

				if (movedNumber > rolledNumber) {
					setPathHorizontalState(isThePathHorizontal);
					setCounterCoordinates(Counter);
					return houseNumber;
				}

			}

			while (houseNumber >= 40 && houseNumber < 44) {

				while (movedNumber <= rolledNumber && Counter.x <= 760
						&& Counter.x >= 540) {
					Counter.x += -kPixel;
					movedNumber++;
					houseNumber++;
				}

				while (movedNumber <= rolledNumber && Counter.x >= 210
						&& Counter.x <= 430) {
					Counter.x += kPixel;
					movedNumber++;
					houseNumber++;
				}

				while (movedNumber <= rolledNumber && Counter.y <= 620
						&& Counter.y >= 400) {
					Counter.y += -kPixel;
					movedNumber++;
					houseNumber++;
				}

				while (movedNumber <= rolledNumber && Counter.y >= 70
						&& Counter.y <= 290) {
					Counter.y += kPixel;
					movedNumber++;
					houseNumber++;
				}

				if (movedNumber > rolledNumber) {
					setPathHorizontalState(isThePathHorizontal);
					setCounterCoordinates(Counter);
					return houseNumber;
				}

			}

			if (movedNumber > rolledNumber) {

				setPathHorizontalState(isThePathHorizontal);
				setCounterCoordinates(Counter);
				return houseNumber;

			}

		}

	}

	public int rollDice() {
		Random rand = new Random();
		int number = rand.nextInt(6) + 1;
		// System.out.println(number);
		return number;

	}

}
