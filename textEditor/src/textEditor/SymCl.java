package textEditor;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;
public class SymCl extends JFrame{
private char[] math = {8704, 8707, 8708,8709, 8710, 8712, 8713, 8715, 8716, 8721, 8723, 8728, 8730, 8734, 8743, 8744, 8745, 8746, 
		8747, 8776, 8793, 8800, 8801, 8804, 8805, 8834, 8835, 8836, 8837, 8838, 8839,169,174,8471,165,123,124,125,126,1160,1421,
		8987,11088,11204,11205,11206,8734,8606,8607,8944,8945,9681,10177};
private JPanel pan = new JPanel();
public SymCl(){
    pan.setPreferredSize(new Dimension(450, 200));
   
    		for (int i = 0; i < math.length; i++){
    	JButton v=new JButton(math[i]+"");
        pan.add(v);
        v.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				    StyledDocument doc=textEdit.getDoc();
				    try {
						doc.insertString(doc.getLength(),((JButton) e.getSource()).getText(), null);
					} catch (BadLocationException e1) {
						e1.printStackTrace();
					}
                    textEdit.textP.setDocument(doc);
			
			}
        	
        });
    }    
    		setSize(new Dimension(450, 270));
    		 add(pan);
    		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    	   setResizable(true);
    pan.setVisible(true);
    setTitle("Symbols");
    show();

}


public static void main(String[] args){
    new SymCl();
}
}