 package textEditor;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class JustifyClicked  {
	protected JustifyClicked() {
		juClicked();
	}
 private  void juClicked() {
	 StyledDocument doc=textEdit.getDoc();
		int selectionEnd = textEdit.textP.getSelectionEnd();
		int selectionStart = textEdit.textP.getSelectionStart();
		if (selectionStart == selectionEnd) {
			return;
		}
		 SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_JUSTIFIED);
		doc.setParagraphAttributes(selectionStart, textEdit.textP.getSelectedText().length(), center, false);
		textEdit.textP.setDocument(doc);
	}
}
