package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Categoria;
import model.Produto;

public class ProdutoDAO {

    // Adicionado id_fornecedor na query de inserção
    private static final String INSERT_SQL = "INSERT INTO produto (nome_produto, sku, id_categoria, id_fornecedor) VALUES (?, ?, ?, ?)";
    private static final String SELECT_ALL_SQL = "SELECT p.id_produto, p.nome_produto, p.sku, c.id_categoria, c.nome_categoria FROM produto p JOIN categoria c ON p.id_categoria = c.id_categoria";


    public void inserirProduto(Connection conn, Produto p) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(INSERT_SQL)) {
            stmt.setString(1, p.getNome_produto());
            stmt.setString(2, p.getSku());
            stmt.setInt(3, p.getCategoria().getid_categoria());
            // Adicionado o binding para id_fornecedor
            stmt.setLong(4, p.getId_fornecedor());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Erro ao tentar inserir o produto: " + e.getMessage(), e);
        }
    }

    public List<Produto> listarProdutos(Connection conn) throws SQLException {
        List<Produto> produtos = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_SQL);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setid_produto(rs.getLong("id_produto"));
                produto.setNome_produto(rs.getString("nome_produto"));
                produto.setSku(rs.getString("sku"));

                Categoria categoria = new Categoria();
                categoria.setid_categoria(rs.getInt("id_categoria"));
                categoria.setnome_categoria(rs.getString("nome_categoria"));
                produto.setCategoria(categoria);

                produtos.add(produto);
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao tentar listar os produtos: " + e.getMessage(), e);
        }
        return produtos;
    }
}