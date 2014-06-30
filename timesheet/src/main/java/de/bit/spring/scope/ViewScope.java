package de.bit.spring.scope;

import java.util.Map;

import javax.faces.context.FacesContext;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

public class ViewScope implements Scope {

	@Override
	public Object get(final String name, final ObjectFactory<?> objectFactory) {
		Map<String, Object> viewMap = FacesContext.getCurrentInstance().getViewRoot().getViewMap();

		if (viewMap.containsKey(name)) {
			// get object from viewmap
			return viewMap.get(name);
		} else {
			// register object in viewmap if not already present
			Object object = objectFactory.getObject();
			viewMap.put(name, object);
			return object;
		}
	}

	@Override
	public Object remove(final String name) {
		return FacesContext.getCurrentInstance().getViewRoot().getViewMap().remove(name);
	}

	@Override
	public String getConversationId() {
		// not supported
		return null;
	}

	@Override
	public void registerDestructionCallback(final String name, final Runnable callback) {
		// not supported
	}

	@Override
	public Object resolveContextualObject(final String key) {
		// not supported
		return null;
	}
}