/*******************************************************************************
 * Copyright © 2010-2023. Cloud Software Group, Inc. All rights reserved.
 *******************************************************************************/
package com.jaspersoft.studio.property.descriptor.returnvalue;

import java.util.List;

import org.eclipse.jface.viewers.LabelProvider;

import com.jaspersoft.studio.model.JReportsDTO;

/*
 * @author Chicu Veaceslav
 */
public class RVPropertiesLabelProvider extends LabelProvider {

	public RVPropertiesLabelProvider() {
		super();
	}

	@Override
	public String getText(Object element) {
		if (element == null)
			return ""; //$NON-NLS-1$
		if (element instanceof JReportsDTO)
			element = ((JReportsDTO) element).getValue();
		if (element instanceof List)
			return String.format("Number of Values: %d", ((List<?>) element).size());

		return element.toString();
	}
}
