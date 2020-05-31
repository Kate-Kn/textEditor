package textEditor;

import java.io.FileInputStream;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.rtf.RTFEditorKit;

public class OpenCl {
	protected OpenCl() {
		openClicked();
	}

	private void openClicked() {
		JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("*.rtf ", "rtf");
		fc.addChoosableFileFilter(filter);
		fc.addChoosableFileFilter(new FileNameExtensionFilter("*.doc", "doc"));
		fc.setAcceptAllFileFilterUsed(false);
		fc.showOpenDialog(null);
		String fileName = "";
		if (fc.showOpenDialog(textEdit.frame) == JFileChooser.APPROVE_OPTION) {
			fileName = fc.getSelectedFile().getAbsolutePath();
		} else {
			return;
		}
		RTFEditorKit rtf = new RTFEditorKit();
		try {
			FileInputStream fi = new FileInputStream(fileName);
			rtf.read(fi, textEdit.textArea.getDocument(), 0);
			fi.close();
		} catch (Exception e) {
			System.out.println("err:" + e.toString());
		}
	}
}