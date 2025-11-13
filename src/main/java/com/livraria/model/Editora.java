package com.livraria.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("editora")
public class Editora extends PessoaJuridica{

    @Column(name= "ano_fundacao", nullable = false)
    private int anoFundacao;

    @Column(name= "editor_chefe", nullable = false)
    private String editorChefe;

    @Column(name= "qtde_titulos_publicados")
    private int titulosPublicados= 0; // nao passei no construtor pq quero que seja incrementado automaticamente

    public Editora(){}
    public Editora(String nomeFantasia, String razaoSocial, String cnpj, String telefoneResponsavel,
                   String telefoneCorporativo, String emailCorporativo, String endereco, String cep,
                   int  anoFundacao, String editorChefe){
        super(nomeFantasia, razaoSocial, cnpj, telefoneResponsavel, telefoneCorporativo,
                emailCorporativo, endereco, cep);
        this.anoFundacao= anoFundacao;
        this.editorChefe= editorChefe;
    }

    public int getAnoFundacao(){return anoFundacao;}
    public void setAnoFundacao(int anoFundacao){this.anoFundacao= anoFundacao;}

    public String getEditorChefe(){return editorChefe;}
    public void setEditorChefe(String editorChefe){this.editorChefe= editorChefe;}

    public int getTitulosPublicados(){return titulosPublicados;}
}
