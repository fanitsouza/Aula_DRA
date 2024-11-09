package teste;

import modelo.Cidade;
import modelo.Estado;
import modelo.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestaPessoaComCidadeEstado {

    public static void inserir(){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Banco01PU");
        EntityManager entityManager = fabrica.createEntityManager();

        Estado estado = new Estado();
        estado.setNome("Bahia");
        estado.setIbge("0569834");

        Cidade cidade= new Cidade();
        cidade.setNome("Salvador");
        cidade.setIbge("8523697");

        Pessoa pessoa = new Pessoa("75315985265","Ze com Cidade e Estado", "7412-5695", "ze@gmail.com");

        cidade.setEstado(estado);
        pessoa.setCidade(cidade);

        entityManager.getTransaction().begin();
        entityManager.persist(cidade);

        entityManager.persist(pessoa);

        entityManager.getTransaction().commit();

        entityManager.close();

        fabrica.close();
    }

    private static void inserirNovaPessoaComCidadeJaSalvo(){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Banco01PU");
        EntityManager entityManager = fabrica.createEntityManager();

        Pessoa pessoa = new Pessoa("96852536417","Joao", "5648-8932", "joao@gmail.com");
        Cidade cidade = entityManager.find(Cidade.class, 2L);
        Estado estado = entityManager.find(Estado.class, 1L);
        pessoa.setCidade(cidade);
        cidade.setEstado(estado);

        entityManager.getTransaction().begin();

        entityManager.persist(estado);
        entityManager.persist(cidade);

        entityManager.persist(pessoa);

        entityManager.getTransaction().commit();

        entityManager.close();

        fabrica.close();
    }
    public static void main(String[] args) {
        //inserir();
        inserirNovaPessoaComCidadeJaSalvo();

    }
}
