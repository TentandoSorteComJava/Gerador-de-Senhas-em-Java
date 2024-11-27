import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeradorDeSenhasGUI extends JFrame {
    private GeradorDeSenha geradorDeSenha;
    public GeradorDeSenhasGUI(){
        super("Gerador de Senhas");
        setSize(540,570);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        geradorDeSenha = new GeradorDeSenha();
        addGuiComponentes();
    }

    private void addGuiComponentes(){
        JLabel titleLabel = new JLabel("Gerador de Senhas");

        titleLabel.setFont(new Font("Dialog", Font.BOLD,32));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(0,10,540,39);
        add(titleLabel);
        JTextArea senhaOutput = new JTextArea();
        senhaOutput.setEditable(false);
        senhaOutput.setFont(new Font("Dialog",Font.BOLD,32));
        JScrollPane senhaOutputPane = new JScrollPane(senhaOutput);
        senhaOutputPane.setBounds(25,97,479,70);
        senhaOutputPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(senhaOutputPane);
        JLabel tamanhoSenhaLabel = new JLabel("Tamanho Senha: ");
        tamanhoSenhaLabel.setFont(new Font("Dialog", Font.PLAIN, 32));
        tamanhoSenhaLabel.setBounds(25,215,272,39);
        add(tamanhoSenhaLabel);

        JTextArea tamanhoSenhaInputArea = new JTextArea();
        tamanhoSenhaInputArea.setFont(new Font("Dialog",Font.PLAIN,32));
        tamanhoSenhaInputArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tamanhoSenhaInputArea.setBounds(310,215,192,39);
        add(tamanhoSenhaInputArea);

        JToggleButton upperCaseToggle = new JToggleButton("Maiúscula");
        upperCaseToggle.setFont(new Font("Dialog", Font.PLAIN,26));
        upperCaseToggle.setBounds(25,302,225,56);
        add(upperCaseToggle);

        JToggleButton lowerCaseToggle = new JToggleButton("Minúscula");
        lowerCaseToggle.setFont(new Font("Dialog", Font.PLAIN,26));
        lowerCaseToggle.setBounds(282, 302,225,56);
        add(lowerCaseToggle);

        JToggleButton numbersToggle = new JToggleButton("Números");
        numbersToggle.setFont(new Font("Dialog", Font.PLAIN,26));
        numbersToggle.setBounds(25,373,225,56);
        add(numbersToggle);

        JToggleButton symbolsToggle = new JToggleButton("Símbolos");
        symbolsToggle.setFont(new Font("Dialog", Font.PLAIN,26));
        symbolsToggle.setBounds(282,373,225,56);
        add(symbolsToggle);

        JButton generateButton = new JButton("Gerar");
        generateButton.setFont(new Font("Dialog",Font.PLAIN,32));
        generateButton.setBounds(155,477,222,41);
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tamanhoSenhaInputArea.getText().length() <= 0) return;
                boolean anyToggleSelected = lowerCaseToggle.isSelected() ||
                        upperCaseToggle.isSelected() ||
                        numbersToggle.isSelected() ||
                        symbolsToggle.isSelected();

                int tamanhoSenha = Integer.parseInt(tamanhoSenhaInputArea.getText());
                if (anyToggleSelected){
                    String geradoSenha = geradorDeSenha.gerarSenha(tamanhoSenha,
                            upperCaseToggle.isSelected(),
                            lowerCaseToggle.isSelected(),
                            numbersToggle.isSelected(),
                            symbolsToggle.isSelected());

                    senhaOutput.setText(geradoSenha);
                }
            }
        });
        add(generateButton);



    }
}
