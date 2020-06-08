package textEditor;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;
import javax.swing.text.rtf.RTFEditorKit;

public class NewCl {
	protected NewCl() {
		neClicked();

	}

	private void neClicked() {
		int dialogButton = JOptionPane.showConfirmDialog(textEdit.textP, "Do you want to save file?",
				"Opening new file", JOptionPane.YES_NO_CANCEL_OPTION);
		if (dialogButton == JOptionPane.YES_OPTION) {
			SaveDoc s = new SaveDoc();
			textEdit.textP.setText("");
			;
		}
		if (dialogButton == JOptionPane.NO_OPTION) {
			textEdit.textP.setText("");
		}
	}
}
