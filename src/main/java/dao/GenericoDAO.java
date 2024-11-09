package dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class GenericoDAO<Tipo> {

    private EntityManager entityManager;

    private Class<Tipo> classe;

    public GenericoDAO(EntityManager entityManager, Class<Tipo> classe) {
        this.entityManager = entityManager;
        this.classe = classe;
    }

    public void inserir(Tipo objeto){
        entityManager.getTransaction().begin();
        entityManager.persist(objeto);
        entityManager.getTransaction().commit();
    }

    public Tipo consultar(Long id){
        return entityManager.find(classe, id);
    }

    public List<Tipo> listar(){
        String consulta = "select o from "+classe.getName()+" o";

        Query query = entityManager.createQuery(consulta);

        return query.getResultList();

    }

    public void remover(Long id){
        entityManager.getTransaction().begin();
        Tipo objetoExcluir = entityManager.find(classe, id);
        entityManager.remove(objetoExcluir);
        entityManager.getTransaction().commit();
    }

    public void alterar(Tipo objeto){
        entityManager.getTransaction().begin();
        entityManager.persist(objeto);
        entityManager.getTransaction().commit();
    }
}
