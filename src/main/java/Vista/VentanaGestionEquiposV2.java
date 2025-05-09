package Vista;

import Controlador.VistaController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Objects;
/**
 * Clase que representa la ventana de gestión de equipos.
 */
public class VentanaGestionEquiposV2 extends JFrame {
    private JButton inscribirEquipo;
    private JButton eliminarEquipo;
    private JButton modificarEquipo;
    private JButton mostrarEquipo;
    private JButton retroceder;
    private JPanel pPrincipal;
    /**
     * Constructor de la clase VentanaGestionEquiposV2.
     * Configura la ventana de gestión de equipos, inicializa los componentes y define los eventos de los botones.
     *
     * @param nombre Nombre del usuario administrador que se mostrará en la ventana.
     */
    private List<String> equipos = VistaController.listaEquipos();

    public VentanaGestionEquiposV2(String nombre) {

        setContentPane(pPrincipal);
        setTitle("Gestion de Equipos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("FaviconEA.png")));
        setIconImage(icon.getImage());

        //Deshabilitar inscribir-modificar-eliminar equipo si la competicion esta cerrada
        if (!VistaController.estadoCompeticion()) {
            inscribirEquipo.setEnabled(false);
            modificarEquipo.setEnabled(false);
            eliminarEquipo.setEnabled(false);
            JOptionPane.showMessageDialog(null, "La competición ya esta cerrada. No se pueden gestionar equipos, unicamente mostrar.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        retroceder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaController.VentanaAdministradorV2(nombre,VentanaGestionEquiposV2.this);
            }
        });
        retroceder.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                retroceder.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });
        mostrarEquipo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                mostrarEquipo.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });
        inscribirEquipo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                inscribirEquipo.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });
        eliminarEquipo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                eliminarEquipo.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });
        modificarEquipo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                modificarEquipo.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });
        eliminarEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(equipos.isEmpty()){
                        throw new Exception("No hay equipos para eliminar");
                    }
                    VistaController.ModalEliminacionEquiposV2();
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        mostrarEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(equipos.isEmpty()){
                        throw new Exception("No hay equipos para mostrar");
                    }
                    VistaController.ModalMostrarEquiposV2();
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        inscribirEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaController.ModalInscripcionEquiposV2();
            }
        });
        modificarEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(equipos.isEmpty()){
                        throw new Exception("No hay equipos para modificar");
                    }
                    VistaController.ModalSeleccionarEquipoV2();
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }
}
