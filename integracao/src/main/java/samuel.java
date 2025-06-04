import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import java.awt.Font;
import org.mindrot.jbcrypt.BCrypt;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import javax.swing.*;
import java.awt.*;
import java.io.*;




public class samuel extends javax.swing.JFrame {

    public samuel() {
        initComponents();
    }
    
       public Connection conectar() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/login", 
            "root",  // Substitua pelo seu usuário
            "senac@2025" // Substitua pela sua senha
        );
    }
       

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logintxt = new javax.swing.JLabel();
        usuariofield = new javax.swing.JTextField();
        usuariotxt = new javax.swing.JLabel();
        senhatxt = new javax.swing.JLabel();
        registrobotao = new javax.swing.JButton();
        deletarbotao = new javax.swing.JButton();
        alterarbotao = new javax.swing.JButton();
        cadastrarbotao = new javax.swing.JButton();
        entrarbotao = new javax.swing.JButton();
        senhafield1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logintxt.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        logintxt.setText("Login");
        getContentPane().add(logintxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, -1, -1));

        usuariofield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuariofieldActionPerformed(evt);
            }
        });
        getContentPane().add(usuariofield, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 100, -1));

        usuariotxt.setText("usuario");
        getContentPane().add(usuariotxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, -1, -1));

        senhatxt.setText("senha");
        getContentPane().add(senhatxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, -1, -1));

        registrobotao.setText("Registro");
        registrobotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrobotaoActionPerformed(evt);
            }
        });
        getContentPane().add(registrobotao, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 80, -1));

        deletarbotao.setText("Deletar");
        deletarbotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletarbotaoActionPerformed(evt);
            }
        });
        getContentPane().add(deletarbotao, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, 80, -1));

        alterarbotao.setText("Alterar");
        alterarbotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarbotaoActionPerformed(evt);
            }
        });
        getContentPane().add(alterarbotao, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, 80, -1));

        cadastrarbotao.setText("Cadastrar");
        cadastrarbotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarbotaoActionPerformed(evt);
            }
        });
        getContentPane().add(cadastrarbotao, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, -1, -1));

        entrarbotao.setText("Entrar");
        entrarbotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrarbotaoActionPerformed(evt);
            }
        });
        getContentPane().add(entrarbotao, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, -1, -1));

        senhafield1.setText("jPasswordField1");
        getContentPane().add(senhafield1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usuariofieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuariofieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuariofieldActionPerformed

    private void entrarbotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrarbotaoActionPerformed
                                                 
     String usuario = usuariofield.getText();
        String senha = new String(senhafield1.getPassword());

        if (!usuario.matches("^[a-zA-Z0-9_]{3,20}$")) {
            JOptionPane.showMessageDialog(null, "Usuário inválido!");
            return;
        }

        if (senha.length() < 6) {
            JOptionPane.showMessageDialog(null, "Senha muito curta!");
            return;
        }

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement("SELECT senha FROM clientes WHERE login = ?")) {

            stmt.setString(1, usuario);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String hashed = rs.getString("senha");

                if (BCrypt.checkpw(senha, hashed)) {
                    JOptionPane.showMessageDialog(null, "Login bem-sucedido!");
                } else {
                    JOptionPane.showMessageDialog(null, "Senha incorreta.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não encontrado.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
       
}
    boolean sucesso = false;

    try {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/seu_banco", "usuario", "senha");

        String sql = "SELECT senha FROM clientes WHERE login = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, usuario);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            String senhaNoBanco = rs.getString("senha");
            
            // Se não estiver usando hash, compare diretamente (recomendo usar hash depois)
            if (senha.equals(senhaNoBanco)) {
                sucesso = true;
                JOptionPane.showMessageDialog(this, "Login bem-sucedido!");
                new samuel().setVisible(true); // abrir sua calculadora, por exemplo
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Senha incorreta.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Login não encontrado.");
        }

        // ✅ Inserir tentativa de login no log
        String logSql = "INSERT INTO logins (login, sucesso) VALUES (?, ?)";
        PreparedStatement logStmt = con.prepareStatement(logSql);
        logStmt.setString(1, usuario);
        logStmt.setBoolean(2, sucesso);
        logStmt.executeUpdate();

        con.close();
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
    }

        
    }//GEN-LAST:event_entrarbotaoActionPerformed

    private void deletarbotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletarbotaoActionPerformed
      String usuario = usuariofield.getText();

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM clientes WHERE login = ?")) {

            stmt.setString(1, usuario);
            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                JOptionPane.showMessageDialog(null, "Usuário deletado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não encontrado.");
            }
      } catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Erro ao tentar fazer login. Tente novamente mais tarde.");
    logErro(e); // aqui chamamos o método para registrar o erro
}

    }//GEN-LAST:event_deletarbotaoActionPerformed

    private void registrobotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrobotaoActionPerformed
    try (Connection conn = conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT login, senha FROM clientes")) {

            DefaultTableModel model = new DefaultTableModel() {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            model.addColumn("Usuário");
            model.addColumn("Senha");

            boolean hasRecords = false;
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("login"), rs.getString("senha")});
                hasRecords = true;
            }

            if (!hasRecords) {
                JOptionPane.showMessageDialog(null, "Nenhum registro encontrado.");
                return;
            }

            JTable table = new JTable(model);
            table.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            table.setRowHeight(25);
            table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));

            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setPreferredSize(new Dimension(350, 200));

            JOptionPane.showMessageDialog(null, scrollPane, "Clientes Cadastrados", JOptionPane.PLAIN_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_registrobotaoActionPerformed

    private void cadastrarbotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarbotaoActionPerformed
        String usuario = usuariofield.getText();
        String senha = new String(senhafield1.getPassword());

        if (usuario.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
            return;
        }

        String hashed = BCrypt.hashpw(senha, BCrypt.gensalt());

        try (Connection conn = conectar();
             PreparedStatement checkUser = conn.prepareStatement("SELECT * FROM clientes WHERE login = ?");
             PreparedStatement insertUser = conn.prepareStatement("INSERT INTO clientes (login, senha) VALUES (?, ?)")) {

            checkUser.setString(1, usuario);
            ResultSet rs = checkUser.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Usuário já existe!");
            } else {
                insertUser.setString(1, usuario);
                insertUser.setString(2, hashed);
                insertUser.executeUpdate();
                JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_cadastrarbotaoActionPerformed

    private void alterarbotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarbotaoActionPerformed
       String usuario = usuariofield.getText();
        String novaSenha = new String(senhafield1.getPassword());

        if (usuario.isEmpty() || novaSenha.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
            return;
        }

        String hashed = BCrypt.hashpw(novaSenha, BCrypt.gensalt());

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement("UPDATE clientes SET senha = ? WHERE login = ?")) {

            stmt.setString(1, hashed);
            stmt.setString(2, usuario);
            int rows = stmt.executeUpdate();

            if (rows > 0) {
                JOptionPane.showMessageDialog(null, "Senha atualizada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não encontrado.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_alterarbotaoActionPerformed

public void logErro(Exception e) {
    try (FileWriter writer = new FileWriter("log_acessos.txt", true)) {
        writer.write(LocalDateTime.now() + " - ERRO: " + e.getMessage() + "\n");
    } catch (IOException ex) {
        System.out.println("Erro ao registrar no log: " + ex.getMessage());
    }
}

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new samuel().setVisible(true);
        });
        try {
    File logFile = new File("log_acessos.txt");
    if (!logFile.exists()) {
        logFile.createNewFile(); // cria o arquivo vazio se não existir
    }
} catch (IOException e) {
    System.out.println("Erro ao criar o arquivo de log: " + e.getMessage());
}
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alterarbotao;
    private javax.swing.JButton cadastrarbotao;
    private javax.swing.JButton deletarbotao;
    private javax.swing.JButton entrarbotao;
    private javax.swing.JLabel logintxt;
    private javax.swing.JButton registrobotao;
    private javax.swing.JPasswordField senhafield1;
    private javax.swing.JLabel senhatxt;
    private javax.swing.JTextField usuariofield;
    private javax.swing.JLabel usuariotxt;
    // End of variables declaration//GEN-END:variables



public class PainelLog extends JFrame {

    public PainelLog() {
        setTitle("Painel de Log de Tentativas");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaTexto);
        add(scroll, BorderLayout.CENTER);

        try (BufferedReader br = new BufferedReader(new FileReader("log_acessos.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                areaTexto.append(linha + "\n");
            }
        } catch (IOException e) {
            areaTexto.setText("Erro ao ler o arquivo de log: " + e.getMessage());
        }
    }
}

}
