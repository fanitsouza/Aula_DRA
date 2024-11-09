package teste;

import dao.CidadeDAO;
import dao.EstadoDAO;
import dao.GenericoDAO;
import modelo.Cidade;
import modelo.Estado;
import modelo.Pessoa;
import util.ConexaoUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TestaGenericoDAO {

    public static void inserirGenericDAOCidade(){

        GenericoDAO<Cidade> genericoDAO = new GenericoDAO<>(ConexaoUtil.getEntityManager(), Cidade.class);
        GenericoDAO<Estado> estadoDAO = new GenericoDAO<>(ConexaoUtil.getEntityManager(), Estado.class);

        Cidade cidade = new Cidade();
        cidade.setNome("Belo Horizonte");
        cidade.setIbge("8974563");
        Estado estado = estadoDAO.consultar(2L);
        cidade.setEstado(estado);

        genericoDAO.inserir(cidade);
    }

    public static void inserirGenericDAOEstado(){

        GenericoDAO<Estado> estadoDAO = new GenericoDAO<>(ConexaoUtil.getEntityManager(), Estado.class);

        Estado estado = new Estado();
        estado.setNome("Minas Gerais");
        estado.setIbge("8523697");

        estadoDAO.inserir(estado);
    }

    public static void listCidade(){
        GenericoDAO<Cidade> genericoDAO = new GenericoDAO<>(ConexaoUtil.getEntityManager(), Cidade.class);

        List<Cidade> cidades = genericoDAO.listar();

        for (Cidade cidade: cidades){
            System.out.println(cidade);
        }

    }

    public static void remover(){
        GenericoDAO<Pessoa> pessoaDAO = new GenericoDAO<>(ConexaoUtil.getEntityManager(), Pessoa.class);
        pessoaDAO.remover(2L);
    }

    public static void alterar(){
        GenericoDAO<Pessoa> pessoaDAO = new GenericoDAO<>(ConexaoUtil.getEntityManager(), Pessoa.class);

        Pessoa pessoa = pessoaDAO.consultar(1L);
        pessoa.setTelefone("36730096");
        pessoaDAO.alterar(pessoa);

    }


    public static void main(String[] args) {

        alterar();
    }
}
