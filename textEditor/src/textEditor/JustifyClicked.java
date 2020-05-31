 package textEditor;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class JustifyClicked  {
	protected JustifyClicked() {
		juClicked();
	}
 private  void juClicked() {
	 StyledDocument doc = textEdit.textArea.getStyledDocument();
	 SimpleAttributeSet center = new SimpleAttributeSet();
	 StyleConstants.setAlignment(center, StyleConstants.ALIGN_JUSTIFIED);
	 doc.setParagraphAttributes(0,doc.getLength(), center, false);
	}
}
