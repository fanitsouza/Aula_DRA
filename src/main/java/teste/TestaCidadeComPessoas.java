package teste;

import dao.GenericoDAO;
import modelo.Cidade;
import modelo.Estado;
import modelo.Pessoa;
import util.ConexaoUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestaCidadeComPessoas {

    public static void inserir(){

        GenericoDAO<Cidade> genericoDAO = new GenericoDAO<>(ConexaoUtil.getEntityManager(), Cidade.class);
        GenericoDAO<Estado> estadoDAO = new GenericoDAO<>(ConexaoUtil.getEntityManager(), Estado.class);
        GenericoDAO<Pessoa> pessoaDAO = new GenericoDAO<>(ConexaoUtil.getEntityManager(), Pessoa.class);

        Estado estado = new Estado();
        estado.setNome("Amazonas");
        estado.setIbge("1235698");

        estadoDAO.inserir(estado);

        Cidade cidade = new Cidade();
        cidade.setNome("Manaus");
        cidade.setIbge("5236941");
        cidade.setEstado(estado);

        genericoDAO.inserir(cidade);

        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("Maria Antonia");
        pessoa1.setCpf("12345678912");
        pessoa1.setEmail("maria@gmail.com");
        pessoa1.setTelefone("36251224");
        pessoa1.setCidade(cidade);

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNome("Jose Antonio");
        pessoa2.setCpf("98765432198");
        pessoa2.setEmail("jose@gmail.com");
        pessoa2.setTelefone("96857884");
        pessoa2.setCidade(cidade);

        pessoaDAO.inserir(pessoa1);
        pessoaDAO.inserir(pessoa2);

    }

    public static void inserirPessoaComEstadoCidade(){
        GenericoDAO<Cidade> genericoDAO = new GenericoDAO<>(ConexaoUtil.getEntityManager(), Cidade.class);
        GenericoDAO<Pessoa> pessoaDAO = new GenericoDAO<>(ConexaoUtil.getEntityManager(), Pessoa.class);

        Cidade cidade = genericoDAO.consultar(1L);
        Pessoa pessoa = new Pessoa("89317564258","Ruan", "1234-8932", "ruan@gmail.com");
        pessoa.setCidade(cidade);
        pessoaDAO.inserir(pessoa);
    }

    public static void main(String[] args) {
        inserirPessoaComEstadoCidade();
    }

}
