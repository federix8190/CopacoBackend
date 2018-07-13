package py.com.copaco.core.backend.security;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Singleton;

import lombok.Getter;
import lombok.Setter;

@Singleton
public class SingletonSecurity {

    /**
     * Map<String nombreObjetoRes, Map<nombrePermiso, NombrePermiso> >
     * permisoPorObjeto
     *
     *
     */
    @Getter
    @Setter
    private Map<String, Map<String, String>> permisoPorObjeto;

    public void Lista() {

        System.out.print("tamaño del maps " + permisoPorObjeto.size() + "\n");

    }

    public void addPermisoPorObjeto(String nombreObjeto, String nombrePermiso) {

        if (permisoPorObjeto.containsKey(nombreObjeto)) {
            permisoPorObjeto.get(nombreObjeto)
                    .put(nombrePermiso, nombrePermiso);
        } else {
            Map<String, String> permisos = new HashMap<String, String>();
            permisos.put(nombrePermiso, nombrePermiso);
            permisoPorObjeto.put(nombreObjeto, permisos);
        }

    }

    public Boolean existePermisoPorObjeto(String nombreObjeto,
            String nombrePermiso) {

        if (permisoPorObjeto.containsKey(nombreObjeto)) {
            if (permisoPorObjeto.get(nombreObjeto).containsKey(nombrePermiso)) {
                return true;
            }
        }

        return false;
    }

}
