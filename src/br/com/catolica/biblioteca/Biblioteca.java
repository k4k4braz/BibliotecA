package br.com.catolica.biblioteca;

public class Biblioteca {

    static String nome;
    static String endereco;
    static String[] titulos = new String[100];
    static String[] autores = new String[100];
    static int[] quantidades = new int[100];
    static int totalLivros = 0;

    public static boolean VerificacaoDeDisponibilidade(String titulo) {
        for (int i = 0; i < totalLivros; i++) {
            if (titulos[i].equals(titulo) && quantidades[i] > 0) {
                return true;
            }
        }
        return false;
    }

    public static String CadastroDeLivros(String titulo, String autor, int quantidade) {
        if (totalLivros >= 100) {
            return "Limite de 100 livros atingido.";
        }
        for (int i = 0; i < totalLivros; i++) {
            if (titulos[i].equals(titulo)) {
                quantidades[i] += quantidade;
                return "O livro '" + titulo + "' foi atualizado com mais " + quantidade + " exemplares.";
            }
        }
        titulos[totalLivros] = titulo;
        autores[totalLivros] = autor;
        quantidades[totalLivros] = quantidade;
        totalLivros++;
        return "Livro '" + titulo + "' cadastrado com sucesso.";
    }

    public static String LocalizacaoDeTitulo(String titulo) {
        for (int i = 0; i < totalLivros; i++) {
            if (titulos[i].equals(titulo)) {
                return "Livro encontrado: Título: " + titulos[i] + ", Autor: " + autores[i] + ", Quantidade: " + quantidades[i];
            }
        }
        return "Livro '" + titulo + "' não encontrado.";
    }

    public static String LocalizacaoDeLivrosDoAutor(String autor) {
        //meti no chat gpt aqui pq n sabia como fzr ler o append la de baixo
        StringBuilder resultado = new StringBuilder("Livros encontrados do autor " + autor + ":\n");
        boolean encontrou = false;
        for (int i = 0; i < totalLivros; i++) {
            if (autores[i].equals(autor)) {
                //fazer um append igual no python
                resultado.append("Título: ").append(titulos[i]).append(", Quantidade: ").append(quantidades[i]).append("\n");
                encontrou = true;
            }
        }
        return encontrou ? resultado.toString() : "Nenhum livro do autor '" + autor + "' foi encontrado.";
    }

    public static String Entregar(String titulo) {
        for (int i = 0; i < totalLivros; i++) {
            if (titulos[i].equals(titulo)) {
                quantidades[i]++;
                return "Livro '" + titulo + "' devolvido com sucesso. Quantidade atual: " + quantidades[i];
            }
        }
        return "Livro '" + titulo + "' nao encontrado para devoluçao.";
    }

    public static String Emprestimo(String titulo) {
        for (int i = 0; i < totalLivros; i++) {
            if (titulos[i].equals(titulo)) {
                if (quantidades[i] > 0) {
                    quantidades[i]--;
                    return "Livro '" + titulo + "' emprestado com sucesso. Quantidade restante: " + quantidades[i];
                } else {
                    return "Livro '" + titulo + "' está indisponivel no momento.";
                }
            }
        }
        return "Livro '" + titulo + "' nao encontrado para emprestimo.";
    }

    public static String ExibirInformacao(String titulo) {
        for (int i = 0; i < totalLivros; i++) {
            if (titulos[i].equals(titulo)) {
                return "Informações do Livro:\nTítulo: " + titulos[i] + "\nAutor: " + autores[i] + "\nQuantidade disponível: " + quantidades[i];
            }
        }
        return "Livro '" + titulo + "' não encontrado.";
    }

    public static void main(String[] args) {
        nome = "Biblioteca Municipal";
        endereco = "Centro, 123";

        System.out.println(CadastroDeLivros("Java para Iniciantes", "Herbert Schildt", 10));
        System.out.println(CadastroDeLivros("Python Avançado", "Elizeu Barbosa Abreu", 5));

        System.out.println(LocalizacaoDeTitulo("Java para Iniciantes"));
        System.out.println(LocalizacaoDeLivrosDoAutor("Herbert Schildt"));

        System.out.println(Emprestimo("Java para Iniciantes"));
        System.out.println(Entregar("Java para Iniciantes"));
        System.out.println(ExibirInformacao("Java para Iniciantes"));
    }
}
