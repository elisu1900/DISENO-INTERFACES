package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.TipoMedicamento;

public class panelAñadirMed extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombreMed;
	private JTextField txtDescripcionMed;
	private JTextField txtLaboratorioMed;
	private JComboBox<TipoMedicamento> cBTipo;
	private JButton btnAdd;

	private JButton btnAddMedicamento;
	private JButton btnAddTratamiento;
	private JButton btnMiSalud;
	private JButton btnCerrarSesion;

	public panelAñadirMed() {
		setLayout(new BorderLayout(0, 0));
		setBackground(new Color(152, 251, 152));

		JPanel panelBtn = new JPanel();
		panelBtn.setBackground(new Color(152, 251, 152));
		add(panelBtn, BorderLayout.WEST);
		panelBtn.setLayout(new GridLayout(4, 1, 0, 0));

		btnAddMedicamento = new JButton("Añadir medicamento");
		btnAddMedicamento.setForeground(new Color(255, 255, 255));
		btnAddMedicamento.setBackground(new Color(46, 139, 87));
		btnAddMedicamento.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelBtn.add(btnAddMedicamento);

		btnAddTratamiento = new JButton("Añadir tratamiento");
		btnAddTratamiento.setBackground(new Color(9, 119, 33));
		btnAddTratamiento.setForeground(new Color(255, 255, 255));
		btnAddTratamiento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelBtn.add(btnAddTratamiento);

		btnMiSalud = new JButton("Mi Salud");
		btnMiSalud.setForeground(new Color(255, 255, 255));
		btnMiSalud.setBackground(new Color(9, 119, 33));
		btnMiSalud.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelBtn.add(btnMiSalud);

		btnCerrarSesion = new JButton("Cerrar Sesión");
		btnCerrarSesion.setForeground(new Color(255, 255, 255));
		btnCerrarSesion.setBackground(new Color(9, 119, 33));
		btnCerrarSesion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelBtn.add(btnCerrarSesion);

		JPanel panelCreate = new JPanel();
		panelCreate.setBackground(new Color(152, 251, 152));
		add(panelCreate, BorderLayout.CENTER);
		GridBagLayout gbl_panelCreate = new GridBagLayout();
		gbl_panelCreate.columnWidths = new int[] { 150, 300 };
		gbl_panelCreate.rowHeights = new int[] { 50, 50, 50, 50, 50, 50, 50, 50 };
		gbl_panelCreate.columnWeights = new double[] { 0.0, 1.0 };
		gbl_panelCreate.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0 };
		panelCreate.setLayout(gbl_panelCreate);

		JLabel lblTitulo = new JLabel("Añadir Medicamento");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.gridwidth = 2;
		gbc_lblTitulo.insets = new Insets(10, 0, 20, 0);
		gbc_lblTitulo.gridx = 0;
		gbc_lblTitulo.gridy = 0;
		panelCreate.add(lblTitulo, gbc_lblTitulo);

		JLabel lblNombreMed = new JLabel("Nombre");
		lblNombreMed.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNombreMed = new GridBagConstraints();
		gbc_lblNombreMed.anchor = GridBagConstraints.EAST;
		gbc_lblNombreMed.insets = new Insets(0, 0, 5, 15);
		gbc_lblNombreMed.gridx = 0;
		gbc_lblNombreMed.gridy = 1;
		panelCreate.add(lblNombreMed, gbc_lblNombreMed);

		txtNombreMed = new JTextField();
		txtNombreMed.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_txtNombreMed = new GridBagConstraints();
		gbc_txtNombreMed.insets = new Insets(0, 0, 5, 0);
		gbc_txtNombreMed.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombreMed.gridx = 1;
		gbc_txtNombreMed.gridy = 1;
		panelCreate.add(txtNombreMed, gbc_txtNombreMed);
		txtNombreMed.setColumns(10);

		JLabel lblLaboratorioMed = new JLabel("Laboratorio");
		lblLaboratorioMed.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLaboratorioMed.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblLaboratorioMed = new GridBagConstraints();
		gbc_lblLaboratorioMed.anchor = GridBagConstraints.EAST;
		gbc_lblLaboratorioMed.insets = new Insets(0, 0, 5, 15);
		gbc_lblLaboratorioMed.gridx = 0;
		gbc_lblLaboratorioMed.gridy = 2;
		panelCreate.add(lblLaboratorioMed, gbc_lblLaboratorioMed);

		txtLaboratorioMed = new JTextField();
		txtLaboratorioMed.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_txtLaboratorioMed = new GridBagConstraints();
		gbc_txtLaboratorioMed.insets = new Insets(0, 0, 5, 0);
		gbc_txtLaboratorioMed.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLaboratorioMed.gridx = 1;
		gbc_txtLaboratorioMed.gridy = 2;
		panelCreate.add(txtLaboratorioMed, gbc_txtLaboratorioMed);
		txtLaboratorioMed.setColumns(10);

		JLabel lblTipoMed = new JLabel("Tipo");
		lblTipoMed.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblTipoMed = new GridBagConstraints();
		gbc_lblTipoMed.anchor = GridBagConstraints.EAST;
		gbc_lblTipoMed.insets = new Insets(0, 0, 5, 15);
		gbc_lblTipoMed.gridx = 0;
		gbc_lblTipoMed.gridy = 3;
		panelCreate.add(lblTipoMed, gbc_lblTipoMed);

		cBTipo = new JComboBox<>();
		for (TipoMedicamento tipo : TipoMedicamento.values()) {
			cBTipo.addItem(tipo);
		}
		cBTipo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_cBTipo = new GridBagConstraints();
		gbc_cBTipo.insets = new Insets(0, 0, 5, 0);
		gbc_cBTipo.fill = GridBagConstraints.HORIZONTAL;
		gbc_cBTipo.gridx = 1;
		gbc_cBTipo.gridy = 3;
		panelCreate.add(cBTipo, gbc_cBTipo);

		// Descripción
		JLabel lblDescripcionMed = new JLabel("Descripción");
		lblDescripcionMed.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblDescripcionMed = new GridBagConstraints();
		gbc_lblDescripcionMed.anchor = GridBagConstraints.EAST;
		gbc_lblDescripcionMed.insets = new Insets(0, 0, 5, 15);
		gbc_lblDescripcionMed.gridx = 0;
		gbc_lblDescripcionMed.gridy = 4;
		panelCreate.add(lblDescripcionMed, gbc_lblDescripcionMed);

		txtDescripcionMed = new JTextField();
		txtDescripcionMed.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_txtDescripcionMed = new GridBagConstraints();
		gbc_txtDescripcionMed.insets = new Insets(0, 0, 5, 0);
		gbc_txtDescripcionMed.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDescripcionMed.gridx = 1;
		gbc_txtDescripcionMed.gridy = 4;
		panelCreate.add(txtDescripcionMed, gbc_txtDescripcionMed);
		txtDescripcionMed.setColumns(10);

		// Botón añadir
		btnAdd = new JButton("Añadir Medicamento");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdd.setBackground(new Color(46, 139, 87));
		btnAdd.setForeground(Color.WHITE);
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(20, 0, 5, 0);
		gbc_btnAdd.gridx = 1;
		gbc_btnAdd.gridy = 5;
		panelCreate.add(btnAdd, gbc_btnAdd);
	}

	public JTextField getTxtNombreMed() {
		return txtNombreMed;
	}

	public JTextField getTxtDescripcionMed() {
		return txtDescripcionMed;
	}

	public JTextField getTxtLaboratorioMed() {
		return txtLaboratorioMed;
	}

	public JComboBox<TipoMedicamento> getCBTipo() {
		return cBTipo;
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public JButton getBtnAddMedicamento() {
		return btnAddMedicamento;
	}

	public JButton getBtnAddTratamiento() {
		return btnAddTratamiento;
	}

	public JButton getBtnMiSalud() {
		return btnMiSalud;
	}

	public JButton getBtnCerrarSesion() {
		return btnCerrarSesion;
	}
}