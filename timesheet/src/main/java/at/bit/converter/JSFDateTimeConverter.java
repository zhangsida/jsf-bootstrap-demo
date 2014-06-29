/**
 * 
 */
package at.bit.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.joda.time.DateTime;

import at.bit.common.Constants;
import at.bit.common.DateHelper;

/**
 * Converts JSF input to DateTime and vice versa
 * 
 * @author christian.laboranowitsch@bridging-it.de
 * 
 */
@FacesConverter("at.bit.JsfDateTimeConverter")
public class JSFDateTimeConverter implements Converter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext
	 * , javax.faces.component.UIComponent, java.lang.String)
	 */
	@Override
	public Object getAsObject(final FacesContext facesContext, final UIComponent comp, final String string) throws ConverterException {
		return DateHelper.convertFromUiString(string);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext
	 * , javax.faces.component.UIComponent, java.lang.Object)
	 */
	@Override
	public String getAsString(final FacesContext facesContext, final UIComponent comp, final Object dateTime) throws ConverterException {
		return ((DateTime) dateTime).toString(Constants.UI_DATE_TIME_FORMAT_STR);
	}

}
