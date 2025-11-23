package Vista;

import BD.Conexion;
import Controlador.*;
import Modelo.Tarjeta_grafica;
import java.awt.Color;
import java.util.List;
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
        tbLista.setDefaultEditor(Object.class, null);
        tbStockPorMarca.setDefaultEditor(Object.class, null);
        cargarTabla();
        
        personalizarColoresTabla();

    }

    private void personalizarColoresTabla() {
        tbLista.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
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
                    case "amd":
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
        
        tbStockPorMarca.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {

                java.awt.Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                // Obtener la marca de esa fila (columna 4 según tu tabla)
                String marca = table.getValueAt(row, 0).toString().toLowerCase();

                // Color según marca
                switch (marca) {
                    case "nvidia":
                        c.setBackground(new Color(144, 238, 144)); // verde suave
                        break;
                    case "amd":
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
    
    public void limpiarCampos(){
        spCodigo.setValue(0);
        tbNombre.setText("Ej: RTX 3060 TI");
        spCantidad.setValue(0);
        rbNuevo.setSelected(true);
        cbMarcas.setSelectedIndex(0);
    }

    private void ComboMarcasActionPerformed(java.awt.event.ActionEvent evt) {
        String marca = cbMarcas.getSelectedItem().toString().toLowerCase();

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

    
    public void cargarTabla() {
        try {
            
            DaoTarjetasGraficas d = new DaoTarjetasGraficas();
            List<Tarjeta_grafica> listadoTarjetas = new DaoTarjetasGraficas().listarTarjetas();
            List<Tarjeta_grafica> listadoStockPorMarca = new DaoTarjetasGraficas().listarStockPorMarca();
            DefaultTableModel dtm = new DefaultTableModel();
            DefaultTableModel dtm2 = new DefaultTableModel();
            
            //dtm:
            dtm.addColumn("Código");
            dtm.addColumn("Nombre");
            dtm.addColumn("Cantidad");
            dtm.addColumn("Estado");
            dtm.addColumn("Marca");

            String[] filas = new String[5];
            for (Tarjeta_grafica tarjeta_grafica : listadoTarjetas) {
                filas[0] = String.valueOf(tarjeta_grafica.getCodigo());
                filas[1] = String.valueOf(tarjeta_grafica.getNombre());
                filas[2] = String.valueOf(tarjeta_grafica.getCantidad());
                filas[3] = String.valueOf(tarjeta_grafica.getEstado());
                filas[4] = String.valueOf(tarjeta_grafica.getMarca());

                dtm.addRow(filas);
            }
            tbLista.setModel(dtm);
            
            //dtm2: para mostrar stock de tarjetas por marca en base a query "Group by".
            dtm2.addColumn("Marca");
            dtm2.addColumn("Stock disponible");
            
            String [] filasStock = new String[2];
            for (Tarjeta_grafica tarjeta_grafica : listadoStockPorMarca) {
                filasStock[0] = String.valueOf(tarjeta_grafica.getMarca());
                filasStock[1] = String.valueOf(tarjeta_grafica.getCantidad());
                dtm2.addRow(filasStock);
            }
            tbStockPorMarca.setModel(dtm2);
            

        } catch (Exception e) {
            System.out.println("FormSP Error al cargar tabla:" + e.getMessage());
        }
        limpiarCampos();
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
        tbNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        BtnRegistrar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        BtnModificar = new javax.swing.JButton();
        spCodigo = new javax.swing.JSpinner();
        rbNuevo = new javax.swing.JRadioButton();
        rbUsado = new javax.swing.JRadioButton();
        rbRecondicionado = new javax.swing.JRadioButton();
        cbMarcas = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbLista = new javax.swing.JTable();
        spCantidad = new javax.swing.JSpinner();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbStockPorMarca = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

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

        tbNombre.setText("Ej: RTX 3060 TI");
        tbNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbNombreMouseClicked(evt);
            }
        });
        tbNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbNombreActionPerformed(evt);
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
        BtnEliminar.setDefaultCapable(false);
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        BtnModificar.setText("Modificar");
        BtnModificar.setDefaultCapable(false);
        BtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarActionPerformed(evt);
            }
        });

        spCodigo.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        rbNuevo.setBackground(new java.awt.Color(255, 255, 255));
        btnGrupo.add(rbNuevo);
        rbNuevo.setSelected(true);
        rbNuevo.setText("Nuevo");
        rbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNuevoActionPerformed(evt);
            }
        });

        rbUsado.setBackground(new java.awt.Color(255, 255, 255));
        btnGrupo.add(rbUsado);
        rbUsado.setText("Usado");
        rbUsado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbUsadoActionPerformed(evt);
            }
        });

        rbRecondicionado.setBackground(new java.awt.Color(255, 255, 255));
        btnGrupo.add(rbRecondicionado);
        rbRecondicionado.setText("Reacondicionado");
        rbRecondicionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbRecondicionadoActionPerformed(evt);
            }
        });

        cbMarcas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO SELECCIONADO", "NVIDIA", "AMD", "INTEL" }));

        tbLista.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbLista);

        spCantidad.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        tbStockPorMarca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbStockPorMarca);

        jLabel8.setText("Stock disponible por marca:");

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
                        .addComponent(rbNuevo)
                        .addGap(10, 10, 10)
                        .addComponent(rbUsado)
                        .addGap(10, 10, 10)
                        .addComponent(rbRecondicionado))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbMarcas, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(BtnRegistrar)
                                .addGap(18, 18, 18)
                                .addComponent(BtnModificar)))
                        .addGap(18, 18, 18)
                        .addComponent(BtnEliminar))
                    .addComponent(spCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(tbNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                        .addComponent(spCodigo, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(73, 73, 73)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tbNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel4))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbNuevo)
                            .addComponent(rbUsado)
                            .addComponent(rbRecondicionado))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbMarcas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnRegistrar)
                            .addComponent(BtnEliminar)
                            .addComponent(BtnModificar)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(22, 22, 22))
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

        jMenu1.setText("Agregar usuario");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Acerca de nosotros");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

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

    private void tbNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbNombreActionPerformed

    private void BtnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegistrarActionPerformed
        try {
            int codigo = Integer.parseInt(spCodigo.getValue().toString());
            String nombre = tbNombre.getText();
            int cantidad = Integer.parseInt(spCantidad.getValue().toString());
            String marca = cbMarcas.getSelectedItem().toString();
            char estado = 'N';
            if (rbUsado.isSelected()) {
                estado = 'U';
            } else if (rbRecondicionado.isSelected()) {
                estado = 'R';
            }
            //2. Validar datos
            if (codigo <= 0) {
                JOptionPane.showMessageDialog(this, "Código no Válido");
                return;
            } else if (nombre.trim().length() == 0) {
                JOptionPane.showMessageDialog(this, "Nombre no Válido");
                return;

            } else if (cantidad <= 0) {
                JOptionPane.showMessageDialog(this, "Debe ingresar una cantidad mayor a 0.");
                return;

            } else if (cbMarcas.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar una marca de tarjeta gráfica.");
                return;
            }
            //3. Crear objeto
            Tarjeta_grafica t = new Tarjeta_grafica(codigo, nombre, cantidad, estado, marca);

            //4. Registrar en la colección
            if (new DaoTarjetasGraficas().agregarTarjeta(t)) {
                cargarTabla();
                JOptionPane.showMessageDialog(this, "Tarjeta Registrada");
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo agregar la tarjeta al registro.\nVerifique datos del ítem.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al intentar agregar tarjeta:\n" + e.getMessage());
        }

    }//GEN-LAST:event_BtnRegistrarActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        try {
            int codigo = Integer.parseInt(spCodigo.getValue().toString());
            if (new DaoTarjetasGraficas().eliminarTarjeta(codigo)) {
                cargarTabla();
                JOptionPane.showMessageDialog(this, "Tarjeta Grafica eliminada");
            } else {
                JOptionPane.showMessageDialog(this, "No se ha eliminado el ítem.\nIngrese un código de ítem existente.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al intentar eliminar el ítem:\n" + e.getMessage());
        }
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed
        try {
            //1. Captura de datos.
            int codigo = Integer.parseInt(spCodigo.getValue().toString());
            String nombre = tbNombre.getText();
            int cantidad = Integer.parseInt(spCantidad.getValue().toString());
            char estado = 'N';
            if (rbUsado.isSelected()){
                estado = 'U';
            } else if (rbRecondicionado.isSelected()){
                estado = 'R';
            }
            String marca = cbMarcas.getSelectedItem().toString();
            
            //2. Validación de datos capturados:
            if (codigo <= 0) {
                JOptionPane.showMessageDialog(this, "Código no Válido");
                return;
            } else if (nombre.trim().length() == 0) {
                JOptionPane.showMessageDialog(this, "Nombre no Válido");
                return;

            } else if (cantidad <= 0) {
                JOptionPane.showMessageDialog(this, "Debe ingresar una cantidad mayor a 0.");
                return;

            } else if (cbMarcas.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar una marca de tarjeta gráfica.");
                return;
            }
            
            //3. Instanciación con datos capturados:
            Tarjeta_grafica nt = new Tarjeta_grafica(codigo, nombre, cantidad, estado, marca);
            if (new DaoTarjetasGraficas().modificarTarjeta(nt)){
                cargarTabla();
                JOptionPane.showMessageDialog(this, "Se han modificado los datos del ítem exitósamente.");
            } else {
                JOptionPane.showMessageDialog(this, "No se han modificado los datos del ítem.\n Verifique la información y el código de ítem.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al intentar modificar datos del item:\n" + e.getMessage());
        }
    }//GEN-LAST:event_BtnModificarActionPerformed

    private void rbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNuevoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbNuevoActionPerformed

    private void rbUsadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbUsadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbUsadoActionPerformed

    private void rbRecondicionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbRecondicionadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbRecondicionadoActionPerformed

    private void tbNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNombreMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbNombreMouseClicked

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
    private javax.swing.ButtonGroup btnGrupo;
    private javax.swing.JComboBox<String> cbMarcas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jpCodigo;
    private javax.swing.JRadioButton rbNuevo;
    private javax.swing.JRadioButton rbRecondicionado;
    private javax.swing.JRadioButton rbUsado;
    private javax.swing.JSpinner spCantidad;
    private javax.swing.JSpinner spCodigo;
    private javax.swing.JTable tbLista;
    private javax.swing.JTextField tbNombre;
    private javax.swing.JTable tbStockPorMarca;
    // End of variables declaration//GEN-END:variables
}
