package textEditor;
import javax.swing.text.AttributeSet;
import javax.swing.text.Element;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class RightClicked  {
	protected RightClicked() {
		riClicked();
	}
 private  void riClicked() {
	 StyledDocument doc=textEdit.getDoc();
		int selectionEnd = textEdit.textP.getSelectionEnd();
		int selectionStart = textEdit.textP.getSelectionStart();
		if (selectionStart == selectionEnd) {
			return;
		}
		 SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_RIGHT);
		doc.setParagraphAttributes(selectionStart, textEdit.textP.getSelectedText().length(), center, false);
		textEdit.textP.setDocument(doc);
	}
}
