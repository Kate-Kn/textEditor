package textEditor;

import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class LeftClicked {
	protected LeftClicked() {
		leftClicked();
	}

	private void leftClicked() { 
		StyledDocument doc=textEdit.getDoc();
	int selectionEnd = textEdit.textP.getSelectionEnd();
	int selectionStart = textEdit.textP.getSelectionStart();
	if (selectionStart == selectionEnd) {
		return;
	}
	 SimpleAttributeSet center = new SimpleAttributeSet();
	StyleConstants.setAlignment(center, StyleConstants.ALIGN_LEFT);
	doc.setParagraphAttributes(selectionStart, textEdit.textP.getSelectedText().length(), center, false);
	textEdit.textP.setDocument(doc);
	}
}
