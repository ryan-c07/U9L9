import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Point;
import java.util.ArrayList;
import java.awt.Font;

class DrawPanel extends JPanel implements MouseListener {

    private ArrayList<Card> hand;
    private Rectangle button;
    private Rectangle replaceButton;

    public DrawPanel() {
        button = new Rectangle(147, 400, 160, 26);
        replaceButton = new Rectangle(270, 0, 160, 26);
        this.addMouseListener(this);
        hand = Card.buildHand();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = 50;
        int y = 10;
        for (int i = 0; i < hand.size(); i++) {
            Card c = hand.get(i);
            if (i != 0 && i % 3 == 0) {
                x = 50;
                y = y + c.getImage().getHeight() + 10;
            }
            if (c.getHighlight()) {
                g.drawRect(x, y, c.getImage().getWidth(), c.getImage().getHeight());
            }
            c.setRectangleLocation(x, y);
            g.drawImage(c.getImage(), x, y, null);
            x = x + c.getImage().getWidth() + 10;
        }
        g.setFont(new Font("Courier New", Font.BOLD, 20));
        g.drawString("PlAY AGAIN", 150, 420);
        g.drawRect((int) button.getX(), (int) button.getY(), (int) button.getWidth(), (int) button.getHeight());
        g.drawString("REPLACE CARDS", 273, 20);
        g.drawRect((int) replaceButton.getX(), (int) replaceButton.getY(), (int) replaceButton.getWidth(), (int) replaceButton.getHeight());
        g.drawString("Cards Left: " + Card.getDeck().size(), 0, 450);
        if (Card.getDeck().isEmpty()) {
            g.drawString("YOU WIN! ", 250, 450);
        }
        else if (checkLost()) {
            g.drawString("NO AVAILABLE MOVES! GAME OVER!", 250, 450);
        }

    }

    public void mousePressed(MouseEvent e) {

        Point clicked = e.getPoint();

        if (e.getButton() == 1) {
            if (button.contains(clicked)) {
                Card.setDeck(Card.buildDeck());
                hand = Card.buildHand();
            }
            if (replaceButton.contains(clicked)) {
                checkMoves();
            }
            for (int i = 0; i < hand.size(); i++) {
                Rectangle box = hand.get(i).getCardBox();
                if (box.contains(clicked)) {
                    hand.get(i).flipCard();
                }
            }
        }

        if (e.getButton() == 3) {
            int hightlightCount = 0;
            for (int i = 0; i < hand.size(); i++) {
                Rectangle box = hand.get(i).getCardBox();
                if (box.contains(clicked) && hightlightCount < 4) {
                    hand.get(i).flipHighlight();
                    hightlightCount++;
                }
            }
        }


    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }
    public boolean checkLost(){
        int numOfA = 0;
        int numOf2 = 0;
        int numOf3 = 0;
        int numOf4 = 0;
        int numOf5 = 0;
        int numOf6 = 0;
        int numOf7 = 0;
        int numOf8 = 0;
        int numOf9 = 0;
        int numOf0 = 0;
        int numOfJ = 0;
        int numOfQ = 0;
        int numOfK = 0;
        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i).getValue().equals("A")) {
                numOfA++;
            }
            if (hand.get(i).getValue().equals("02")) {
                numOf2++;
            }
            if (hand.get(i).getValue().equals("03")) {
                numOf3++;
            }
            if (hand.get(i).getValue().equals("04")) {
                numOf4++;
            }
            if (hand.get(i).getValue().equals("05")) {
                numOf5++;
            }
            if (hand.get(i).getValue().equals("06")) {
                numOf6++;
            }
            if (hand.get(i).getValue().equals("07")) {
                numOf7++;
            }
            if (hand.get(i).getValue().equals("08")) {
                numOf8++;
            }
            if (hand.get(i).getValue().equals("09")) {
                numOf9++;
            }
            if (hand.get(i).getValue().equals("10")) {
                numOf0++;
            }
            if (hand.get(i).getValue().equals("J")) {
                numOfJ++;
            }
            if (hand.get(i).getValue().equals("Q")) {
                numOfQ++;
            }
            if (hand.get(i).getValue().equals("K")) {
                numOfK++;
            }
        }
        if (numOfA >= 1 && numOf0 >= 1){
            return false;
        }
        if (numOf2 >= 1 && numOf9 >= 1){
            return false;
        }
        if (numOf3 >= 1 && numOf8 >= 1){
            return false;
        }
        if (numOf4 >= 1 && numOf7 >= 1){
            return false;
        }
        if (numOf5 >= 1 && numOf6 >= 1){
            return false;
        }
        if (numOfJ >= 1 && numOfQ >= 1 && numOfK >= 1){
            return false;
        }
        return true;
    }
    public void checkMoves() {
        int sum = 0;
        int num = 0;
        int numOfJ = 0;
        int numOfQ = 0;
        int numOfK = 0;
        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i).getHighlight()) {
                if (hand.get(i).getValue().equals("A")) {
                    sum = sum + 1;
                }
                if (hand.get(i).getValue().equals("02")) {
                    sum = sum + 2;
                }
                if (hand.get(i).getValue().equals("03")) {
                    sum = sum + 3;
                }
                if (hand.get(i).getValue().equals("04")) {
                    sum = sum + 4;
                }
                if (hand.get(i).getValue().equals("05")) {
                    sum = sum + 5;
                }
                if (hand.get(i).getValue().equals("06")) {
                    sum = sum + 6;
                }
                if (hand.get(i).getValue().equals("07")) {
                    sum = sum + 7;
                }
                if (hand.get(i).getValue().equals("08")) {
                    sum = sum + 8;
                }
                if (hand.get(i).getValue().equals("09")) {
                    sum = sum + 9;
                }
                if (hand.get(i).getValue().equals("10")) {
                    sum = sum + 10;
                }
                if (hand.get(i).getValue().equals("J")) {
                    numOfJ++;
                }
                if (hand.get(i).getValue().equals("Q")) {
                    numOfQ++;
                }
                if (hand.get(i).getValue().equals("K")) {
                    numOfK++;
                }
                num++;
            }
        }
        if (sum == 11 && num == 2) {
            for (int i = 0; i < hand.size(); i++) {
                if (hand.get(i).getHighlight()) {
                    hand.set(i, Card.replaceCard(hand));
                }
            }
        }
        else if (numOfJ == 1 && numOfQ == 1 && numOfK == 1 && num == 3) {
            for (int i = 0; i < hand.size(); i++) {
                if (hand.get(i).getHighlight()) {
                    hand.set(i, Card.replaceCard(hand));
                }
            }
        }
    }
}