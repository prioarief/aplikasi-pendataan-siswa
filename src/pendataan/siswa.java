package pendataan;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Prio Arief G
 */
public class siswa extends javax.swing.JFrame {

    private Object[] hasil1, hasil2;
    
    public siswa() {
        initComponents();
        load_table();
        kosong();
    }
    private boolean validasiInput(){
        boolean valid = false;
        if (jTextFieldnis.getText().trim().isEmpty() ){
            JOptionPane.showMessageDialog(null, "nis tidak boleh kosong");
        }else{
            valid = true;
        }
        return valid;
    }
    
    private void load_table() {
        // membuat tampilan model tabel
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nis");
        model.addColumn("Nama");
        model.addColumn("Sekolah");
        model.addColumn("Jenis Kelamin");
        model.addColumn("Jurusan");
        model.addColumn("Tempat PKL");

        //menampilkan data database kedalam tabel
        try {
            int no = 1;
            String sql = "select * from tampil_siswa";
            java.sql.Connection conn = (Connection) config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                model.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3),
                    res.getString(4), res.getString(5), res.getString(6)});
                
            }
            jTable1.setModel(model);
        } catch (SQLException e) {
        }

        
        
        try {
            String sql = "select * from jurusan";
            java.sql.Connection conn = (Connection) config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            this.hasil1 = new Object[3];
            int counter = 0;
            while (res.next()) {                                                
                jComboBoxjurusan.addItem(res.getString(2));
                this.hasil1[counter++] = res.getString(1);
            }
        } catch(SQLException e) {
            
        }
        
        try {
            String sql = "select * from lab";
            java.sql.Connection conn = (Connection) config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            this.hasil2 = new Object[5];
            int counter = 0;
            while (res.next()) {
                
                jComboBoxpkl.addItem(res.getString(2));
                this.hasil2[counter++] = res.getString(1);
            }
        } catch(SQLException e) {
            
        }
    }
    
    private void kosong(){
        jTextFieldnis.setText(null);
        jTextFieldnama.setText(null);
        jTextFieldaslsklh.setText(null);
        jLabeljenis.setText(null);
        jRadioButtonperempuan.setSelected(false);
        jRadioButtonlaki.setSelected(false);
        jComboBoxjurusan.setSelectedItem(null);
        jComboBoxpkl.setSelectedItem(null);
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
        jTextFieldnama = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldaslsklh = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jRadioButtonlaki = new javax.swing.JRadioButton();
        jRadioButtonperempuan = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxjurusan = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxpkl = new javax.swing.JComboBox<>();
        jButtontambah = new javax.swing.JButton();
        jButtonhapus = new javax.swing.JButton();
        jButtonubah = new javax.swing.JButton();
        jButtonclear = new javax.swing.JButton();
        jLabeljenis = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldnis = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        searchfield = new javax.swing.JTextField();
        searchbtn = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Nama");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Asal Sekolah");

        jTextFieldaslsklh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldaslsklhActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Jenis Kelamin");

        jRadioButtonlaki.setText("Laki laki");
        jRadioButtonlaki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonlakiActionPerformed(evt);
            }
        });

        jRadioButtonperempuan.setText("Perempuan");
        jRadioButtonperempuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonperempuanActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Form Data Siswa");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Jurusan");

        jComboBoxjurusan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));
        jComboBoxjurusan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxjurusanActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Tempat PKL");

        jComboBoxpkl.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));

        jButtontambah.setText("Tambah");
        jButtontambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtontambahActionPerformed(evt);
            }
        });

        jButtonhapus.setText("Hapus");
        jButtonhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonhapusActionPerformed(evt);
            }
        });

        jButtonubah.setText("Ubah");
        jButtonubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonubahActionPerformed(evt);
            }
        });

        jButtonclear.setText("Clear");
        jButtonclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonclearActionPerformed(evt);
            }
        });

        jLabeljenis.setText("jenis");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("NIS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldnama, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldaslsklh)
                            .addComponent(jComboBoxpkl, 0, 221, Short.MAX_VALUE)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButtontambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonubah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButtonclear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonhapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jLabeljenis))
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jRadioButtonlaki)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButtonperempuan, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jComboBoxjurusan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7)
                            .addComponent(jTextFieldnis))
                        .addGap(0, 22, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(2, 2, 2)
                .addComponent(jTextFieldnis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addComponent(jTextFieldnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(4, 4, 4)
                .addComponent(jTextFieldaslsklh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabeljenis))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonlaki)
                    .addComponent(jRadioButtonperempuan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxjurusan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxpkl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtontambah)
                    .addComponent(jButtonhapus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonubah)
                    .addComponent(jButtonclear))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setSelectionBackground(new java.awt.Color(102, 102, 255));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("COPYRIGHT SMKN 4 KOTA TANGERANG 2019");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("DATA SISWA PRAKERIN DI DEPARTEMEN ELEKTRONIKA DAN INFFORMATIKA (ELIT)");

        searchfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchfieldActionPerformed(evt);
            }
        });
        searchfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchfieldKeyReleased(evt);
            }
        });

        searchbtn.setText("Search");
        searchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbtnActionPerformed(evt);
            }
        });
        searchbtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchbtnKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(searchfield, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(searchbtn))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel9)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchbtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldaslsklhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldaslsklhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldaslsklhActionPerformed

    private void jButtontambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtontambahActionPerformed
        
        
        try {
            
            String sql = "INSERT INTO siswa VALUES (?, ?, ?, ?, ?, ?)";

            java.sql.Connection conn = (Connection) config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, jTextFieldnis.getText());
            pst.setString(2, jTextFieldnama.getText());
            pst.setString(3, jTextFieldaslsklh.getText());
            pst.setString(4, jLabeljenis.getText());
            pst.setString(5, String.valueOf(this.hasil1[jComboBoxjurusan.getSelectedIndex()]));
            pst.setString(6, String.valueOf(this.hasil2[jComboBoxpkl.getSelectedIndex()]));
