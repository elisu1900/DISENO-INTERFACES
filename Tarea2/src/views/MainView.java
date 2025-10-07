package views;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class MainView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

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

        // Header
        JPanel panel_header = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel_header.setBackground(Color.decode("#0A3D91")); // azul corporativo
        contentPane.add(panel_header, BorderLayout.NORTH);
        
        JLabel header = new JLabel("I.E.S.Pablo Picasso");
        header.setFont(new Font("Tahoma", Font.PLAIN, 17));
        panel_header.add(header);
        
        
        // Menú lateral
        JPanel panel_menu = new JPanel(new GridLayout(4, 1, 10, 10));
        panel_menu.setBackground(Color.decode("#1C4587"));
        contentPane.add(panel_menu, BorderLayout.WEST);
        
        JButton btnProductos = new JButton("Productos");
        panel_menu.add(btnProductos);

        JButton btnClientes = new JButton("Clientes");
        panel_menu.add(btnClientes);

        JButton btnFacturas = new JButton("Facturas");
        panel_menu.add(btnFacturas);
        
        JButton btnUsuario = new JButton("Usuarios");
        panel_menu.add(btnUsuario);
        
        // Panel central 
        JPanel panel_main = new JPanel();
        panel_main.setBackground(Color.decode("#6FA8DC"));
        contentPane.add(panel_main, BorderLayout.CENTER);
        

        // Footer
        JPanel panel_footer = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel_footer.setBackground(Color.LIGHT_GRAY);
        contentPane.add(panel_footer, BorderLayout.SOUTH);
        
        JLabel footer = new JLabel("Elias Wassit Calzado");
        footer.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_footer.add(footer);
        
    }
}
