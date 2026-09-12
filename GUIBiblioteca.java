package Front_end;

import Back_end.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GUIBiblioteca extends JFrame {

    // --- Estructuras de datos ---
    private final List<Cliente> clientes = new ArrayList<>();
    private final List<Recepcionista> recepcionistas = new ArrayList<>();
    private final List<Administrador> administradores = new ArrayList<>();
    private final List<Autor> autores = new ArrayList<>();
    private final List<Libro> libros = new ArrayList<>();
    private final List<Editorial> editoriales = new ArrayList<>();
    private final List<Estante> estantes = new ArrayList<>();
    private final List<Prestamo> prestamos = new ArrayList<>();

    // --- Modelos de Tabla ---
    private DefaultTableModel tmCliente, tmRecep, tmAdmin, tmAutor;
    private DefaultTableModel tmLibro, tmEdit, tmEstante, tmPrestamo;

    // --- Campos de texto por pestaña (Usamos arrays para limpiar el código) ---
    private JTextField[] cCli, cRec, cAdm, cAut, cLib, cEdi, cEst, cPre;

    public GUIBiblioteca() {
        setTitle("Sistema de Gestión de Biblioteca");
        setSize(1000, 750);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        // Inicializar pestañas
        tabbedPane.addTab("Cliente", initCliente());
        tabbedPane.addTab("Recepcionista", initRecepcionista());
        tabbedPane.addTab("Administrador", initAdministrador());
        tabbedPane.addTab("Autor", initAutor());
        tabbedPane.addTab("Libro", initLibro());
        tabbedPane.addTab("Editorial", initEditorial());
        tabbedPane.addTab("Estante", initEstante());
        tabbedPane.addTab("Préstamo", initPrestamo());

        add(tabbedPane);
    }

    // =======================================================================
    // MÉTODOS DE INICIALIZACIÓN DE PESTAÑAS
    // =======================================================================

    private JPanel initCliente() {
        String[] labels = {"CURP:", "Nombre:", "Apellido:", "IDE:", "Fecha Ingreso (dd/MM/yyyy):", "Correo:", "Teléfono:", "Tipo Cliente:", "Imagen:", "Estado:"};
        cCli = crearCampos(10);
        tmCliente = crearModelo("CURP", "Nombre", "Apellido", "Correo", "Teléfono", "Tipo");
        
        JButton btnCrear = new JButton("Crear"); btnCrear.addActionListener(e -> crearCliente());
        JButton btnBuscar = new JButton("Buscar"); btnBuscar.addActionListener(e -> buscarCliente());
        JButton btnMostrar = new JButton("Refrescar"); btnMostrar.addActionListener(e -> { recargarCliente(); JOptionPane.showMessageDialog(this, "Tabla actualizada."); });
        JButton btnAct = new JButton("Actualizar"); btnAct.addActionListener(e -> actualizarCliente());
        JButton btnBorrar = new JButton("Borrar"); btnBorrar.addActionListener(e -> borrarCliente());
        JButton btnDest = new JButton("Destruir Todo"); btnDest.addActionListener(e -> { clientes.clear(); recargarCliente(); });
        
        return crearTab(labels, cCli, new JButton[]{btnCrear, btnBuscar, btnMostrar, btnAct, btnBorrar, btnDest}, tmCliente);
    }

    private JPanel initRecepcionista() {
        String[] labels = {"CURP:", "Nombre:", "Apellido:", "IDE:", "Fecha Ingreso:", "ID Único:", "Salario:", "Puesto:", "Área:", "Turno:", "Imagen:", "Estado:"};
        cRec = crearCampos(12);
        tmRecep = crearModelo("CURP", "Nombre", "Puesto", "Área", "Turno", "Salario");
        
        JButton[] btns = crearBotonesCRUD(() -> crearRecep(), () -> buscarRecep(), () -> { recargarRecep(); JOptionPane.showMessageDialog(this, "Tabla actualizada."); }, () -> actualizarRecep(), () -> borrarRecep(), () -> { recepcionistas.clear(); recargarRecep(); });
        return crearTab(labels, cRec, btns, tmRecep);
    }

    private JPanel initAdministrador() {
        String[] labels = {"CURP:", "Nombre:", "Apellido:", "IDE:", "Fecha Ingreso:", "ID Único:", "Salario:", "Puesto:", "Nivel Acceso:", "Permisos:", "Imagen:", "Estado:"};
        cAdm = crearCampos(12);
        tmAdmin = crearModelo("CURP", "Nombre", "Puesto", "Nivel Acceso", "Permisos");
        
        JButton[] btns = crearBotonesCRUD(() -> crearAdmin(), () -> buscarAdmin(), () -> { recargarAdmin(); JOptionPane.showMessageDialog(this, "Tabla actualizada."); }, () -> actualizarAdmin(), () -> borrarAdmin(), () -> { administradores.clear(); recargarAdmin(); });
        return crearTab(labels, cAdm, btns, tmAdmin);
    }

    private JPanel initAutor() {
        String[] labels = {"ID Autor:", "Nombre:", "Nacionalidad:", "Fecha Nac (dd/MM/yyyy):", "Imagen:", "Estado:"};
        cAut = crearCampos(6);
        tmAutor = crearModelo("ID", "Nombre", "Nacionalidad", "Fecha Nac");
        
        JButton[] btns = crearBotonesCRUD(() -> crearAutor(), () -> buscarAutor(), () -> { recargarAutor(); JOptionPane.showMessageDialog(this, "Tabla actualizada."); }, () -> actualizarAutor(), () -> borrarAutor(), () -> { autores.clear(); recargarAutor(); });
        return crearTab(labels, cAut, btns, tmAutor);
    }

    private JPanel initLibro() {
        String[] labels = {"ISBN:", "Título:", "Fecha Pub (dd/MM/yyyy):", "Imagen:", "Estado:"};
        cLib = crearCampos(5);
        tmLibro = crearModelo("ISBN", "Título", "Fecha Pub");
        
        JButton[] btns = crearBotonesCRUD(() -> crearLibro(), () -> buscarLibro(), () -> { recargarLibro(); JOptionPane.showMessageDialog(this, "Tabla actualizada."); }, () -> actualizarLibro(), () -> borrarLibro(), () -> { libros.clear(); recargarLibro(); });
        return crearTab(labels, cLib, btns, tmLibro);
    }

    private JPanel initEditorial() {
        String[] labels = {"ID Nombre:", "Teléfono:", "Dirección:", "Imagen:", "Estado:"};
        cEdi = crearCampos(5);
        tmEdit = crearModelo("ID", "Teléfono", "Dirección");
        
        JButton[] btns = crearBotonesCRUD(() -> crearEdit(), () -> buscarEdit(), () -> { recargarEdit(); JOptionPane.showMessageDialog(this, "Tabla actualizada."); }, () -> actualizarEdit(), () -> borrarEdit(), () -> { editoriales.clear(); recargarEdit(); });
        return crearTab(labels, cEdi, btns, tmEdit);
    }

    private JPanel initEstante() {
        String[] labels = {"ID Estante:", "Ubicación:", "Capacidad:", "Imagen:", "Estado:"};
        cEst = crearCampos(5);
        tmEstante = crearModelo("ID", "Ubicación", "Capacidad");
        
        JButton[] btns = crearBotonesCRUD(() -> crearEst(), () -> buscarEst(), () -> { recargarEst(); JOptionPane.showMessageDialog(this, "Tabla actualizada."); }, () -> actualizarEst(), () -> borrarEst(), () -> { estantes.clear(); recargarEst(); });
        return crearTab(labels, cEst, btns, tmEstante);
    }

    private JPanel initPrestamo() {
        String[] labels = {"ID Préstamo:", "Fecha Préstamo (dd/MM/yyyy):", "Fecha Devolución (dd/MM/yyyy):", "Imagen:", "Estado:"};
        cPre = crearCampos(5);
        tmPrestamo = crearModelo("ID", "Fecha Préstamo", "Fecha Devolución", "Estado");
        
        JButton[] btns = crearBotonesCRUD(() -> crearPrest(), () -> buscarPrest(), () -> { recargarPrest(); JOptionPane.showMessageDialog(this, "Tabla actualizada."); }, () -> actualizarPrest(), () -> borrarPrest(), () -> { prestamos.clear(); recargarPrest(); });
        return crearTab(labels, cPre, btns, tmPrestamo);
    }

    // =======================================================================
    // MÉTODOS AUXILIARES DE UI
    // =======================================================================

    private JTextField[] crearCampos(int cantidad) {
        JTextField[] campos = new JTextField[cantidad];
        for (int i = 0; i < cantidad; i++) campos[i] = new JTextField(20);
        return campos;
    }

    private DefaultTableModel crearModelo(String... columnas) {
        return new DefaultTableModel(columnas, 0) {
            @Override public boolean isCellEditable(int row, int column) { return false; }
        };
    }

    private JButton[] crearBotonesCRUD(Runnable crear, Runnable buscar, Runnable mostrar, Runnable act, Runnable borrar, Runnable destruir) {
        JButton b1 = new JButton("Crear"); b1.addActionListener(e -> crear.run());
        JButton b2 = new JButton("Buscar"); b2.addActionListener(e -> buscar.run());
        JButton b3 = new JButton("Refrescar"); b3.addActionListener(e -> mostrar.run());
        JButton b4 = new JButton("Actualizar"); b4.addActionListener(e -> act.run());
        JButton b5 = new JButton("Borrar"); b5.addActionListener(e -> borrar.run());
        JButton b6 = new JButton("Destruir Todo"); b6.addActionListener(e -> destruir.run());
        return new JButton[]{b1, b2, b3, b4, b5, b6};
    }

    private JPanel crearTab(String[] labels, JTextField[] fields, JButton[] buttons, DefaultTableModel tableModel) {
        JPanel panel = new JPanel(new BorderLayout(15, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Panel Superior (Formulario + Botones)
        JPanel topPanel = new JPanel(new BorderLayout(15, 15));
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.anchor = GridBagConstraints.WEST;

        for (int i = 0; i < labels.length; i++) {
            gbc.gridx = 0; gbc.gridy = i; gbc.fill = GridBagConstraints.NONE;
            formPanel.add(new JLabel(labels[i]), gbc);
            gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
            formPanel.add(fields[i], gbc);
        }

        JPanel btnPanel = new JPanel(new GridLayout(buttons.length, 1, 5, 5));
        for (JButton btn : buttons) {
            btn.setFocusPainted(false);
            btnPanel.add(btn);
        }

        topPanel.add(formPanel, BorderLayout.CENTER);
        topPanel.add(btnPanel, BorderLayout.EAST);

        // Panel Inferior (Tabla)
        JTable table = new JTable(tableModel);
        table.setFillsViewportHeight(true);
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private void limpiarCampos(JTextField[] campos) {
        for (JTextField c : campos) c.setText("");
        if (campos.length > 0) campos[0].requestFocus();
    }

    // =======================================================================
    // LÓGICA CRUD (BACKEND INTEGRATION)
    // =======================================================================

    // --- CLIENTE ---
    private void crearCliente() {
        try {
            Cliente c = new Cliente(cCli[5].getText(), cCli[6].getText(), cCli[7].getText(), cCli[0].getText(), cCli[1].getText(), cCli[2].getText(), cCli[3].getText(), parseDate(cCli[4].getText()), cCli[8].getText(), cCli[9].getText());
            clientes.add(c); recargarCliente(); limpiarCampos(cCli);
            JOptionPane.showMessageDialog(this, "Cliente creado.");
        } catch (Exception e) { mostrarError(e); }
    }
    private void buscarCliente() { buscarEnLista(clientes, cCli[0].getText(), c -> c.getCurp(), c -> { cCli[1].setText(c.getNombre()); cCli[2].setText(c.getApellido()); cCli[3].setText(c.getIde()); cCli[4].setText(formatDate(c.getIngreso())); cCli[5].setText(c.getCorreo()); cCli[6].setText(c.getTelefono()); cCli[7].setText(c.getTipoCliente()); cCli[8].setText(c.getImagen()); cCli[9].setText(c.getEstado()); }); }
    private void actualizarCliente() {
        try {
            Cliente c = clientes.stream().filter(x -> x.getCurp().equals(cCli[0].getText())).findFirst().orElse(null);
            if (c != null) { c.setNombre(cCli[1].getText()); c.setApellido(cCli[2].getText()); c.setIde(cCli[3].getText()); c.setIngreso(parseDate(cCli[4].getText())); c.setCorreo(cCli[5].getText()); c.setTelefono(cCli[6].getText()); c.setTipoCliente(cCli[7].getText()); c.setImagen(cCli[8].getText()); c.setEstado(cCli[9].getText()); recargarCliente(); JOptionPane.showMessageDialog(this, "Actualizado."); }
            else JOptionPane.showMessageDialog(this, "No encontrado.");
        } catch (Exception e) { mostrarError(e); }
    }
    private void borrarCliente() { if (clientes.removeIf(c -> c.getCurp().equals(cCli[0].getText()))) { recargarCliente(); limpiarCampos(cCli); JOptionPane.showMessageDialog(this, "Borrado."); } else JOptionPane.showMessageDialog(this, "No encontrado."); }
    private void recargarCliente() { tmCliente.setRowCount(0); clientes.forEach(c -> tmCliente.addRow(new Object[]{c.getCurp(), c.getNombre(), c.getApellido(), c.getCorreo(), c.getTelefono(), c.getTipoCliente()})); }

    // --- RECEPCIONISTA ---
    private void crearRecep() {
        try {
            Recepcionista r = new Recepcionista(cRec[8].getText(), cRec[9].getText(), parseDouble(cRec[6].getText()), parseInt(cRec[5].getText()), cRec[7].getText(), cRec[0].getText(), cRec[1].getText(), cRec[2].getText(), cRec[3].getText(), parseDate(cRec[4].getText()), cRec[10].getText(), cRec[11].getText());
            recepcionistas.add(r); recargarRecep(); limpiarCampos(cRec); JOptionPane.showMessageDialog(this, "Creado.");
        } catch (Exception e) { mostrarError(e); }
    }
    private void buscarRecep() { buscarEnLista(recepcionistas, cRec[0].getText(), r -> r.getCurp(), r -> { cRec[1].setText(r.getNombre()); cRec[2].setText(r.getApellido()); cRec[3].setText(r.getIde()); cRec[4].setText(formatDate(r.getIngreso())); cRec[5].setText(String.valueOf(r.getIdunico())); cRec[6].setText(String.valueOf(r.getSalario())); cRec[7].setText(r.getPuesto()); cRec[8].setText(r.getArea()); cRec[9].setText(r.getTurno()); cRec[10].setText(r.getImagen()); cRec[11].setText(r.getEstado()); }); }
    private void actualizarRecep() {
        try {
            Recepcionista r = recepcionistas.stream().filter(x -> x.getCurp().equals(cRec[0].getText())).findFirst().orElse(null);
            if (r != null) { r.setNombre(cRec[1].getText()); r.setApellido(cRec[2].getText()); r.setArea(cRec[8].getText()); r.setTurno(cRec[9].getText()); r.setSalario(parseDouble(cRec[6].getText())); recargarRecep(); JOptionPane.showMessageDialog(this, "Actualizado."); }
            else JOptionPane.showMessageDialog(this, "No encontrado.");
        } catch (Exception e) { mostrarError(e); }
    }
    private void borrarRecep() { if (recepcionistas.removeIf(r -> r.getCurp().equals(cRec[0].getText()))) { recargarRecep(); limpiarCampos(cRec); JOptionPane.showMessageDialog(this, "Borrado."); } else JOptionPane.showMessageDialog(this, "No encontrado."); }
    private void recargarRecep() { tmRecep.setRowCount(0); recepcionistas.forEach(r -> tmRecep.addRow(new Object[]{r.getCurp(), r.getNombre(), r.getPuesto(), r.getArea(), r.getTurno(), r.getSalario()})); }

    // --- ADMINISTRADOR ---
    private void crearAdmin() {
        try {
            Administrador a = new Administrador(parseInt(cAdm[8].getText()), cAdm[9].getText(), parseDouble(cAdm[6].getText()), parseInt(cAdm[5].getText()), cAdm[7].getText(), cAdm[0].getText(), cAdm[1].getText(), cAdm[2].getText(), cAdm[3].getText(), parseDate(cAdm[4].getText()), cAdm[10].getText(), cAdm[11].getText());
            administradores.add(a); recargarAdmin(); limpiarCampos(cAdm); JOptionPane.showMessageDialog(this, "Creado.");
        } catch (Exception e) { mostrarError(e); }
    }
    private void buscarAdmin() { buscarEnLista(administradores, cAdm[0].getText(), a -> a.getCurp(), a -> { cAdm[1].setText(a.getNombre()); cAdm[2].setText(a.getApellido()); cAdm[3].setText(a.getIde()); cAdm[4].setText(formatDate(a.getIngreso())); cAdm[5].setText(String.valueOf(a.getIdunico())); cAdm[6].setText(String.valueOf(a.getSalario())); cAdm[7].setText(a.getPuesto()); cAdm[8].setText(String.valueOf(a.getNivelAcceso())); cAdm[9].setText(a.getPermisos()); cAdm[10].setText(a.getImagen()); cAdm[11].setText(a.getEstado()); }); }
    private void actualizarAdmin() {
        try {
            Administrador a = administradores.stream().filter(x -> x.getCurp().equals(cAdm[0].getText())).findFirst().orElse(null);
            if (a != null) { a.setNombre(cAdm[1].getText()); a.setNivelAcceso(parseInt(cAdm[8].getText())); a.setPermisos(cAdm[9].getText()); a.setSalario(parseDouble(cAdm[6].getText())); recargarAdmin(); JOptionPane.showMessageDialog(this, "Actualizado."); }
            else JOptionPane.showMessageDialog(this, "No encontrado.");
        } catch (Exception e) { mostrarError(e); }
    }
    private void borrarAdmin() { if (administradores.removeIf(a -> a.getCurp().equals(cAdm[0].getText()))) { recargarAdmin(); limpiarCampos(cAdm); JOptionPane.showMessageDialog(this, "Borrado."); } else JOptionPane.showMessageDialog(this, "No encontrado."); }
    private void recargarAdmin() { tmAdmin.setRowCount(0); administradores.forEach(a -> tmAdmin.addRow(new Object[]{a.getCurp(), a.getNombre(), a.getPuesto(), a.getNivelAcceso(), a.getPermisos()})); }

    // --- AUTOR ---
    private void crearAutor() {
        try { autores.add(new Autor(cAut[0].getText(), cAut[1].getText(), cAut[2].getText(), parseDate(cAut[3].getText()), cAut[4].getText(), cAut[5].getText())); recargarAutor(); limpiarCampos(cAut); JOptionPane.showMessageDialog(this, "Creado."); } catch (Exception e) { mostrarError(e); }
    }
    private void buscarAutor() { buscarEnLista(autores, cAut[0].getText(), a -> a.getIdAutor(), a -> { cAut[1].setText(a.getNombre()); cAut[2].setText(a.getNacionalidad()); cAut[3].setText(formatDate(a.getFechaNac())); cAut[4].setText(a.getImagen()); cAut[5].setText(a.getEstado()); }); }
    private void actualizarAutor() {
        try {
            Autor a = autores.stream().filter(x -> x.getIdAutor().equals(cAut[0].getText())).findFirst().orElse(null);
            if (a != null) { a.setNombre(cAut[1].getText()); a.setNacionalidad(cAut[2].getText()); a.setFechaNac(parseDate(cAut[3].getText())); recargarAutor(); JOptionPane.showMessageDialog(this, "Actualizado."); }
            else JOptionPane.showMessageDialog(this, "No encontrado.");
        } catch (Exception e) { mostrarError(e); }
    }
    private void borrarAutor() { if (autores.removeIf(a -> a.getIdAutor().equals(cAut[0].getText()))) { recargarAutor(); limpiarCampos(cAut); JOptionPane.showMessageDialog(this, "Borrado."); } else JOptionPane.showMessageDialog(this, "No encontrado."); }
    private void recargarAutor() { tmAutor.setRowCount(0); autores.forEach(a -> tmAutor.addRow(new Object[]{a.getIdAutor(), a.getNombre(), a.getNacionalidad(), formatDate(a.getFechaNac())})); }

    // --- LIBRO ---
    private void crearLibro() {
        try { libros.add(new Libro(cLib[1].getText(), cLib[0].getText(), parseDate(cLib[2].getText()), cLib[3].getText(), cLib[4].getText())); recargarLibro(); limpiarCampos(cLib); JOptionPane.showMessageDialog(this, "Creado."); } catch (Exception e) { mostrarError(e); }
    }
    private void buscarLibro() { buscarEnLista(libros, cLib[0].getText(), l -> l.getIsbn(), l -> { cLib[1].setText(l.getTitulo()); cLib[2].setText(formatDate(l.getFechapubl())); cLib[3].setText(l.getImagen()); cLib[4].setText(l.getEstado()); }); }
    private void actualizarLibro() {
        try {
            Libro l = libros.stream().filter(x -> x.getIsbn().equals(cLib[0].getText())).findFirst().orElse(null);
            if (l != null) { l.setTitulo(cLib[1].getText()); l.setFechapubl(parseDate(cLib[2].getText())); recargarLibro(); JOptionPane.showMessageDialog(this, "Actualizado."); }
            else JOptionPane.showMessageDialog(this, "No encontrado.");
        } catch (Exception e) { mostrarError(e); }
    }
    private void borrarLibro() { if (libros.removeIf(l -> l.getIsbn().equals(cLib[0].getText()))) { recargarLibro(); limpiarCampos(cLib); JOptionPane.showMessageDialog(this, "Borrado."); } else JOptionPane.showMessageDialog(this, "No encontrado."); }
    private void recargarLibro() { tmLibro.setRowCount(0); libros.forEach(l -> tmLibro.addRow(new Object[]{l.getIsbn(), l.getTitulo(), formatDate(l.getFechapubl())})); }

    // --- EDITORIAL ---
    private void crearEdit() {
        try { editoriales.add(new Editorial(cEdi[0].getText(), parseLong(cEdi[1].getText()), cEdi[2].getText(), cEdi[3].getText(), cEdi[4].getText())); recargarEdit(); limpiarCampos(cEdi); JOptionPane.showMessageDialog(this, "Creado."); } catch (Exception e) { mostrarError(e); }
    }
    private void buscarEdit() { buscarEnLista(editoriales, cEdi[0].getText(), e -> e.getIdnombre(), e -> { cEdi[1].setText(String.valueOf(e.getNumerotel())); cEdi[2].setText(e.getDireccion()); cEdi[3].setText(e.getImagen()); cEdi[4].setText(e.getEstado()); }); }
    private void actualizarEdit() {
        try {
            Editorial e = editoriales.stream().filter(x -> x.getIdnombre().equals(cEdi[0].getText())).findFirst().orElse(null);
            if (e != null) { e.setDireccion(cEdi[2].getText()); e.setNumerotel(parseLong(cEdi[1].getText())); recargarEdit(); JOptionPane.showMessageDialog(this, "Actualizado."); }
            else JOptionPane.showMessageDialog(this, "No encontrado.");
        } catch (Exception ex) { mostrarError(ex); }
    }
    private void borrarEdit() { if (editoriales.removeIf(e -> e.getIdnombre().equals(cEdi[0].getText()))) { recargarEdit(); limpiarCampos(cEdi); JOptionPane.showMessageDialog(this, "Borrado."); } else JOptionPane.showMessageDialog(this, "No encontrado."); }
    private void recargarEdit() { tmEdit.setRowCount(0); editoriales.forEach(e -> tmEdit.addRow(new Object[]{e.getIdnombre(), e.getNumerotel(), e.getDireccion()})); }

    // --- ESTANTE ---
    private void crearEst() {
        try { estantes.add(new Estante(parseInt(cEst[0].getText()), cEst[1].getText(), parseInt(cEst[2].getText()), cEst[3].getText(), cEst[4].getText())); recargarEst(); limpiarCampos(cEst); JOptionPane.showMessageDialog(this, "Creado."); } catch (Exception e) { mostrarError(e); }
    }
    private void buscarEst() { buscarEnLista(estantes, cEst[0].getText(), e -> String.valueOf(e.getIdestante()), e -> { cEst[1].setText(e.getUbicacion()); cEst[2].setText(String.valueOf(e.getCapacidad())); cEst[3].setText(e.getImagen()); cEst[4].setText(e.getEstado()); }); }
    private void actualizarEst() {
        try {
            Estante e = estantes.stream().filter(x -> x.getIdestante() == parseInt(cEst[0].getText())).findFirst().orElse(null);
            if (e != null) { e.setUbicacion(cEst[1].getText()); e.setCapacidad(parseInt(cEst[2].getText())); recargarEst(); JOptionPane.showMessageDialog(this, "Actualizado."); }
            else JOptionPane.showMessageDialog(this, "No encontrado.");
        } catch (Exception ex) { mostrarError(ex); }
    }
    private void borrarEst() { if (estantes.removeIf(e -> e.getIdestante() == parseInt(cEst[0].getText()))) { recargarEst(); limpiarCampos(cEst); JOptionPane.showMessageDialog(this, "Borrado."); } else JOptionPane.showMessageDialog(this, "No encontrado."); }
    private void recargarEst() { tmEstante.setRowCount(0); estantes.forEach(e -> tmEstante.addRow(new Object[]{e.getIdestante(), e.getUbicacion(), e.getCapacidad()})); }

    // --- PRÉSTAMO ---
    private void crearPrest() {
        try { prestamos.add(new Prestamo(parseInt(cPre[0].getText()), parseDate(cPre[1].getText()), parseDate(cPre[2].getText()), "Normal", cPre[3].getText(), cPre[4].getText())); recargarPrest(); limpiarCampos(cPre); JOptionPane.showMessageDialog(this, "Creado."); } catch (Exception e) { mostrarError(e); }
    }
    private void buscarPrest() { buscarEnLista(prestamos, cPre[0].getText(), p -> String.valueOf(p.getIdprestamo()), p -> { cPre[1].setText(formatDate(p.getFechapres())); cPre[2].setText(formatDate(p.getFechadevo())); cPre[3].setText(p.getImagen()); cPre[4].setText(p.getEstado()); }); }
    private void actualizarPrest() {
        try {
            Prestamo p = prestamos.stream().filter(x -> x.getIdprestamo() == parseInt(cPre[0].getText())).findFirst().orElse(null);
            if (p != null) { p.setFechapres(parseDate(cPre[1].getText())); p.setFechadevo(parseDate(cPre[2].getText())); p.setEstado(cPre[4].getText()); recargarPrest(); JOptionPane.showMessageDialog(this, "Actualizado."); }
            else JOptionPane.showMessageDialog(this, "No encontrado.");
        } catch (Exception ex) { mostrarError(ex); }
    }
    private void borrarPrest() { if (prestamos.removeIf(p -> p.getIdprestamo() == parseInt(cPre[0].getText()))) { recargarPrest(); limpiarCampos(cPre); JOptionPane.showMessageDialog(this, "Borrado."); } else JOptionPane.showMessageDialog(this, "No encontrado."); }
    private void recargarPrest() { tmPrestamo.setRowCount(0); prestamos.forEach(p -> tmPrestamo.addRow(new Object[]{p.getIdprestamo(), formatDate(p.getFechapres()), formatDate(p.getFechadevo()), p.getEstado()})); }

    // =======================================================================
    // MÉTODOS AUXILIARES GENERALES
    // =======================================================================

    private <T> void buscarEnLista(List<T> lista, String key, java.util.function.Function<T, String> getKey, java.util.function.Consumer<T> setFields) {
        T item = lista.stream().filter(x -> getKey.apply(x).equals(key)).findFirst().orElse(null);
        if (item != null) setFields.accept(item);
        else JOptionPane.showMessageDialog(this, "Registro no encontrado.");
    }

    private void mostrarError(Exception e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error de Validación", JOptionPane.ERROR_MESSAGE);
    }

    private Date parseDate(String text) {
        if (text == null || text.trim().isEmpty()) return null;
        try { return new SimpleDateFormat("dd/MM/yyyy").parse(text); } 
        catch (Exception e) { throw new IllegalArgumentException("Formato de fecha inválido. Use dd/MM/yyyy"); }
    }

    private String formatDate(Date date) {
        return date != null ? new SimpleDateFormat("dd/MM/yyyy").format(date) : "";
    }

    private int parseInt(String text) {
        if (text == null || text.trim().isEmpty()) return 0;
        try { return Integer.parseInt(text); } catch (Exception e) { throw new IllegalArgumentException("Número entero inválido"); }
    }

    private double parseDouble(String text) {
        if (text == null || text.trim().isEmpty()) return 0.0;
        try { return Double.parseDouble(text); } catch (Exception e) { throw new IllegalArgumentException("Número decimal inválido"); }
    }

    private long parseLong(String text) {
        if (text == null || text.trim().isEmpty()) return 0;
        try { return Long.parseLong(text); } catch (Exception e) { throw new IllegalArgumentException("Número largo inválido"); }
    }

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(() -> new GUIBiblioteca().setVisible(true));
    }
}