package br.com.catolica.biblioteca;

public class Livro {

        private String titulo;
        private String autor;
        private String isbn;
        private int anoPublicacao;
        private int qtdEstoque;


        public Livro(String titulo, String autor, String isbn, int anoPublicacao, int qtdEstoque) {
            this.titulo = titulo;
            this.autor = autor;
            this.isbn = isbn;
            this.anoPublicacao = anoPublicacao;
            this.qtdEstoque = qtdEstoque;
        }

        public void exibirInfo() {
            System.out.println("Título: " + titulo);
            System.out.println("Autor: " + autor);
            System.out.println("ISBN: " + isbn);
            System.out.println("Ano de Publicação: " + anoPublicacao);
            System.out.println("Quantidade em Estoque: " + qtdEstoque);
        }

        public static void main(String[] args) {

            Livro livro1 = new Livro("Extraordinario", "Raquel Jaramillo Palacio", "9780370332284", 2012, 3);
            livro1.exibirInfo();
        }
}
