package py.com.copaco.core.backend.util;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListUtil {

	public static <T> Difference<T> getDifference(List<T> listaVieja,
			List<T> listaNueva) {

		Difference<T> toRet = new Difference<>();

		if (isEmpty(listaVieja) && isEmpty(listaNueva)) {
			return toRet;
		}

		if (isEmpty(listaVieja)) {
			toRet.creados = listaNueva;
			return toRet;
		}

		if (isEmpty(listaNueva)) {
			toRet.eliminados = listaVieja;
			return toRet;
		}

		for (T nuevo : listaNueva) {
			if (listaVieja.contains(nuevo))
				toRet.modificados.add(nuevo);
			else
				toRet.creados.add(nuevo);
		}

		for (T viejo : listaVieja) {
			if (listaNueva.contains(viejo)) {

			} else {
				toRet.eliminados.add(viejo);
			}
		}

		return toRet;
	}

	public static boolean isEmpty(Collection<?> list) {

		return list == null || list.isEmpty();
	}

	public static class Difference<T> {

		private List<T> creados = new ArrayList<>();
		private List<T> eliminados = new ArrayList<>();
		private List<T> modificados = new ArrayList<>();

		public List<T> getCreados() {
			return creados;
		}

		public List<T> getEliminados() {
			return eliminados;
		}

		public List<T> getModificados() {
			return modificados;
		}

	}

}
