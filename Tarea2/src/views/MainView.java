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
    ClientView panelCliente = new ClientView();
    ProductView panelProducto = new ProductView();

    private JPanel panelCards; 
    private CardLayout cardLayout;
    

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
        panelCards.add(panelProducto, "producto");
        
        panelCliente.setCardLayout(panelCards, cardLayout);
        
        // Menú lateral
        JPanel panel_menu = new JPanel(new GridLayout(4, 1, 10, 10));
        panel_menu.setBackground(Color.decode("#1C4587"));
        panel_menu.setPreferredSize(new Dimension(200,0));
        contentPane.add(panel_menu, BorderLayout.WEST);
        
        ImageIcon icono = new ImageIcon(getClass().getResource("/images/imgClient.jpg"));
        Image img = icono.getImage();
        Image imgRedimensionada = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado = new ImageIcon(imgRedimensionada);
        
                JButton btnClientes = new JButton("Clientes", iconoRedimensionado);
                btnClientes.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		cardLayout.show(panelCards, "cliente");
                	}
                });
                panel_menu.add(btnClientes);
        
                
        ImageIcon icono2 = new ImageIcon(getClass().getResource("/images/imgProduct.jpg"));
        Image img2 = icono2.getImage();
        Image imgRedimensionada2 = img2.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado2 = new ImageIcon(imgRedimensionada2);
                
        JButton btnProductos = new JButton("Productos", iconoRedimensionado2);
        btnProductos.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(panelCards, "producto");
        	}
        });
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
