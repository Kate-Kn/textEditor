package textEditor;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.rtf.RTFEditorKit;

public class SaveDoc {
	protected SaveDoc() {
		saveClicked();
	}

	private void saveClicked() {
		JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("*.rtf ", "rtf");
		fc.addChoosableFileFilter(filter);
		fc.addChoosableFileFilter(new FileNameExtensionFilter("*.doc", "doc"));
		fc.setAcceptAllFileFilterUsed(false);
		fc.showSaveDialog(null);
		textEdit.textArea.setEditorKit(new RTFEditorKit());
		StyledDocument doc = textEdit.textArea.getStyledDocument();
		try {
			String v = fc.getFileFilter().toString().substring(fc.getFileFilter().toString().length() - 5);
			v = v.substring(0, 3);
			FileOutputStream fos = new FileOutputStream(fc.getSelectedFile() + "." + v);
			RTFEditorKit kit = (RTFEditorKit) textEdit.textArea.getEditorKit();
			int len = doc.getLength();
			kit.write(fos, doc, 0, len);
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}
}
