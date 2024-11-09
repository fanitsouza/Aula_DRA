package teste;

import modelo.Cidade;
import modelo.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class TestaCidade {

    private static void inserir(){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Banco01PU");
        EntityManager entityManager = fabrica.createEntityManager();

        Cidade cidade = new Cidade("Manaus", "0987665", "Amazonas");
        entityManager.getTransaction().begin();

        entityManager.persist(cidade);

        entityManager.getTransaction().commit();

        entityManager.close();

        fabrica.close();
    }

    private static void listar(){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Banco01PU");
        EntityManager entityManager = fabrica.createEntityManager();

        String pesquisar = "Select c from Cidade c";

        Query query = entityManager.createQuery(pesquisar);

        List<Cidade> cidades = query.getResultList();

        for(Cidade c: cidades){
            System.out.println(c.getId());
            System.out.println(c.getNome());
            System.out.println(c.getIbge());
            System.out.println(c.getEstado());
            System.out.println("****************");
        }

        entityManager.close();

        fabrica.close();
    }

    private static void pesquisar(){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Banco01PU");

        EntityManager entityManager = fabrica.createEntityManager();

        Cidade cidade = entityManager.find(Cidade.class,1L);

        System.out.println("Cidade: "+cidade.getNome());

        entityManager.close();

        fabrica.close();
    }

    private static void remover(){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Banco01PU");

        EntityManager entityManager = fabrica.createEntityManager();

        entityManager.getTransaction().begin();

        Cidade cidade = entityManager.find(Cidade.class, 1L);
        entityManager.remove(cidade);

        entityManager.getTransaction().commit();

        entityManager.close();
        fabrica.close();
    }

    private static void alterar(){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Banco01PU");

        EntityManager entityManager = fabrica.createEntityManager();

        entityManager.getTransaction().begin();

        Cidade cidade = entityManager.find(Cidade.class, 1L);

        cidade.setNome("Alterar");

        entityManager.getTransaction().commit();

        entityManager.close();
        fabrica.close();
    }

    public static void main(String[] args) {
        inserir();
        //listar();
        //remover();
        //pesquisar();
    }
}
