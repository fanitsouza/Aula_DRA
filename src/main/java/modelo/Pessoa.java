package modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 11, name = "cpfpessoa")
    private String cpf;

    @Column(nullable = false, name = "nomepessoa")
    private String nome;

    private String telefone;

    @Column(nullable = false, unique = true, name = "emailpessoa")
    private String email;

    @ManyToOne
    private Cidade cidade;

    @ManyToMany
    private List<Interesse> interesses = new ArrayList<>();

    public Pessoa() {
    }

    public Pessoa(String cpf, String nome, String telefone, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;

    }

    public Pessoa(Long id, String cpf, String nome, String telefone, String email) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public List<Interesse> getInteresses() {
        return interesses;
    }

    public void setInteresses(List<Interesse> interesses) {
        this.interesses = interesses;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
        cidade.addPessoa(this);
    }

    public void addInteresse(Interesse interesse){
        if (!this.interesses.contains(interesse)){
            this.interesses.add(interesse);
            interesse.addPessoa(this);
        }

    }
}
