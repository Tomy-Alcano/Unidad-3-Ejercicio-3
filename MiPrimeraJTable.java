import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class MiPrimeraJTable {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame ventana = new JFrame("Tabla de Productos");
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.setSize(700,400);
            ventana.setLocationRelativeTo(null);
            ventana.setLayout(new BorderLayout());

            String[] columnas = new String[]{"Id", "Nombre", "Categoria", "Precio"};

            DefaultTableModel modelo=  new DefaultTableModel(columnas, 0){
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                    }

            };

            modelo.addRow(new Object[]{1,"Notebook", "Electronica", 850000});

            modelo.addRow(new Object[]{2, "Mouse", "Electrónica", 25000});

            modelo.addRow(new Object[]{3, "Remera", "Ropa", 18000});

            modelo.addRow(new Object[]{4, "Silla", "Hogar", 95000});

            modelo.addRow(new Object[]{5, "Café", "Alimentos", 7000});

            JTable tabla = new JTable(modelo);

            tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            JScrollPane scroll = new JScrollPane(tabla);

            JButton btnAgregar = new JButton("Agregar producto de prueba");

            JButton  btnEliminar = new JButton("Eliminar fila seleccionado");

            JLabel lblCantidad = new JLabel("Total de filas:" + modelo.getRowCount());

            btnAgregar.addActionListener(e -> {

                modelo.addRow(new Object[]{modelo.getRowCount() + 1, "Prueba", "Otros", 1000});

                lblCantidad.setText("Total de filas:" + modelo.getRowCount());

            });

            btnEliminar.addActionListener(e -> {
                int fila = tabla.getSelectedRow();

                if (fila == -1) {
                    JOptionPane.showMessageDialog(ventana, "Debe seleccionar una fila");

                    return;
                }
                modelo.removeRow(fila);

                lblCantidad.setText("Total de filas:" + modelo.getRowCount());
            });

            JPanel panelInferior = new JPanel();

            panelInferior.add(btnAgregar);
            panelInferior.add(btnEliminar);
            panelInferior.add(lblCantidad);

            ventana.add(scroll, BorderLayout.CENTER);
            ventana.add(panelInferior, BorderLayout.SOUTH);

            ventana.setVisible(true);


        });

    }


}
