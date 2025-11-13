package com.livraria.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name= "tipo_pj", discriminatorType= DiscriminatorType.STRING, length = 20)
@Table(name= "pessoa_juridica")
public abstract class PessoaJuridica {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name= "nome_fantasia", nullable = false)
    private String nomeFantasia;

    @Column(name= "razao_social", unique = true, nullable = false)
    private String razaoSocial;

    @Column(unique = true, nullable = false, length = 14)
    private String cnpj;

    @Column(nullable = false)
    private String telefoneResponsavel;

    @Column(nullable = false)
    private String telefoneCorporativo;

    @Column(nullable = false)
    private String emailCorporativo;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false, length = 8)
    private String cep;

    @Column(name= "data_criacao_pj", nullable = false)
    private LocalDateTime dataCriacaoPJ;
    @Column(name= "data_atualizacao_pj", nullable = false)
    private LocalDateTime dataAtualizacaoPJ;

    public PessoaJuridica(){}
    public PessoaJuridica(String nomeFantasia, String razaoSocial, String cnpj, String telefoneResponsavel,
                          String telefoneCorporativo, String emailCorporativo,
                          String endereco, String cep){
        this.nomeFantasia= nomeFantasia;
        this.razaoSocial= razaoSocial;
        this.cnpj= cnpj;
        this.telefoneResponsavel= telefoneResponsavel;
        this.telefoneCorporativo= telefoneCorporativo;
        this.emailCorporativo= emailCorporativo;
        this.endereco= endereco;
        this.cep= cep;}

    @PrePersist
    protected void onCreatePJ(){
        this.dataCriacaoPJ= LocalDateTime.now();
        this.dataAtualizacaoPJ= LocalDateTime.now();}

    @PreUpdate
    protected void onUpdatePJ(){
        this.dataAtualizacaoPJ= LocalDateTime.now();}

    public String getNomeFantasia(){return nomeFantasia;}
    public void setNomeFantasia(String nomeFantasia){this.nomeFantasia= nomeFantasia;}

    public String getRazaoSocial(){return razaoSocial;}
    public void setRazaoSocial(String razaoSocial){this.razaoSocial= razaoSocial;}

    public String getCnpj(){return cnpj;}
    public void setCnpj(String cnpj){this.cnpj= cnpj;}

    public String getTelefoneResponsavel(){return telefoneResponsavel;}
    public void setTelefoneResponsavel(String telefoneResponsavel){this.telefoneResponsavel= telefoneResponsavel;}

    public String getTelefoneCorporativo(){return telefoneCorporativo;}
    public void setTelefoneCorporativo(String telefoneCorporativo){this.telefoneCorporativo= telefoneCorporativo;}

    public String getEmailCorporativo(){return emailCorporativo;}
    public void setEmailCorporativo(String emailCorporativo){this.emailCorporativo= emailCorporativo;}

    public String getEndereco(){return endereco;}
    public void setEndereco(String endereco){this.endereco= endereco;}

    public String getCep(){return cep;}
    public void setCep(String cep){this.cep= cep;}

    public Long getId(){return id;}
    public LocalDateTime getDataCriacaoPJ(){return dataCriacaoPJ;}
    public LocalDateTime getDataAtualizacaoPJ(){return dataAtualizacaoPJ;}




}
