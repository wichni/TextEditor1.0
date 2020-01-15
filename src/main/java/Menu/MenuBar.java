package Menu;

import javax.swing.*;

public class MenuBar extends JMenuBar {
   private FileMenu fileMenu = new FileMenu();

   public JMenu getFileMenu() {
        return fileMenu.setUpFileMenu();
    }
}