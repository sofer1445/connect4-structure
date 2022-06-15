import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Board extends JFrame {
    private final JButton[][] squares = new JButton[7][];
    private int incForY1;
    private int incForY2;
    private int incForY3;
    private int incForY4;
    private int incForY5;
    private int incForY6;
    private int incForY7;
    private boolean player;


    public Board() {
        this.incForY1 = 1;
        this.incForY2 = 1;
        this.incForY3 = 1;
        this.incForY4 = 1;
        this.incForY5 = 1;
        this.incForY6 = 1;
        this.incForY7 = 1;
        this.player = false;
        boolean winer = false;
        for (int i = 0; i < Constant.BOARD_WIDTH; ++i) {
            this.squares[i] = new JButton[Constant.BOARD_WIDTH];

            for (int j = 0; j < Constant.BOARD_WIDTH; ++j) {
                JButton square = new JButton();
                if (i == 0) {
                    square.setText(String.valueOf(j + 1));
                    square.setBackground(Color.WHITE);
                    square.setFont(new Font(Constant.FONT_NAME, 1, Constant.FONT_SIZE));
                    square.addActionListener((e) -> {
                        switch (square.getText()) {
                            case "1":
                                placeSquare(1, incForY1, check(this.player));
                                player = !player;
                                incForY1++;
                                break;
                            case "2":
                                placeSquare(2, incForY2, check(this.player));
                                player = !player;
                                incForY2++;
                                break;
                            case "3":
                                placeSquare(3, incForY3, check(this.player));
                                player = !player;
                                incForY3++;
                                break;
                            case "4":
                                placeSquare(4, incForY4, check(this.player));
                                player = !player;
                                incForY4++;
                                break;
                            case "5":
                                placeSquare(5, incForY5, check(this.player));
                                player = !player;
                                incForY5++;
                                break;
                            case "6":
                                placeSquare(6, incForY6, check(this.player));
                                player = !player;
                                incForY6++;
                                break;
                            case "7":
                                placeSquare(7, incForY7, check(this.player));
                                player = !player;
                                incForY7++;
                                break;
                        }
                        if (win()) {
                            System.out.println("Player 1 = false\n" +
                                    "Player 2 = true");
                            System.out.println("wiiner " + this.player);
                        }

                    });
                } else {
                    square.setEnabled(false);
                }

                this.squares[i][j] = square;
                this.add(square);
            }
        }

        this.setLocationRelativeTo((Component) null);
        GridLayout gridLayout = new GridLayout(Constant.BOARD_WIDTH, Constant.BOARD_HEIGHT);
        this.setLayout(gridLayout);
        this.setSize(Constant.BOARD_HEIGHT * Constant.SQUARE_SIZE, Constant.BOARD_HEIGHT * Constant.SQUARE_SIZE);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

//    public static boolean winner(Board board, int player) {
//        boolean win = false;
//        for (int i = 1; i < 5; i++) {
//            for (int j = 1; j < 5; j++) {
//                if (board.getPlayerInSquare(i, j) == board.getPlayerInSquare(i + 1, j + 1) && board.getPlayerInSquare(i, j) == board.getPlayerInSquare(i + 2, j + 2) && board.getPlayerInSquare(i, j) == board.getPlayerInSquare(i + 3, j + 3)) {
//                    win = true;
//                    break;
//                }
//                if (board.getPlayerInSquare(i, j) == board.getPlayerInSquare(i + 1, j) && board.getPlayerInSquare(i, j) == board.getPlayerInSquare(i + 2, j) && board.getPlayerInSquare(i, j) == board.getPlayerInSquare(i + 3, j)) {
//                    win = true;
//                    break;
//                }
//                if (board.getPlayerInSquare(i, j) == board.getPlayerInSquare(i + 1, j) && board.getPlayerInSquare(i, j) == board.getPlayerInSquare(i, j + 2) && board.getPlayerInSquare(i, j) == board.getPlayerInSquare(i, j + 3)) {
//                    win = true;
//                    break;
//                }
//            }
//        }
//        return win;
//    }

    private boolean sameButton(JButton button1, JButton button2) {
        return button1 == button2;
    }

    public void placeSquare(int x, int y, int player) {
        this.squares[Constant.BOARD_WIDTH - y][x - 1].setBackground(player == 1 ? Color.RED : Color.YELLOW);
    }

    public int getPlayerInSquare(int x, int y) {
        byte player = 0;

        try {
            Color backgroundColor = this.squares[Constant.BOARD_WIDTH - y][x - 1].getBackground();
            if (backgroundColor.equals(Color.RED)) {
                player = 1;
            } else if (backgroundColor.equals(Color.YELLOW)) {
                player = 2;
            }
        } catch (Exception var5) {
            var5.printStackTrace();
        }

        return player;
    }

    public int check(boolean test) {
        if (test) {
            return 1;
        } else {
            return 2;
        }


    }

//        if (player11 == player21 && player21 == player31 && player31 == player41) {
//
//        }

    public boolean win() {
        int player11;
        int counter1 = 0;
        int counter2 = 0;
        for (int i = 1; i < squares.length - 1; i++) {
            for (int j = 1; j < squares.length - 1; j++) {
                player11 = getPlayerInSquare(j, i);
                if (player11 == 1) {
                    counter1++;
                    if (counter1 == 4) {
                        return true;
                    }
                } else if (player11 == 2) {
                    counter2++;
                    if (counter2 == 4) {
                        return true;
                    }
                }

            }

        }
        return false;
    }
}
