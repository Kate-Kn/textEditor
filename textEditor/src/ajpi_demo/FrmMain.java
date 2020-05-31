
package ajpi_demo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.text.Element;
import javax.swing.text.StyledDocument;
import javax.swing.text.rtf.RTFEditorKit;

public class FrmMain extends javax.swing.JFrame {

    Color selectColor;

    /**
     * Creates new form FrmMain
     */
    public FrmMain() {
        initComponents();
        // setting center screen for this form
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(size.width / 2 - this.getWidth() / 2,
                size.height / 2 - this.getHeight() / 2);
        loadFont();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    
    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jToolBar1 = new javax.swing.JToolBar();
        btnNew = new javax.swing.JButton();
        btnOpen = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnSelectColor = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jcbFont = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jcbSelectSize = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        lblStatus = new javax.swing.JLabel();
        lblPosition = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnNew = new javax.swing.JMenuItem();
        mnOpen = new javax.swing.JMenuItem();
        mnSave = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajpi_demo/copy.png"))); // NOI18N
        jMenuItem2.setText("Copy");
        jPopupMenu1.add(jMenuItem2);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajpi_demo/paste.png"))); // NOI18N
        jMenuItem3.setText("Paste");
        jPopupMenu1.add(jMenuItem3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 400));

        jToolBar1.setRollover(true);

        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajpi_demo/new.png"))); // NOI18N
        btnNew.setFocusable(false);
        btnNew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNew.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNew);

        btnOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajpi_demo/open.png"))); // NOI18N
        btnOpen.setFocusable(false);
        btnOpen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOpen.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenActionPerformed(evt);
            }
        });
        jToolBar1.add(btnOpen);

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajpi_demo/save.png"))); // NOI18N
        btnSave.setFocusable(false);
        btnSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSave);

        btnSelectColor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajpi_demo/color.png"))); // NOI18N
        btnSelectColor.setFocusable(false);
        btnSelectColor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSelectColor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSelectColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectColorActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSelectColor);

        jLabel1.setText("Font");
        jToolBar1.add(jLabel1);

        jcbFont.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbFont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbFontActionPerformed(evt);
            }
        });
        jToolBar1.add(jcbFont);

        jLabel2.setText("Size");
        jToolBar1.add(jLabel2);

        jcbSelectSize.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "10", "14", "18", "22", "26", "30", "34", "36", "40", "44", "48", "52" }));
        jcbSelectSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbSelectSizeActionPerformed(evt);
            }
        });
        jToolBar1.add(jcbSelectSize);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 24));

        lblStatus.setText("Key");
        jPanel1.add(lblStatus);

        lblPosition.setText("n chars");
        jPanel1.add(lblPosition);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jTextPane1.setCaretColor(new java.awt.Color(51, 51, 255));
        jTextPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextPane1.setDoubleBuffered(true);
        jTextPane1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextPane1CaretUpdate(evt);
            }
        });
        jTextPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTextPane1MouseReleased(evt);
            }
        });
        jTextPane1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTextPane1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTextPane1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextPane1KeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(jTextPane1);

        getContentPane().add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jMenu1.setText("File");

        mnNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        mnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajpi_demo/new.png"))); // NOI18N
        mnNew.setText("New");
        mnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnNewActionPerformed(evt);
            }
        });
        jMenu1.add(mnNew);

        mnOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        mnOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajpi_demo/open.png"))); // NOI18N
        mnOpen.setText("Open");
        mnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnOpenActionPerformed(evt);
            }
        });
        jMenu1.add(mnOpen);

        mnSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        mnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajpi_demo/save.png"))); // NOI18N
        mnSave.setText("Save");
        mnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnSaveActionPerformed(evt);
            }
        });
        jMenu1.add(mnSave);
        jMenu1.add(jSeparator1);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajpi_demo/exit.png"))); // NOI18N
        jMenuItem4.setText("Exit");
        jMenuItem4.setToolTipText("Exists ");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Helps");

        jMenuItem1.setText("About");
        jMenu2.add(jMenuItem1);

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("Help");
        jMenu2.add(jCheckBoxMenuItem1);
        jMenu2.add(jSeparator2);

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("Check update");
        jMenu2.add(jRadioButtonMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        System.exit(1);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void btnSelectColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectColorActionPerformed
        Color jColor = selectColor;
        // open color dialog and select Color
        if ((jColor = JColorChooser.showDialog(this, "Select color", jColor)) != null) {
            selectColor = jColor;
            // set text color
            jTextPane1.setForeground(selectColor);
        }
    }//GEN-LAST:event_btnSelectColorActionPerformed

    private void jcbSelectSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbSelectSizeActionPerformed
        // Select size of text
        String getSize = jcbSelectSize.getSelectedItem().toString();
        Font f = jTextPane1.getFont();
        jTextPane1.setFont(new Font(f.getFontName(),
                f.getStyle(), Integer.parseInt(getSize)));


    }//GEN-LAST:event_jcbSelectSizeActionPerformed

    private void jcbFontActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbFontActionPerformed
        // Change font of text
        jTextPane1.setFont(new Font(jcbFont.getSelectedItem().toString(),
                Font.PLAIN, Integer.parseInt(jcbSelectSize.getSelectedItem().toString())));
    }//GEN-LAST:event_jcbFontActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        save();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenActionPerformed
        open();
    }//GEN-LAST:event_btnOpenActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        jTextPane1.setText("");
    }//GEN-LAST:event_btnNewActionPerformed

    private void jTextPane1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPane1KeyTyped
        // TODO add your handling code here:
        lblStatus.setText("Typing: " + evt.getKeyChar());
    }//GEN-LAST:event_jTextPane1KeyTyped

    private void jTextPane1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTextPane1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextPane1AncestorAdded

    private void jTextPane1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextPane1CaretUpdate
        int pos = jTextPane1.getCaretPosition();
        Element map = jTextPane1.getDocument().getDefaultRootElement();
        // get position of cursor on TextPane
        int row = map.getElementIndex(pos);
        Element lineElem = map.getElement(row);
        int col = pos - lineElem.getStartOffset();
        // show row and col 
        lblPosition.setText("At: row " + row + " col " + col);
    }//GEN-LAST:event_jTextPane1CaretUpdate

    private void mnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnNewActionPerformed
        jTextPane1.setText("");
    }//GEN-LAST:event_mnNewActionPerformed

    private void mnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnOpenActionPerformed
        open();
    }//GEN-LAST:event_mnOpenActionPerformed

    private void mnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnSaveActionPerformed
        save();
    }//GEN-LAST:event_mnSaveActionPerformed

    private void jTextPane1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextPane1MouseReleased
        // TODO add your handling code here:
        if (evt.getButton() == MouseEvent.BUTTON3) {
            jPopupMenu1.show(jTextPane1, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_jTextPane1MouseReleased

    private void save() {
        JFileChooser file = new JFileChooser();
       // TextFilter filter = new TextFilter();
       // file.setFileFilter(filter);
        String fileName = "";
        // show save file dialog
        if (file.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            // get full path of selected file
            fileName = file.getSelectedFile().getAbsolutePath();
            // get meta of text
            StyledDocument doc = (StyledDocument) jTextPane1.getDocument();
            // convert to richtext format
            RTFEditorKit kit = new RTFEditorKit();
            BufferedOutputStream out;
            try {
                out = new BufferedOutputStream(new FileOutputStream(fileName));
                // save content to file
                kit.write(out, doc, doc.getStartPosition().getOffset(), doc.getLength());
                out.flush();
                out.close();
            } catch (Exception e) {
                System.out.println("Err:" + e.toString());
            }

        } else {
            return;
        }
    }

    private void open() {
        JFileChooser file = new JFileChooser();
       // TextFilter filter = new TextFilter();
       // file.setFileFilter(filter);
        String fileName = "";
        // show open file dialog
        if (file.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            fileName = file.getSelectedFile().getAbsolutePath();
        } else {
            return;
        }
        // using richtext format
        RTFEditorKit rtf = new RTFEditorKit();
        try {
            // load file into jTextPane
            FileInputStream fi = new FileInputStream(fileName);
            rtf.read(fi, jTextPane1.getDocument(), 0);
            fi.close();
        } catch (Exception e) {
            System.out.println("err:" + e.toString());
        }
    }

private void loadFont() {
    GraphicsEnvironment gEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
    // get all font name 
    String[] fontNames = gEnv.getAvailableFontFamilyNames();
        // load to combobox
    ComboBoxModel model = new DefaultComboBoxModel(fontNames);
    jcbFont.setModel(model);
}

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMain().setVisible(true);
            }
        });
    }

    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnOpen;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSelectColor;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JComboBox jcbFont;
    private javax.swing.JComboBox jcbSelectSize;
    private javax.swing.JLabel lblPosition;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JMenuItem mnNew;
    private javax.swing.JMenuItem mnOpen;
    private javax.swing.JMenuItem mnSave;
}
