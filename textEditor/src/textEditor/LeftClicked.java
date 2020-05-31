package textEditor;

import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class LeftClicked {
	protected LeftClicked() {
		leftClicked();
	}

	private void leftClicked() {
		StyledDocument doc = textEdit.textArea.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_LEFT);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
	}
}
