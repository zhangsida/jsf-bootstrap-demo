package de.bit.spring.scope;

import java.util.Map;

import javax.faces.context.FacesContext;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

public class ViewScope implements Scope {

	public Object get(final String name, final ObjectFactory<?> objectFactory) {
		Map<String, Object> viewMap = FacesContext.getCurrentInstance()
				.getViewRoot().getViewMap();

		if (viewMap.containsKey(name)) {
			return viewMap.get(name);
		} else {
			Object object = objectFactory.getObject();
			viewMap.put(name, object);

			return object;
		}
	}

	public Object remove(final String name) {
		return FacesContext.getCurrentInstance().getViewRoot().getViewMap()
				.remove(name);
	}

	public String getConversationId() {
		return null;
	}

	public void registerDestructionCallback(final String name,
			final Runnable callback) {
		// Not supported
	}

	public Object resolveContextualObject(final String key) {
		return null;
	}
}