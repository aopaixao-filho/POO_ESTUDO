package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Categoria;

public class CategoriaDAO {
    private static final String INSERT_SQL = "INSERT INTO categoria (nome_categoria, id_categoria) VALUES (?, ?)";
    private static final String SELECT_ALL_SQL = "SELECT id, nome_categoria, id_categoria FROM categoria";
    private static final String SELECT_BY_ID_SQL = "SELECT id, nome_categoria, id_categoria FROM categoria WHERE id = ?";

    public void inserirCategoria(Connection conn, Categoria categoria) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(INSERT_SQL)) {
            stmt.setString(1, categoria.getnome_categoria());
            stmt.setInt(2, categoria.getid_categoria());
            stmt.executeUpdate();
        }
    }

    public List<Categoria> listarCategorias(Connection conn) throws SQLException {
        List<Categoria> categorias = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_SQL);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setid_categoria(rs.getInt("id"));
                categoria.setnome_categoria(rs.getString("nome"));
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
                    categoria.setid_categoria(rs.getInt("id"));
                    categoria.setnome_categoria(rs.getString("nome"));
                }
            }
        }
        return categoria;
    }
}