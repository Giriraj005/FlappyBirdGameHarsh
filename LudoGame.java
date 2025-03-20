import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class LudoGame extends JFrame {
    private JButton rollDiceButton;
    private JLabel diceResultLabel;
    private JLabel turnLabel;
    private JPanel boardPanel;
    private int currentPlayer = 0;
    private Random random;
    
    private String[] players = {"Red", "Blue", "Green", "Yellow"};
    private int[] playerPositions = {-1, -1, -1, -1};

    public LudoGame() {
        setTitle("Ludo Game");
        setSize(500, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        random = new Random();

        JPanel controlPanel = new JPanel();
        rollDiceButton = new JButton("Roll Dice");
        diceResultLabel = new JLabel("Dice: 0");
        turnLabel = new JLabel("Current Turn: Red");
        
        rollDiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rollDice();
            }
        });

        controlPanel.add(rollDiceButton);
        controlPanel.add(diceResultLabel);
        controlPanel.add(turnLabel);
        add(controlPanel, BorderLayout.NORTH);

        boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(7, 7));
        createBoard();
        add(boardPanel, BorderLayout.CENTER);
    }

    private void createBoard() {
        boardPanel.removeAll();
        for (int i = 0; i < 49; i++) {
            JPanel cell = new JPanel();
            cell.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            cell.setBackground(Color.WHITE);
            boardPanel.add(cell);
        }
        updatePlayerPositions();
    }

    private void rollDice() {
        int diceRoll = random.nextInt(6) + 1;
        diceResultLabel.setText("Dice: " + diceRoll);
        movePlayer(diceRoll);
    }

    private void movePlayer(int steps) {
        if (playerPositions[currentPlayer] == -1 && steps == 6) {
            playerPositions[currentPlayer] = 0;
        } else if (playerPositions[currentPlayer] >= 0) {
            playerPositions[currentPlayer] += steps;
            if (playerPositions[currentPlayer] >= 48) {
                playerPositions[currentPlayer] = 48;
                checkWin();
            }
        }
        updatePlayerPositions();
        nextTurn(steps);
    }

    private void updatePlayerPositions() {
        Component[] cells = boardPanel.getComponents();
        for (Component cell : cells) {
            cell.setBackground(Color.WHITE);
        }
        for (int i = 0; i < players.length; i++) {
            if (playerPositions[i] >= 0) {
                cells[playerPositions[i]].setBackground(getPlayerColor(i));
            }
        }
    }

    private void nextTurn(int steps) {
        if (steps != 6) {
            currentPlayer = (currentPlayer + 1) % 4;
        }
        turnLabel.setText("Current Turn: " + players[currentPlayer]);
    }

    private void checkWin() {
        if (playerPositions[currentPlayer] == 48) {
            JOptionPane.showMessageDialog(this, players[currentPlayer] + " wins the game!");
            resetGame();
        }
    }

    private void resetGame() {
        playerPositions = new int[]{-1, -1, -1, -1};
        currentPlayer = 0;
        updatePlayerPositions();
    }

    private Color getPlayerColor(int playerIndex) {
        switch (playerIndex) {
            case 0: return Color.RED;
            case 1: return Color.BLUE;
            case 2: return Color.GREEN;
            case 3: return Color.YELLOW;
            default: return Color.BLACK;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LudoGame game = new LudoGame();
            game.setVisible(true);
        });
    }
}
import javax.swing.*;
import java.awt.*;

public class LudoGame extends JFrame {
    private Image boardImage;

    public LudoGame() {
        setTitle("Ludo Game");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Load board image
        boardImage = new ImageIcon("assets/ludo_board.png").getImage();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(boardImage, 50, 50, 500, 500, this); // Adjust size and position
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LudoGame game = new LudoGame();
            game.setVisible(true);
        });
    }
}
