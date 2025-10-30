package view;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import model.Medicamento;
import java.util.List;

public class panelAñadirTratamiento extends JPanel {

	private static final long serialVersionUID = 1L;

	private JComboBox<String> cBMedicamento;
	private JTextArea txtDescripcion;
	private JDateChooser dateInicio;
	private JDateChooser dateFin;
	private JSpinner spinnerComprimidos;
	private JSpinner spinnerHoras;
	private JButton btnAgregar;
	private JTextField txtTipoMedicamento;

	private JButton btnAddMedicamento;
	private JButton btnAddTratamiento;
	private JButton btnMiSalud;
	private JButton btnCerrarSesion;

	public panelAñadirTratamiento() {
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
		btnAddTratamiento.setBackground(new Color(46, 139, 87));
		btnAddTratamiento.setForeground(Color.WHITE);
		btnAddTratamiento.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelBtn.add(btnAddTratamiento);

		btnMiSalud = new JButton("Mi Salud");
		btnMiSalud.setForeground(Color.WHITE);
		btnMiSalud.setBackground(new Color(9, 119, 33));
		btnMiSalud.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelBtn.add(btnMiSalud);

		btnCerrarSesion = new JButton("Cerrar Sesión");
		btnCerrarSesion.setForeground(Color.WHITE);
		btnCerrarSesion.setBackground(new Color(9, 119, 33));
		btnCerrarSesion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelBtn.add(btnCerrarSesion);

		JPanel panelCreate = new JPanel();
		panelCreate.setBackground(new Color(152, 251, 152));
		add(panelCreate, BorderLayout.CENTER);
		GridBagLayout gbl_panelCreate = new GridBagLayout();
		gbl_panelCreate.columnWidths = new int[] { 150, 300 };
		gbl_panelCreate.rowHeights = new int[] { 50, 50, 50, 50, 50, 50, 50, 50, 50 };
		gbl_panelCreate.columnWeights = new double[] { 0.0, 1.0 };
		gbl_panelCreate.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		panelCreate.setLayout(gbl_panelCreate);

		JLabel lblTitulo = new JLabel("Añadir Tratamiento");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.gridwidth = 2;
		gbc_lblTitulo.insets = new Insets(10, 0, 20, 0);
		gbc_lblTitulo.gridx = 0;
		gbc_lblTitulo.gridy = 0;
		panelCreate.add(lblTitulo, gbc_lblTitulo);

		JLabel lblMedicamento = new JLabel("Medicamento");
		lblMedicamento.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblMedicamento = new GridBagConstraints();
		gbc_lblMedicamento.anchor = GridBagConstraints.EAST;
		gbc_lblMedicamento.insets = new Insets(0, 0, 5, 15);
		gbc_lblMedicamento.gridx = 0;
		gbc_lblMedicamento.gridy = 1;
		panelCreate.add(lblMedicamento, gbc_lblMedicamento);

		cBMedicamento = new JComboBox<>();
		cBMedicamento.addItem("Seleccione un medicamento");
		cBMedicamento.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_cBMedicamento = new GridBagConstraints();
		gbc_cBMedicamento.insets = new Insets(0, 0, 5, 0);
		gbc_cBMedicamento.fill = GridBagConstraints.HORIZONTAL;
		gbc_cBMedicamento.gridx = 1;
		gbc_cBMedicamento.gridy = 1;
		panelCreate.add(cBMedicamento, gbc_cBMedicamento);

		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblTipo = new GridBagConstraints();
		gbc_lblTipo.anchor = GridBagConstraints.EAST;
		gbc_lblTipo.insets = new Insets(0, 0, 5, 15);
		gbc_lblTipo.gridx = 0;
		gbc_lblTipo.gridy = 2;
		panelCreate.add(lblTipo, gbc_lblTipo);

		txtTipoMedicamento = new JTextField();
		txtTipoMedicamento.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTipoMedicamento.setEditable(false); // NO EDITABLE
		txtTipoMedicamento.setBackground(new Color(240, 240, 240));
		GridBagConstraints gbc_txtTipo = new GridBagConstraints();
		gbc_txtTipo.insets = new Insets(0, 0, 5, 0);
		gbc_txtTipo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTipo.gridx = 1;
		gbc_txtTipo.gridy = 2;
		panelCreate.add(txtTipoMedicamento, gbc_txtTipo);

		JLabel lblDescripcion = new JLabel("Descripción");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 15);
		gbc_lblDescripcion.gridx = 0;
		gbc_lblDescripcion.gridy = 3;
		panelCreate.add(lblDescripcion, gbc_lblDescripcion);

		txtDescripcion = new JTextArea(3, 20);
		txtDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDescripcion.setEditable(false);
		txtDescripcion.setLineWrap(true);
		txtDescripcion.setWrapStyleWord(true);
		txtDescripcion.setBackground(new Color(240, 240, 240));
		txtDescripcion.setBorder(BorderFactory.createLineBorder(Color.GRAY));

		JScrollPane scrollDescripcion = new JScrollPane(txtDescripcion);
		GridBagConstraints gbc_txtDescripcion = new GridBagConstraints();
		gbc_txtDescripcion.insets = new Insets(0, 0, 5, 0);
		gbc_txtDescripcion.fill = GridBagConstraints.BOTH;
		gbc_txtDescripcion.gridx = 1;
		gbc_txtDescripcion.gridy = 3;
		panelCreate.add(scrollDescripcion, gbc_txtDescripcion);

