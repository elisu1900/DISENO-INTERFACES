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
    ClientView panelClient = new ClientView();
    ProductView panelProduct = new ProductView();

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
        
        ImageIcon iconHeader = new ImageIcon(getClass().getResource("/images/imgHeader.png"));
        Image imgHeader = iconHeader.getImage();
        Image imgresizedHeader = imgHeader.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon iconresizedHeader = new ImageIcon(imgresizedHeader);

        JLabel lblImgHeader = new JLabel(iconresizedHeader);
        JLabel header = new JLabel("I.E.S.Pablo Picasso");
        
        header.setForeground(Color.WHITE);
        header.setHorizontalAlignment(SwingConstants.CENTER);
        header.setFont(new Font("Tahoma", Font.PLAIN, 19));
        panel_header.add(lblImgHeader);
        panel_header.add(header);
        
        JPanel panelMain = new JPanel();
        panelMain.setBackground(Color.decode("#6FA8DC"));
        
        
        panelCards.add(panelMain, "main");
        panelCards.add(panelClient, "cliente");
        panelCards.add(panelProduct, "producto");
        
        panelClient.setCardLayout(panelCards, cardLayout);
        
        // Menú lateral
        JPanel panelMenu = new JPanel(new GridLayout(4, 1, 10, 10));
        panelMenu.setBackground(Color.decode("#1C4587"));
        panelMenu.setPreferredSize(new Dimension(200,0));
        contentPane.add(panelMenu, BorderLayout.WEST);
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/imgClient.jpg"));
        Image img = icon.getImage();
        Image imgresized = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon iconresized = new ImageIcon(imgresized);
        
                JButton btnClient = new JButton("Clientes", iconresized);
                btnClient.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		cardLayout.show(panelCards, "cliente");
                	}
                });
                panelMenu.add(btnClient);
        
                
        ImageIcon icon2 = new ImageIcon(getClass().getResource("/images/imgProduct.jpg"));
        Image img2 = icon2.getImage();
        Image imgresized2 = img2.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon iconresized2 = new ImageIcon(imgresized2);
                
        JButton btnProducts = new JButton("Productos", iconresized2);
        btnProducts.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(panelCards, "producto");
        	}
        });
        panelMenu.add(btnProducts);

        JButton btnBill = new JButton("Facturas");
        panelMenu.add(btnBill);
        
        JButton btnUser = new JButton("Usuarios");
        panelMenu.add(btnUser);
        

        
        // Footer
        JPanel panelFooter = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelFooter.setBackground(Color.LIGHT_GRAY);
        contentPane.add(panelFooter, BorderLayout.SOUTH);
        
        JLabel footer = new JLabel("Elias Wassit Calzado");
        footer.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panelFooter.add(footer);
        
    }
}
