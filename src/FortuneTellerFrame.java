import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {

    private JTextArea fortuneArea;
    private ArrayList<String> fortunes;
    private Random random;
    private int lastIndex = -1;

    public FortuneTellerFrame() {

        super("Fortune Teller");

        random = new Random();

        Font titleFont = new Font("Serif", Font.BOLD, 48);
        Font buttonFont = new Font("SansSerif", Font.BOLD, 20);
        Font fortuneFont = new Font("Monospaced", Font.PLAIN, 18);

        JPanel topPanel = new JPanel();

        ImageIcon icon = new ImageIcon(getClass().getResource("/istockphoto-619772718-612x612.jpg"));
        JLabel titleLabel = new JLabel("Fortune Teller", icon, JLabel.CENTER);

        titleLabel.setHorizontalTextPosition(JLabel.CENTER);
        titleLabel.setVerticalTextPosition(JLabel.BOTTOM);
        titleLabel.setFont(titleFont);

        topPanel.add(titleLabel);

        fortuneArea = new JTextArea(10, 40);
        fortuneArea.setFont(fortuneFont);
        fortuneArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(fortuneArea);

        JPanel bottomPanel = new JPanel();

        JButton fortuneButton = new JButton("Read My Fortune!");
        JButton quitButton = new JButton("Quit");

        fortuneButton.setFont(buttonFont);
        quitButton.setFont(buttonFont);

        bottomPanel.add(fortuneButton);
        bottomPanel.add(quitButton);

        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        int width = (int)(screenSize.width * 0.75);
        int height = (int)(screenSize.height * 0.75);

        setSize(width, height);
        setLocationRelativeTo(null);

        fortunes = new ArrayList<>();
        fortunes.add("You will step on a Lego soon");
        fortunes.add("Your code will never compile today");
        fortunes.add("You will be hungrier than usual");
        fortunes.add("You will survive your next exam");
        fortunes.add("Beware of group projects");
        fortunes.add("You will find your wallet in an old jacket");
        fortunes.add("Your WiFi will go out");
        fortunes.add("A nap will be needed today");
        fortunes.add("You will discover a new favorite song");
        fortunes.add("Someone is going to compliment your outfit");
        fortunes.add("your crush is going to ghost you");
        fortunes.add("You will feel better than usual");

        fortuneButton.addActionListener(e -> showFortune());

        quitButton.addActionListener(e -> System.exit(0));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void showFortune() {

        int newIndex;

        do {
            newIndex = random.nextInt(fortunes.size());
        } while (newIndex == lastIndex);

        lastIndex = newIndex;

        fortuneArea.append(fortunes.get(newIndex) + "\n");
    }
}