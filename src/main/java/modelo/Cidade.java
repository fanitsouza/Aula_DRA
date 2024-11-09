package modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "cidade")
public class Cidade {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "nomeEstado", nullable = false)
    private String nome;

    @Column(name = "ibgeEstado", nullable = false, length = 7)
    private String ibge;

    @ManyToOne
    private Estado estado;

    @OneToMany(mappedBy = "cidade", fetch = FetchType.EAGER)
    private List<Pessoa> pessoas = new ArrayList<>();



    public Cidade() {
    }

    public Cidade(String nome, String ibge, String estado) {
        this.nome = nome;
        this.ibge = ibge;
    }

    public Cidade(Long id, String nome, String ibge, String estado) {
        this.id = id;
        this.nome = nome;
        this.ibge = ibge;
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public void addPessoa(Pessoa pessoa){
        if(!this.pessoas.contains(pessoa)) {
            this.pessoas.add(pessoa);
            pessoa.setCidade(this);
        }
    }
}

