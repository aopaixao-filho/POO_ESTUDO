package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Categoria;
import model.Produto;

public class ProdutoDAO {
    public void inserirProduto(Connection conn, Produto produto) throws SQLException {
        String sql = "INSERT INTO produto (nome_produto, sku, categoria_id) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome_produto());
            stmt.setString(2, produto.getSku());
            stmt.setInt(3, produto.getCategoria().getId());
            stmt.executeUpdate();
        }
    }

    public List<Produto> listarProdutos(Connection conn) throws SQLException {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT p.id, p.nome_produto, p.sku, c.id AS categoria_id, c.nome AS categoria_nome, c.descricao AS categoria_descricao " +
                     "FROM produto p INNER JOIN categoria c ON p.categoria_id = c.id";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setNome_produto(rs.getString("nome_produto"));
                produto.setSku(rs.getString("sku"));

                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("categoria_id"));
                categoria.setNome(rs.getString("categoria_nome"));
                categoria.setDescricao(rs.getString("categoria_descricao"));

                produto.setCategoria(categoria);
                produtos.add(produto);
            }
        }
        return produtos;
    }
}