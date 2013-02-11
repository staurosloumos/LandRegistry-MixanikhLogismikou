package UI;

import Model.Land;
import dbConnection.DB;
import java.awt.Window;
import com.mysql.jdbc.Connection;
import javax.swing.JOptionPane;

/*
 * The update record dialog form.
 * 
 */
public class UpdateRecord extends javax.swing.JDialog {
    // Create an instance of the sap connection.
    private Connection dbConn;
    private Main parentFrame;
    private Land rec; 
    /** Creates new form login */
    public UpdateRecord(Window owner, Connection _dbConn, Main frm, Land _rec) {
        super(owner, ModalityType.APPLICATION_MODAL);
        dbConn = _dbConn;
        parentFrame = frm;
        rec = _rec;
        initComponents();
        // Add values.
        addValues(rec);
         // Add items to combo.
        DB.dbLoadCombo(LandPerson, dbConn);
        // here's the part where i center the jframe on screen
        this.setLocationRelativeTo(null);
    }           
    private void addValues(Land l){
        LandName.setText(l.getLandName());
        LandPlace.setText(l.getLandPlace());
        KAEK.setText(String.valueOf(l.getKAEK()));
        LandType.setText(l.getLandType());
        LandInfo.setText(l.getLandInfo());
        LandSize.setText(String.valueOf(l.getLandSize()));
        LandOwn.setText(l.getLandOwn()); 
        // Set the selected item from the model of combobox.
        // LandPerson.setSelectedItem();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        LandName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        LandPlace = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        LandInfo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        LandSize = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        LandType = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        KAEK = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        LandOwn = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Update = new javax.swing.JButton();
        Cancel = new javax.swing.JButton();
        LandPerson = new javax.swing.JComboBox();

        setTitle("Επεξεργασία");
        setName("dlgLogin"); // NOI18N

        jLabel1.setText("Ονομασία Ακ.");

        jLabel2.setText("Τοποθεσία Ακ.");

        jLabel3.setText("ΚΑΕΚ");

        jLabel4.setText("Τύπος Ακ.");

        jLabel5.setText("Ιδιαιτερότητα Ακ.");

        jLabel6.setText("Εμβαδόν Ακ.");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 51, 51));
        jLabel7.setText("Επεξεργασία κτηματολογικών στοιχείων:");

        jLabel8.setText("Τύπος Ιδιοκτησίας Ακ.");

        jLabel9.setText("Κάτοχος Ακ.");

        Update.setText("Αποθήκευση");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        Cancel.setText("Ακύρωση");
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel8))
                                        .addGap(30, 30, 30))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(76, 76, 76)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LandOwn, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Update)
                                        .addGap(38, 38, 38)
                                        .addComponent(Cancel))
                                    .addComponent(KAEK, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LandPerson, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(67, 67, 67)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LandPlace)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(LandName, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(LandType, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(LandInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(LandSize, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(LandName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(LandPlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(KAEK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LandType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(LandInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(LandSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(LandOwn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(LandPerson, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Update)
                    .addComponent(Cancel))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        // TODO add your handling code here:
       Land l = null;       
       String lName = LandName.getText();
       String lPlace = LandPlace.getText();
       int K = Integer.valueOf(KAEK.getText());
       String lType = LandType.getText();
       String lInfo = LandInfo.getText();
       double Size = Double.valueOf(LandSize.getText());
       String lOwn = LandOwn.getText();
       String combo = LandPerson.getSelectedItem().toString();
       // Get the id from the selected item.
       String[] t = combo.split(" ");
       int person = Integer.valueOf(t[0]);
       int landId = rec.getLandID();
       // Create the object.
       l = new Land(landId, lName, lPlace, K, lType, lInfo, Size, lOwn, person);
       // Insert the record.
        Object options[] = {"Ναι", "'Οχι"};
        int response = JOptionPane.showOptionDialog(null, "Είστε σίγουρος;", "Εισαγωγή", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        switch (response) {
            case 0:
                DB.dbUpdateLand(l, dbConn);              
                setVisible(false);
                // Update main form.
                parentFrame.updateInfo(null);
                break;
            case 1:  
                // Just cancel the update.
                break;
        }
    }//GEN-LAST:event_UpdateActionPerformed

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_CancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancel;
    private javax.swing.JTextField KAEK;
    private javax.swing.JTextField LandInfo;
    private javax.swing.JTextField LandName;
    private javax.swing.JTextField LandOwn;
    private javax.swing.JComboBox LandPerson;
    private javax.swing.JTextField LandPlace;
    private javax.swing.JTextField LandSize;
    private javax.swing.JTextField LandType;
    private javax.swing.JButton Update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
