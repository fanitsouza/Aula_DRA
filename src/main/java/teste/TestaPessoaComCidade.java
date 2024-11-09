package teste;

import modelo.Cidade;
import modelo.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestaPessoaComCidade {

    public static void inserir(){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Banco01PU");
        EntityManager entityManager = fabrica.createEntityManager();

        Cidade cidade= new Cidade();
        cidade.setNome("Manaus");
        cidade.setIbge("1302603");

        Pessoa pessoa = new Pessoa("18765432123","Matheus com cidade", "8659-5695", "matheus2@gmail.com");

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

        Pessoa pessoa = new Pessoa("89317564258","Ruan", "1234-8932", "ruan@gmail.com");
        Cidade cidade = entityManager.find(Cidade.class, 2L);
        pessoa.setCidade(cidade);

        entityManager.getTransaction().begin();
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
