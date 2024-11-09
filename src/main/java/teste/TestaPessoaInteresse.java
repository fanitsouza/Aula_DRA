package teste;

import dao.GenericoDAO;
import modelo.Cidade;
import modelo.Estado;
import modelo.Interesse;
import modelo.Pessoa;
import util.ConexaoUtil;

import java.util.ArrayList;
import java.util.List;

public class TestaPessoaInteresse {

    public static void inserir(){

        GenericoDAO<Interesse> genericoDAO = new GenericoDAO<>(ConexaoUtil.getEntityManager(), Interesse.class);
        GenericoDAO<Pessoa> pessoaDAO = new GenericoDAO<>(ConexaoUtil.getEntityManager(), Pessoa.class);
        GenericoDAO<Cidade> cidadeDAO = new GenericoDAO<>(ConexaoUtil.getEntityManager(), Cidade.class);


        //Interesse interesse = new Interesse();
        //interesse.setNome("Economia");
        //genericoDAO.inserir(interesse);

        Cidade cidade = cidadeDAO.consultar(1L);
        Pessoa pessoa = new Pessoa("85296374125","Mateus", "86542347", "matheus@gmail.com");
        pessoa.setCidade(cidade);
        pessoaDAO.inserir(pessoa);
        //List<Interesse> interesses = new ArrayList<>();
        //interesses.add(interesse);
        //pessoa.setInteresses(interesses);



    }

    public static void inserirPessoaComEstadoCidade(){
        GenericoDAO<Cidade> genericoDAO = new GenericoDAO<>(ConexaoUtil.getEntityManager(), Cidade.class);
        GenericoDAO<Pessoa> pessoaDAO = new GenericoDAO<>(ConexaoUtil.getEntityManager(), Pessoa.class);

        Cidade cidade = genericoDAO.consultar(1L);
        Pessoa pessoa = new Pessoa("89317564258","Ruan", "1234-8932", "ruan@gmail.com");
        pessoa.setCidade(cidade);
        pessoaDAO.inserir(pessoa);
    }

    public static void consultarCidadeePessoas(){
        GenericoDAO<Cidade> genericoDAO = new GenericoDAO<>(ConexaoUtil.getEntityManager(), Cidade.class);

        System.out.println("Consultando Pessoa");

        Cidade cidade = genericoDAO.consultar(1L);
        System.out.println(cidade.getNome());

        System.out.println("Listando Pessoas");

        for(Pessoa pessoa:cidade.getPessoas()){
            System.out.println(pessoa.getEmail());
        }
    }

    public static void main(String[] args) {
        inserir();
    }

}
