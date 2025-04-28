package model;

public class Categoria {
    private int id_categoria;
    private String nome_categoria;
    

    public Categoria() {
    }

    public Categoria(int id, String nome, String descricao) {
        this.id_categoria = id_categoria;
        this.nome_categoria = nome_categoria;
    }

    public int getid_categoria() {
        return id_categoria;
    }

    public void setid_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getnome_categoria() {
        return nome_categoria;
    }

    public void setnome_categoria(String nome_categoria) {
        this.nome_categoria = nome_categoria;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id_categoria +
                ", nome='" + nome_categoria + '\'' +
                '}';
    }
}