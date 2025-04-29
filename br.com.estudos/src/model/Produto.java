package model;

public class Produto {
    private Long id_produto;
    private String sku;
    private String nome_produto;
    private Long id_fornecedor;
    private Long id_categoria;
    private String imagem_produto;
    private Categoria categoria;

    public Long getid_produto() {
        return id_produto;
    }

    public void setid_produto(Long id_produto) {
        this.id_produto = id_produto;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public Long getId_fornecedor() {
        return id_fornecedor;
    }

    public void setId_fornecedor(Long id_fornecedor) {
        this.id_fornecedor = id_fornecedor;
    }

    public Long getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Long id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getImagem_produto() {
        return imagem_produto;
    }

    public void setImagem_produto(String imagem_produto) {
        this.imagem_produto = imagem_produto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}