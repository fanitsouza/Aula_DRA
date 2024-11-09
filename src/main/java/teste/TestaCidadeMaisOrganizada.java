package teste;

import dao.CidadeDAO;
import dao.PessoaDAO;
import modelo.Cidade;
import modelo.Pessoa;
import util.ConexaoUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class TestaCidadeMaisOrganizada {

    private static void inserir(){
        EntityManager entityManager = ConexaoUtil.getEntityManager();

        Cidade cidade = new Cidade("Manaus", "1234567", "Amazonas");

        CidadeDAO cidadeDAO = new CidadeDAO(entityManager);

        cidadeDAO.inserir(cidade);

        entityManager.close();
    }

    private static void listar(){
        EntityManager entityManager = ConexaoUtil.getEntityManager();

        CidadeDAO cidadeDAO = new CidadeDAO(entityManager);

        List<Cidade> cidades = cidadeDAO.listar();

        for(Cidade c: cidades){
            System.out.println(c.getId());
            System.out.println(c.getNome());
            System.out.println(c.getIbge());
            System.out.println(c.getEstado());
            System.out.println("****************");
        }

        entityManager.close();
    }

    private static void consultarr(){
        EntityManager entityManager = ConexaoUtil.getEntityManager();

        CidadeDAO cidadeDAO = new CidadeDAO(entityManager);
        Cidade c = cidadeDAO.consultar(1L);

        System.out.println(c.getId());
        System.out.println(c.getNome());
        System.out.println(c.getIbge());
        System.out.println(c.getEstado());
        System.out.println("****************");

        entityManager.close();
    }

    private static void remover(){
        EntityManager entityManager = ConexaoUtil.getEntityManager();

        CidadeDAO cidadeDAO = new CidadeDAO(entityManager);

        cidadeDAO.excluir(1L);

        entityManager.close();
    }

    private static void alterar(){
        EntityManager entityManager = ConexaoUtil.getEntityManager();

        CidadeDAO cidadeDAO = new CidadeDAO(entityManager);
        Cidade cidadeAlterar = new Cidade(1L, "Manaus", "1234567", "Amazonas");

        cidadeDAO.alterar(cidadeAlterar);

        entityManager.close();
    }

    public static void main(String[] args) {
        //inserir();
        //listar();
        remover();
        //pesquisar();
    }
}
