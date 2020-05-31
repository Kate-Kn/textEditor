package textEditor;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.MenuElement;
import javax.swing.MenuSelectionManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Main extends JFrame {
  public Main() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container cp = getContentPane();
    cp.setLayout(new FlowLayout());

    JMenuBar mb = new JMenuBar();
    setJMenuBar(mb);

    JMenu om = new JMenu("Options");
    JMenu opSubm = new JMenu("SubOptions");
    opSubm.add(new JMenuItem("Alpha"));
    opSubm.add(new JMenuItem("Gamma"));
    opSubm.add(new JMenuItem("Delta"));
    om.add(opSubm);
    mb.add(om);

    MenuSelectionManager.defaultManager().addChangeListener(
        new ChangeListener() {
          public void stateChanged(ChangeEvent evt) {

            MenuElement[] path = MenuSelectionManager.defaultManager()
                .getSelectedPath();

            if (path.length == 0) {
              System.out.println("No menus are opened or menu items selected"); 
            }
            for (int i = 0; i < path.length; i++) {
              Component c = path[i].getComponent();

              if (c instanceof JMenuItem) {
                JMenuItem mi = (JMenuItem) c;
                String label = mi.getText();
              }
            }

          }
        });

    pack();
  }
  public static void main(String[] arg) {
    Main mb = new Main();
    mb.setVisible(true);
  }
}
