import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class LoginGrafico extends JFrame implements ActionListener {

    private JTextField txtUsuario;
    private JPasswordField txtClave;
    private JButton btnIngresar;
    private JButton btnRegistrar;

    
    private Map<String, String> usuarios = new HashMap<>();

    public LoginGrafico() {
        
        usuarios.put("admin", "1234");

        setTitle("Inicio de Sesión Seguro");
        setSize(400, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(Color.WHITE);

        
        JPanel panelAvatar = new JPanel();
        panelAvatar.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
        panelAvatar.setBackground(Color.WHITE);

        try {
            ImageIcon imgOriginal = new ImageIcon("user_icon.png");
            Image imgEscalada = imgOriginal.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            JLabel lblAvatar = new JLabel(new ImageIcon(imgEscalada));
            panelAvatar.add(lblAvatar);
        } catch (Exception e) {
            panelAvatar.add(new JLabel("Imagen user_icon.png"));
        }

        
        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new GridLayout(3, 2, 10, 15));
        panelFormulario.setBackground(Color.WHITE);
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));

        
        JLabel lblUsuario = new JLabel("Usuario:");
        try {
            ImageIcon icoUser = new ImageIcon("user_icon.png");
            Image icoUserEscalado = icoUser.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            lblUsuario.setIcon(new ImageIcon(icoUserEscalado));
        } catch (Exception e) {
            System.out.println("no se encontró user_icon.png");
        }
        txtUsuario = new JTextField();
        panelFormulario.add(lblUsuario);
        panelFormulario.add(txtUsuario);

        
        JLabel lblClave = new JLabel("Contraseña:");
        try {
            ImageIcon icoLock = new ImageIcon("candado_icon.png");
            Image icoLockEscalado = icoLock.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            lblClave.setIcon(new ImageIcon(icoLockEscalado));
        } catch (Exception e) {
            System.out.println("no se encontró candado_icon.png");
        }
        txtClave = new JPasswordField();
        panelFormulario.add(lblClave);
        panelFormulario.add(txtClave);

       
        btnRegistrar = new JButton("Crear Cuenta");
        btnRegistrar.setFont(new Font("Arial", Font.BOLD, 12));
        btnRegistrar.setBackground(new Color(46, 204, 113)); // Verde
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setFocusPainted(false);
        btnRegistrar.addActionListener(this);

        btnIngresar = new JButton("Ingresar");
        btnIngresar.setFont(new Font("Arial", Font.BOLD, 12));
        btnIngresar.setBackground(new Color(41, 128, 185)); // Azul
        btnIngresar.setForeground(Color.WHITE);
        btnIngresar.setFocusPainted(false);
        btnIngresar.addActionListener(this);

        panelFormulario.add(btnRegistrar);
        panelFormulario.add(btnIngresar);

        
        add(panelAvatar, BorderLayout.NORTH);
        add(panelFormulario, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnIngresar) {
            String usuario = txtUsuario.getText().trim();
            String clave = new String(txtClave.getPassword()).trim();

            if (usuarios.containsKey(usuario) && usuarios.get(usuario).equals(clave)) {
                JOptionPane.showMessageDialog(this, "Acceso Concedido. ¡Bienvenido " + usuario + "!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos", "Error de autenticación", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnRegistrar) {
            // AQUÍ SE VINCULA: Abre la ventana FormularioRegistro y cierra el Login
            FormularioRegistro registro = new FormularioRegistro();
            registro.setVisible(true);
            dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginGrafico ventana = new LoginGrafico();
            ventana.setVisible(true);
        });
    }
}