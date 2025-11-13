package com.livraria.model;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name= "venda_item")
public class VendaItem {
    private Long id;
    private Venda idVenda;
    private Livro idLivro;
    private int quantidade;
    private BigDecimal valorUnitario;

    private LocalDateTime dataCriacaoVendaItem;
    private LocalDateTime dataAtualizacaoVendaItem;

    public VendaItem(){}
    public VendaItem(Venda idVenda, Livro idLivro, int quantidade, BigDecimal valorUnitario){
        this.idVenda= idVenda;
        this.idLivro= idLivro;
        this.quantidade= quantidade;
        this.valorUnitario= valorUnitario;
    }
}
