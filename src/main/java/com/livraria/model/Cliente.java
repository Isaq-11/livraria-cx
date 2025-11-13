package com.livraria.model;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("cliente")
public class Cliente extends PessoaFisica {

    @Column(name= "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false, length = 8)
    private String cep;

    //private BigDecimal limiteCredito;

    //??historico compras;

    public Cliente(){}
    public Cliente(String nomeCompleto, String cpf, String email, String telefone,
                   LocalDate dataNascimento, String endereco, String cep){
        super(nomeCompleto, cpf, email, telefone);
        this.dataNascimento= dataNascimento;
        this.endereco= endereco;
        this.cep= cep;}

    public LocalDate getDataNascimento(){return dataNascimento;}
    public void setDataNascimento(LocalDate dataNascimento){this.dataNascimento= dataNascimento;}

    public String getEndereco(){return endereco;}
    public void setEndereco(String endereco){this.endereco= endereco;}

    public String getCep(){return cep;}
    public void setCep(String cep){this.cep= cep;}
}
