package questoes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Jogo extends JFrame {
    
    private JPanel painelPrincipal;
    private JPanel painelCreditos;
    private JPanel painelPergunta;
    private JPanel painelConfirmacao;
    private JPanel painelFimDeJogo;
    private CardLayout cardLayout;

    private GeraPergunta geraPergunta;
    private Pergunta perguntaAtual;
    private int perguntaID = 1;
    private int acertos = 0;
    private int erros = 0;
    
    public Jogo() {
        geraPergunta = new GeraPergunta();
        perguntaAtual = geraPergunta.DefinePergunta(perguntaID);

        // Configurações da janela
        setTitle("GamIFique");
        setUndecorated(true); // Remove a barra de título
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximiza a janela para cobrir toda a tela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Usando CardLayout para gerenciar múltiplas telas
        cardLayout = new CardLayout();
        setLayout(cardLayout);

        // Criando o painel principal
        painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BorderLayout());

        // Adicionando o título
        JLabel titulo = new JLabel("GamIFique", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        painelPrincipal.add(titulo, BorderLayout.NORTH);

        // Criando os botões
        JButton botaoIniciar = new JButton("Iniciar Jogo");
        JButton botaoCreditos = new JButton("Créditos");
        JButton botaoSair = new JButton("Sair");

        // Adicionando os botões ao painel em orientação vertical
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new BoxLayout(painelBotoes, BoxLayout.Y_AXIS));
        painelBotoes.add(Box.createRigidArea(new Dimension(0, 10)));
        painelBotoes.add(botaoIniciar);
        painelBotoes.add(Box.createRigidArea(new Dimension(0, 10)));
        painelBotoes.add(botaoCreditos);
        painelBotoes.add(Box.createRigidArea(new Dimension(0, 10)));
        painelBotoes.add(botaoSair);
        painelBotoes.add(Box.createRigidArea(new Dimension(0, 10)));

        // Criando um painel para centralizar os botões horizontalmente
        JPanel painelCentral = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painelCentral.add(painelBotoes);

        painelPrincipal.add(painelCentral, BorderLayout.CENTER);

        // Adicionando ações aos botões
        botaoIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarTelaPergunta();
            }
        });

        botaoCreditos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarTelaCreditos();
            }
        });

        botaoSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Criando o painel de créditos
        painelCreditos = new JPanel();
        painelCreditos.setLayout(new BorderLayout());

        JLabel textoCreditos = new JLabel("Créditos", SwingConstants.CENTER);
        textoCreditos.setFont(new Font("Arial", Font.BOLD, 24));
        painelCreditos.add(textoCreditos, BorderLayout.CENTER);

        JButton botaoVoltar = new JButton("Voltar");
        painelCreditos.add(botaoVoltar, BorderLayout.SOUTH);

        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarTelaPrincipal();
            }
        });

        // Criando o painel de pergunta
        painelPergunta = new JPanel();
        painelPergunta.setLayout(new BorderLayout());

        // Carregando e redimensionando a imagem
        String caminhoImagem = "C:/Users/filho/OneDrive/Área de Trabalho/GamIFique/IMG/imagem1.jpg";
        ImageIcon imagemIcon = new ImageIcon(caminhoImagem);
        Image imagem = imagemIcon.getImage();
        Image imagemRedimensionada = imagem.getScaledInstance(480, 480, Image.SCALE_SMOOTH);
        ImageIcon imagemRedimensionadaIcon = new ImageIcon(imagemRedimensionada);
        JLabel imagemLabel = new JLabel(imagemRedimensionadaIcon);
        painelPergunta.add(imagemLabel, BorderLayout.WEST);

        // Texto da pergunta com JTextArea para ajuste automático
        JTextArea textoPergunta = new JTextArea("Digitar pergunta");
        textoPergunta.setFont(new Font("Arial", Font.BOLD, 24));
        textoPergunta.setLineWrap(true); // Quebra de linha automática
        textoPergunta.setWrapStyleWord(true); // Quebra de linha em palavras
        textoPergunta.setEditable(false); // Não editável
        textoPergunta.setPreferredSize(new Dimension(0, 200)); // Altura fixa
        textoPergunta.setOpaque(false); // Fundo transparente

        JScrollPane scrollPaneTexto = new JScrollPane(textoPergunta);
        scrollPaneTexto.setBorder(BorderFactory.createEmptyBorder()); // Remove borda padrão

        painelPergunta.add(scrollPaneTexto, BorderLayout.NORTH);

        // Botões abaixo do texto
        JPanel painelBotoesPergunta = new JPanel();
        painelBotoesPergunta.setLayout(new BoxLayout(painelBotoesPergunta, BoxLayout.Y_AXIS));
        for (int i = 1; i <= 5; i++) {
            JButton botao = new JButton("Botão " + i);
            painelBotoesPergunta.add(Box.createRigidArea(new Dimension(0, 10)));
            painelBotoesPergunta.add(botao);
        }
        JScrollPane scrollPane = new JScrollPane(painelBotoesPergunta);
        painelPergunta.add(scrollPane, BorderLayout.CENTER);

        // Criando o painel de confirmação
        painelConfirmacao = new JPanel();
        painelConfirmacao.setLayout(new BorderLayout());

        // Adicionando o texto de confirmação
        JLabel textoConfirmacao = new JLabel("Resposta: ", SwingConstants.CENTER);
        textoConfirmacao.setFont(new Font("Arial", Font.BOLD, 24));
        painelConfirmacao.add(textoConfirmacao, BorderLayout.CENTER);

        // Painel para a imagem de confirmação
        JPanel painelImagemConfirmacao = new JPanel();
        painelConfirmacao.add(painelImagemConfirmacao, BorderLayout.EAST);

        // Botões Voltar e Avançar
        JPanel painelBotoesConfirmacao = new JPanel();
        painelBotoesConfirmacao.setLayout(new FlowLayout());

        JButton botaoVoltarConfirmacao = new JButton("Sair");
        JButton botaoAvancarConfirmacao = new JButton("Avançar");

        painelBotoesConfirmacao.add(botaoVoltarConfirmacao);
        painelBotoesConfirmacao.add(botaoAvancarConfirmacao);

        painelConfirmacao.add(painelBotoesConfirmacao, BorderLayout.SOUTH);

        botaoVoltarConfirmacao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarTelaPrincipal();
            }
        });

        botaoAvancarConfirmacao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (perguntaID < 5) {
                    perguntaID++;
                    perguntaAtual = geraPergunta.DefinePergunta(perguntaID);
                    mostrarTelaPergunta();
                } else {
                    mostrarTelaFimDeJogo();
                }
            }
        });

        // Criando o painel de fim de jogo
        painelFimDeJogo = new JPanel();
        painelFimDeJogo.setLayout(new BorderLayout());

        JLabel textoFimDeJogo = new JLabel("Fim de Jogo", SwingConstants.CENTER);
        textoFimDeJogo.setFont(new Font("Arial", Font.BOLD, 24));
        painelFimDeJogo.add(textoFimDeJogo, BorderLayout.NORTH);

        JLabel textoResultado = new JLabel("Acertos: " + acertos + " | Erros: " + erros, SwingConstants.CENTER);
        textoResultado.setFont(new Font("Arial", Font.BOLD, 24));
        painelFimDeJogo.add(textoResultado, BorderLayout.CENTER);

        JButton botaoSairFimDeJogo = new JButton("Sair");
        painelFimDeJogo.add(botaoSairFimDeJogo, BorderLayout.SOUTH);

        botaoSairFimDeJogo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zerarContadores(); // Zera os contadores ao sair
                mostrarTelaPrincipal();
            }
        });

        // Adicionando Painéis ao CardLayout
        add(painelPrincipal, "Principal");
        add(painelCreditos, "Creditos");
        add(painelPergunta, "Pergunta");
        add(painelConfirmacao, "Confirmacao");
        add(painelFimDeJogo, "FimDeJogo");

        // Mostra a tela principal inicialmente
        cardLayout.show(getContentPane(), "Principal");

        // Tornando a janela visível
        setVisible(true);
    }

    private void mostrarTelaCreditos() {
        cardLayout.show(getContentPane(), "Creditos");
    }

    private void mostrarTelaPergunta() {
        // Atualiza o texto da pergunta e os botões
        JTextArea textoPergunta = (JTextArea) ((JScrollPane) painelPergunta.getComponent(1)).getViewport().getView();
        textoPergunta.setText(perguntaAtual.getPerguntaTexto());

        // Atualiza as alternativas
        JPanel painelBotoesPergunta = (JPanel) ((JScrollPane) painelPergunta.getComponent(2)).getViewport().getView();
        painelBotoesPergunta.removeAll();
        for (String letra : perguntaAtual.getAlternativas().keySet()) {
            Alternativa alternativa = perguntaAtual.getAlternativa(letra);
            JButton botaoAlternativa = new JButton(letra + ": " + alternativa.getTexto());
            botaoAlternativa.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    verificarResposta(letra);
                }
            });
            painelBotoesPergunta.add(botaoAlternativa);
        }
        painelBotoesPergunta.revalidate();
        painelBotoesPergunta.repaint();

        // Atualiza a imagem
        String caminhoImagem = "C:/Users/filho/OneDrive/Área de Trabalho/GamIFique/IMG/imagem1.jpg";
        ImageIcon imagemIcon = new ImageIcon(caminhoImagem);
        Image imagem = imagemIcon.getImage();
        Image imagemRedimensionada = imagem.getScaledInstance(480, 480, Image.SCALE_SMOOTH);
        ImageIcon imagemRedimensionadaIcon = new ImageIcon(imagemRedimensionada);
        JLabel imagemLabel = (JLabel) painelPergunta.getComponent(0);
        imagemLabel.setIcon(imagemRedimensionadaIcon);

        cardLayout.show(getContentPane(), "Pergunta");
    }

    private void verificarResposta(String letraSelecionada) {
        Alternativa alternativaSelecionada = perguntaAtual.getAlternativa(letraSelecionada);
        Alternativa alternativaCorreta = perguntaAtual.getAlternativaCorreta();

        if (alternativaSelecionada.getEhCorreta()) {
            acertos++;
            mostrarTelaConfirmacao("Você acertou!", "imagem2.jpg");
        } else {
            erros++;
            mostrarTelaConfirmacao("Você errou! A resposta correta é: " + alternativaCorreta.getTexto(), "imagem3.jpg");
        }
    }

    private void mostrarTelaConfirmacao(String mensagem, String imagemNome) {
        // Atualiza o texto da confirmação
        JLabel textoConfirmacao = (JLabel) painelConfirmacao.getComponent(0);
        textoConfirmacao.setText(mensagem);

        // Atualiza o painel de imagem
        JPanel painelImagemConfirmacao = (JPanel) painelConfirmacao.getComponent(1);
        painelImagemConfirmacao.removeAll(); // Remove todos os componentes existentes

        String caminhoImagem = "C:/Users/filho/OneDrive/Área de Trabalho/GamIFique/IMG/" + imagemNome;
        ImageIcon imagemIcon = new ImageIcon(caminhoImagem);
        Image imagem = imagemIcon.getImage();
        Image imagemRedimensionada = imagem.getScaledInstance(480, 480, Image.SCALE_SMOOTH);
        ImageIcon imagemRedimensionadaIcon = new ImageIcon(imagemRedimensionada);
        JLabel imagemLabel = new JLabel(imagemRedimensionadaIcon);
        
        painelImagemConfirmacao.add(imagemLabel);
        painelImagemConfirmacao.revalidate(); // Revalida o painel para atualizar o layout
        painelImagemConfirmacao.repaint(); // Repinta o painel para garantir a atualização visual

        cardLayout.show(getContentPane(), "Confirmacao");
    }

    private void mostrarTelaFimDeJogo() {
        JLabel textoResultado = (JLabel) painelFimDeJogo.getComponent(1);
        textoResultado.setText("Acertos: " + acertos + " | Erros: " + erros);
        cardLayout.show(getContentPane(), "FimDeJogo");
    }

    private void mostrarTelaPrincipal() {
        cardLayout.show(getContentPane(), "Principal");
    }

    private void zerarContadores() {
        acertos = 0;
        erros = 0;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Jogo();
            }
        });
    }
}
