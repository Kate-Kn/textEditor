package textEditor;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.LinkedList;

import javax.swing.Action;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.ListCellRenderer;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.Element;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;


@SuppressWarnings("serial")
public class textEdit extends javax.swing.JFrame {
	Color selectColor;
	String fontName[];
	enum BulletActionType {INSERT, REMOVE};
	enum NumbersActionType {INSERT, REMOVE};
	static boolean im = false;

	public static void main(String[] args) {
		textEdit te = new textEdit();
	}

	public textEdit() {
		start();
	}

	public void start() {
		textP = new JTextPane();

		JPopupMenu menu = new JPopupMenu();
		JMenuItem sele = new JMenuItem("Select all");
		sele.setAccelerator(KeyStroke.getKeyStroke('A', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		sele.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				textP.selectAll();
			}
		});

		menu.add(sele);

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

		textP.setComponentPopupMenu(menu);
		JMenu m = new JMenu("File");
		JMenu ed = new JMenu("Edit");
		JMenu ad = new JMenu("Additional functions");

		JScrollPane jsp = new JScrollPane(textP, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
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
				OpenCl o = new OpenCl();
			}
		});
		JMenuItem m3 = new JMenuItem("New");
		m3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				// var x=10;
				NewCl ne = new NewCl();
			}
		});
		/*
		 * JMenuItem m4 = new JMenuItem("Insert photo (only png available)");
		 * m4.addActionListener(new java.awt.event.ActionListener() { public void
		 * actionPerformed(java.awt.event.ActionEvent evt) { im=true; ImageCl im = new
		 * ImageCl(); } });
		 */
		JMenuItem m5 = new JMenuItem("Quit");
		m5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				StyledDocument doc = textP.getStyledDocument();
				int dialogButton = JOptionPane.YES_NO_CANCEL_OPTION;
				int n = JOptionPane.showConfirmDialog(textP, "Do you want to save file?",
						"Closing program", dialogButton);
				if (n == JOptionPane.YES_OPTION) {
				SaveDoc s=new SaveDoc();
				frame.dispose();
				}
					if (n == JOptionPane.NO_OPTION)
						frame.dispose();
				
			}

		});

		JMenuItem color = new JMenuItem("Change foreground");
		color.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Color jColor = JColorChooser.showDialog(frame, "Select color", selectColor);
				if (jColor != null) {
					int selectionEnd = textP.getSelectionEnd();
					int selectionStart = textP.getSelectionStart();
					if (selectionStart == selectionEnd) {
						return;
					}
					StyledDocument doc = textP.getStyledDocument();
					SimpleAttributeSet asNew = new SimpleAttributeSet();
					StyleConstants.setForeground(asNew, jColor);
					doc.setCharacterAttributes(selectionStart, textP.getSelectedText().length(), asNew, false);
					textP.setDocument(doc);
				}
			}
		});
		JMenuItem bColor = new JMenuItem("Change background");
		bColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Color jColor = JColorChooser.showDialog(frame, "Select color", selectColor);
				if (jColor != null) {
					int selectionEnd = textP.getSelectionEnd();
					int selectionStart = textP.getSelectionStart();
					if (selectionStart == selectionEnd) {
						return;
					}
					StyledDocument doc = textP.getStyledDocument();
					SimpleAttributeSet asNew = new SimpleAttributeSet();
					StyleConstants.setBackground(asNew, jColor);
					doc.setCharacterAttributes(selectionStart, textP.getSelectedText().length(), asNew, false);
					textP.setDocument(doc);
				}
			}
		});
		JMenuItem bold = new JMenuItem("Make bold");
		Font fo = new Font("arial black", Font.BOLD, 12);
		bold.setFont(fo);
		bold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				StyledDocument doc = (StyledDocument) textP.getDocument();
				int selectionEnd = textP.getSelectionEnd();
				int selectionStart = textP.getSelectionStart();
				if (selectionStart == selectionEnd) {
					return;
				}
				Element element = doc.getCharacterElement(selectionStart);
				 AttributeSet as = element.getAttributes();
				MutableAttributeSet asNew = new SimpleAttributeSet(as.copyAttributes());
				StyleConstants.setBold(asNew, !StyleConstants.isBold(as));
				doc.setCharacterAttributes(selectionStart, textP.getSelectedText().length(), asNew, false);
			}
		});
		JMenuItem italic = new JMenuItem("Italicize your text");
		italic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				StyledDocument doc = (StyledDocument) textP.getDocument();
				int selectionEnd = textP.getSelectionEnd();
				int selectionStart = textP.getSelectionStart();
				if (selectionStart == selectionEnd) {
					return;
				}
				 Element element = doc.getCharacterElement(selectionStart);
				 AttributeSet as = element.getAttributes();
				MutableAttributeSet asNew = new SimpleAttributeSet(as.copyAttributes());
				StyleConstants.setItalic(asNew, !StyleConstants.isItalic(as));
				doc.setCharacterAttributes(selectionStart, textP.getSelectedText().length(), asNew, false);
			}
		});
		Font f = new Font("sans-serif", Font.ITALIC, 12);

		italic.setFont(f);
		JMenuItem underline = new JMenuItem("<html><u>Underline your text</u></html>");
		underline.setMnemonic('U');

		underline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				StyledDocument doc = (StyledDocument) textP.getDocument();
				int selectionEnd = textP.getSelectionEnd();
				int selectionStart = textP.getSelectionStart();
				if (selectionStart == selectionEnd) {
					return;
				}
				Element element = doc.getCharacterElement(selectionStart);
				 AttributeSet as = element.getAttributes();
				MutableAttributeSet asNew = new SimpleAttributeSet(as.copyAttributes());
				StyleConstants.setUnderline(asNew, !StyleConstants.isUnderline(as));
				doc.setCharacterAttributes(selectionStart, textP.getSelectedText().length(), asNew, false);
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
		letter.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				String str = textP.getText();
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
		sym.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				int n = textP.getStyledDocument().getLength();
				JOptionPane.showMessageDialog(frame, "The number of symbols (space included) is " + n,
						"Number of symbols", JOptionPane.PLAIN_MESSAGE);
			}
		});
		JMenuItem dAT = new JMenuItem("Date and time");
		dAT.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				StyledDocument doc = textP.getStyledDocument();
				try {
					doc.insertString(doc.getLength(), LocalDateTime.now().toString(), null);
				} catch (BadLocationException e) {
					e.printStackTrace();
				}
				textP.setDocument(doc);

			}
		});
		JMenuItem insS = new JMenuItem("Insert symbol");
		insS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SymCl s = new SymCl();
			}
		});
		JMenuItem rep = new JMenuItem("Replace all occurrence of the word");
		rep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				JPanel myPanel = new JPanel();
				JTextField rep = new JTextField(15);
				JTextField repT = new JTextField(15);
				myPanel.add(new JLabel("Replace: "));
				myPanel.add(rep);
				myPanel.add(new JLabel("Replace to: "));
				myPanel.add(repT);
				int result = JOptionPane.showConfirmDialog(null, myPanel,
						"Replacement (empty cell is regarded as a space)", JOptionPane.OK_CANCEL_OPTION);
				String replace = "";
				String replaceTo = "";
				if (result == JOptionPane.OK_OPTION) {
					replace = rep.getText();
					replaceTo = repT.getText();
				}
				if (replace.equals("")) {
					replace = " ";
				}
				if (replaceTo.equals("")) {
					replaceTo = " ";
				}
				StyledDocument doc = textP.getStyledDocument();			
				//Style st = doc.getStyle(textP.getText());
				LinkedList <MutableAttributeSet> list=new LinkedList<>();
				LinkedList <Alignment> lis=new LinkedList<>();
				int l=doc.getLength();
				for(int i=0;i<l;i++) {
				Element element = doc.getCharacterElement(i);
				AttributeSet as = element.getAttributes();
				MutableAttributeSet asNew=new SimpleAttributeSet(as.copyAttributes());
				list.add(asNew);
				
				}		
				String v = textP.getText();
				String r = v.replaceAll(replace, replaceTo);
				try {
					doc.remove(0, doc.getLength());
				} catch (BadLocationException e) {
					e.printStackTrace();
				}
				try {
					 SimpleAttributeSet aSet = new SimpleAttributeSet();
					for(int i=1;i<=r.length();i++) {
						if(i-1<list.size()) {
					  doc.insertString(i-1, r.substring(i-1,i), list.get(i-1));
						}else {
							doc.insertString(i-1,r.substring(i-1,i),list.get(list.size()-1));
						}
					
					}
				} catch (BadLocationException e) {
					e.printStackTrace();
				}

				textP.setDocument(doc);
			}

		});
		/*JMenuItem oL = new JMenuItem("Create ordered list");
		oL.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {	
			}
			
			
		});*/
		//JMenuItem uoL = new JMenuItem("Create unordered list");

		m.add(m1);
		m.add(m2);
		m.add(m3);
		// m.add(m4);
		m.add(m5);

		ed.add(color);
		ed.add(bColor);
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
		//ad.add(oL);
		//ad.add(uoL);
		ad.add(insS);
		Font fon = new Font("sans-serif", Font.PLAIN, 12);
		m.setFont(fon);
		ad.setFont(fon);
		ed.setFont(fon);
		font = new JLabel();
		sizeL = new JLabel();
		fontC = new JComboBox();
		jcbSelectSize = new JComboBox();
		jToolBar1 = new JToolBar();
		font.setText("Font");
		jToolBar1.add(font);
         jToolBar1.setFont(fon);
		Integer array[];
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		fontName = ge.getAvailableFontFamilyNames();
		array = new Integer[fontName.length];
		for (int i = 1; i <= fontName.length; i++) {
			array[i - 1] = i;
		}
		fontC = new JComboBox(array);
		ComboBoxRenderar renderar = new ComboBoxRenderar();
		fontC.setRenderer(renderar);
		jToolBar1.add(fontC);
		fontC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				System.out.println("Here");
				fontAction();
			}
		});
		jToolBar1.add(fontC);
		sizeL.setText("Size");
		jToolBar1.add(sizeL);

		jcbSelectSize.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "10", "14", "18", "22", "26", "30", "34", "36", "40", "44", "48", "52" }));
		jcbSelectSize.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				sizeAction();
			}
		});
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
		StyledDocument doc = textEdit.getDoc();
		int selectionEnd = textEdit.textP.getSelectionEnd();
		int selectionStart = textEdit.textP.getSelectionStart();
		if (selectionStart == selectionEnd) {
			return;
		}
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setFontSize(center, Integer.parseInt(getSize));
		doc.setParagraphAttributes(selectionStart, textEdit.textP.getSelectedText().length(), center, false);
		textEdit.textP.setDocument(doc);
	}

	private void fontAction() {
		StyledDocument doc = textEdit.getDoc();
		int selectionEnd = textEdit.textP.getSelectionEnd();
		int selectionStart = textEdit.textP.getSelectionStart();
		if (selectionStart == selectionEnd) {
			return;
		}
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setFontFamily(center, fontName[(int)fontC.getSelectedItem()-1]);
		
		doc.setParagraphAttributes(selectionStart, textEdit.textP.getSelectedText().length(), center, false);
		textEdit.textP.setDocument(doc);
	}

	protected javax.swing.JMenu m;
	protected javax.swing.JMenuItem ce;
	protected javax.swing.JMenuItem al;
	protected javax.swing.JMenuItem justify;
	protected javax.swing.JMenu size;
	protected static javax.swing.JTextPane textP;
	protected static JFrame frame;
	private JToolBar jToolBar1;
	private JComboBox fontC;
	private JComboBox jcbSelectSize;
	private javax.swing.JLabel lblPosition;
	private javax.swing.JLabel lblStatus;
	private javax.swing.JLabel font;
	private javax.swing.JLabel sizeL;

	public static StyledDocument getDoc() {
		return textP.getStyledDocument();
	}
	 

	public class ComboBoxRenderar extends JLabel implements ListCellRenderer {
		@Override
		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			int offset = ((Integer) value).intValue() - 1;
			String name = fontName[offset];
			setText(name);
			setFont(new Font(name, Font.PLAIN, 14));
			return this;
	}
	    }
}

