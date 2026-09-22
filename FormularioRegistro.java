import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioRegistro extends JFrame {

    private JTextField txtUsuario;
    private JTextField txtCorreo;
    private JPasswordField txtPassword;
    private JPasswordField txtConfirmarPassword;
    private JButton btnRegistrar;
    private JButton btnVolverLogin;

    public FormularioRegistro() {
        // Configuración de la ventana principal
        setTitle("Crear Nueva Cuenta");
        setSize(400, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);



        // Panel Principal
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(245, 245, 245));
        add(panel);

       
        JLabel lblTitulo = new JLabel("REGISTRO DE USUARIO");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setForeground(new Color(33, 33, 33));
        lblTitulo.setBounds(80, 20, 240, 30);
        panel.add(lblTitulo);

        
        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(50, 70, 100, 25);
        panel.add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(50, 95, 280, 30);
        panel.add(txtUsuario);

      
        JLabel lblCorreo = new JLabel("Correo Electrónico:");
        lblCorreo.setBounds(50, 130, 150, 25);
        panel.add(lblCorreo);

        txtCorreo = new JTextField();
        txtCorreo.setBounds(50, 155, 280, 30);
        panel.add(txtCorreo);

       
        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setBounds(50, 190, 100, 25);
        panel.add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(50, 215, 280, 30);
        panel.add(txtPassword);

     
        JLabel lblConfirmar = new JLabel("Confirmar Contraseña:");
        lblConfirmar.setBounds(50, 250, 180, 25);
        panel.add(lblConfirmar);

        txtConfirmarPassword = new JPasswordField();
        txtConfirmarPassword.setBounds(50, 275, 280, 30);
        panel.add(txtConfirmarPassword);

        btnRegistrar = new JButton("Guardar Cuenta");
        btnRegistrar.setBounds(50, 330, 280, 35);
        btnRegistrar.setBackground(new Color(46, 125, 50)); // Verde
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setFocusable(false);
        panel.add(btnRegistrar);

       
        btnVolverLogin = new JButton("¿Ya tienes cuenta? Inicia Sesión");
        btnVolverLogin.setBounds(50, 375, 280, 25);
        btnVolverLogin.setContentAreaFilled(false);
        btnVolverLogin.setBorderPainted(false);
        btnVolverLogin.setForeground(new Color(25, 118, 210)); // Azul
        btnVolverLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(btnVolverLogin);

      
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarUsuario();
            }
        });

        btnVolverLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // AQUÍ SE VINCULA: Abre la ventana LoginGrafico y cierra Registro
                LoginGrafico login = new LoginGrafico();
                login.setVisible(true);
                dispose();
            }
        });
    }

    private void registrarUsuario() {
        String usuario = txtUsuario.getText().trim();
        String correo = txtCorreo.getText().trim();
        String pass = new String(txtPassword.getPassword());
        String confirmPass = new String(txtConfirmarPassword.getPassword());

        if (usuario.isEmpty() || correo.isEmpty() || pass.isEmpty() || confirmPass.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Por favor completa todos los campos.",
                    "Atención",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!pass.equals(confirmPass)) {
            JOptionPane.showMessageDialog(this,
                    "Las contraseñas no coinciden.",
                    "Error de Validación",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this,
                "¡Cuenta creada con éxito para " + usuario + "!",
                "Éxito",
                JOptionPane.INFORMATION_MESSAGE);

        txtUsuario.setText("");
        txtCorreo.setText("");
        txtPassword.setText("");
        txtConfirmarPassword.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FormularioRegistro().setVisible(true);
        });
    }
}