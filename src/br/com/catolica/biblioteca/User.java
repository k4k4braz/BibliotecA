package br.com.catolica.biblioteca;

public class User {

    private String nome;
    private String id;
    private String email;
    private Livro[] livrosGuardado;
    private int LIMITE_LIVROS = 5;
    private int qtdLivros;

    public User(String nome, String id, String email) {
        this.nome = nome;
        this.id = id;
        this.email = email;
        this.livrosGuardado = new Livro[LIMITE_LIVROS];
        this.qtdLivros = 0;
    }

    public void exibirInfo() {
        System.out.println("Nome: " + nome);
        System.out.println("ID: " + id);
        System.out.println("Email: " + email);
        System.out.println("Livros guardado: ");
        if (qtdLivros == 0) {
            System.out.println("Nenhum livro guardado.");
        } else {
            for (int i = 0; i < qtdLivros; i++) {
                System.out.println("- " + livrosGuardado[i]);
            }
        }
    }

    public boolean adicionarLivro(Livro livro) {
        if (qtdLivros < LIMITE_LIVROS) {
            livrosGuardado[qtdLivros] = livro;
            qtdLivros++;
            System.out.println("Livro" + "adicionado.");
            return true;
        } else {
            System.out.println("Limite de" + LIMITE_LIVROS + "livros atingido.");
            return false;
        }
    }

    public boolean removerLivro(Livro livro) {
        for (int i = 0; i < qtdLivros; i++) {
            if (livrosGuardado[i].equals(livro)) {

                for (int j = i; j < qtdLivros - 1; j++) {
                    livrosGuardado[j] = livrosGuardado[j + 1];
                }
                livrosGuardado[qtdLivros - 1] = null;
                qtdLivros--;
                System.out.println("Livro" + "removido.");
                return true;
            }
        }
        System.out.println("O livro não está na posse do usuario.");
        return false;
    }
}
