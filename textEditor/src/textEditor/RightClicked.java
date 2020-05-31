package textEditor;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class RightClicked  {
	protected RightClicked() {
		riClicked();
	}
 private  void riClicked() {
	 StyledDocument doc = textEdit.textArea.getStyledDocument();
	 SimpleAttributeSet center = new SimpleAttributeSet();
	 StyleConstants.setAlignment(center, StyleConstants.ALIGN_RIGHT);
	 doc.setParagraphAttributes(0,doc.getLength(), center, false);
	}
}
