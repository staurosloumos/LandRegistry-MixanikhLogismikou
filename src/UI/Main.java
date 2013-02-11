/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Model.Land;
import com.mysql.jdbc.Connection;
import dbConnection.DB;
import dbConnection.DB.DriverType;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * Main code.
 */
public class Main extends javax.swing.JFrame {

    // Connection that will get established when the form is loaded.
    private Connection dbConn = null;
    

    /**
     * Creates new form Main
     */
    public Main() {        
        initComponents();
        // Disable filter.
        this.FilterToogle.setEnabled(false);
        this.setLocationRelativeTo(null);
        // Open the connection to the database, database that will use is MySQL.        
        dbConn = DB.dbConnect("LandRegistryDB", DriverType.MySQL);        
    }

    /* Prompt the user for an input value. */
    public String promptMessage(String prompt) {
        return (String) JOptionPane.showInputDialog(null, prompt, "", JOptionPane.INFORMATION_MESSAGE, null, null, null);
    }   

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message , "", JOptionPane.PLAIN_MESSAGE);
    }
    // Enables the filter button and changes state.
    public void enableToogleFilter (){
        this.FilterToogle.setEnabled(true);
        this.FilterToogle.setText("Ναι");
    }
    // Updates ui.
    public void updateInfo(ResultSet ds) {
        int i = 0;
        if (null == ds) {
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                // Select all the records from the DB.
                ps = dbConn.prepareStatement("SELECT * FROM lands");
                rs = ps.executeQuery();
                // Fill table model.            
                DefaultTableModel model = (DefaultTableModel) Records.getModel();
                model.getDataVector().removeAllElements();
                Records.repaint();
                while (rs.next()) {
                    Object[] data = new Object[8];
                    data[0] = rs.getInt(1);
                    data[1] = rs.getString(2);
                    data[2] = rs.getString(3);
                    data[3] = rs.getInt(4);
                    data[4] = rs.getString(5);
                    data[5] = rs.getString(6);
                    data[6] = rs.getDouble(7);
                    data[7] = rs.getString(8);
                    model.addRow(data);
                    /*
                     model.setValueAt(rs.getInt(1), i, 0);
                     model.setValueAt(rs.getString(2), i, 1);
                     model.setValueAt(rs.getString(3), i, 2);
                     model.setValueAt(rs.getInt(4), i, 3);
                     model.setValueAt(rs.getString(5), i, 4);
                     model.setValueAt(rs.getString(6), i, 5);
                     model.setValueAt(rs.getDouble(7), i, 6);
                     model.setValueAt(rs.getString(8), i, 7);
                     */

                    // Count the records affected.
                    i++;
                }
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (ps != null) {
                    try {
                        ps.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } else {
            try {
                // Here we come from search query.
                // Fill table model.            
                DefaultTableModel model = (DefaultTableModel) Records.getModel();
                model.getDataVector().removeAllElements();
                Records.repaint();
                while (ds.next()) {
                    Object[] data = new Object[8];
                    data[0] = ds.getInt(1);
                    data[1] = ds.getString(2);
                    data[2] = ds.getString(3);
                    data[3] = ds.getInt(4);
                    data[4] = ds.getString(5);
                    data[5] = ds.getString(6);
                    data[6] = ds.getDouble(7);
                    data[7] = ds.getString(8);
                    model.addRow(data);
                    /*
                     model.setValueAt(rs.getInt(1), i, 0);
                     model.setValueAt(rs.getString(2), i, 1);
                     model.setValueAt(rs.getString(3), i, 2);
                     model.setValueAt(rs.getInt(4), i, 3);
                     model.setValueAt(rs.getString(5), i, 4);
                     model.setValueAt(rs.getString(6), i, 5);
                     model.setValueAt(rs.getDouble(7), i, 6);
                     model.setValueAt(rs.getString(8), i, 7);
                     */

                    // Count the records affected.
                    i++;
                }
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (ds != null) {
                    try {
                        ds.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        }

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Records = new javax.swing.JTable(){

            public boolean isCellEditable(int rowIndex, int colIndex) {

                return false;   //Disallow the editing of any cell

            }

        };
        jToolBar1 = new javax.swing.JToolBar();
        Info = new javax.swing.JLabel();
        User = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        FilterToogle = new javax.swing.JToggleButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        Edit = new javax.swing.JMenuItem();
        save = new javax.swing.JMenuItem();
        Delete = new javax.swing.JMenuItem();
        Print = new javax.swing.JMenuItem();
        Backup = new javax.swing.JMenuItem();
        Exit = new javax.swing.JMenuItem();
        Insert = new javax.swing.JMenu();
        NewLRegisterAct = new javax.swing.JMenuItem();
        Search = new javax.swing.JMenu();
        LandRecords = new javax.swing.JMenuItem();
        ActionsHistory = new javax.swing.JMenuItem();
        Statistics = new javax.swing.JMenu();
        Help = new javax.swing.JMenu();
        Contents = new javax.swing.JMenuItem();
        About = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Διαχείριση Κτηματολογίου");
        setName("LandRegister"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        Records.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Α/Α", "Όνομασία Ακ.", "Τοποθεσία Ακ.", "ΚΑΕΚ", "Τύπος Ακ.", "Ιδιαιτερ. Ακ.", "Εμβαδόν Ακ.", "Ιδιοκτησία Ακ."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        Records.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Records.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RecordsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Records);

        jToolBar1.setRollover(true);

        Info.setText("Χρήστης: ");
        jToolBar1.add(Info);

        User.setText("\"N/A\"");
        jToolBar1.add(User);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("| Φίλτρο:");
        jToolBar1.add(jLabel1);

        FilterToogle.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        FilterToogle.setText("Όχι");
        FilterToogle.setFocusable(false);
        FilterToogle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        FilterToogle.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        FilterToogle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilterToogleActionPerformed(evt);
            }
        });
        jToolBar1.add(FilterToogle);

        File.setText("Αρχείο");

        Edit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        Edit.setText("Επεξεργασία");
        Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditActionPerformed(evt);
            }
        });
        File.add(Edit);

        save.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        save.setText("Αποθήκευση");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        File.add(save);

        Delete.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        Delete.setText("Διαγραφή");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });
        File.add(Delete);

        Print.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        Print.setText("Εκτύπωση");
        Print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintActionPerformed(evt);
            }
        });
        File.add(Print);

        Backup.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        Backup.setText("Αντίγραφα Ασφαλείας");
        Backup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackupActionPerformed(evt);
            }
        });
        File.add(Backup);

        Exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        Exit.setText("Έξοδος");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        File.add(Exit);

        jMenuBar1.add(File);

        Insert.setText("Εισαγωγή");

        NewLRegisterAct.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_0, java.awt.event.InputEvent.CTRL_MASK));
        NewLRegisterAct.setText("Νέα Έγγρ. Πράξη");
        NewLRegisterAct.setToolTipText("");
        NewLRegisterAct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewLRegisterActActionPerformed(evt);
            }
        });
        Insert.add(NewLRegisterAct);

        jMenuBar1.add(Insert);

        Search.setText("Αναζήτηση");

        LandRecords.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_MASK));
        LandRecords.setText("Κτμ. Εγγραφών");
        LandRecords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LandRecordsActionPerformed(evt);
            }
        });
        Search.add(LandRecords);

        ActionsHistory.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.CTRL_MASK));
        ActionsHistory.setText("Ιστορικό Ενεργειών / Τροπ.");
        Search.add(ActionsHistory);

        jMenuBar1.add(Search);

        Statistics.setText("Στατιστικά");
        jMenuBar1.add(Statistics);

        Help.setText("Βοήθεια");

        Contents.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.CTRL_MASK));
        Contents.setText("Περιεχόμενα");
        Help.add(Contents);

        About.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, java.awt.event.InputEvent.CTRL_MASK));
        About.setText("Περί Προγράμματος");
        About.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutActionPerformed(evt);
            }
        });
        Help.add(About);

        jMenuBar1.add(Help);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Login l = new Login(this);
        l.setVisible(true);
        if (DB.LoginValue) {
            // Set the text to display the name.            
            User.setText(DB.Username);
             // Enable deletion of records only for administrator.
            if(DB.Username.equals("administrator"))           
            {
                Delete.setEnabled(true);           
                Backup.setEnabled(true);
            }
            else            
            {
                // Users can not delete records from database.
                Delete.setEnabled(false);            
                Backup.setEnabled(false);
            }
            // We must update our table in  a new thread so the GUI is respondable.
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    // Run the method that updates the table with the records from the database.
                    updateInfo(null);
                }
            });
        } else {
            // We must close the program, incorrect logon info was passed.
            if (!DB.LoginValue) {
                JOptionPane.showMessageDialog(this, "Δε δώσατε στοιχεία για την είσοδο.\n"
                        + "Η εφαρμογή θα κλείσει.", "Κλείσιμο", JOptionPane.PLAIN_MESSAGE);
                this.setVisible(false);
                /*
                 * Dispose the item, bug found @ 14/12/2011.
                 * 
                 */
                this.dispose();
            }
        }
    }//GEN-LAST:event_formWindowOpened

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
         this.setVisible(false);
            /*
             * Dispose the item.
             * 
             */
            this.dispose();
    }//GEN-LAST:event_ExitActionPerformed

    private void BackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BackupActionPerformed

    private void PrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintActionPerformed
        // Open a print dialog menu
        PrinterJob prJob = PrinterJob.getPrinterJob();
        if (prJob.printDialog()) {
            try {
                prJob.print();
            } catch (PrinterException exc) {
                System.out.println(exc);
            }

        }
    }//GEN-LAST:event_PrintActionPerformed

    private void NewLRegisterActActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewLRegisterActActionPerformed
        // TODO add your handling code here:
        InsertRecord ins = new InsertRecord(this, dbConn, this);
        ins.setVisible(true);
    }//GEN-LAST:event_NewLRegisterActActionPerformed

    private void EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditActionPerformed
        // TODO add your handling code here:
        Land l = null;
        int personID = -1;
        PreparedStatement ps = null;
        ResultSet rs = null; 
        TableModel model = Records.getModel();
        try {
            int r = Records.getSelectedRow();
            // Get the values from that row.
            int lId = (int) model.getValueAt(r, 0);
            String lName = (String) model.getValueAt(r, 1);
            String lPlace = (String) model.getValueAt(r, 2);
            int lKAEK = (int) model.getValueAt(r, 3);
            String lType = (String) model.getValueAt(r, 4);
            String lPlan = (String) model.getValueAt(r, 5);
            double lSize = (double) model.getValueAt(r, 6);
            String lOccupy = (String) model.getValueAt(r, 7);                                      
            // Get person responsible.
            ps = dbConn.prepareStatement("SELECT * FROM lands WHERE landID=?");            
            ps.setInt(1, lId);
            rs = ps.executeQuery();
            if(rs.next())
            {
            // Get the person id.
                personID = rs.getInt(9);
            }
            // Create Land.
            l = new Land(lId, lName, lPlace, lKAEK, lType, lPlan, lSize, lOccupy, personID);
            // Pass the parameters to the update form.
            UpdateRecord u = new UpdateRecord(this, dbConn, this, l);
            u.setVisible(true);                        
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ArrayIndexOutOfBoundsException ex) {
                showMessage("Παρακαλώ επιλέξτε την εγγραφή που θέλετε να επεξεργαστείτε");
            } catch (NullPointerException ex) {
                showMessage("Παρακαλώ επιλέξτε την εγγραφή που θέλετε να επεξεργαστείτε");            
            } finally {
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (ps != null) {
                    try {
                        ps.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
    }//GEN-LAST:event_EditActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed

        // For each record in the table store it again into the database.
        Land l = null;
        int personID = -1;
        TableModel model = Records.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            // Get the values from that row.
            try {
                int lId = (int) model.getValueAt(i, 0);
                String lName = (String) model.getValueAt(i, 1);
                String lPlace = (String) model.getValueAt(i, 2);
                int lKAEK = (int) model.getValueAt(i, 3);
                String lType = (String) model.getValueAt(i, 4);
                String lPlan = (String) model.getValueAt(i, 5);
                double lSize = (double) model.getValueAt(i, 6);
                String lOccupy = (String) model.getValueAt(i, 7);
                // Create Land.
                l = new Land(lId, lName, lPlace, lKAEK, lType, lPlan, lSize, lOccupy, personID);
                // Update into database.
                DB.dbUpdateLandNoPerson(l, dbConn);
            } catch (NullPointerException ex) {
                // Break the loop because no data was read.
                break;
            }
        }
        // End of for loop.
        // Refresh table from database.
        updateInfo(null);
        showMessage("Οι αλλαγές αποθηκεύτηκαν επιτυχώς στην βάση");
    }//GEN-LAST:event_saveActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        // TODO add your handling code here:
        Land l = null;
        int personID = -1;               
        TableModel model = Records.getModel();
        try {
            int r = Records.getSelectedRow();
            // Get the values from that row.
            int lId = (int) model.getValueAt(r, 0);
            String lName = (String) model.getValueAt(r, 1);
            String lPlace = (String) model.getValueAt(r, 2);
            int lKAEK = (int) model.getValueAt(r, 3);
            String lType = (String) model.getValueAt(r, 4);
            String lPlan = (String) model.getValueAt(r, 5);
            double lSize = (double) model.getValueAt(r, 6);
            String lOccupy = (String) model.getValueAt(r, 7);                                      
            // Get person responsible.            
            // Create Land.
            l = new Land(lId, lName, lPlace, lKAEK, lType, lPlan, lSize, lOccupy, personID);
            DB.dbDeleteRecord(l, dbConn); 
             // Refresh table from database.
            updateInfo(null);
            showMessage("Η εγγραφή διαγράφτηκε επιτυχώς");
            } catch (ArrayIndexOutOfBoundsException ex) {
                showMessage("Παρακαλώ επιλέξτε την εγγραφή που θέλετε να διαγράψετε");
            } 
            catch (NullPointerException ex) {
                showMessage("Παρακαλώ επιλέξτε την εγγραφή που θέλετε να διαγράψετε");
            }
    }//GEN-LAST:event_DeleteActionPerformed

    private void LandRecordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LandRecordsActionPerformed
        // TODO add your handling code here:
        SearchRecord search = new SearchRecord(this, dbConn, this);
        search.setVisible(true);
    }//GEN-LAST:event_LandRecordsActionPerformed

    private void FilterToogleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FilterToogleActionPerformed
        // TODO add your handling code here:
        this.FilterToogle.setText("Όχι");
        this.FilterToogle.setEnabled(false);
        // Update info with all records.
        updateInfo(null);
    }//GEN-LAST:event_FilterToogleActionPerformed

    private void AboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutActionPerformed
       
        About ab = new About(this, true);
        ab.setVisible(true);
        
    }//GEN-LAST:event_AboutActionPerformed

    private void RecordsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RecordsMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount() == 2)
        {
            // Perform the edit function.
            EditActionPerformed(null);
        }
    }//GEN-LAST:event_RecordsMouseClicked
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem About;
    private javax.swing.JMenuItem ActionsHistory;
    private javax.swing.JMenuItem Backup;
    private javax.swing.JMenuItem Contents;
    private javax.swing.JMenuItem Delete;
    private javax.swing.JMenuItem Edit;
    private javax.swing.JMenuItem Exit;
    private javax.swing.JMenu File;
    private javax.swing.JToggleButton FilterToogle;
    private javax.swing.JMenu Help;
    private javax.swing.JLabel Info;
    private javax.swing.JMenu Insert;
    private javax.swing.JMenuItem LandRecords;
    private javax.swing.JMenuItem NewLRegisterAct;
    private javax.swing.JMenuItem Print;
    private javax.swing.JTable Records;
    private javax.swing.JMenu Search;
    private javax.swing.JMenu Statistics;
    private javax.swing.JLabel User;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem save;
    // End of variables declaration//GEN-END:variables
}
