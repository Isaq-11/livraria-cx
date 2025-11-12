package com.livraria.model;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name= "venda")
public class Venda {
    private Long id;
    private Livro livro;
    private Cliente cliente;
    private Funcionario funcionario;
    private LocalDateTime dataVenda;
    private BigDecimal valorTotal;

    private LocalDateTime dataCriacaoVenda;
    private LocalDateTime dataAtualizacaoVenda;

    public Venda(){}
    public Venda(Cliente cliente, Funcionario funcionario, LocalDateTime dataVenda,
                 BigDecimal valorTotal){
        this.cliente= cliente;
        this.funcionario= funcionario;
        this.dataVenda= dataVenda;
        this.valorTotal= valorTotal;
    }

    @PrePersist
    protected void onCreate(){this.dataCriacaoVenda= LocalDateTime.now();
        this.dataAtualizacaoVenda= LocalDateTime.now();}

    @PreUpdate
    protected void onUpdate(){
        this.dataAtualizacaoVenda= LocalDateTime.now();}

    public Cliente getCliente(){return cliente;}
    public void setCliente(Cliente cliente){this.cliente= cliente;}

    public Funcionario getFuncionario(){return funcionario;}
    public void setFuncionario(Funcionario funcionario){this.funcionario= funcionario;}

    public LocalDateTime getDataVenda(){return dataVenda;}
    public void setDataVenda(LocalDateTime dataVenda){this.dataVenda= dataVenda;}

    public BigDecimal getValorTotal(){return valorTotal;}
    public void setValorTotal(BigDecimal valorTotal){this.valorTotal= valorTotal;}

}