		JLabel lblComprimidos = new JLabel("Comprimidos");
		lblComprimidos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblComprimidos = new GridBagConstraints();
		gbc_lblComprimidos.anchor = GridBagConstraints.EAST;
		gbc_lblComprimidos.insets = new Insets(0, 0, 5, 15);
		gbc_lblComprimidos.gridx = 0;
		gbc_lblComprimidos.gridy = 4;
		panelCreate.add(lblComprimidos, gbc_lblComprimidos);

		spinnerComprimidos = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
		spinnerComprimidos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_spinnerComprimidos = new GridBagConstraints();
		gbc_spinnerComprimidos.insets = new Insets(0, 0, 5, 0);
		gbc_spinnerComprimidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinnerComprimidos.gridx = 1;
		gbc_spinnerComprimidos.gridy = 4;
		panelCreate.add(spinnerComprimidos, gbc_spinnerComprimidos);

		JLabel lblHoras = new JLabel("Cada cuántas horas");
		lblHoras.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblHoras = new GridBagConstraints();
		gbc_lblHoras.anchor = GridBagConstraints.EAST;
		gbc_lblHoras.insets = new Insets(0, 0, 5, 15);
		gbc_lblHoras.gridx = 0;
		gbc_lblHoras.gridy = 5;
		panelCreate.add(lblHoras, gbc_lblHoras);

		spinnerHoras = new JSpinner(new SpinnerNumberModel(8, 1, 24, 1));
		spinnerHoras.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_spinnerHoras = new GridBagConstraints();
		gbc_spinnerHoras.insets = new Insets(0, 0, 5, 0);
		gbc_spinnerHoras.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinnerHoras.gridx = 1;
		gbc_spinnerHoras.gridy = 5;
		panelCreate.add(spinnerHoras, gbc_spinnerHoras);

		JLabel lblInicio = new JLabel("Inicio tratamiento");
		lblInicio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblInicio = new GridBagConstraints();
		gbc_lblInicio.anchor = GridBagConstraints.EAST;
		gbc_lblInicio.insets = new Insets(0, 0, 5, 15);
		gbc_lblInicio.gridx = 0;
		gbc_lblInicio.gridy = 6;
		panelCreate.add(lblInicio, gbc_lblInicio);

		dateInicio = new JDateChooser();
		dateInicio.setDateFormatString("dd/MM/yyyy");
		dateInicio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_dateInicio = new GridBagConstraints();
		gbc_dateInicio.insets = new Insets(0, 0, 5, 0);
		gbc_dateInicio.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateInicio.gridx = 1;
		gbc_dateInicio.gridy = 6;
		panelCreate.add(dateInicio, gbc_dateInicio);

		JLabel lblFin = new JLabel("Fin tratamiento");
		lblFin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblFin = new GridBagConstraints();
		gbc_lblFin.anchor = GridBagConstraints.EAST;
		gbc_lblFin.insets = new Insets(0, 0, 5, 15);
		gbc_lblFin.gridx = 0;
		gbc_lblFin.gridy = 7;
		panelCreate.add(lblFin, gbc_lblFin);

		dateFin = new JDateChooser();
		dateFin.setDateFormatString("dd/MM/yyyy");
		dateFin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_dateFin = new GridBagConstraints();
		gbc_dateFin.insets = new Insets(0, 0, 5, 0);
		gbc_dateFin.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateFin.gridx = 1;
		gbc_dateFin.gridy = 7;
		panelCreate.add(dateFin, gbc_dateFin);

		btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAgregar.setBackground(new Color(46, 139, 87));
		btnAgregar.setForeground(Color.WHITE);
		GridBagConstraints gbc_btnAgregar = new GridBagConstraints();
		gbc_btnAgregar.insets = new Insets(0, 0, 5, 0);
		gbc_btnAgregar.gridx = 1;
		gbc_btnAgregar.gridy = 8;
		panelCreate.add(btnAgregar, gbc_btnAgregar);
	}

	/**
	 * meotodo que muestra medicamentos
	 * 
	 * @param medicamentos
	 */
	public void cargarMedicamentos(List<Medicamento> medicamentos) {
		cBMedicamento.removeAllItems();
		cBMedicamento.addItem("Seleccione un medicamento");
		for (Medicamento med : medicamentos) {
			cBMedicamento.addItem(med.getNombre());
		}
	}

	// Getters
	public JComboBox<String> getCBMedicamento() {
		return cBMedicamento;
	}

	public JTextField getTxtTipoMedicamento() {
		return txtTipoMedicamento;
	}

	public JTextArea getTxtDescripcion() {
		return txtDescripcion;
	}

	public JDateChooser getDateInicio() {
		return dateInicio;
	}

	public JDateChooser getDateFin() {
		return dateFin;
	}

	public JSpinner getSpinnerComprimidos() {
		return spinnerComprimidos;
	}

	public JSpinner getSpinnerHoras() {
		return spinnerHoras;
	}

	public JButton getBtnAgregar() {
		return btnAgregar;
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