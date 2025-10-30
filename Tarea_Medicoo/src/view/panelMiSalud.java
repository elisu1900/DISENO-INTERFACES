package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

public class panelMiSalud extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButton btnAddMedicamento;
	private JButton btnAddTratamiento;
	private JButton btnMiSalud;
	private JButton btnCerrarSesion;

	private JTable tablaMedicamentos;
	private JTable tablaTratamientos;
	private DefaultTableModel modeloMedicamentos;
	private DefaultTableModel modeloTratamientos;

	private JTextField txtBuscarMedicamento;
	private JTextField txtBuscarTratamiento;

	private JButton btnBuscarMedicamento;
	private JButton btnBuscarTratamiento;

	public panelMiSalud() {
		setLayout(new BorderLayout(0, 0));
		setBackground(new Color(152, 251, 152));

		JPanel panelBtn = new JPanel();
		panelBtn.setBackground(new Color(152, 251, 152));
		add(panelBtn, BorderLayout.WEST);
		panelBtn.setLayout(new GridLayout(4, 1, 0, 0));

		btnAddMedicamento = new JButton("Añadir medicamento");
		btnAddMedicamento.setForeground(Color.WHITE);
		btnAddMedicamento.setBackground(new Color(9, 119, 33));
		btnAddMedicamento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelBtn.add(btnAddMedicamento);

		btnAddTratamiento = new JButton("Añadir tratamiento");
		btnAddTratamiento.setBackground(new Color(9, 119, 33));
		btnAddTratamiento.setForeground(Color.WHITE);
		btnAddTratamiento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelBtn.add(btnAddTratamiento);

		btnMiSalud = new JButton("Mi Salud");
		btnMiSalud.setForeground(Color.WHITE);
		btnMiSalud.setBackground(new Color(46, 139, 87));
		btnMiSalud.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelBtn.add(btnMiSalud);

		btnCerrarSesion = new JButton("Cerrar Sesión");
		btnCerrarSesion.setForeground(Color.WHITE);
		btnCerrarSesion.setBackground(new Color(9, 119, 33));
		btnCerrarSesion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelBtn.add(btnCerrarSesion);

		JPanel panelCentral = new JPanel();
		panelCentral.setBackground(new Color(152, 251, 152));
		add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(5, 10, 5, 10);
		gbc.weightx = 1.0;

		JLabel lblTituloMedicamentos = new JLabel("Medicamentos");
		lblTituloMedicamentos.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTituloMedicamentos.setHorizontalAlignment(SwingConstants.CENTER);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.weighty = 0;
		panelCentral.add(lblTituloMedicamentos, gbc);

		JPanel panelBusquedaMed = new JPanel();
		panelBusquedaMed.setBackground(new Color(152, 251, 152));
		panelBusquedaMed.setLayout(new BorderLayout(5, 0));

		JLabel lblBuscarMed = new JLabel("Buscar:");
		lblBuscarMed.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelBusquedaMed.add(lblBuscarMed, BorderLayout.WEST);

		txtBuscarMedicamento = new JTextField();
		txtBuscarMedicamento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelBusquedaMed.add(txtBuscarMedicamento, BorderLayout.CENTER);

		btnBuscarMedicamento = new JButton("Buscar");
		btnBuscarMedicamento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBuscarMedicamento.setBackground(new Color(46, 139, 87));
		btnBuscarMedicamento.setForeground(Color.WHITE);
		panelBusquedaMed.add(btnBuscarMedicamento, BorderLayout.EAST);

		gbc.gridy = 1;
		gbc.weighty = 0;
		panelCentral.add(panelBusquedaMed, gbc);

		String[] columnasMedicamentos = { "Nombre", "Laboratorio", "Tipo", "Descripción" };
		modeloMedicamentos = new DefaultTableModel(columnasMedicamentos, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tablaMedicamentos = new JTable(modeloMedicamentos);
		tablaMedicamentos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tablaMedicamentos.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 12));
		tablaMedicamentos.setRowHeight(25);

		JScrollPane scrollMedicamentos = new JScrollPane(tablaMedicamentos);
		gbc.gridy = 2;
		gbc.weighty = 0.4;
		panelCentral.add(scrollMedicamentos, gbc);

		JLabel lblTituloTratamientos = new JLabel("Mis tratamientos");
		lblTituloTratamientos.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTituloTratamientos.setHorizontalAlignment(SwingConstants.CENTER);
		gbc.gridy = 3;
		gbc.weighty = 0;
		panelCentral.add(lblTituloTratamientos, gbc);

		JPanel panelBusquedaTrat = new JPanel();
		panelBusquedaTrat.setBackground(new Color(152, 251, 152));
		panelBusquedaTrat.setLayout(new BorderLayout(5, 0));

		JLabel lblBuscarTrat = new JLabel("Buscar:");
		lblBuscarTrat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelBusquedaTrat.add(lblBuscarTrat, BorderLayout.WEST);

		txtBuscarTratamiento = new JTextField();
		txtBuscarTratamiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelBusquedaTrat.add(txtBuscarTratamiento, BorderLayout.CENTER);

		btnBuscarTratamiento = new JButton("Buscar");
		btnBuscarTratamiento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBuscarTratamiento.setBackground(new Color(46, 139, 87));
		btnBuscarTratamiento.setForeground(Color.WHITE);
		panelBusquedaTrat.add(btnBuscarTratamiento, BorderLayout.EAST);

		gbc.gridy = 4;
		gbc.weighty = 0;
		panelCentral.add(panelBusquedaTrat, gbc);

		String[] columnasTratamientos = { "Nombre", "Fecha Inicio", "Fecha Fin", "Tipo", "Comprimidos", "Horas" };
		modeloTratamientos = new DefaultTableModel(columnasTratamientos, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tablaTratamientos = new JTable(modeloTratamientos);
		tablaTratamientos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tablaTratamientos.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 12));
		tablaTratamientos.setRowHeight(25);

		JScrollPane scrollTratamientos = new JScrollPane(tablaTratamientos);
		gbc.gridy = 5;
		gbc.weighty = 0.4;
		panelCentral.add(scrollTratamientos, gbc);
	}

	// Getters
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

	public JTable getTablaMedicamentos() {
		return tablaMedicamentos;
	}

	public JTable getTablaTratamientos() {
		return tablaTratamientos;
	}

	public DefaultTableModel getModeloMedicamentos() {
		return modeloMedicamentos;
	}

	public DefaultTableModel getModeloTratamientos() {
		return modeloTratamientos;
	}

	public JTextField getTxtBuscarMedicamento() {
		return txtBuscarMedicamento;
	}

	public JTextField getTxtBuscarTratamiento() {
		return txtBuscarTratamiento;
	}

	public JButton getBtnBuscarMedicamento() {
		return btnBuscarMedicamento;
	}

	public JButton getBtnBuscarTratamiento() {
		return btnBuscarTratamiento;
	}
}