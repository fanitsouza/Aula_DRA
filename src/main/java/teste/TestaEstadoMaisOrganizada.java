package teste;

import dao.CidadeDAO;
import dao.EstadoDAO;
import modelo.Cidade;
import modelo.Estado;
import util.ConexaoUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class TestaEstadoMaisOrganizada {

    private static void inserir(){
        EntityManager entityManager = ConexaoUtil.getEntityManager();

        Estado estado = new Estado("Amazonas", "1230987");

        EstadoDAO estadoDAO = new EstadoDAO(entityManager);

        estadoDAO.inserir(estado);

        entityManager.close();
    }

    private static void listar(){
        EntityManager entityManager = ConexaoUtil.getEntityManager();

        EstadoDAO estadoDAO = new EstadoDAO(entityManager);

        List<Estado> estados = estadoDAO.listar();

        for(Estado e: estados){
            System.out.println(e.getId());
            System.out.println(e.getNome());
            System.out.println(e.getIbge());
            System.out.println("****************");
        }

        entityManager.close();
    }

    private static void consultarr(){
        EntityManager entityManager = ConexaoUtil.getEntityManager();

        EstadoDAO estadoDAO = new EstadoDAO(entityManager);
        Estado e = estadoDAO.consultar(1L);

        System.out.println(e.getId());
        System.out.println(e.getNome());
        System.out.println(e.getIbge());
        System.out.println("****************");

        entityManager.close();
    }

    private static void remover(){
        EntityManager entityManager = ConexaoUtil.getEntityManager();

        EstadoDAO estadoDAO = new EstadoDAO(entityManager);

        estadoDAO.excluir(1L);

        entityManager.close();
    }

    private static void alterar(){
        EntityManager entityManager = ConexaoUtil.getEntityManager();

        EstadoDAO estadoDAO = new EstadoDAO(entityManager);
        Estado estadoAlterar = new Estado("Amazonas", "0984563", 1L);

       estadoDAO.alterar(estadoAlterar);

        entityManager.close();
    }

    public static void main(String[] args) {
        inserir();
        //listar();
        //remover();
        //pesquisar();
    }
}
