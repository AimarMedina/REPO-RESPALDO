package Vista;

import Controlador.VistaController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;
/**
 * Clase que representa la ventana de gestión de jornadas.
 */
public class VentanaGestionJornadasV2 extends JFrame{
    private JPanel panel1;
    private JButton mostrarEnfrentamientos;
    private JButton retroceder;
    /**
     * Constructor de la clase VentanaGestionJornadasV2.
     * Configura la ventana de gestión de jornadas, inicializa los componentes y define los eventos de los botones.
     *
     * @param nombre Nombre del usuario administrador que se mostrará en la ventana.
     */
    public VentanaGestionJornadasV2(String nombre)  {
        setContentPane(panel1);
        setTitle("Gestion de Jornadas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("FaviconEA.png")));
        setIconImage(icon.getImage());

        retroceder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaController.VentanaAdministradorV2(nombre,VentanaGestionJornadasV2.this);
            }
        });

        mostrarEnfrentamientos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                mostrarEnfrentamientos.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });
        retroceder.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                retroceder.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });
        mostrarEnfrentamientos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    if(VistaController.obtenerJornadas().isEmpty()){
                        throw new Exception("No hay jornadas para mostrar");
                    }
                    VistaController.ModalMostrarJornadasV2();
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }
}
