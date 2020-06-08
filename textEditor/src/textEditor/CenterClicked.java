package textEditor;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class CenterClicked {
	protected CenterClicked() {
		cenClicked();
	}
 private  void cenClicked() {
	 StyledDocument doc=textEdit.getDoc();
		int selectionEnd = textEdit.textP.getSelectionEnd();
		int selectionStart = textEdit.textP.getSelectionStart();
		if (selectionStart == selectionEnd) {
			return;
		}
		 SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(selectionStart, textEdit.textP.getSelectedText().length(), center, false);
		textEdit.textP.setDocument(doc);
	}
}
 
