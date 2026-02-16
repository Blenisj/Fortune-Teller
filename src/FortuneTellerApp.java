import javax.swing.SwingUtilities;

public class FortuneTellerApp {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new FortuneTellerFrame();
        });
    }
}