package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Fornecedor {
    private int idFornecedor;
    private String tipo;
    private String razaoSocial;
    private String cnpj;
    private String uf;
    private String telefone;
    private String email;
    private String nomeFantasia;
    private String statusSituacao;
    private String bairro;
    private String logradouro;
    private String numero;
    private String complemento;
    private String cep;
    private String municipio;
    private Date dataAbertura;
    private List<Produto> produtos;

    public Fornecedor(String tipo, String razaoSocial, String cnpj, String uf, String telefone,
                      String email, String nomeFantasia, String statusSituacao, String bairro, String logradouro,
                      String numero, String complemento, String cep, String municipio, Date dataAbertura) {
        this.tipo = tipo;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.uf = uf;
        this.telefone = telefone;
        this.email = email;
        this.nomeFantasia = nomeFantasia;
        this.statusSituacao = statusSituacao;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.municipio = municipio;
        this.dataAbertura = dataAbertura;
        this.produtos = new ArrayList<>();
    }

    public Fornecedor() {
        this.produtos = new ArrayList<>();
    }

    // Getters and Setters
    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getStatusSituacao() {
        return statusSituacao;
    }

    public void setStatusSituacao(String statusSituacao) {
        this.statusSituacao = statusSituacao;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

        @Override
        public String toString() {
            return "--- Fornecedor ---" +
                   "\n  ID: " + idFornecedor +
                   "\n  Tipo: " + (tipo != null ? tipo : "N/A") +
                   "\n  Razão Social: " + razaoSocial +
                   "\n  Nome Fantasia: " + nomeFantasia +
                   "\n  CNPJ: " + cnpj +
                   "\n  Status: " + statusSituacao +
                   "\n  Contato:" +
                   "\n    Telefone: " + telefone +
                   "\n    Email: " + email +
                   "\n  Endereço:" +
                   "\n    Logradouro: " + logradouro + ", " + numero + (complemento != null && !complemento.isEmpty() ? " - " + complemento : "") +
                   "\n    Bairro: " + bairro +
                   "\n    Município: " + municipio + " - " + uf +
                   "\n    CEP: " + cep +
                   "\n  Data Abertura: " + (dataAbertura != null ? dataAbertura : "N/A");
        }
}