package com.livraria.model;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("fornecedor")
public class Fornecedor extends PessoaJuridica{

    @Column(name= "nome_representante", nullable = false)
    private String representanteNome;

    @Column(name= "inscricao_estadual", nullable = false)
    private String inscricaoEstadual;

    public Fornecedor(){}
    public Fornecedor(String nomeFantasia, String razaoSocial, String cnpj, String inscricaoEstadual,
                      String representanteNome, String telefoneResponsavel, String telefoneCorporativo,
                      String emailCorporativo, String endereco, String cep){
        super(nomeFantasia, razaoSocial, cnpj, telefoneResponsavel, telefoneCorporativo, emailCorporativo,
                endereco, cep);
        this.representanteNome= representanteNome;
        this.inscricaoEstadual= inscricaoEstadual;}

    public String getRepresentanteNome(){return  representanteNome;}
    public void setRepresentanteNome(String representanteNome){this.representanteNome= representanteNome;}

    public String getInscricaoEstadual(){return  inscricaoEstadual;}
    public void setInscricaoEstadual(String inscricaoEstadual){this.inscricaoEstadual= inscricaoEstadual;}

    

}
