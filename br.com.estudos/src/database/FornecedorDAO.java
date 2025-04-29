package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Fornecedor;

public class FornecedorDAO {
    private static final String INSERT_SQL =
    "INSERT INTO fornecedor (razao_social, nome_fantasia, cnpj, uf, telefone, email, status_situacao, bairro, logradouro, numero, complemento, cep, municipio, data_abertura) " +
    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String SELECT_ALL_SQL =
        "SELECT id_fornecedor, tipo, razao_social, cnpj, uf, telefone, email, nome_fantasia, " +
        "status_situacao, bairro, logradouro, numero, complemento, cep, municipio, data_abertura " +
        "FROM fornecedor";

    public void inserirFornecedor(Connection conn, Fornecedor f) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(INSERT_SQL)) {

            stmt.setString(1, f.getRazaoSocial());
            stmt.setString(2, f.getNomeFantasia());
            stmt.setString(3, f.getCnpj());
            stmt.setString(4, f.getUf());
            stmt.setString(5, f.getTelefone());
            stmt.setString(6, f.getEmail());
            stmt.setString(7, f.getStatusSituacao());
            stmt.setString(8, f.getBairro());
            stmt.setString(9, f.getLogradouro());
            stmt.setString(10, f.getNumero());
            stmt.setString(11, f.getComplemento());
            stmt.setString(12, f.getCep());
            stmt.setString(13, f.getMunicipio());
            stmt.setDate(14, new java.sql.Date(f.getDataAbertura().getTime()));

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Erro ao tentar inserir os dados: " + e.getMessage(), e);
        }
    }

    public List<Fornecedor> listarFornecedores(Connection conn) throws SQLException {
        List<Fornecedor> fornecedores = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_SQL);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setTipo(rs.getString("tipo"));
                fornecedor.setRazaoSocial(rs.getString("razao_social"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setUf(rs.getString("uf"));
                fornecedor.setTelefone(rs.getString("telefone"));
                fornecedor.setEmail(rs.getString("email"));
                fornecedor.setNomeFantasia(rs.getString("nome_fantasia"));
                fornecedor.setStatusSituacao(rs.getString("status_situacao"));
                fornecedor.setBairro(rs.getString("bairro"));
                fornecedor.setLogradouro(rs.getString("logradouro"));
                fornecedor.setNumero(rs.getString("numero"));
                fornecedor.setComplemento(rs.getString("complemento"));
                fornecedor.setCep(rs.getString("cep"));
                fornecedor.setMunicipio(rs.getString("municipio"));
                fornecedor.setDataAbertura(rs.getDate("data_abertura"));

                fornecedores.add(fornecedor);
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao tentar listar os fornecedores: " + e.getMessage(), e);
        }
        return fornecedores;
    }
}