//            pst.setString(5, String.valueOf(this.hasil[jComboBoxjurusan.getSelectedItem()]));
//            pst.setString(6, String.valueOf(this.hasil[jComboBoxpkl.getSelectedIndex()]));
            pst.executeUpdate();
            
            
            JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
        try {
            
            String sql2 = "INSERT INTO nilai VALUES (? , ?, ?, ?, default)";

            java.sql.Connection conn = (Connection) config.configDB();
            java.sql.PreparedStatement nilai = conn.prepareStatement(sql2);
            nilai.setString(1, jTextFieldnis.getText());
            nilai.setString(2, jTextFieldnis.getText());
            nilai.setString(3, String.valueOf(this.hasil1[jComboBoxjurusan.getSelectedIndex()]));
            nilai.setString(4, String.valueOf(this.hasil2[jComboBoxpkl.getSelectedIndex()]));
//            pst.setString(5, String.valueOf(this.hasil[jComboBoxjurusan.getSelectedItem()]));
//            pst.setString(6, String.valueOf(this.hasil[jComboBoxpkl.getSelectedIndex()]));
            nilai.executeUpdate();
            
            
            
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
        
        load_table();
        kosong();
        
        

    }//GEN-LAST:event_jButtontambahActionPerformed

    private void jRadioButtonlakiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonlakiActionPerformed
        if(jRadioButtonlaki.isSelected()){
            jLabeljenis.setText("Laki-laki");
            jRadioButtonperempuan.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButtonlakiActionPerformed

    private void jRadioButtonperempuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonperempuanActionPerformed
        if(jRadioButtonperempuan.isSelected()){
            jLabeljenis.setText("Perempuan");
            jRadioButtonlaki.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButtonperempuanActionPerformed

    private void jComboBoxjurusanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxjurusanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxjurusanActionPerformed

    private void jButtonhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonhapusActionPerformed
         // fungsi hapus data
        try {
            String sql ="delete from siswa where nis= ?";
            java.sql.Connection conn=(Connection)config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1, jTextFieldnis.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "berhasil di hapus");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        load_table();
        kosong();
    }//GEN-LAST:event_jButtonhapusActionPerformed

    private void jButtonclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonclearActionPerformed
        kosong();
    }//GEN-LAST:event_jButtonclearActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // menampilkan data kedalam form pengisian:
        int baris = jTable1.rowAtPoint(evt.getPoint());
        String nis =jTable1.getValueAt(baris, 0).toString();
        jTextFieldnis.setText(nis);
        String nama = jTable1.getValueAt(baris,1).toString();
        jTextFieldnama.setText(nama);
        String sekolah = jTable1.getValueAt(baris,2).toString();
        jTextFieldaslsklh.setText(sekolah);
        
        String jk = jTable1.getValueAt(baris, 3).toString();
        if ("Laki-laki".equals(jk)){
            jRadioButtonlaki.setSelected(true);
            jRadioButtonperempuan.setSelected(false);
            jLabeljenis.setText(jk);
            
        }else{
            jRadioButtonperempuan.setSelected(true);
            jRadioButtonlaki.setSelected(false);
            jLabeljenis.setText(jk);
        }
        
        String jurusan = jTable1.getValueAt(baris, 4).toString();
        jComboBoxjurusan.setSelectedItem(jurusan);
        
        String pkl = jTable1.getValueAt(baris, 5).toString();
        jComboBoxpkl.setSelectedItem(pkl);

        
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButtonubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonubahActionPerformed
         // Edit Data
        try {
            
            String sql ="UPDATE siswa SET nis = ?, nama = ?, sekolah = ?, jk = ?, jurusan = ?, lab=? WHERE nis = ?";
                    
            java.sql.Connection conn=(Connection)config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1, jTextFieldnis.getText());
            pst.setString(2, jTextFieldnama.getText());
            pst.setString(3, jTextFieldaslsklh.getText());
            pst.setString(4, jLabeljenis.getText());
            pst.setString(5, String.valueOf(jComboBoxjurusan.getSelectedItem()));
            pst.setString(6, String.valueOf(jComboBoxpkl.getSelectedItem()));
            pst.setString(7, jTextFieldnis.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "data berhasil di edit");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Perubahan Data Gagal"+e.getMessage());
        }
        load_table();
        kosong();
    }//GEN-LAST:event_jButtonubahActionPerformed

    private void searchbtnKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchbtnKeyReleased
        // membuat tampilan model tabel
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nis");
        model.addColumn("Nama");
        model.addColumn("Sekolah");
        model.addColumn("Jenis Kelamin");
        model.addColumn("Jurusan");
        model.addColumn("Tempat PKL");

        //menampilkan data database kedalam tabel
        try {
            int no = 1;
            String sql = "SELECT * FROM `tampil_siswa` WHERE `nama` LIKE '%'"+ searchfield.getText() + "'%' ";
            java.sql.Connection conn = (Connection) config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                model.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3),
                    res.getString(4), res.getString(5), res.getString(6)});
                
            }
            jTable1.setModel(model);
        } catch (SQLException e) {
        }
    }//GEN-LAST:event_searchbtnKeyReleased

    private void searchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbtnActionPerformed
        // membuat tampilan model tabel
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nis");
        model.addColumn("Nama");
        model.addColumn("Sekolah");
        model.addColumn("Jenis Kelamin");
        model.addColumn("Jurusan");
        model.addColumn("Tempat PKL");

        //menampilkan data database kedalam tabel
        try {
            int no = 1;
//            String sql = "SELECT * FROM `tampil_siswa` WHERE `nama` LIKE '%'"+ searchfield.getText() + "'%' ";
            java.sql.Connection conn = (Connection) config.configDB();
            java.sql.PreparedStatement stm = conn.prepareStatement("SELECT * FROM tampil_siswa WHERE nama LIKE ?");
            stm.setString(1, "%" + searchfield.getText() + "%");
            java.sql.ResultSet res = stm.executeQuery();
            while (res.next()) {
                model.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3),
                    res.getString(4), res.getString(5), res.getString(6)});
                
            }
            jTable1.setModel(model);
        } catch (SQLException e) {
        }
    }//GEN-LAST:event_searchbtnActionPerformed

    private void searchfieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchfieldKeyReleased
        // membuat tampilan model tabel
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nis");
        model.addColumn("Nama");
        model.addColumn("Sekolah");
        model.addColumn("Jenis Kelamin");
        model.addColumn("Jurusan");
        model.addColumn("Tempat PKL");

        //menampilkan data database kedalam tabel
        try {
            int no = 1;
//            String sql = "SELECT * FROM `tampil_siswa` WHERE `nama` LIKE '%'"+ searchfield.getText() + "'%' ";
            java.sql.Connection conn = (Connection) config.configDB();
            java.sql.PreparedStatement stm = conn.prepareStatement("SELECT * FROM tampil_siswa WHERE nama LIKE ? OR nis LIKE ?");
            stm.setString(1, "%" + searchfield.getText() + "%");
            stm.setString(2, "%" + searchfield.getText() + "%");
            java.sql.ResultSet res = stm.executeQuery();
            while (res.next()) {
                model.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3),
                    res.getString(4), res.getString(5), res.getString(6)});
                
            }
            jTable1.setModel(model);
        } catch (SQLException e) {
        }
    }//GEN-LAST:event_searchfieldKeyReleased

    private void searchfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchfieldActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new siswa().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonclear;
    private javax.swing.JButton jButtonhapus;
    private javax.swing.JButton jButtontambah;
    private javax.swing.JButton jButtonubah;
    private javax.swing.JComboBox<String> jComboBoxjurusan;
    private javax.swing.JComboBox<String> jComboBoxpkl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabeljenis;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButtonlaki;
    private javax.swing.JRadioButton jRadioButtonperempuan;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldaslsklh;
    private javax.swing.JTextField jTextFieldnama;
    private javax.swing.JTextField jTextFieldnis;
    private javax.swing.JButton searchbtn;
    private javax.swing.JTextField searchfield;
    // End of variables declaration//GEN-END:variables
}
