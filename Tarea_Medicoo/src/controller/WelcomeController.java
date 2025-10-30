package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MainView;
import view.panelAñadirMed;
import view.panelUser;

public class WelcomeController {
    
    private panelUser panel;

    public WelcomeController(panelUser panel) {
        this.panel = panel;
    }

    public void addListeners() {
        panel.getBtnAddMedicamento().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                
                panelAñadirMed medicamento = new panelAñadirMed();
                panel.add(medicamento, BorderLayout.CENTER);
                
                panel.revalidate();
                panel.repaint();
            }
        });
        
        panel.getBtnCerrarSesion().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainView.contentPane.removeAll();
                MainView.contentPane.add(MainView.mainPanel, BorderLayout.CENTER);
                MainView.contentPane.revalidate();
                MainView.contentPane.repaint();
            }
        });
    }
}