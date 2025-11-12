package com.livraria.model;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("funcionario")
public class Funcionario extends PessoaFisica {

    @Column(nullable = false)
    private String cargo;

    @Column(nullable = false)
    private LocalDate dataAdmissao;

    private BigDecimal salario;
    //data de desligamento da pra pensar num futuro

    public Funcionario(){}
    public Funcionario(String nomeCompleto, String cpf, String email, String telefone, String cargo,
                       LocalDate dataAdmissao, BigDecimal salario){
        super(nomeCompleto, cpf, email, telefone);
        this.cargo= cargo;
        this.dataAdmissao= dataAdmissao;
        this.salario= salario;
    }

    public String getCargo(){return cargo;}
    public void setCargo(String cargo){this.cargo= cargo;}

    public LocalDate getDataAdmissao(){return dataAdmissao;}
    public void setCargo(LocalDate dataAdmissao){this.dataAdmissao= dataAdmissao;}

    public BigDecimal getSalario(){return salario;}
    public void setSalario(BigDecimal salario){this.salario= salario;}
}
