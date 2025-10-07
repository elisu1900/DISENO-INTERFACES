package views;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Component;
import javax.swing.SwingConstants;

public class MainView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    Cliente panelCliente = new Cliente();
    private JPanel panelCards; 
    private CardLayout cardLayout;
    
    private JPanel panelMain;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainView frame = new MainView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public MainView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 907, 528);

        contentPane = new JPanel(new BorderLayout());
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        
        cardLayout = new CardLayout();
        panelCards = new JPanel(cardLayout);
        contentPane.add(panelCards, BorderLayout.CENTER);


        // Header
        JPanel panel_header = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel_header.setBackground(Color.decode("#0A3D91")); 
        contentPane.add(panel_header, BorderLayout.NORTH);
        
        JLabel header = new JLabel("I.E.S.Pablo Picasso");
        header.setForeground(Color.WHITE);
        header.setHorizontalAlignment(SwingConstants.CENTER);
        header.setFont(new Font("Tahoma", Font.PLAIN, 17));
        panel_header.add(header);
        
        JPanel panelMain = new JPanel();
        panelMain.setBackground(Color.decode("#6FA8DC"));
        panelCards.add(panelMain, "main");
        panelCards.add(panelCliente, "cliente");
        
        // Menú lateral
        JPanel panel_menu = new JPanel(new GridLayout(4, 1, 10, 10));
        panel_menu.setBackground(Color.decode("#1C4587"));
        contentPane.add(panel_menu, BorderLayout.WEST);
        		ImageIcon icon = new ImageIcon("/Tarea2/src/images/imgCliente.jpg");
        		Image img = icon.getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
                JButton btnClientes = new JButton("Clientes", icon);
                btnClientes.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		cardLayout.show(panelCards, "cliente");
                	}
                });
                panel_menu.add(btnClientes);
        
        JButton btnProductos = new JButton("Productos");
        panel_menu.add(btnProductos);

        JButton btnFacturas = new JButton("Facturas");
        panel_menu.add(btnFacturas);
        
        JButton btnUsuario = new JButton("Usuarios");
        panel_menu.add(btnUsuario);
        

        
        // Footer
        JPanel panel_footer = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel_footer.setBackground(Color.LIGHT_GRAY);
        contentPane.add(panel_footer, BorderLayout.SOUTH);
        
        JLabel footer = new JLabel("Elias Wassit Calzado");
        footer.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_footer.add(footer);
        
    }
}
