import java.awt.*;

public class Card {

	public final int CARDX;
	public final int CARDY;

	public final int CARDWIDTH = 100;
	public final int CARDHEIGHT = 150;
	public final int ARCCARDWIDTH = 50;
	public final int ARCCARDHEIGHT = 50;
	public final int CIRCLEWIDTH = 50;
	public final int CIRCLEHEIGHT = 50;
	private int suitValue;
	private int numberValue;

	public Card(int x, int y) {
		CARDX = x;
		CARDY = y;
	}

	public void setup(int theSuitValue, int theNumberValue) {
		suitValue = theSuitValue;
		numberValue = theNumberValue;

	}

	public void drawFaceDownCard(Graphics pane) {
		pane.setColor(Color.BLACK);
		pane.drawRoundRect(CARDX, CARDY + 200, CARDWIDTH, CARDHEIGHT,
				ARCCARDWIDTH, ARCCARDHEIGHT);
		pane.fillRoundRect(CARDX, CARDY + 200, CARDWIDTH, CARDHEIGHT,
				ARCCARDWIDTH, ARCCARDHEIGHT);
	}

	public void drawFaceUpCard(Graphics pane) {
		pane.setColor(Color.WHITE);
		pane.drawRoundRect(CARDX, CARDY, CARDWIDTH, CARDHEIGHT, ARCCARDWIDTH,
				ARCCARDHEIGHT);
		pane.fillRoundRect(CARDX, CARDY, CARDWIDTH, CARDHEIGHT, ARCCARDWIDTH,
				ARCCARDHEIGHT);
		this.drawSuitValue(pane);
		this.drawNumberValue(pane);

	}

	private void drawNumberValue(Graphics pane) {
		if (numberValue == 2) {
			pane.drawString("2", CARDX + 10, CARDY + 25);
		} else if (numberValue == 3) {
			pane.drawString("3", CARDX + 10, CARDY + 25);
		} else if (numberValue == 4) {
			pane.drawString("4", CARDX + 10, CARDY + 25);
		} else if (numberValue == 5) {
			pane.drawString("5", CARDX + 10, CARDY + 25);
		} else if (numberValue == 6) {
			pane.drawString("6", CARDX + 10, CARDY + 25);
		} else if (numberValue == 7) {
			pane.drawString("7", CARDX + 10, CARDY + 25);
		} else if (numberValue == 8) {
			pane.drawString("8", CARDX + 10, CARDY + 25);
		} else if (numberValue == 9) {
			pane.drawString("9", CARDX + 10, CARDY + 25);
		} else if (numberValue == 10) {
			pane.drawString("10", CARDX + 10, CARDY + 25);
		} else if (numberValue == 11) {
			pane.drawString("J", CARDX + 10, CARDY + 25);
		} else if (numberValue == 12) {
			pane.drawString("Q", CARDX + 10, CARDY + 25);
		} else if (numberValue == 13) {
			pane.drawString("K", CARDX + 10, CARDY + 25);
		} else if (numberValue == 14) {
			pane.drawString("A", CARDX + 10, CARDY + 25);
		}
	}

	private void drawSuitValue(Graphics pane) {
		// Draws the heart suit
		if (suitValue == 1) {
			this.drawHearts(pane);

		} else if (suitValue == 2) {
			// Draws the club suit
			this.drawClubs(pane);

		} else if (suitValue == 3) { // Draws the spade suitValue
			this.drawSpades(pane);

		} else {// Draws the diamond suitValue
			this.drawDiamonds(pane);

		}
	}

	private void drawHearts(Graphics pane) {
		pane.setColor(Color.RED);
		pane.drawOval(CARDX + 10, CARDY + 30, CIRCLEWIDTH, CIRCLEHEIGHT);
		pane.fillOval(CARDX + 10, CARDY + 30, CIRCLEWIDTH, CIRCLEHEIGHT);
		pane.drawOval(CARDX + 45, CARDY + 30, CIRCLEWIDTH, CIRCLEHEIGHT);
		pane.fillOval(CARDX + 45, CARDY + 30, CIRCLEWIDTH, CIRCLEHEIGHT);
		int[] x = { CARDX + 80, CARDX + 20, CARDX + 50 };
		int[] y = { CARDY + 65, CARDY + 65, CARDY + 115 };
		int n = 3;

		Polygon p = new Polygon(x, y, n); // This polygon represents a triangle
											// with the above
											// vertices.

		pane.fillPolygon(p); // Fills the triangle above.
	}

	private void drawClubs(Graphics pane) {
		pane.setColor(Color.RED);
		pane.drawOval(CARDX + 25, CARDY + 10, CIRCLEWIDTH, CIRCLEHEIGHT);
		pane.fillOval(CARDX + 25, CARDY + 10, CIRCLEWIDTH, CIRCLEHEIGHT);
		pane.drawOval(CARDX + 10, CARDY + 30, CIRCLEWIDTH, CIRCLEHEIGHT);
		pane.fillOval(CARDX + 10, CARDY + 30, CIRCLEWIDTH, CIRCLEHEIGHT);
		pane.drawOval(CARDX + 45, CARDY + 30, CIRCLEWIDTH, CIRCLEHEIGHT);
		pane.fillOval(CARDX + 45, CARDY + 30, CIRCLEWIDTH, CIRCLEHEIGHT);
		int[] x = { CARDX + 80, CARDX + 20, CARDX + 50 };
		int[] y = { CARDY + 105, CARDY + 105, CARDY + 50 };
		int n = 3;

		Polygon p = new Polygon(x, y, n);

		pane.fillPolygon(p);
	}

	private void drawSpades(Graphics pane) {
		pane.setColor(Color.RED);
		pane.drawOval(CARDX + 10, CARDY + 50, CIRCLEWIDTH, CIRCLEHEIGHT);
		pane.drawOval(CARDX + 45, CARDY + 50, CIRCLEWIDTH, CIRCLEHEIGHT);
		pane.fillOval(CARDX + 10, CARDY + 50, CIRCLEWIDTH, CIRCLEHEIGHT);
		pane.fillOval(CARDX + 45, CARDY + 50, CIRCLEWIDTH, CIRCLEHEIGHT);

		int[] x1 = { CARDX + 80, CARDX + 20, CARDX + 50 }; // top triangle
		int[] y1 = { CARDY + 75, CARDY + 75, CARDY + 20 };
		int n1 = 3;

		Polygon p = new Polygon(x1, y1, n1);

		pane.fillPolygon(p);

		int[] x2 = { CARDX + 80, CARDX + 20, CARDX + 50 }; // bottom triangle
		int[] y2 = { CARDY + 125, CARDY + 125, CARDY + 70 };
		int n2 = 3;

		Polygon q = new Polygon(x2, y2, n2);

		pane.fillPolygon(q);
	}

	private void drawDiamonds(Graphics pane) {
		pane.setColor(Color.RED);
		int[] x = { CARDX + 50, CARDX + 75, CARDX + 50, CARDX + 20 };
		int[] y = { CARDY + 95, CARDY + 65, CARDY + 40, CARDY + 70 };
		int n = 4;

		Polygon p = new Polygon(x, y, n);

		pane.fillPolygon(p);

	}
}