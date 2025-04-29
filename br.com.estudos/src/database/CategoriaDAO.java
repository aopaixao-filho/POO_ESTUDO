package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Categoria;

public class CategoriaDAO {

    private static final String INSERT_SQL = "INSERT INTO categoria (id_categoria, nome_categoria) VALUES (?, ?)";
    private static final String SELECT_ALL_SQL = "SELECT id_categoria, nome_categoria FROM categoria";
    private static final String SELECT_BY_ID_SQL = "SELECT id_categoria, nome_categoria FROM categoria WHERE id_categoria = ?";


    public void inserirCategoria(Connection conn, Categoria c) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(INSERT_SQL)) {
            stmt.setInt(1, c.getid_categoria());
            stmt.setString(2, c.getnome_categoria());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Erro ao tentar inserir a categoria: " + e.getMessage(), e);
        }
    }

    public List<Categoria> listarCategorias(Connection conn) throws SQLException {
        List<Categoria> categorias = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_SQL);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setid_categoria(rs.getInt("id_categoria"));
                categoria.setnome_categoria(rs.getString("nome_categoria"));
                categorias.add(categoria);
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao tentar listar as categorias: " + e.getMessage(), e);
        }
        return categorias;
    }

    public Categoria buscarCategoriaPorId(Connection conn, int id) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Categoria categoria = new Categoria();
                    categoria.setid_categoria(rs.getInt("id_categoria"));
                    categoria.setnome_categoria(rs.getString("nome_categoria"));
                    return categoria;
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar categoria por ID: " + e.getMessage(), e);
        }
    }
}