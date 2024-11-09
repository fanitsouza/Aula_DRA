package teste;

import dao.PessoaDAO;
import modelo.Pessoa;
import util.ConexaoUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class TestaPessoaMaisOrganizado {

    private static void persistir(){

        EntityManager entityManager = ConexaoUtil.getEntityManager();

        Pessoa pessoa = new Pessoa("98765432123","Matheus", "8659-5695", "matheus@gmail.com");

        PessoaDAO pessoaDAO = new PessoaDAO(entityManager);

        entityManager.close();


    }

    private static void listar(){

        EntityManager entityManager = ConexaoUtil.getEntityManager();

        PessoaDAO pessoaDAO = new PessoaDAO(entityManager);

        List<Pessoa> pessoas = pessoaDAO.listar();

        for(Pessoa p: pessoas){
            System.out.println(p.getId());
            System.out.println(p.getCpf());
            System.out.println(p.getNome());
            System.out.println(p.getEmail());
            System.out.println(p.getTelefone());
            System.out.println("****************");
        }

        entityManager.close();


    }

    private static void consultar(){

        EntityManager entityManager = ConexaoUtil.getEntityManager();

        PessoaDAO pessoaDAO = new PessoaDAO(entityManager);
        Pessoa p = pessoaDAO.consultar(1L);

        System.out.println(p.getId());
        System.out.println(p.getCpf());
        System.out.println(p.getNome());
        System.out.println(p.getEmail());
        System.out.println(p.getTelefone());
        System.out.println("****************");

        entityManager.close();

    }

    private static void remover(){

        EntityManager entityManager = ConexaoUtil.getEntityManager();

        PessoaDAO pessoaDAO = new PessoaDAO(entityManager);

        pessoaDAO.excluir(1L);

        entityManager.close();

    }

    private static void alterar(){

        EntityManager entityManager = ConexaoUtil.getEntityManager();

        PessoaDAO pessoaDAO = new PessoaDAO(entityManager);
        Pessoa pessoaAlterar = new Pessoa(1L, "99376850432", "Julia Alterado", "939954855", "julia@gmail.com");

        pessoaDAO.alterar(pessoaAlterar);

        entityManager.close();

    }


    public static void main(String[] args) {
        //persistir();
        //alterar();
        listar();
        //mesclar();
        //consultar();
        //remover();

        ConexaoUtil.fecharFabrica();


    }
}
