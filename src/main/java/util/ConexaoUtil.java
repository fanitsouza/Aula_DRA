package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexaoUtil {

    private static EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Banco01PU");

    public static EntityManager getEntityManager(){
        return fabrica.createEntityManager();
    }

    public static void fecharFabrica(){
        fabrica.close();
    }

}

