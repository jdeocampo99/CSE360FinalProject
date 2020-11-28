/**
 * Name			Rebecca Kraft
 *				Justin De Ocampo
 *				Kevin Weinhold
 *				Ishrar Zaman
 * 				Lingge Zhang
 *
 * Email 		rmkraft@asu.edu
 * 				jcdeocam@asu.edu
 * 				kweinho2@asu.edu		
 *				izaman1@asu.edu
 * 				lzhan264@asu.edu
 * 
 * Class		CSE 360	70605
 * Final Project
 * 
 * This class displays group members' names in a dialog box. 
 * 
 * @author 		
 * 
 */

import javax.swing.*;

public class AboutMenu {
    String message = String.join("\n", "Team Members:","Justin De Ocampo",
    		"Rebecca Kraft","Kevin Weinhold","Ishrar Zaman","Lingge Zhang");
    JTextArea infopage;

    /**
     * Renders the about menu and its message
     */
    public void createAboutMenu(){
        JOptionPane.showMessageDialog(infopage , message);
    }
}
