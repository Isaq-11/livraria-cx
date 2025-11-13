package com.livraria.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name= "venda")
public class Venda {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name= "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name= "funcionario_id", nullable = false)
    private Funcionario funcionario;

    @Column(name= "data_venda", nullable = false)
    private LocalDateTime dataVenda;

    @Column(name= "valor_total", nullable = false, precision= 10, scale= 2)
    private BigDecimal valorTotal;

    @Column(name= "data_criacao_venda", nullable = false)
    private LocalDateTime dataCriacaoVenda;
    @Column(name= "data_atualizacao_venda", nullable = false)
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
    protected void onCreateVenda(){
        this.dataCriacaoVenda= LocalDateTime.now();
        this.dataAtualizacaoVenda= LocalDateTime.now();}

    @PreUpdate
    protected void onUpdateVenda(){
        this.dataAtualizacaoVenda= LocalDateTime.now();}

    public Cliente getCliente(){return cliente;}
    public void setCliente(Cliente cliente){this.cliente= cliente;}

    public Funcionario getFuncionario(){return funcionario;}
    public void setFuncionario(Funcionario funcionario){this.funcionario= funcionario;}

    public LocalDateTime getDataVenda(){return dataVenda;}
    public void setDataVenda(LocalDateTime dataVenda){this.dataVenda= dataVenda;}

    public BigDecimal getValorTotal(){return valorTotal;}
    public void setValorTotal(BigDecimal valorTotal){this.valorTotal= valorTotal;}

    public Long getId(){return id;}
    public LocalDateTime getDataCriacaoVenda(){return dataCriacaoVenda;}
    public LocalDateTime getDataAtualizacaoVenda(){return dataAtualizacaoVenda;}

}
