import javax.swing.*;

public class AboutMenu {
    String message = String.join("\n", "Team Members:","Justin De Ocampo","Rebecca Kraft","Kevin Weinhold");
    JTextArea infopage;

    /**
     * Renders the about menu and its message
     */
    public void createAboutMenu(){
        JOptionPane.showMessageDialog(infopage , message);
    }
}