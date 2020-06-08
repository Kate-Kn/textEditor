package textEditor;

import java.io.FileInputStream;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.rtf.RTFEditorKit;

public class OpenCl {
	protected OpenCl() {
		openClicked();
	}

	private void openClicked() {
		int dialogButton=JOptionPane.showConfirmDialog(textEdit.textP, "Do you want to save file?", "Opening file", 
				 JOptionPane.YES_NO_OPTION);
			if ( dialogButton==JOptionPane.YES_OPTION){
				SaveDoc s=new SaveDoc();
				textEdit.textP.setText("");
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
					rtf.read(fi, textEdit.textP.getDocument(), 0);
					fi.close();
				} catch (Exception e) {
					System.out.println("err:" + e.toString());
				}
			}
			if ( dialogButton==JOptionPane.NO_OPTION){
		textEdit.textP.setText("");
		JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("*.rtf" , "rtf");
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
			rtf.read(fi, textEdit.textP.getDocument(), 0);
			fi.close();
		} catch (Exception e) {
			System.out.println("err:" + e.toString());
		}
			}
	}
}