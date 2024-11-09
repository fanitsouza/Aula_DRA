package teste;

import modelo.Pessoa;

import javax.persistence.*;
import java.util.List;

public class TestaPessoa {

    private static void persistir(){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Banco01PU");
        EntityManager entityManager = fabrica.createEntityManager();

        Pessoa pessoa = new Pessoa("98765432123","Matheus", "8659-5695", "matheus@gmail.com");

        entityManager.getTransaction().begin();

        entityManager.persist(pessoa);

        entityManager.getTransaction().commit();

        entityManager.close();

        fabrica.close();
    }

    private static void listar(){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Banco01PU");

        EntityManager entityManager = fabrica.createEntityManager();

        String consulta = "select p from Pessoa p";

        Query query = entityManager.createQuery(consulta);

        List<Pessoa> pessoas = query.getResultList();

        for(Pessoa p: pessoas){
            System.out.println(p.getId());
            System.out.println(p.getCpf());
            System.out.println(p.getNome());
            System.out.println(p.getEmail());
            System.out.println(p.getTelefone());
            System.out.println("****************");
        }

        entityManager.close();

        fabrica.close();
    }

    private static void consultar(){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Banco01PU");

        EntityManager entityManager = fabrica.createEntityManager();

        Pessoa pessoa = entityManager.find(Pessoa.class,1L);

        System.out.println("Pessoa: "+pessoa.getNome());

        entityManager.close();

        fabrica.close();
    }

    private static void remover(){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Banco01PU");

        EntityManager entityManager = fabrica.createEntityManager();

        //transiente
        // Pessoa pessoa = new Pessoa();
        //pessoa.setId(1L);

        entityManager.getTransaction().begin();

        Pessoa pessoa = entityManager.find(Pessoa.class, 3L);
        entityManager.remove(pessoa);

        entityManager.getTransaction().commit();

        entityManager.close();
        fabrica.close();
    }

    private static void alterar(){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Banco01PU");

        EntityManager entityManager = fabrica.createEntityManager();

        entityManager.getTransaction().begin();

        Pessoa pessoa = entityManager.find(Pessoa.class, 4L);

        pessoa.setNome("Maria Marta");

        entityManager.getTransaction().commit();

        entityManager.close();
        fabrica.close();
    }

    private static void mesclar(){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Banco01PU");

        EntityManager entityManager = fabrica.createEntityManager();

        Pessoa pessoa = new Pessoa();
        //pessoa.setId(2L);
        pessoa.setNome("Marcela Mesclado");

        entityManager.getTransaction().begin();

        entityManager.merge(pessoa);

        entityManager.getTransaction().commit();


        entityManager.close();
        fabrica.close();
    }

    public static void main(String[] args) {
        persistir();
        //alterar();
        //listar();
        //mesclar();
        //consultar();
        //remover();


    }
}
