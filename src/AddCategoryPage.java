import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Database.Categories;
import java.util.*;
import Database.Database;

public class AddCategoryPage extends javax.swing.JFrame {
    Database database = new Database();
    private int selectedIndex = 0;

    public AddCategoryPage() {
        initComponents();
        showCategoriesInTable();
    }

    public void setSelectedIndex(int i) {
        this.selectedIndex = i;
    }

    public void showCategoriesInTable() {
        ArrayList<Categories> categories = database.getAllCategories();
        DefaultTableModel model = (DefaultTableModel) categoriesTable.getModel();

        model.setRowCount(0);

        Object[] row = new Object[2];

        for (int i = 0; i < categories.size(); i++) {
            row[0] = categories.get(i).getId();
            row[1] = categories.get(i).getName();

            model.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        categoriesTable = new javax.swing.JTable();
        categoryInput = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("ADD CATEGORY");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Category Name:");

        categoriesTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "Id", "Name"
                }) {
            boolean[] canEdit = new boolean[] {
                    false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        categoriesTable.setFocusable(false);
        categoriesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                categoriesTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(categoriesTable);
        if (categoriesTable.getColumnModel().getColumnCount() > 0) {
            categoriesTable.getColumnModel().getColumn(0).setPreferredWidth(350);
        }

        categoryInput.setBackground(new java.awt.Color(255, 255, 255));
        categoryInput.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        categoryInput.setForeground(new java.awt.Color(0, 0, 0));
        categoryInput.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(51, 51, 51), null));
        categoryInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryInputActionPerformed(evt);
            }
        });

        addButton.setBackground(new java.awt.Color(3, 236, 10));
        addButton.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        deleteButton.setBackground(new java.awt.Color(204, 0, 0));
        deleteButton.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(categoryInput, javax.swing.GroupLayout.PREFERRED_SIZE, 269,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37,
                                        Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel1)
                                .addGap(34, 34, 34)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(categoryInput, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(addButton)
                                        .addComponent(deleteButton))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void categoriesTableMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_categoriesTableMouseClicked
        // TODO add your handling code here:
        setSelectedIndex(categoriesTable.getSelectedRow());
    }// GEN-LAST:event_categoriesTableMouseClicked

    private void categoryInputActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_categoryInputActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_categoryInputActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        Categories category = database.getAllCategories().get(selectedIndex);
        int answer = JOptionPane.showConfirmDialog(null, "Are you sure to delete " + category.getName() + " category?",
                "Delete Category",
                JOptionPane.YES_NO_CANCEL_OPTION);

        if (answer == 0) {
            database.deleteCategories(category.getId());
            showCategoriesInTable();
        }
    }// GEN-LAST:event_deleteButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        if (categoryInput.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Category name is needed!", "Wrong Input", JOptionPane.ERROR_MESSAGE);
        } else {
            String id = UUID.randomUUID().toString();
            Categories category = new Categories(id, categoryInput.getText().trim());
            this.database.addCategories(category);
            System.out.println("Successfully Add category");
            showCategoriesInTable();
            categoryInput.setText("");
        }

    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddCategoryPage.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddCategoryPage.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddCategoryPage.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddCategoryPage.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddCategoryPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTable categoriesTable;
    private javax.swing.JTextField categoryInput;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
