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

public class panelAñadirMed extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombreMed;
	private JTextField txtDescripcionMed;
	private JTextField txtLaboratorioMed;

	/**
	 * Create the panel.
	 */
	public panelAñadirMed() {
		JPanel panelAñadirMed = new JPanel();
		panelAñadirMed.setLayout(new BorderLayout(0, 0));

		JPanel panelBotonAM = new JPanel();
		panelBotonAM.setBackground(new Color(152, 251, 152));
		panelAñadirMed.add(panelBotonAM, BorderLayout.WEST);
		panelBotonAM.setLayout(new GridLayout(4, 0, 0, 0));

		JButton btnAddMed_1 = new JButton("Añadir Medicamento\r\n");
		btnAddMed_1.setForeground(Color.WHITE);
		btnAddMed_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAddMed_1.setBackground(new Color(46, 139, 87));
		panelBotonAM.add(btnAddMed_1);

		JButton btnAddTrat_1 = new JButton("Añadir tratamiento\r\n");
		btnAddTrat_1.setForeground(Color.WHITE);
		btnAddTrat_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAddTrat_1.setBackground(new Color(46, 139, 87));
		panelBotonAM.add(btnAddTrat_1);

		JButton btnMiSalud_1 = new JButton("Mi Salud\r\n");
		btnMiSalud_1.setForeground(Color.WHITE);
		btnMiSalud_1.setBackground(new Color(46, 139, 87));
		panelBotonAM.add(btnMiSalud_1);

		JButton btnCerrar_1 = new JButton("Cerrar Sesion");
		btnCerrar_1.setForeground(Color.WHITE);
		btnCerrar_1.setBackground(new Color(46, 139, 87));
		panelBotonAM.add(btnCerrar_1);

		JPanel panelCreate = new JPanel();
		panelCreate.setBackground(new Color(152, 251, 152));
		panelAñadirMed.add(panelCreate, BorderLayout.CENTER);
		GridBagLayout gbl_panelCreate = new GridBagLayout();
		gbl_panelCreate.columnWidths = new int[] { 0, 0, 0 };
		gbl_panelCreate.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panelCreate.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_panelCreate.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelCreate.setLayout(gbl_panelCreate);

		JLabel lblNombreMed = new JLabel("Nombre\r\n");
		lblNombreMed.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNombreMed = new GridBagConstraints();
		gbc_lblNombreMed.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreMed.gridx = 0;
		gbc_lblNombreMed.gridy = 0;
		panelCreate.add(lblNombreMed, gbc_lblNombreMed);

		txtNombreMed = new JTextField();
		txtNombreMed.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_txtNombreMed = new GridBagConstraints();
		gbc_txtNombreMed.insets = new Insets(0, 0, 5, 0);
		gbc_txtNombreMed.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombreMed.gridx = 1;
		gbc_txtNombreMed.gridy = 0;
		panelCreate.add(txtNombreMed, gbc_txtNombreMed);
		txtNombreMed.setColumns(10);

		JLabel lblLaboratorioMed = new JLabel("Laboratorio\r\n");
		lblLaboratorioMed.setHorizontalAlignment(SwingConstants.CENTER);
		lblLaboratorioMed.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblLaboratorioMed = new GridBagConstraints();
		gbc_lblLaboratorioMed.insets = new Insets(0, 0, 5, 5);
		gbc_lblLaboratorioMed.gridx = 0;
		gbc_lblLaboratorioMed.gridy = 1;
		panelCreate.add(lblLaboratorioMed, gbc_lblLaboratorioMed);

		txtLaboratorioMed = new JTextField();
		txtLaboratorioMed.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_txtLaboratorioMed = new GridBagConstraints();
		gbc_txtLaboratorioMed.insets = new Insets(0, 0, 5, 0);
		gbc_txtLaboratorioMed.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLaboratorioMed.gridx = 1;
		gbc_txtLaboratorioMed.gridy = 1;
		panelCreate.add(txtLaboratorioMed, gbc_txtLaboratorioMed);
		txtLaboratorioMed.setColumns(10);

		JLabel lblTipoMed = new JLabel("Tipo\r\n");
		lblTipoMed.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblTipoMed = new GridBagConstraints();
		gbc_lblTipoMed.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoMed.gridx = 0;
		gbc_lblTipoMed.gridy = 2;
		panelCreate.add(lblTipoMed, gbc_lblTipoMed);

		JComboBox cBTipo = new JComboBox();
		cBTipo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_cBTipo = new GridBagConstraints();
		gbc_cBTipo.insets = new Insets(0, 0, 5, 0);
		gbc_cBTipo.fill = GridBagConstraints.HORIZONTAL;
		gbc_cBTipo.gridx = 1;
		gbc_cBTipo.gridy = 2;
		panelCreate.add(cBTipo, gbc_cBTipo);

		JLabel lblDescripcionMed = new JLabel("Descripcion\r\n");
		lblDescripcionMed.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblDescripcionMed = new GridBagConstraints();
		gbc_lblDescripcionMed.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcionMed.gridx = 0;
		gbc_lblDescripcionMed.gridy = 3;
		panelCreate.add(lblDescripcionMed, gbc_lblDescripcionMed);

		txtDescripcionMed = new JTextField();
		txtDescripcionMed.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_txtDescripcionMed = new GridBagConstraints();
		gbc_txtDescripcionMed.insets = new Insets(0, 0, 5, 0);
		gbc_txtDescripcionMed.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDescripcionMed.gridx = 1;
		gbc_txtDescripcionMed.gridy = 3;
		panelCreate.add(txtDescripcionMed, gbc_txtDescripcionMed);
		txtDescripcionMed.setColumns(10);

		JButton btnAdd = new JButton("Añadir Medicamento\r\n");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 5, 0);
		gbc_btnAdd.gridx = 1;
		gbc_btnAdd.gridy = 6;
		panelCreate.add(btnAdd, gbc_btnAdd);
	}

}
