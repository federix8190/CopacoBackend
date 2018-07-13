package py.com.copaco.core.backend.security;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@SessionScoped
public class SessionSecurity implements Serializable {

    /**
     * Hashmap de url mas una lista de metodo como post, get, put
	 *
     */
    private Map<String, List<String>> urlPorMetodo = new HashMap<String, List<String>>();
    private Map<String, Map<String, String>> permisoPorObjeto = new HashMap<String, Map<String, String>>();

    private String nombreUsuario;

    private String nroLegajo;

    private List<String> rolesPorUsuario;

    @Inject
    private EntityManager em;

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNroLegajo(String nroLegajo) {
        this.nroLegajo = nroLegajo;
    }

    public String getNroLegajo() {
        return nroLegajo;
    }

    public void setRolesPorUsuario(List<String> rolesPorUsuario) {
        this.rolesPorUsuario = rolesPorUsuario;
    }

    public void setRolPorUsuario(String rol) {
        rolesPorUsuario.add(rol);
    }

    public List<String> getRolesPorUsuario() {
        return rolesPorUsuario;
    }

    public void setUrlPorMetodo(Map<String, List<String>> urlPorMetodo) {
        this.urlPorMetodo = urlPorMetodo;
    }

    public Map<String, List<String>> getUrlPorMetodo() {
        return urlPorMetodo;
    }

    public Map<String, Map<String, String>> getPermisoPorObjeto() {
        return permisoPorObjeto;
    }

    public void setPermisoPorObjeto(
            Map<String, Map<String, String>> permisoPorObjeto) {
        this.permisoPorObjeto = permisoPorObjeto;
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

    public Boolean existeUrl(String url) {

        if (urlPorMetodo.containsKey(url)) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean existeUrlXMetodo(String url, String metodo) {

        if (urlPorMetodo.containsKey(url)) {
            return urlPorMetodo.get(url).contains(metodo);
        } else {
            return false;
        }

    }

    public boolean existeRol(String rol) {
        return rolesPorUsuario.contains(rol);
    }

    public Boolean existeObjeto(String nombreObjeto) {
        if (rolesPorUsuario.contains("BILL_ADMIN_BILLING")) {
            return true;
        } else if (permisoPorObjeto.containsKey(nombreObjeto)) {
            return true;
        } else {
            return false;
        }
    }

}
