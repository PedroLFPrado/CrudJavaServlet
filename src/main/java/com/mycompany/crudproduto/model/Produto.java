/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudproduto.model;

/**
 *
 * @author Pedro Lemos / Gustavo Henrique
 */
import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


@Entity
@Table(name = "produto")
public class Produto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(length = 100, nullable = false)
    private String descricao;

    // usar BigDecimal para representar preço com precisão
    @Column(nullable = false)
    private Double preco;

    @Column(nullable = false)
    private Integer qtde;

    public Produto() { }

    // getters e setters
    public Integer getCodigo() { return codigo; }
    public void setCodigo(Integer codigo) { this.codigo = codigo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Double getPreco() { return preco; }
    public void setPreco(Double preco) { this.preco = preco; }

    public Integer getQtde() { return qtde; }
    public void setQtde(Integer qtde) { this.qtde = qtde; }
}
