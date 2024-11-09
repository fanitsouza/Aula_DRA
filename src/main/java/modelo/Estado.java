package modelo;

import javax.persistence.*;

@Entity
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nomeEstado", nullable = false)
    private String nome;
    @Column(name = "ibgeEstado", nullable = false, length = 7)
    private String ibge;

    public Estado() {
    }

    public Estado(String nome, String ibge) {
        this.nome = nome;
        this.ibge = ibge;
    }

    public Estado(String ibge, String nome, Long id) {
        this.ibge = ibge;
        this.nome = nome;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIbge() {
        return ibge;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }
}
