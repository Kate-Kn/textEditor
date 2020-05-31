package textEditor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.Action;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.MenuSelectionManager;
import javax.swing.Popup;
import javax.swing.SwingUtilities;
import javax.swing.event.CaretListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Element;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.rtf.RTFEditorKit;

import ajpi_demo.AJPI_Demo;

@SuppressWarnings("serial")
public class textEdit extends javax.swing.JFrame {
	Color selectColor;

	public static void main(String[] args) {
		textEdit te = new textEdit();
	}

	public textEdit() {
		start();
	}

	public void start() {
		textArea = new javax.swing.JTextPane();

		JPopupMenu menu = new JPopupMenu();
		Action cut = new DefaultEditorKit.CutAction();
		cut.putValue(Action.NAME, "Cut");
		cut.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control X"));
		menu.add(cut);

		Action copy = new DefaultEditorKit.CopyAction();
		copy.putValue(Action.NAME, "Copy");
		copy.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control C"));
		menu.add(copy);

		Action paste = new DefaultEditorKit.PasteAction();
		paste.putValue(Action.NAME, "Paste");
		paste.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control V"));
		menu.add(paste);

		textArea.setComponentPopupMenu(menu);
		JMenu m = new JMenu("File");
		JMenu ed = new JMenu("Edit");
		JMenu ad = new JMenu("Additional functions");

		JScrollPane jsp = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		JMenuItem m1 = new JMenuItem("Save");
		m1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SaveDoc s = new SaveDoc();
			}
		});
		JMenuItem m2 = new JMenuItem("Open");
		m2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				OpenCl o=new OpenCl();
			}
		});
		JMenuItem m3 = new JMenuItem("New");
		m3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				NewCl ne = new NewCl();
			}
		});
		JMenuItem m4 = new JMenuItem("Insert photo (only png available)");
		m4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ImageCl im = new ImageCl();
			}
		});
		JMenuItem m5 = new JMenuItem("Quit");
		m5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				StyledDocument doc = textArea.getStyledDocument();
				if (doc != null) {
					int dialogButton = JOptionPane.YES_NO_CANCEL_OPTION;
					int n = JOptionPane.showConfirmDialog(textEdit.textArea, "Do you want to save file?",
							"Closing program", dialogButton);
					if (n == JOptionPane.YES_OPTION) {
						JFileChooser fc = new JFileChooser();
						FileNameExtensionFilter filter = new FileNameExtensionFilter("*.rtf ", "rtf");
						fc.addChoosableFileFilter(filter);
						fc.addChoosableFileFilter(new FileNameExtensionFilter("*.doc", "doc"));
						fc.setAcceptAllFileFilterUsed(false);
						fc.showSaveDialog(null);
						textEdit.textArea.setEditorKit(new RTFEditorKit());

						// System.out.println(fc.getSelectedFile()+"."+v);
						try {
							String v = fc.getFileFilter().toString()
									.substring(fc.getFileFilter().toString().length() - 5);
							v = v.substring(0, 3);
							// System.out.println(fc.getSelectedFile()+"."+v);
							FileOutputStream fos = new FileOutputStream(fc.getSelectedFile() + "." + v);
							RTFEditorKit kit = (RTFEditorKit) textEdit.textArea.getEditorKit();
							int len = doc.getLength();
							kit.write(fos, doc, 0, len);
							fos.close();
						} catch (IOException e) {

							e.printStackTrace();
						} catch (BadLocationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if (n == JOptionPane.NO_OPTION)
						frame.dispose();

				} else {
					frame.dispose();
				}
			}

		});

		JMenuItem color = new JMenuItem("Change color");
		color.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Color jColor = selectColor;
				if ((jColor = JColorChooser.showDialog(frame, "Select color", jColor)) != null) {
					selectColor = jColor;
					textArea.setForeground(selectColor);
				}
			}
		});
		JMenuItem bold = new JMenuItem("Make bold");
		Font fo = new Font("arial black", Font.BOLD, 12);
		bold.setFont(fo);
		bold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				StyledDocument doc = (StyledDocument) textArea.getDocument();
				int selectionEnd = textArea.getSelectionEnd();
				int selectionStart = textArea.getSelectionStart();
				if (selectionStart == selectionEnd) {
					return;
				}
				Element element = doc.getCharacterElement(selectionStart);
				AttributeSet as = element.getAttributes();
				MutableAttributeSet asNew = new SimpleAttributeSet(as.copyAttributes());
				StyleConstants.setBold(asNew, !StyleConstants.isBold(as));
				doc.setCharacterAttributes(selectionStart, textArea.getSelectedText().length(), asNew, true);
			}
		});
		JMenuItem italic = new JMenuItem("Italicize your text");
		italic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				StyledDocument doc = (StyledDocument) textArea.getDocument();
				int selectionEnd = textArea.getSelectionEnd();
				int selectionStart = textArea.getSelectionStart();
				if (selectionStart == selectionEnd) {
					return;
				}
				Element element = doc.getCharacterElement(selectionStart);
				AttributeSet as = element.getAttributes();
				MutableAttributeSet asNew = new SimpleAttributeSet(as.copyAttributes());
				StyleConstants.setItalic(asNew, !StyleConstants.isItalic(as));
				doc.setCharacterAttributes(selectionStart, textArea.getSelectedText().length(), asNew, true);
			}
		});
		Font f = new Font("sans-serif", Font.ITALIC, 12);

		italic.setFont(f);
		JMenuItem underline = new JMenuItem("<html><u>Underline your text</u></html>");
		underline.setMnemonic('U');
		
		underline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				StyledDocument doc = (StyledDocument) textArea.getDocument();
				int selectionEnd = textArea.getSelectionEnd();
				int selectionStart = textArea.getSelectionStart();
				if (selectionStart == selectionEnd) {
					return;
				}
				Element element = doc.getCharacterElement(selectionStart);
				AttributeSet as = element.getAttributes();
				MutableAttributeSet asNew = new SimpleAttributeSet(as.copyAttributes());
				StyleConstants.setUnderline(asNew, !StyleConstants.isUnderline(as));
				doc.setCharacterAttributes(selectionStart, textArea.getSelectedText().length(), asNew, true);
			}
		});
		al = new JMenuItem("Align left");
		al.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LeftClicked le = new LeftClicked();
			}
		});
		JMenuItem ar = new JMenuItem("Align right");
		ar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				RightClicked ri = new RightClicked();
			}
		});
		ce = new JMenuItem("Center your text");
		ce.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				CenterClicked ce = new CenterClicked();
			}
		});
		JMenuItem justify = new JMenuItem("Justify");
		justify.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				JustifyClicked juct = new JustifyClicked();
			}
		});
		JMenuItem letter = new JMenuItem("Calculate number of letters");
		letter.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				String str = textArea.getText();
				int count = 0;
				for (int i = 0; i < str.length(); i++) {
					if (Character.isLetter(str.charAt(i)))
						count++;
				}
				JOptionPane.showMessageDialog(frame, "The number of letters  is " + count, "Number of symbols",
						JOptionPane.PLAIN_MESSAGE);
			}
		});
		JMenuItem sym = new JMenuItem("Calculate number of symbols (space included)");
		sym.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				int n = textArea.getText().length();
				JOptionPane.showMessageDialog(frame, "The number of symbols (space included) is " + n,
						"Number of symbols", JOptionPane.PLAIN_MESSAGE);
			}
		});
		JMenuItem dAT = new JMenuItem("Date and time");
		dAT.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {

			}
		});
		JMenuItem rep = new JMenuItem("Replace all occurrence of the word");
		JMenuItem oL = new JMenuItem("Create ordered list");
		JMenuItem uoL = new JMenuItem("Create unordered list");

		m.add(m1);
		m.add(m2);
		m.add(m3);
		m.add(m4);
		m.add(m5);

		ed.add(color);
		ed.add(al);
		ed.add(ar);
		ed.add(ce);
		ed.add(justify);
		ed.add(bold);
		ed.add(italic);
		ed.add(underline);

		ad.add(letter);
		ad.add(sym);
		ad.add(dAT);
		ad.add(rep);
		ad.add(oL);
		ad.add(uoL);
		Font fon=new Font("sans-serif", Font.PLAIN, 12);
		m.setFont(fon);
		ad.setFont(fon);
		ed.setFont(fon);
		font = new JLabel();
		sizeL = new JLabel();
		jcbFont = new JComboBox();
		jcbSelectSize = new JComboBox();
		jToolBar1 = new JToolBar();
		font.setText("Font");
		jToolBar1.add(font);
		GraphicsEnvironment gEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] fontNames = gEnv.getAvailableFontFamilyNames();
		ComboBoxModel model = new DefaultComboBoxModel(fontNames);
		jcbFont.setModel(model);
		jcbFont.setFont(fon);
		jcbFont.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				fontAction();
			}
		});
		jToolBar1.add(jcbFont);

		sizeL.setText("Size");
		jToolBar1.add(sizeL);

		jcbSelectSize.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "10", "14", "18", "22", "26", "30", "34", "36", "40", "44", "48", "52" }));
		jcbSelectSize.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				sizeAction();
			}
		});
		jcbSelectSize.setFont(fon);
		jToolBar1.add(jcbSelectSize);
		JMenuBar mb = new JMenuBar();
		mb.add(m);
		mb.add(ed);
		mb.add(ad);

		frame = new JFrame();
		frame.setTitle("Text Editor");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setJMenuBar(mb);
		frame.getContentPane().add(jsp);
		frame.getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(screenSize.width, screenSize.height);
	}

	private void sizeAction() {
		String getSize = jcbSelectSize.getSelectedItem().toString();
		Font f = textArea.getFont();
		textArea.setFont(new Font(f.getFontName(), f.getStyle(), Integer.parseInt(getSize)));
	}

	private void fontAction() {
		textArea.setFont(new Font(jcbFont.getSelectedItem().toString(), Font.PLAIN,
				Integer.parseInt(jcbSelectSize.getSelectedItem().toString())));
	}

	protected javax.swing.JMenu m;
	protected javax.swing.JMenuItem ce;
	protected javax.swing.JMenuItem al;
	protected javax.swing.JMenuItem justify;
	protected javax.swing.JMenu size;
	protected static javax.swing.JTextPane textArea;
	protected static JFrame frame;
	private JToolBar jToolBar1;
	private JComboBox jcbFont;
	private JComboBox jcbSelectSize;
	private javax.swing.JLabel lblPosition;
	private javax.swing.JLabel lblStatus;
	private javax.swing.JLabel font;
	private javax.swing.JLabel sizeL;

}
