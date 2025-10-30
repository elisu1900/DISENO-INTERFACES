package controller;

import model.Medicamento;
import model.TipoMedicamento;
import model.Usuario;
import view.panelAñadirMed;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

public class MedicamentoController {
    
    private panelAñadirMed vista;
    private Usuario usuarioActual;

    public MedicamentoController(panelAñadirMed vista, Usuario usuarioActual) {
        this.vista = vista;
        this.usuarioActual = usuarioActual;
        addListeners();
    }

    private void addListeners() {
        vista.getBtnAdd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                añadirMedicamento();
            }
        });
    }

    private void añadirMedicamento() {
        // Obtener los valores de los campos
        String nombre = vista.getTxtNombreMed().getText().trim();
        String laboratorio = vista.getTxtLaboratorioMed().getText().trim();
        TipoMedicamento tipo =(TipoMedicamento) vista.getCBTipo().getSelectedItem();
        String descripcion = vista.getTxtDescripcionMed().getText().trim();

        // Validar que los campos no estén vacíos
        if (nombre.isEmpty() || laboratorio.isEmpty() || descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(vista, 
                "Todos los campos son obligatorios", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Crear el medicamento
        Medicamento nuevoMedicamento = new Medicamento(nombre, laboratorio, tipo, descripcion);

        // Añadir el medicamento a la lista del usuario
        usuarioActual.getMedicamentos().add(nuevoMedicamento);

        // Mostrar mensaje de éxito
        JOptionPane.showMessageDialog(vista, 
            "Medicamento añadido correctamente\nTotal de medicamentos: " + 
            usuarioActual.getMedicamentos().size(), 
            "Éxito", 
            JOptionPane.INFORMATION_MESSAGE);

        // Limpiar los campos
        limpiarCampos();
    }

    private void limpiarCampos() {
        vista.getTxtNombreMed().setText("");
        vista.getTxtLaboratorioMed().setText("");
        vista.getTxtDescripcionMed().setText("");
        vista.getCBTipo().setSelectedIndex(0);
    }

    public List<Medicamento> obtenerMedicamentos() {
        return usuarioActual.getMedicamentos();
    }
}