package dao;

import modelo.Cidade;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CidadeDAO {
    private EntityManager entityManager;

    public CidadeDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

        public void inserir(Cidade cidade){
            entityManager.getTransaction().begin();
            entityManager.persist(cidade);
            entityManager.getTransaction().commit();

        }

        public Cidade consultar(Long id){

            return entityManager.find(Cidade.class, id);

        }

        public List<Cidade> listar(){

            String consulta = "select c from Cidade c";

            Query query = entityManager.createQuery(consulta);

            return query.getResultList();
        }

        public void excluir(Long id){

            entityManager.getTransaction().begin();

            Cidade cidade = entityManager.find(Cidade.class, id);

            entityManager.remove(cidade);

            entityManager.getTransaction().commit();
        }

        public void alterar(Cidade cidade){

            entityManager.getTransaction().begin();

            Cidade cidadeBD = entityManager.find(Cidade.class, cidade.getId());

            cidadeBD.setNome(cidade.getNome());
            cidadeBD.setIbge(cidade.getIbge());
            cidadeBD.setEstado(cidade.getEstado());

            entityManager.getTransaction().commit();
        }

}
