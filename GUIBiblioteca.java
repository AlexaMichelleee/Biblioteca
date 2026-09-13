package Front_end;

import Back_end.Administrador;
import Back_end.Autor;
import Back_end.Cliente;
import Back_end.Editorial;
import Back_end.Estante;
import Back_end.Libro;
import Back_end.Prestamo;
import Back_end.Recepcionista;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GUIBiblioteca extends JFrame {

    // =====================================================
    // ALMACENAMIENTO: UN solo objeto por pestaña
    // (Sin arrays, sin ArrayList, sin List, sin colecciones)
    // =====================================================
    private Cliente clienteActual;
    private Recepcionista recepcionistaActual;
    private Administrador administradorActual;
    private Autor autorActual;
    private Libro libroActual;
    private Editorial editorialActual;
    private Estante estanteActual;
    private Prestamo prestamoActual;

    // =====================================================
    // PESTAÑA 1: CLIENTE (campos individuales, sin arrays)
    // =====================================================
    private JTextField txtCliCurp = new JTextField(20);
    private JTextField txtCliNombre = new JTextField(20);
    private JTextField txtCliApellido = new JTextField(20);
    private JTextField txtCliIde = new JTextField(20);
    private JTextField txtCliFecha = new JTextField(20);
    private JTextField txtCliCorreo = new JTextField(20);
    private JTextField txtCliTelefono = new JTextField(20);
    private JTextField txtCliTipo = new JTextField(20);
    private JTextField txtCliImagen = new JTextField(20);
    private JTextField txtCliEstado = new JTextField(20);

    // =====================================================
    // PESTAÑA 2: RECEPCIONISTA
    // =====================================================
    private JTextField txtRecCurp = new JTextField(20);
    private JTextField txtRecNombre = new JTextField(20);
    private JTextField txtRecApellido = new JTextField(20);
    private JTextField txtRecIde = new JTextField(20);
    private JTextField txtRecFecha = new JTextField(20);
    private JTextField txtRecIdUnico = new JTextField(20);
    private JTextField txtRecSalario = new JTextField(20);
    private JTextField txtRecPuesto = new JTextField(20);
    private JTextField txtRecArea = new JTextField(20);
    private JTextField txtRecTurno = new JTextField(20);
    private JTextField txtRecImagen = new JTextField(20);
    private JTextField txtRecEstado = new JTextField(20);

    // =====================================================
    // PESTAÑA 3: ADMINISTRADOR
    // =====================================================
    private JTextField txtAdmCurp = new JTextField(20);
    private JTextField txtAdmNombre = new JTextField(20);
    private JTextField txtAdmApellido = new JTextField(20);
    private JTextField txtAdmIde = new JTextField(20);
    private JTextField txtAdmFecha = new JTextField(20);
    private JTextField txtAdmIdUnico = new JTextField(20);
    private JTextField txtAdmSalario = new JTextField(20);
    private JTextField txtAdmPuesto = new JTextField(20);
    private JTextField txtAdmNivel = new JTextField(20);
    private JTextField txtAdmPermisos = new JTextField(20);
    private JTextField txtAdmImagen = new JTextField(20);
    private JTextField txtAdmEstado = new JTextField(20);

    // =====================================================
    // PESTAÑA 4: AUTOR
    // =====================================================
    private JTextField txtAutId = new JTextField(20);
    private JTextField txtAutNombre = new JTextField(20);
    private JTextField txtAutNacionalidad = new JTextField(20);
    private JTextField txtAutFecha = new JTextField(20);
    private JTextField txtAutImagen = new JTextField(20);
    private JTextField txtAutEstado = new JTextField(20);

    // =====================================================
    // PESTAÑA 5: LIBRO
    // =====================================================
    private JTextField txtLibIsbn = new JTextField(20);
    private JTextField txtLibTitulo = new JTextField(20);
    private JTextField txtLibFecha = new JTextField(20);
    private JTextField txtLibImagen = new JTextField(20);
    private JTextField txtLibEstado = new JTextField(20);

    // =====================================================
    // PESTAÑA 6: EDITORIAL
    // =====================================================
    private JTextField txtEdiId = new JTextField(20);
    private JTextField txtEdiTelefono = new JTextField(20);
    private JTextField txtEdiDireccion = new JTextField(20);
    private JTextField txtEdiImagen = new JTextField(20);
    private JTextField txtEdiEstado = new JTextField(20);

    // =====================================================
    // PESTAÑA 7: ESTANTE
    // =====================================================
    private JTextField txtEstId = new JTextField(20);
    private JTextField txtEstUbicacion = new JTextField(20);
    private JTextField txtEstCapacidad = new JTextField(20);
    private JTextField txtEstImagen = new JTextField(20);
    private JTextField txtEstEstado = new JTextField(20);

    // =====================================================
    // PESTAÑA 8: PRÉSTAMO
    // =====================================================
    private JTextField txtPreId = new JTextField(20);
    private JTextField txtPreFechaPres = new JTextField(20);
    private JTextField txtPreFechaDev = new JTextField(20);
    private JTextField txtPreImagen = new JTextField(20);
    private JTextField txtPreEstado = new JTextField(20);

    public GUIBiblioteca() {
        setTitle("Sistema de Biblioteca");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(750, 550);
        setLocationRelativeTo(null);

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Cliente", crearPanelCliente());
        tabs.addTab("Recepcionista", crearPanelRecepcionista());
        tabs.addTab("Administrador", crearPanelAdministrador());
        tabs.addTab("Autor", crearPanelAutor());
        tabs.addTab("Libro", crearPanelLibro());
        tabs.addTab("Editorial", crearPanelEditorial());
        tabs.addTab("Estante", crearPanelEstante());
        tabs.addTab("Préstamo", crearPanelPrestamo());

        add(tabs);
    }

    // =====================================================
    // MÉTODOS AUXILIARES DE CONVERSIÓN
    // =====================================================
    private Date parseDate(String text) {
        if (text == null || text.trim().isEmpty()) return null;
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(text);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Formato de fecha inválido. Use dd/MM/yyyy");
        }
    }

    private int parseInt(String text) {
        if (text == null || text.trim().isEmpty()) return 0;
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Número entero inválido");
        }
    }

    private double parseDouble(String text) {
        if (text == null || text.trim().isEmpty()) return 0.0;
        try {
            return Double.parseDouble(text);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Número decimal inválido");
        }
    }

    private long parseLong(String text) {
        if (text == null || text.trim().isEmpty()) return 0;
        try {
            return Long.parseLong(text);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Número largo inválido");
        }
    }

    private void agregarFila(JPanel panel, GridBagConstraints gbc, int fila, String texto, JTextField campo) {
        gbc.gridx = 0;
        gbc.gridy = fila;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(new JLabel(texto), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(campo, gbc);
    }

    private JPanel crearPanelBotones(JButton crear, JButton buscar, JButton mostrar, JButton actualizar, JButton borrar, JButton destruir) {
        JPanel panel = new JPanel(new GridLayout(6, 1, 5, 5));
        panel.add(crear);
        panel.add(buscar);
        panel.add(mostrar);
        panel.add(actualizar);
        panel.add(borrar);
        panel.add(destruir);
        return panel;
    }

    // =====================================================
    // PESTAÑA 1: CLIENTE
    // =====================================================
    private JPanel crearPanelCliente() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);

        agregarFila(form, gbc, 0, "CURP:", txtCliCurp);
        agregarFila(form, gbc, 1, "Nombre:", txtCliNombre);
        agregarFila(form, gbc, 2, "Apellido:", txtCliApellido);
        agregarFila(form, gbc, 3, "IDE:", txtCliIde);
        agregarFila(form, gbc, 4, "Fecha Ingreso (dd/MM/yyyy):", txtCliFecha);
        agregarFila(form, gbc, 5, "Correo:", txtCliCorreo);
        agregarFila(form, gbc, 6, "Teléfono:", txtCliTelefono);
        agregarFila(form, gbc, 7, "Tipo Cliente:", txtCliTipo);
        agregarFila(form, gbc, 8, "Imagen:", txtCliImagen);
        agregarFila(form, gbc, 9, "Estado:", txtCliEstado);

        JButton btnCrear = new JButton("Crear");
        JButton btnBuscar = new JButton("Buscar");
        JButton btnMostrar = new JButton("Mostrar");
        JButton btnActualizar = new JButton("Actualizar");
        JButton btnBorrar = new JButton("Borrar");
        JButton btnDestruir = new JButton("Destruir");

        btnCrear.addActionListener(e -> {
            try {
                clienteActual = new Cliente(
                        txtCliCorreo.getText(), txtCliTelefono.getText(), txtCliTipo.getText(),
                        txtCliCurp.getText(), txtCliNombre.getText(), txtCliApellido.getText(),
                        txtCliIde.getText(), parseDate(txtCliFecha.getText()),
                        txtCliImagen.getText(), txtCliEstado.getText());
                JOptionPane.showMessageDialog(panel, "Cliente creado correctamente.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Error: " + ex.getMessage());
            }
        });

        btnBuscar.addActionListener(e -> {
            if (clienteActual != null && clienteActual.getCurp().equals(txtCliCurp.getText())) {
                txtCliNombre.setText(clienteActual.getNombre());
                txtCliApellido.setText(clienteActual.getApellido());
                txtCliIde.setText(clienteActual.getIde());
                txtCliCorreo.setText(clienteActual.getCorreo());
                txtCliTelefono.setText(clienteActual.getTelefono());
                txtCliTipo.setText(clienteActual.getTipoCliente());
                txtCliImagen.setText(clienteActual.getImagen());
                txtCliEstado.setText(clienteActual.getEstado());
                if (clienteActual.getIngreso() != null) {
                    txtCliFecha.setText(new SimpleDateFormat("dd/MM/yyyy").format(clienteActual.getIngreso()));
                }
            } else {
                JOptionPane.showMessageDialog(panel, "CURP no encontrada.");
            }
        });

        btnMostrar.addActionListener(e -> {
            if (clienteActual == null) {
                JOptionPane.showMessageDialog(panel, "No hay registro de cliente.");
            } else {
                JOptionPane.showMessageDialog(panel, clienteActual.toString());
            }
        });

        btnActualizar.addActionListener(e -> {
            try {
                if (clienteActual != null && clienteActual.getCurp().equals(txtCliCurp.getText())) {
                    clienteActual.setNombre(txtCliNombre.getText());
                    clienteActual.setApellido(txtCliApellido.getText());
                    clienteActual.setIde(txtCliIde.getText());
                    clienteActual.setCorreo(txtCliCorreo.getText());
                    clienteActual.setTelefono(txtCliTelefono.getText());
                    clienteActual.setTipoCliente(txtCliTipo.getText());
                    clienteActual.setIngreso(parseDate(txtCliFecha.getText()));
                    clienteActual.setImagen(txtCliImagen.getText());
                    clienteActual.setEstado(txtCliEstado.getText());
                    JOptionPane.showMessageDialog(panel, "Cliente actualizado.");
                } else {
                    JOptionPane.showMessageDialog(panel, "Cliente no encontrado.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Error: " + ex.getMessage());
            }
        });

        btnBorrar.addActionListener(e -> {
            if (clienteActual != null && clienteActual.getCurp().equals(txtCliCurp.getText())) {
                clienteActual = null;
                JOptionPane.showMessageDialog(panel, "Cliente borrado.");
            } else {
                JOptionPane.showMessageDialog(panel, "No encontrado.");
            }
        });

        btnDestruir.addActionListener(e -> {
            clienteActual = null;
            JOptionPane.showMessageDialog(panel, "Registro destruido.");
        });

        panel.add(form, BorderLayout.CENTER);
        panel.add(crearPanelBotones(btnCrear, btnBuscar, btnMostrar, btnActualizar, btnBorrar, btnDestruir), BorderLayout.EAST);
        return panel;
    }

    // =====================================================
    // PESTAÑA 2: RECEPCIONISTA
    // =====================================================
    private JPanel crearPanelRecepcionista() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);

        agregarFila(form, gbc, 0, "CURP:", txtRecCurp);
        agregarFila(form, gbc, 1, "Nombre:", txtRecNombre);
        agregarFila(form, gbc, 2, "Apellido:", txtRecApellido);
        agregarFila(form, gbc, 3, "IDE:", txtRecIde);
        agregarFila(form, gbc, 4, "Fecha Ingreso (dd/MM/yyyy):", txtRecFecha);
        agregarFila(form, gbc, 5, "ID Único:", txtRecIdUnico);
        agregarFila(form, gbc, 6, "Salario:", txtRecSalario);
        agregarFila(form, gbc, 7, "Puesto:", txtRecPuesto);
        agregarFila(form, gbc, 8, "Área:", txtRecArea);
        agregarFila(form, gbc, 9, "Turno:", txtRecTurno);
        agregarFila(form, gbc, 10, "Imagen:", txtRecImagen);
        agregarFila(form, gbc, 11, "Estado:", txtRecEstado);

        JButton btnCrear = new JButton("Crear");
        JButton btnBuscar = new JButton("Buscar");
        JButton btnMostrar = new JButton("Mostrar");
        JButton btnActualizar = new JButton("Actualizar");
        JButton btnBorrar = new JButton("Borrar");
        JButton btnDestruir = new JButton("Destruir");

        btnCrear.addActionListener(e -> {
            try {
                recepcionistaActual = new Recepcionista(
                        txtRecArea.getText(), txtRecTurno.getText(), parseDouble(txtRecSalario.getText()),
                        parseInt(txtRecIdUnico.getText()), txtRecPuesto.getText(), txtRecCurp.getText(),
                        txtRecNombre.getText(), txtRecApellido.getText(), txtRecIde.getText(),
                        parseDate(txtRecFecha.getText()), txtRecImagen.getText(), txtRecEstado.getText());
                JOptionPane.showMessageDialog(panel, "Recepcionista creado.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Error: " + ex.getMessage());
            }
        });

        btnBuscar.addActionListener(e -> {
            if (recepcionistaActual != null && recepcionistaActual.getCurp().equals(txtRecCurp.getText())) {
                txtRecNombre.setText(recepcionistaActual.getNombre());
                txtRecApellido.setText(recepcionistaActual.getApellido());
                txtRecIde.setText(recepcionistaActual.getIde());
                txtRecIdUnico.setText(String.valueOf(recepcionistaActual.getIdunico()));
                txtRecSalario.setText(String.valueOf(recepcionistaActual.getSalario()));
                txtRecPuesto.setText(recepcionistaActual.getPuesto());
                txtRecArea.setText(recepcionistaActual.getArea());
                txtRecTurno.setText(recepcionistaActual.getTurno());
                txtRecImagen.setText(recepcionistaActual.getImagen());
                txtRecEstado.setText(recepcionistaActual.getEstado());
                if (recepcionistaActual.getIngreso() != null) {
                    txtRecFecha.setText(new SimpleDateFormat("dd/MM/yyyy").format(recepcionistaActual.getIngreso()));
                }
            } else {
                JOptionPane.showMessageDialog(panel, "CURP no encontrada.");
            }
        });

        btnMostrar.addActionListener(e -> {
            if (recepcionistaActual == null) {
                JOptionPane.showMessageDialog(panel, "No hay registro de recepcionista.");
            } else {
                JOptionPane.showMessageDialog(panel, recepcionistaActual.toString());
            }
        });

        btnActualizar.addActionListener(e -> {
            try {
                if (recepcionistaActual != null && recepcionistaActual.getCurp().equals(txtRecCurp.getText())) {
                    recepcionistaActual.setNombre(txtRecNombre.getText());
                    recepcionistaActual.setApellido(txtRecApellido.getText());
                    recepcionistaActual.setArea(txtRecArea.getText());
                    recepcionistaActual.setTurno(txtRecTurno.getText());
                    recepcionistaActual.setSalario(parseDouble(txtRecSalario.getText()));
                    JOptionPane.showMessageDialog(panel, "Actualizado.");
                } else {
                    JOptionPane.showMessageDialog(panel, "No encontrado.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Error: " + ex.getMessage());
            }
        });

        btnBorrar.addActionListener(e -> {
            if (recepcionistaActual != null && recepcionistaActual.getCurp().equals(txtRecCurp.getText())) {
                recepcionistaActual = null;
                JOptionPane.showMessageDialog(panel, "Borrado.");
            } else {
                JOptionPane.showMessageDialog(panel, "No encontrado.");
            }
        });

        btnDestruir.addActionListener(e -> {
            recepcionistaActual = null;
            JOptionPane.showMessageDialog(panel, "Registro destruido.");
        });

        panel.add(form, BorderLayout.CENTER);
        panel.add(crearPanelBotones(btnCrear, btnBuscar, btnMostrar, btnActualizar, btnBorrar, btnDestruir), BorderLayout.EAST);
        return panel;
    }

    // =====================================================
    // PESTAÑA 3: ADMINISTRADOR
    // =====================================================
    private JPanel crearPanelAdministrador() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);

        agregarFila(form, gbc, 0, "CURP:", txtAdmCurp);
        agregarFila(form, gbc, 1, "Nombre:", txtAdmNombre);
        agregarFila(form, gbc, 2, "Apellido:", txtAdmApellido);
        agregarFila(form, gbc, 3, "IDE:", txtAdmIde);
        agregarFila(form, gbc, 4, "Fecha Ingreso (dd/MM/yyyy):", txtAdmFecha);
        agregarFila(form, gbc, 5, "ID Único:", txtAdmIdUnico);
        agregarFila(form, gbc, 6, "Salario:", txtAdmSalario);
        agregarFila(form, gbc, 7, "Puesto:", txtAdmPuesto);
        agregarFila(form, gbc, 8, "Nivel Acceso:", txtAdmNivel);
        agregarFila(form, gbc, 9, "Permisos:", txtAdmPermisos);
        agregarFila(form, gbc, 10, "Imagen:", txtAdmImagen);
        agregarFila(form, gbc, 11, "Estado:", txtAdmEstado);

        JButton btnCrear = new JButton("Crear");
        JButton btnBuscar = new JButton("Buscar");
        JButton btnMostrar = new JButton("Mostrar");
        JButton btnActualizar = new JButton("Actualizar");
        JButton btnBorrar = new JButton("Borrar");
        JButton btnDestruir = new JButton("Destruir");

        btnCrear.addActionListener(e -> {
            try {
                administradorActual = new Administrador(
                        parseInt(txtAdmNivel.getText()), txtAdmPermisos.getText(), parseDouble(txtAdmSalario.getText()),
                        parseInt(txtAdmIdUnico.getText()), txtAdmPuesto.getText(), txtAdmCurp.getText(),
                        txtAdmNombre.getText(), txtAdmApellido.getText(), txtAdmIde.getText(),
                        parseDate(txtAdmFecha.getText()), txtAdmImagen.getText(), txtAdmEstado.getText());
                JOptionPane.showMessageDialog(panel, "Administrador creado.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Error: " + ex.getMessage());
            }
        });

        btnBuscar.addActionListener(e -> {
            if (administradorActual != null && administradorActual.getCurp().equals(txtAdmCurp.getText())) {
                txtAdmNombre.setText(administradorActual.getNombre());
                txtAdmApellido.setText(administradorActual.getApellido());
                txtAdmIde.setText(administradorActual.getIde());
                txtAdmNivel.setText(String.valueOf(administradorActual.getNivelAcceso()));
                txtAdmPermisos.setText(administradorActual.getPermisos());
                txtAdmSalario.setText(String.valueOf(administradorActual.getSalario()));
                txtAdmPuesto.setText(administradorActual.getPuesto());
                txtAdmImagen.setText(administradorActual.getImagen());
                txtAdmEstado.setText(administradorActual.getEstado());
                if (administradorActual.getIngreso() != null) {
                    txtAdmFecha.setText(new SimpleDateFormat("dd/MM/yyyy").format(administradorActual.getIngreso()));
                }
            } else {
                JOptionPane.showMessageDialog(panel, "No encontrado.");
            }
        });

        btnMostrar.addActionListener(e -> {
            if (administradorActual == null) {
                JOptionPane.showMessageDialog(panel, "No hay registro de administrador.");
            } else {
                JOptionPane.showMessageDialog(panel, administradorActual.toString());
            }
        });

        btnActualizar.addActionListener(e -> {
            try {
                if (administradorActual != null && administradorActual.getCurp().equals(txtAdmCurp.getText())) {
                    administradorActual.setNombre(txtAdmNombre.getText());
                    administradorActual.setNivelAcceso(parseInt(txtAdmNivel.getText()));
                    administradorActual.setPermisos(txtAdmPermisos.getText());
                    administradorActual.setSalario(parseDouble(txtAdmSalario.getText()));
                    JOptionPane.showMessageDialog(panel, "Actualizado.");
                } else {
                    JOptionPane.showMessageDialog(panel, "No encontrado.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Error: " + ex.getMessage());
            }
        });

        btnBorrar.addActionListener(e -> {
            if (administradorActual != null && administradorActual.getCurp().equals(txtAdmCurp.getText())) {
                administradorActual = null;
                JOptionPane.showMessageDialog(panel, "Borrado.");
            } else {
                JOptionPane.showMessageDialog(panel, "No encontrado.");
            }
        });

        btnDestruir.addActionListener(e -> {
            administradorActual = null;
            JOptionPane.showMessageDialog(panel, "Registro destruido.");
        });

        panel.add(form, BorderLayout.CENTER);
        panel.add(crearPanelBotones(btnCrear, btnBuscar, btnMostrar, btnActualizar, btnBorrar, btnDestruir), BorderLayout.EAST);
        return panel;
    }

    // =====================================================
    // PESTAÑA 4: AUTOR
    // =====================================================
    private JPanel crearPanelAutor() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);

        agregarFila(form, gbc, 0, "ID Autor:", txtAutId);
        agregarFila(form, gbc, 1, "Nombre:", txtAutNombre);
        agregarFila(form, gbc, 2, "Nacionalidad:", txtAutNacionalidad);
        agregarFila(form, gbc, 3, "Fecha Nacimiento (dd/MM/yyyy):", txtAutFecha);
        agregarFila(form, gbc, 4, "Imagen:", txtAutImagen);
        agregarFila(form, gbc, 5, "Estado:", txtAutEstado);

        JButton btnCrear = new JButton("Crear");
        JButton btnBuscar = new JButton("Buscar");
        JButton btnMostrar = new JButton("Mostrar");
        JButton btnActualizar = new JButton("Actualizar");
        JButton btnBorrar = new JButton("Borrar");
        JButton btnDestruir = new JButton("Destruir");

        btnCrear.addActionListener(e -> {
            try {
                autorActual = new Autor(
                        txtAutId.getText(), txtAutNombre.getText(), txtAutNacionalidad.getText(),
                        parseDate(txtAutFecha.getText()), txtAutImagen.getText(), txtAutEstado.getText());
                JOptionPane.showMessageDialog(panel, "Autor creado.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Error: " + ex.getMessage());
            }
        });

        btnBuscar.addActionListener(e -> {
            if (autorActual != null && autorActual.getIdAutor().equals(txtAutId.getText())) {
                txtAutNombre.setText(autorActual.getNombre());
                txtAutNacionalidad.setText(autorActual.getNacionalidad());
                txtAutImagen.setText(autorActual.getImagen());
                txtAutEstado.setText(autorActual.getEstado());
                if (autorActual.getFechaNac() != null) {
                    txtAutFecha.setText(new SimpleDateFormat("dd/MM/yyyy").format(autorActual.getFechaNac()));
                }
            } else {
                JOptionPane.showMessageDialog(panel, "No encontrado.");
            }
        });

        btnMostrar.addActionListener(e -> {
            if (autorActual == null) {
                JOptionPane.showMessageDialog(panel, "No hay registro de autor.");
            } else {
                JOptionPane.showMessageDialog(panel, autorActual.toString());
            }
        });

        btnActualizar.addActionListener(e -> {
            try {
                if (autorActual != null && autorActual.getIdAutor().equals(txtAutId.getText())) {
                    autorActual.setNombre(txtAutNombre.getText());
                    autorActual.setNacionalidad(txtAutNacionalidad.getText());
                    autorActual.setFechaNac(parseDate(txtAutFecha.getText()));
                    JOptionPane.showMessageDialog(panel, "Actualizado.");
                } else {
                    JOptionPane.showMessageDialog(panel, "No encontrado.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Error: " + ex.getMessage());
            }
        });

        btnBorrar.addActionListener(e -> {
            if (autorActual != null && autorActual.getIdAutor().equals(txtAutId.getText())) {
                autorActual = null;
                JOptionPane.showMessageDialog(panel, "Borrado.");
            } else {
                JOptionPane.showMessageDialog(panel, "No encontrado.");
            }
        });

        btnDestruir.addActionListener(e -> {
            autorActual = null;
            JOptionPane.showMessageDialog(panel, "Registro destruido.");
        });

        panel.add(form, BorderLayout.CENTER);
        panel.add(crearPanelBotones(btnCrear, btnBuscar, btnMostrar, btnActualizar, btnBorrar, btnDestruir), BorderLayout.EAST);
        return panel;
    }

    // =====================================================
    // PESTAÑA 5: LIBRO
    // =====================================================
    private JPanel crearPanelLibro() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);

        agregarFila(form, gbc, 0, "ISBN:", txtLibIsbn);
        agregarFila(form, gbc, 1, "Título:", txtLibTitulo);
        agregarFila(form, gbc, 2, "Fecha Publicación (dd/MM/yyyy):", txtLibFecha);
        agregarFila(form, gbc, 3, "Imagen:", txtLibImagen);
        agregarFila(form, gbc, 4, "Estado:", txtLibEstado);

        JButton btnCrear = new JButton("Crear");
        JButton btnBuscar = new JButton("Buscar");
        JButton btnMostrar = new JButton("Mostrar");
        JButton btnActualizar = new JButton("Actualizar");
        JButton btnBorrar = new JButton("Borrar");
        JButton btnDestruir = new JButton("Destruir");

        btnCrear.addActionListener(e -> {
            try {
                libroActual = new Libro(
                        txtLibTitulo.getText(), txtLibIsbn.getText(), parseDate(txtLibFecha.getText()),
                        txtLibImagen.getText(), txtLibEstado.getText());
                JOptionPane.showMessageDialog(panel, "Libro creado.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Error: " + ex.getMessage());
            }
        });

        btnBuscar.addActionListener(e -> {
            if (libroActual != null && libroActual.getIsbn().equals(txtLibIsbn.getText())) {
                txtLibTitulo.setText(libroActual.getTitulo());
                txtLibImagen.setText(libroActual.getImagen());
                txtLibEstado.setText(libroActual.getEstado());
                if (libroActual.getFechapubl() != null) {
                    txtLibFecha.setText(new SimpleDateFormat("dd/MM/yyyy").format(libroActual.getFechapubl()));
                }
            } else {
                JOptionPane.showMessageDialog(panel, "No encontrado.");
            }
        });

        btnMostrar.addActionListener(e -> {
            if (libroActual == null) {
                JOptionPane.showMessageDialog(panel, "No hay registro de libro.");
            } else {
                JOptionPane.showMessageDialog(panel, libroActual.toString());
            }
        });

        btnActualizar.addActionListener(e -> {
            try {
                if (libroActual != null && libroActual.getIsbn().equals(txtLibIsbn.getText())) {
                    libroActual.setTitulo(txtLibTitulo.getText());
                    libroActual.setFechapubl(parseDate(txtLibFecha.getText()));
                    JOptionPane.showMessageDialog(panel, "Actualizado.");
                } else {
                    JOptionPane.showMessageDialog(panel, "No encontrado.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Error: " + ex.getMessage());
            }
        });

        btnBorrar.addActionListener(e -> {
            if (libroActual != null && libroActual.getIsbn().equals(txtLibIsbn.getText())) {
                libroActual = null;
                JOptionPane.showMessageDialog(panel, "Borrado.");
            } else {
                JOptionPane.showMessageDialog(panel, "No encontrado.");
            }
        });

        btnDestruir.addActionListener(e -> {
            libroActual = null;
            JOptionPane.showMessageDialog(panel, "Registro destruido.");
        });

        panel.add(form, BorderLayout.CENTER);
        panel.add(crearPanelBotones(btnCrear, btnBuscar, btnMostrar, btnActualizar, btnBorrar, btnDestruir), BorderLayout.EAST);
        return panel;
    }

    // =====================================================
    // PESTAÑA 6: EDITORIAL
    // =====================================================
    private JPanel crearPanelEditorial() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);

        agregarFila(form, gbc, 0, "ID Editorial:", txtEdiId);
        agregarFila(form, gbc, 1, "Teléfono:", txtEdiTelefono);
        agregarFila(form, gbc, 2, "Dirección:", txtEdiDireccion);
        agregarFila(form, gbc, 3, "Imagen:", txtEdiImagen);
        agregarFila(form, gbc, 4, "Estado:", txtEdiEstado);

        JButton btnCrear = new JButton("Crear");
        JButton btnBuscar = new JButton("Buscar");
        JButton btnMostrar = new JButton("Mostrar");
        JButton btnActualizar = new JButton("Actualizar");
        JButton btnBorrar = new JButton("Borrar");
        JButton btnDestruir = new JButton("Destruir");

        btnCrear.addActionListener(e -> {
            try {
                editorialActual = new Editorial(
                        txtEdiId.getText(), parseLong(txtEdiTelefono.getText()), txtEdiDireccion.getText(),
                        txtEdiImagen.getText(), txtEdiEstado.getText());
                JOptionPane.showMessageDialog(panel, "Editorial creada.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Error: " + ex.getMessage());
            }
        });

        btnBuscar.addActionListener(e -> {
            if (editorialActual != null && editorialActual.getIdnombre().equals(txtEdiId.getText())) {
                txtEdiDireccion.setText(editorialActual.getDireccion());
                txtEdiTelefono.setText(String.valueOf(editorialActual.getNumerotel()));
                txtEdiImagen.setText(editorialActual.getImagen());
                txtEdiEstado.setText(editorialActual.getEstado());
            } else {
                JOptionPane.showMessageDialog(panel, "No encontrado.");
            }
        });

        btnMostrar.addActionListener(e -> {
            if (editorialActual == null) {
                JOptionPane.showMessageDialog(panel, "No hay registro de editorial.");
            } else {
                JOptionPane.showMessageDialog(panel, editorialActual.toString());
            }
        });

        btnActualizar.addActionListener(e -> {
            try {
                if (editorialActual != null && editorialActual.getIdnombre().equals(txtEdiId.getText())) {
                    editorialActual.setDireccion(txtEdiDireccion.getText());
                    editorialActual.setNumerotel(parseLong(txtEdiTelefono.getText()));
                    JOptionPane.showMessageDialog(panel, "Actualizado.");
                } else {
                    JOptionPane.showMessageDialog(panel, "No encontrado.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Error: " + ex.getMessage());
            }
        });

        btnBorrar.addActionListener(e -> {
            if (editorialActual != null && editorialActual.getIdnombre().equals(txtEdiId.getText())) {
                editorialActual = null;
                JOptionPane.showMessageDialog(panel, "Borrado.");
            } else {
                JOptionPane.showMessageDialog(panel, "No encontrado.");
            }
        });

        btnDestruir.addActionListener(e -> {
            editorialActual = null;
            JOptionPane.showMessageDialog(panel, "Registro destruido.");
        });

        panel.add(form, BorderLayout.CENTER);
        panel.add(crearPanelBotones(btnCrear, btnBuscar, btnMostrar, btnActualizar, btnBorrar, btnDestruir), BorderLayout.EAST);
        return panel;
    }

    // =====================================================
    // PESTAÑA 7: ESTANTE
    // =====================================================
    private JPanel crearPanelEstante() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);

        agregarFila(form, gbc, 0, "ID Estante:", txtEstId);
        agregarFila(form, gbc, 1, "Ubicación:", txtEstUbicacion);
        agregarFila(form, gbc, 2, "Capacidad:", txtEstCapacidad);
        agregarFila(form, gbc, 3, "Imagen:", txtEstImagen);
        agregarFila(form, gbc, 4, "Estado:", txtEstEstado);

        JButton btnCrear = new JButton("Crear");
        JButton btnBuscar = new JButton("Buscar");
        JButton btnMostrar = new JButton("Mostrar");
        JButton btnActualizar = new JButton("Actualizar");
        JButton btnBorrar = new JButton("Borrar");
        JButton btnDestruir = new JButton("Destruir");

        btnCrear.addActionListener(e -> {
            try {
                estanteActual = new Estante(
                        parseInt(txtEstId.getText()), txtEstUbicacion.getText(), parseInt(txtEstCapacidad.getText()),
                        txtEstImagen.getText(), txtEstEstado.getText());
                JOptionPane.showMessageDialog(panel, "Estante creado.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Error: " + ex.getMessage());
            }
        });

        btnBuscar.addActionListener(e -> {
            if (estanteActual != null && estanteActual.getIdestante() == parseInt(txtEstId.getText())) {
                txtEstUbicacion.setText(estanteActual.getUbicacion());
                txtEstCapacidad.setText(String.valueOf(estanteActual.getCapacidad()));
                txtEstImagen.setText(estanteActual.getImagen());
                txtEstEstado.setText(estanteActual.getEstado());
            } else {
                JOptionPane.showMessageDialog(panel, "No encontrado.");
            }
        });

        btnMostrar.addActionListener(e -> {
            if (estanteActual == null) {
                JOptionPane.showMessageDialog(panel, "No hay registro de estante.");
            } else {
                JOptionPane.showMessageDialog(panel, estanteActual.toString());
            }
        });

        btnActualizar.addActionListener(e -> {
            try {
                if (estanteActual != null && estanteActual.getIdestante() == parseInt(txtEstId.getText())) {
                    estanteActual.setUbicacion(txtEstUbicacion.getText());
                    estanteActual.setCapacidad(parseInt(txtEstCapacidad.getText()));
                    JOptionPane.showMessageDialog(panel, "Actualizado.");
                } else {
                    JOptionPane.showMessageDialog(panel, "No encontrado.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Error: " + ex.getMessage());
            }
        });

        btnBorrar.addActionListener(e -> {
            if (estanteActual != null && estanteActual.getIdestante() == parseInt(txtEstId.getText())) {
                estanteActual = null;
                JOptionPane.showMessageDialog(panel, "Borrado.");
            } else {
                JOptionPane.showMessageDialog(panel, "No encontrado.");
            }
        });

        btnDestruir.addActionListener(e -> {
            estanteActual = null;
            JOptionPane.showMessageDialog(panel, "Registro destruido.");
        });

        panel.add(form, BorderLayout.CENTER);
        panel.add(crearPanelBotones(btnCrear, btnBuscar, btnMostrar, btnActualizar, btnBorrar, btnDestruir), BorderLayout.EAST);
        return panel;
    }

    // =====================================================
    // PESTAÑA 8: PRÉSTAMO
    // =====================================================
    private JPanel crearPanelPrestamo() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);

        agregarFila(form, gbc, 0, "ID Préstamo:", txtPreId);
        agregarFila(form, gbc, 1, "Fecha Préstamo (dd/MM/yyyy):", txtPreFechaPres);
        agregarFila(form, gbc, 2, "Fecha Devolución (dd/MM/yyyy):", txtPreFechaDev);
        agregarFila(form, gbc, 3, "Imagen:", txtPreImagen);
        agregarFila(form, gbc, 4, "Estado:", txtPreEstado);

        JButton btnCrear = new JButton("Crear");
        JButton btnBuscar = new JButton("Buscar");
        JButton btnMostrar = new JButton("Mostrar");
        JButton btnActualizar = new JButton("Actualizar");
        JButton btnBorrar = new JButton("Borrar");
        JButton btnDestruir = new JButton("Destruir");

        btnCrear.addActionListener(e -> {
            try {
                prestamoActual = new Prestamo(
                        parseInt(txtPreId.getText()), parseDate(txtPreFechaPres.getText()),
                        parseDate(txtPreFechaDev.getText()), "Normal",
                        txtPreImagen.getText(), txtPreEstado.getText());
                JOptionPane.showMessageDialog(panel, "Préstamo creado.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Error: " + ex.getMessage());
            }
        });

        btnBuscar.addActionListener(e -> {
            if (prestamoActual != null && prestamoActual.getIdprestamo() == parseInt(txtPreId.getText())) {
                txtPreEstado.setText(prestamoActual.getEstado());
                txtPreImagen.setText(prestamoActual.getImagen());
                if (prestamoActual.getFechapres() != null) {
                    txtPreFechaPres.setText(new SimpleDateFormat("dd/MM/yyyy").format(prestamoActual.getFechapres()));
                }
                if (prestamoActual.getFechadevo() != null) {
                    txtPreFechaDev.setText(new SimpleDateFormat("dd/MM/yyyy").format(prestamoActual.getFechadevo()));
                }
            } else {
                JOptionPane.showMessageDialog(panel, "No encontrado.");
            }
        });

        btnMostrar.addActionListener(e -> {
            if (prestamoActual == null) {
                JOptionPane.showMessageDialog(panel, "No hay registro de préstamo.");
            } else {
                JOptionPane.showMessageDialog(panel, prestamoActual.toString());
            }
        });

        btnActualizar.addActionListener(e -> {
            try {
                if (prestamoActual != null && prestamoActual.getIdprestamo() == parseInt(txtPreId.getText())) {
                    prestamoActual.setEstado(txtPreEstado.getText());
                    prestamoActual.setFechapres(parseDate(txtPreFechaPres.getText()));
                    prestamoActual.setFechadevo(parseDate(txtPreFechaDev.getText()));
                    JOptionPane.showMessageDialog(panel, "Actualizado.");
                } else {
                    JOptionPane.showMessageDialog(panel, "No encontrado.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Error: " + ex.getMessage());
            }
        });

        btnBorrar.addActionListener(e -> {
            if (prestamoActual != null && prestamoActual.getIdprestamo() == parseInt(txtPreId.getText())) {
                prestamoActual = null;
                JOptionPane.showMessageDialog(panel, "Borrado.");
            } else {
                JOptionPane.showMessageDialog(panel, "No encontrado.");
            }
        });

        btnDestruir.addActionListener(e -> {
            prestamoActual = null;
            JOptionPane.showMessageDialog(panel, "Registro destruido.");
        });

        panel.add(form, BorderLayout.CENTER);
        panel.add(crearPanelBotones(btnCrear, btnBuscar, btnMostrar, btnActualizar, btnBorrar, btnDestruir), BorderLayout.EAST);
        return panel;
    }

    // =====================================================
    // MÉTODO MAIN
    // =====================================================
    public static void main(String... args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        EventQueue.invokeLater(() -> new GUIBiblioteca().setVisible(true));
    }
}