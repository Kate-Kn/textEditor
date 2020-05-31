package textEditor;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class CenterClicked {
	protected CenterClicked() {
		cenClicked();
	}
 private  void cenClicked() {
	 StyledDocument doc = textEdit.textArea.getStyledDocument();
	 SimpleAttributeSet center = new SimpleAttributeSet();
	 StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
	 doc.setParagraphAttributes(0,doc.getLength(), center, false);
	 
	}
}
 
