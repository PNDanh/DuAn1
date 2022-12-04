/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.poly.it17323.group6.view;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author LE BAO NGOC
 */
public class SRM_PrintBill extends javax.swing.JFrame {

    //  String billNo="";
    Double totalAmount = 0.0;
    Double cash = 0.0;
    Double balance = 0.0;
    Double bHeight = 0.0;
    
    ArrayList<String> itemName = new ArrayList<>();
    ArrayList<String> quantity = new ArrayList<>();
    ArrayList<String> itemPrice = new ArrayList<>();
    ArrayList<String> subtotal = new ArrayList<>();

    /**
     * Creates new form SRM_PrintBill
     */
    public SRM_PrintBill() {
        initComponents();
        setLocationRelativeTo(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnPrint = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        txtItemName = new javax.swing.JTextField();
        txtQuantity = new javax.swing.JTextField();
        txtItemPrice = new javax.swing.JTextField();
        txtSubTotal = new javax.swing.JTextField();
        txtTotalPrice = new javax.swing.JTextField();
        txtCash = new javax.swing.JTextField();
        txtBalance = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("ITem Name");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 70, 20));

        jLabel2.setText("Quantity");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 70, 20));

        jLabel3.setText("ITemPrice");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 60, 20));

        jLabel4.setText("Sub Total");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 60, 20));

        jLabel5.setText("Total Price");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        jLabel6.setText("Cash");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, -1, -1));

        jLabel7.setText("Balance");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, -1, -1));

        btnPrint.setText("Print");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        jPanel1.add(btnPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 500, -1, -1));

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, -1, -1));
        jPanel1.add(txtItemName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 78, 240, -1));
        jPanel1.add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 240, -1));
        jPanel1.add(txtItemPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 240, -1));
        jPanel1.add(txtSubTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 240, -1));
        jPanel1.add(txtTotalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 240, -1));
        jPanel1.add(txtCash, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, 240, -1));
        jPanel1.add(txtBalance, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 460, 240, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        itemName.add(txtItemName.getText());
        quantity.add(txtQuantity.getText());
        itemPrice.add(txtItemPrice.getText());
        subtotal.add(txtSubTotal.getText());
        totalAmount = totalAmount + Double.valueOf(txtSubTotal.getText());
        txtTotalPrice.setText(totalAmount + "");
        clear();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        bHeight = Double.valueOf(itemName.size());
        //JOptionPane.showMessageDialog(rootPane, bHeight);

        PrinterJob pj = PrinterJob.getPrinterJob();
        pj.setPrintable(new BillPrintable(), getPageFormat(pj));
        try {
            pj.print();
            
        } catch (PrinterException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnPrintActionPerformed
    
    public PageFormat getPageFormat(PrinterJob pj) {
        
        PageFormat pf = pj.defaultPage();
        Paper paper = pf.getPaper();
        
        double bodyHeight = bHeight;
        double headerHeight = 5.0;
        double footerHeight = 5.0;
        double width = cm_to_pp(8);
        double height = cm_to_pp(headerHeight + bodyHeight + footerHeight);
        paper.setSize(width, height);
        paper.setImageableArea(0, 10, width, height - cm_to_pp(1));
        
        pf.setOrientation(PageFormat.PORTRAIT);
        pf.setPaper(paper);
        
        return pf;
    }
    
    protected static double cm_to_pp(double cm) {
        return toPPI(cm * 0.393600787);
    }
    
    protected static double toPPI(double inch) {
        return inch * 72d;
    }
    
    private void clear() {
        txtItemName.setText("");
        txtQuantity.setText("");
        txtItemPrice.setText("");
        txtSubTotal.setText("");
    }
    
    public class BillPrintable implements Printable {
        
        public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
                throws PrinterException {            
            
            int r = itemName.size();
            ImageIcon icon = new ImageIcon("C:\\Users\\LE BAO NGOC\\Pictures\\Saved Pictures\\Logo.png");            
            int result = NO_SUCH_PAGE;            
            if (pageIndex == 0) {                
                
                Graphics2D g2d = (Graphics2D) graphics;                
                double width = pageFormat.getImageableWidth();                
                g2d.translate((int) pageFormat.getImageableX(), (int) pageFormat.getImageableY());

                //  FontMetrics metrics=g2d.getFontMetrics(new Font("Arial",Font.BOLD,7));
                try {
                    int y = 20;
                    int yShift = 10;
                    int headerRectHeight = 15;
                    // int headerRectHeighta=40;
                    
                    g2d.setFont(new Font("Monospaced", Font.PLAIN, 9));
                    g2d.drawImage(icon.getImage(), 50, 20, 90, 30, rootPane);
                    y += yShift + 30;
                    g2d.drawString("-------------------------------------", 12, y);
                    y += yShift;
                    g2d.drawString("         CodeGuid.com        ", 12, y);
                    y += yShift;
                    g2d.drawString("   No 00000 Address Line One ", 12, y);
                    y += yShift;
                    g2d.drawString("   Address Line 02 SRI LANKA ", 12, y);
                    y += yShift;
                    g2d.drawString("   www.facebook.com/CodeGuid ", 12, y);
                    y += yShift;
                    g2d.drawString("        +94700000000      ", 12, y);
                    y += yShift;
                    g2d.drawString("-------------------------------------", 12, y);
                    y += headerRectHeight;
                    
                    g2d.drawString(" Item Name                  Price   ", 10, y);
                    y += yShift;
                    g2d.drawString("-------------------------------------", 10, y);
                    y += headerRectHeight;
                    
                    for (int s = 0; s < r; s++) {
                        g2d.drawString(" " + itemName.get(s) + "                            ", 10, y);
                        y += yShift;
                        g2d.drawString("      " + quantity.get(s) + " * " + itemPrice.get(s), 10, y);
                        g2d.drawString(subtotal.get(s), 160, y);
                        y += yShift;
                        
                    }
                    
                    g2d.drawString("-------------------------------------", 10, y);
                    y += yShift;
                    g2d.drawString(" Total amount:               " + txtTotalPrice.getText() + "   ", 10, y);
                    y += yShift;
                    g2d.drawString("-------------------------------------", 10, y);
                    y += yShift;
                    g2d.drawString(" Cash      :                 " + txtCash.getText() + "   ", 10, y);
                    y += yShift;
                    g2d.drawString("-------------------------------------", 10, y);
                    y += yShift;
                    g2d.drawString(" Balance   :                 " + txtBalance.getText() + "   ", 10, y);
                    y += yShift;
                    
                    g2d.drawString("*************************************", 10, y);
                    y += yShift;
                    g2d.drawString("       THANK YOU COME AGAIN            ", 10, y);
                    y += yShift;
                    g2d.drawString("*************************************", 10, y);
                    y += yShift;
                    g2d.drawString("       SOFTWARE BY:CODEGUID          ", 10, y);
                    y += yShift;
                    g2d.drawString("   CONTACT: contact@codeguid.com       ", 10, y);
                    y += yShift;                    
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                result = PAGE_EXISTS;                
            }            
            return result;            
        }
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
            java.util.logging.Logger.getLogger(SRM_PrintBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SRM_PrintBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SRM_PrintBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SRM_PrintBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SRM_PrintBill().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnPrint;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtBalance;
    private javax.swing.JTextField txtCash;
    private javax.swing.JTextField txtItemName;
    private javax.swing.JTextField txtItemPrice;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtTotalPrice;
    // End of variables declaration//GEN-END:variables
}