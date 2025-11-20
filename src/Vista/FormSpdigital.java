package Vista;


import Controlador.Lista_Tarjetas_graficas;
import Modelo.Tarjetas_graficas;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Nicolas
 */
public class FormSpdigital extends javax.swing.JFrame {
    Lista_Tarjetas_graficas lista = new Lista_Tarjetas_graficas();
    /**
     * Creates new form FormSpdigital
     */
    public FormSpdigital() {
        initComponents();
        cargarTabla();
        personalizarColoresTabla();
        
    }
    
    private void personalizarColoresTabla() {
    Lista.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
        @Override
        public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {

            java.awt.Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            // Obtener la marca de esa fila (columna 4 según tu tabla)
            String marca = table.getValueAt(row, 4).toString().toLowerCase();

            // Color según marca
            switch (marca) {
                case "nvidia":
                    c.setBackground(new Color(144, 238, 144)); // verde suave
                    break;
                case "radeon":
                    c.setBackground(new Color(255, 160, 122)); // rojo claro
                    break;
                case "intel":
                    c.setBackground(new Color(173, 216, 230)); // azul claro
                    break;
                default:
                    c.setBackground(Color.WHITE);
                    break;
            }

            // Si la fila está seleccionada, mantener selección visible
            if (isSelected) {
                c.setBackground(c.getBackground().darker());
            }

            return c;
        }
    });
}
    
    
    private void ComboMarcasActionPerformed(java.awt.event.ActionEvent evt) {                                          
    String marca = ComboMarcas.getSelectedItem().toString().toLowerCase();

    switch (marca) {
        case "nvidia":
            jPanel4.setBackground(Color.GREEN);
            break;
        case "radeon":
            jLabel4.setBackground(Color.RED);
            break;
        case "intel":
            jLabel4.setBackground(Color.BLUE);
            break;
        default:
            jLabel4.setBackground(Color.WHITE);
            break;
    }
}
    
    public void cargarTabla(){
        DefaultTableModel dtm= new DefaultTableModel();
        
        dtm.addColumn("Código");
        dtm.addColumn("Nombre");
        dtm.addColumn("Cantidad");
        dtm.addColumn("Estado");
        dtm.addColumn("Marca");
        
        String[] filas=new String[5];
        for (Tarjetas_graficas tarjetas_graficas :lista.getLista()){
        filas[0]=String.valueOf(tarjetas_graficas.getCodigo());
        filas[1]=String.valueOf(tarjetas_graficas.getNombre());
        filas[2]=String.valueOf(tarjetas_graficas.getCantidad());
        filas[3]=String.valueOf(tarjetas_graficas.getEstado());
        filas[4]=String.valueOf(tarjetas_graficas.getMarca());
        
            dtm.addRow(filas);
        }
        Lista.setModel(dtm);
        
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrupo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jpCodigo = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TxtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        BtnRegistrar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        BtnModificar = new javax.swing.JButton();
        SpCodigo = new javax.swing.JSpinner();
        ButtonNuevo = new javax.swing.JRadioButton();
        ButtonUsado = new javax.swing.JRadioButton();
        ButtonRecondicionado = new javax.swing.JRadioButton();
        ComboMarcas = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        Lista = new javax.swing.JTable();
        SpCantidad = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Formulario ingreso producto");
        setResizable(false);

        jpCodigo.setBackground(new java.awt.Color(153, 153, 153));

        jPanel3.setBackground(new java.awt.Color(0, 0, 102));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SPDigital");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("Tarjetas gráficas");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("Código: ");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 102));
        jLabel4.setText("Cantidad:");

        TxtNombre.setText("Ej: RTX 3060 TI");
        TxtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNombreActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 102));
        jLabel5.setText("Nombre:");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 102));
        jLabel6.setText("Estado:");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 102));
        jLabel7.setText("Marcas");

        BtnRegistrar.setText("Registrar");
        BtnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegistrarActionPerformed(evt);
            }
        });

        BtnEliminar.setText("Eliminar");
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        BtnModificar.setText("Modificar");
        BtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarActionPerformed(evt);
            }
        });

        SpCodigo.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        ButtonNuevo.setBackground(new java.awt.Color(255, 255, 255));
        btnGrupo.add(ButtonNuevo);
        ButtonNuevo.setSelected(true);
        ButtonNuevo.setText("Nuevo");
        ButtonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonNuevoActionPerformed(evt);
            }
        });

        ButtonUsado.setBackground(new java.awt.Color(255, 255, 255));
        btnGrupo.add(ButtonUsado);
        ButtonUsado.setText("Usado");
        ButtonUsado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonUsadoActionPerformed(evt);
            }
        });

        ButtonRecondicionado.setBackground(new java.awt.Color(255, 255, 255));
        btnGrupo.add(ButtonRecondicionado);
        ButtonRecondicionado.setText("Reacondicionado");
        ButtonRecondicionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRecondicionadoActionPerformed(evt);
            }
        });

        ComboMarcas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO SELECCIONADO", "NVIDIA", "AMD", "INTEL" }));

        Lista.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(Lista);

        SpCantidad.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(ButtonNuevo)
                        .addGap(10, 10, 10)
                        .addComponent(ButtonUsado)
                        .addGap(10, 10, 10)
                        .addComponent(ButtonRecondicionado))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(ComboMarcas, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(BtnRegistrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BtnEliminar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnModificar))
                    .addComponent(SpCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(TxtNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                        .addComponent(SpCodigo, javax.swing.GroupLayout.Alignment.LEADING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SpCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SpCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel6)
                        .addGap(5, 5, 5)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ButtonNuevo)
                            .addComponent(ButtonUsado)
                            .addComponent(ButtonRecondicionado))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ComboMarcas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnRegistrar)
                            .addComponent(BtnEliminar)
                            .addComponent(BtnModificar))
                        .addGap(0, 39, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jpCodigoLayout = new javax.swing.GroupLayout(jpCodigo);
        jpCodigo.setLayout(jpCodigoLayout);
        jpCodigoLayout.setHorizontalGroup(
            jpCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpCodigoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpCodigoLayout.setVerticalGroup(
            jpCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCodigoLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TxtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtNombreActionPerformed

    private void BtnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegistrarActionPerformed
        int codigo =Integer.parseInt(SpCodigo.getValue().toString());
        String nombre=TxtNombre.getText();
        int cantidad =Integer.parseInt(SpCantidad.getValue().toString());
        String marca=ComboMarcas.getSelectedItem().toString();
        char estado='N';
        if (ButtonNuevo.isSelected()) {
            estado = 'N';
        } else if (ButtonUsado.isSelected()) {
            estado = 'U';
        } else if (ButtonRecondicionado.isSelected()) {
            estado = 'R';    
        } else {
        JOptionPane.showMessageDialog(this, "Debe seleccionar un estado");
        return;
        }
        //2. Validar datos
        if(codigo<=0){
            JOptionPane.showMessageDialog(this,"Código no Válido");
            return;
        }else if(nombre.trim().length()==0){
            JOptionPane.showMessageDialog(this,"Nombre no Válido");
            return;
            
        } else if(cantidad <= 0){
            JOptionPane.showMessageDialog(this, "Debe ingresar una cantidad mayor a 0.");
            return;
        
        } else if (ComboMarcas.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(this, "Debe seleccionar una marca de tarjeta gráfica.");
            return;
        }
        //3. Crear objeto
        Tarjetas_graficas t=new Tarjetas_graficas(codigo, nombre, cantidad,estado,marca);
        
        //4. Registrar en la colección
        if(lista.agregarTarjetaGrafica(t)){
            cargarTabla();
            JOptionPane.showMessageDialog(this,"Tarjeta Registrada");
        }else{
            JOptionPane.showMessageDialog(this,"Código Repetido");
        }
        
    }//GEN-LAST:event_BtnRegistrarActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed

        int codigo =Integer.parseInt(SpCodigo.getValue().toString());
        if(lista.eliminarTarjeta(codigo)){
            cargarTabla();
            JOptionPane.showMessageDialog(this,"Tarjeta Grafica el Eliminado");
        }else{
            JOptionPane.showMessageDialog(this,"No existe código");
        }
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnModificarActionPerformed

    private void ButtonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonNuevoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonNuevoActionPerformed

    private void ButtonUsadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonUsadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonUsadoActionPerformed

    private void ButtonRecondicionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRecondicionadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonRecondicionadoActionPerformed

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
            java.util.logging.Logger.getLogger(FormSpdigital.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormSpdigital.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormSpdigital.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormSpdigital.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormSpdigital().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnModificar;
    private javax.swing.JButton BtnRegistrar;
    private javax.swing.JRadioButton ButtonNuevo;
    private javax.swing.JRadioButton ButtonRecondicionado;
    private javax.swing.JRadioButton ButtonUsado;
    private javax.swing.JComboBox<String> ComboMarcas;
    private javax.swing.JTable Lista;
    private javax.swing.JSpinner SpCantidad;
    private javax.swing.JSpinner SpCodigo;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.ButtonGroup btnGrupo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpCodigo;
    // End of variables declaration//GEN-END:variables
}
