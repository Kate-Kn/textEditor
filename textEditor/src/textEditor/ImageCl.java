package textEditor;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImageCl {
	protected ImageCl() {
		imageClicked();
	}

	private void imageClicked() {
		JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("*.png ", "png");
		fc.addChoosableFileFilter(filter);
		fc.setAcceptAllFileFilterUsed(false);
		fc.showOpenDialog(null);
		textEdit.textArea.insertIcon(new ImageIcon(fc.getSelectedFile().getAbsolutePath()));
	}
}