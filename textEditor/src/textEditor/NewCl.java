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

public class NewCl  {
	protected NewCl() {
		try {
			neClicked();
		} catch (IOException | BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
 private  void neClicked() throws IOException, BadLocationException {
	 StyledDocument doc=textEdit.textArea.getStyledDocument();
	 int dialogButton=JOptionPane.showConfirmDialog(textEdit.textArea, "Do you want to save file?", "Opening new file", 
			 JOptionPane.YES_NO_CANCEL_OPTION);
		if ( dialogButton==JOptionPane.YES_OPTION){
			JFileChooser fc=new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter( "*.rtf ", "rtf");
			    fc.addChoosableFileFilter(filter);
			    fc.addChoosableFileFilter(new FileNameExtensionFilter("*.doc", "doc"));
			    fc.setAcceptAllFileFilterUsed(false);
			    fc.showSaveDialog(null);
			    textEdit.textArea.setEditorKit(new RTFEditorKit());
			    try {
			    	String v= fc.getFileFilter().toString().substring(fc.getFileFilter().toString().length()-5);
			    	v=v.substring(0,3);
					FileOutputStream fos=new FileOutputStream(fc.getSelectedFile()+"."+v);
					RTFEditorKit kit=(RTFEditorKit) textEdit.textArea.getEditorKit();
					int len=doc.getLength();
					kit.write(fos, doc, 0, len);
					fos.close();
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				}    
         if(dialogButton== JOptionPane.NO_OPTION) {
        	 textEdit.textArea.setText("");
             }     
	 }
	}
}



