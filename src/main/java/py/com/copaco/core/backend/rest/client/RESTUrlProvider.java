package py.com.copaco.core.backend.rest.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import py.com.copaco.billing.entities.Configuracion;
import py.com.copaco.core.backend.exception.ApplicationRuntimeException;

@Singleton
public class RESTUrlProvider {

    private Map<String, String> cache;

    @Inject
    private EntityManager entityManager;

    @PostConstruct
    void init() {
        cache = new HashMap<String, String>();
        List<Configuracion> otro = entityManager
                .createNamedQuery("configuracion.modulo.host",
                        Configuracion.class)
                .setParameter("nombre", "host").getResultList();
        for (Configuracion ele : otro) {
            cache.put(ele.getModulo(), ele.getValor());
        }
    }

    public String getUrl(String sistema) {
        String valor = cache.get(sistema);
        String toRet = null; //cache.get(sistema);
        if (valor != null && !valor.isEmpty()) {
            toRet = valor;
            if (!toRet.endsWith("/")) {
                toRet += "/";
            }
            toRet += sistema;
        } else {
            throw new ApplicationRuntimeException("Error al obtener configuracion para el modulo. ");
        }

//		//if (toRet == null) {
//			
//			/*List<String> result = entityManager
//					.createNamedQuery("configuracion.modulo.value",
//							String.class).setMaxResults(1)
//					.setParameter("modulo", sistema.toLowerCase())
//					.setParameter("nombre", "host").getResultList();*/
//			List<String> result = new ArrayList<String>();
//			if (result.isEmpty())
//				toRet = "http://localhost:8081/billing/" + sistema.toLowerCase();
//			else {
//				toRet = result.get(0);
//				if (!toRet.endsWith("/"))
//					toRet += "/";
//				toRet += sistema;
//			}
//			//cache.put(sistema, toRet);
//		//}
        return toRet;
    }
}
