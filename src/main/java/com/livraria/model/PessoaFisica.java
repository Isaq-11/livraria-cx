package com.livraria.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name= "tipo", discriminatorType = DiscriminatorType.STRING, length = 20)
@Table(name= "pessoa")
public abstract class PessoaFisica {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //@ManyToOne -== pensar melhor se devo implementar aqui, pois pra salvar um cliente/funcionario teria
    //@JoinColumn(name= "endereco_id") == que persistir o endereco e dps salvar ele, o endereço e por fim persistir td
    //private Endereco endereco;

    @Column(name= "nome_completo", nullable = false)
    private String nomeCompleto;

    @Column(unique = true, length = 11, nullable = false)
    private String cpf;

    @Column(unique = true, length = 50, nullable = false)
    private String email;

    @Column(length = 20, nullable = false)
    private String telefone;

    private LocalDateTime dataCriação;
    private LocalDateTime dataAtualização;

    public PessoaFisica(){}
    public PessoaFisica(String nomeCompleto, String cpf, String email, String telefone){
        this.nomeCompleto= nomeCompleto;
        this.cpf= cpf;
        this.email= email;
        this.telefone= telefone;}

    @PrePersist
    protected void onCreate(){this.dataCriação= LocalDateTime.now();
        this.dataAtualização= LocalDateTime.now();}

    @PreUpdate
    protected void onUpdate(){this.dataAtualização= LocalDateTime.now();}

    public String getNomeCompleto(){return nomeCompleto;}
    public void setNomeCompleto(String nomeCompleto){this.nomeCompleto= nomeCompleto;}

    public String getCpf(){return cpf;}
    public void setCpf(String cpf){this.cpf= cpf;}

    public String getEmail(){return email;}
    public void setEmail(String email){this.email= email;}

    public String getTelefone(){return telefone;}
    public void setTelefone(String telefone){this.telefone= telefone;}

}
