package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Fornecedor;

public class FornecedorDAO {
    private static final String INSERT_SQL =
        "INSERT INTO fornecedor (razao_social, nome_fantasia, cnpj, bairro, cpf, email, telefone, uf, logradouro, complemento, numero, cep, municipio) " +
        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String SELECT_ALL_SQL =
        "SELECT razao_social, nome_fantasia, cnpj, cpf, email, logradouro, municipio, cep, bairro, uf, complemento, numero " +
        "FROM fornecedor";

    public void inserirFornecedor(Connection conn, Fornecedor f) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(INSERT_SQL)) {
            stmt.setString(1, f.getRazao_social());
            stmt.setString(2, f.getNome_fantasia());
            stmt.setString(3, f.getCnpj());
            stmt.setString(4, f.getBairro());
            stmt.setString(5, f.getCpf());
            stmt.setString(6, f.getEmail());
            stmt.setString(7, f.getTelefone());
            stmt.setString(8, f.getUf());
            stmt.setString(9, f.getLogradouro());
            stmt.setString(10, f.getComplemento());
            stmt.setString(11, f.getNumero());
            stmt.setString(12, f.getCep());
            stmt.setString(13, f.getMunicipio());

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
                fornecedor.setRazao_social(rs.getString("razao_social"));
                fornecedor.setNome_fantasia(rs.getString("nome_fantasia"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setCpf(rs.getString("cpf"));
                fornecedor.setEmail(rs.getString("email"));
                fornecedor.setLogradouro(rs.getString("logradouro"));
                fornecedor.setMunicipio(rs.getString("municipio"));
                fornecedor.setCep(rs.getString("cep"));
                fornecedor.setBairro(rs.getString("bairro"));
                fornecedor.setUf(rs.getString("uf"));
                fornecedor.setComplemento(rs.getString("complemento"));
                fornecedor.setNumero(rs.getString("numero"));

                fornecedores.add(fornecedor);
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao tentar listar os fornecedores: " + e.getMessage(), e);
        }
        return fornecedores;
    }
}
