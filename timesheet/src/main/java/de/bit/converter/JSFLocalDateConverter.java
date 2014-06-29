/**
 * 
 */
package de.bit.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.joda.time.LocalDate;

import de.bit.common.Constants;
import de.bit.common.DateHelper;

/**
 * Converts JSF input to DateTime and vice versa
 * 
 * @author christian.laboranowitsch@bridging-it.de
 * 
 */
@FacesConverter("at.bit.JsfLocalDateConverter")
public class JSFLocalDateConverter implements Converter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext
	 * , javax.faces.component.UIComponent, java.lang.String)
	 */
	@Override
	public Object getAsObject(final FacesContext facesContext, final UIComponent comp, final String string) throws ConverterException {
		return DateHelper.convertLocalDateFromUiString(string);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext
	 * , javax.faces.component.UIComponent, java.lang.Object)
	 */
	@Override
	public String getAsString(final FacesContext facesContext, final UIComponent comp, final Object localDate) throws ConverterException {
		return ((LocalDate) localDate).toString(Constants.UI_DATE_TIME_FORMAT_STR);
	}

}
