package modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Interesse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_interesse", nullable = false)
    private String nome;

    @ManyToMany(mappedBy = "interesses")
    private List<Pessoa> pessoas = new ArrayList<>();


    public Interesse() {
    }

    public Interesse(Long id, String nome) {
        this.id = id;
        this.nome = nome;
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

    public List<Pessoa> getPessoas() {
      return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public void setPessoa (List<Pessoa> pessoas){
        this.pessoas = pessoas;
        for (Pessoa pessoa: pessoas){
            pessoa.addInteresse(this);
        }
    }

    public void addPessoa(Pessoa pessoa){
        if (!this.pessoas.contains(pessoa)){
            this.pessoas.add(pessoa);
            pessoa.addInteresse(this);
        }

    }
}
