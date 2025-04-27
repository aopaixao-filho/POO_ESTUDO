package model;

import java.util.ArrayList;
import java.util.List;

public class Fornecedor {
    private String razao_social;
    private String uf;
    private String telefone;
    private String email;
    private String nome_fantasia;
    private String status_situacao;
    private String bairro;
    private String logradouro;
    private String numero;
    private String complemento;
    private String cpf;
    private String cep;
    private String cnpj;
    private String municipio;
    private List<Produto> produtos;

    public Fornecedor(String razao_social, String uf, String telefone, String email, String nome_fantasia,
                      String status_situacao, String bairro, String logradouro, String numero, String complemento,
                      String cpf, String cep, String cnpj, String municipio) {
        this.razao_social = razao_social;
        this.uf = uf;
        this.telefone = telefone;
        this.email = email;
        this.nome_fantasia = nome_fantasia;
        this.status_situacao = status_situacao;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cpf = cpf;
        this.cep = cep;
        this.cnpj = cnpj;
        this.municipio = municipio;
        this.produtos = new ArrayList<>();
    }

    public Fornecedor() {
        this.produtos = new ArrayList<>();
    }

    // Getters and Setters
    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
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

    public String getNome_fantasia() {
        return nome_fantasia;
    }

    public void setNome_fantasia(String nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
    }

    public String getStatus_situacao() {
        return status_situacao;
    }

    public void setStatus_situacao(String status_situacao) {
        this.status_situacao = status_situacao;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Fornecedor{");
        sb.append("razao_social=").append(razao_social);
        sb.append(", uf=").append(uf);
        sb.append(", telefone=").append(telefone);
        sb.append(", email=").append(email);
        sb.append(", nome_fantasia=").append(nome_fantasia);
        sb.append(", status_situacao=").append(status_situacao);
        sb.append(", bairro=").append(bairro);
        sb.append(", logradouro=").append(logradouro);
        sb.append(", numero=").append(numero);
        sb.append(", complemento=").append(complemento);
        sb.append(", cpf=").append(cpf);
        sb.append(", cep=").append(cep);
        sb.append(", cnpj=").append(cnpj);
        sb.append(", municipio=").append(municipio);
        sb.append('}');
        return sb.toString();
    }
}
