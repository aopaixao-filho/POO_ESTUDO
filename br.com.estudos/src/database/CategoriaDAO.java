package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Categoria;

public class CategoriaDAO {
    private static final String INSERT_SQL = "INSERT INTO categoria (nome, descricao) VALUES (?, ?)";
    private static final String SELECT_ALL_SQL = "SELECT id, nome, descricao FROM categoria";
    private static final String SELECT_BY_ID_SQL = "SELECT id, nome, descricao FROM categoria WHERE id = ?";

    public void inserirCategoria(Connection conn, Categoria categoria) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(INSERT_SQL)) {
            stmt.setString(1, categoria.getNome());
            stmt.setString(2, categoria.getDescricao());
            stmt.executeUpdate();
        }
    }

    public List<Categoria> listarCategorias(Connection conn) throws SQLException {
        List<Categoria> categorias = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_SQL);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("id"));
                categoria.setNome(rs.getString("nome"));
                categoria.setDescricao(rs.getString("descricao"));
                categorias.add(categoria);
            }
        }
        return categorias;
    }

    public Categoria buscarCategoriaPorId(Connection conn, int id) throws SQLException {
        Categoria categoria = null;
        try (PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    categoria = new Categoria();
                    categoria.setId(rs.getInt("id"));
                    categoria.setNome(rs.getString("nome"));
                    categoria.setDescricao(rs.getString("descricao"));
                }
            }
        }
        return categoria;
    }
}