/*******************************************************************************
 * Copyright (C) 2010 - 2013 Jaspersoft Corporation. All rights reserved.
 * http://www.jaspersoft.com
 * 
 * Unless you have purchased a commercial license agreement from Jaspersoft, 
 * the following license terms apply:
 * 
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Jaspersoft Studio Team - initial API and implementation
 ******************************************************************************/
package com.jaspersoft.studio.property.section.graphic;

import net.sf.jasperreports.engine.base.JRBaseImage;
import net.sf.jasperreports.engine.base.JRBaseStyle;
import net.sf.jasperreports.engine.design.JRDesignImage;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.IPropertyDescriptor;

import com.jaspersoft.studio.properties.view.TabbedPropertySheetPage;
import com.jaspersoft.studio.property.section.AbstractRealValueSection;
import com.jaspersoft.studio.property.section.widgets.ASPropertyWidget;
import com.jaspersoft.studio.property.section.widgets.SPEvaluationTime;

/*
 * The location section on the location tab.
 * 
 * @author Chicu Veaceslav
 */
public class ImageFieldSection extends AbstractRealValueSection {

	
	/**
	 * @see org.eclipse.ui.views.properties.tabbed.ITabbedPropertySection#createControls(org.eclipse.swt.widgets.Composite,
	 *      org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
	 */
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);

		parent.setLayout(new GridLayout(2, false));

		ASPropertyWidget w = createWidget4Property(parent, JRDesignImage.PROPERTY_EXPRESSION);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 1;
		w.getControl().setLayoutData(gd);

		IPropertyDescriptor pd = getPropertyDesriptor(JRDesignImage.PROPERTY_EVALUATION_TIME);
		IPropertyDescriptor gpd = getPropertyDesriptor(JRDesignImage.PROPERTY_EVALUATION_GROUP);
		getWidgetFactory().createCLabel(parent, pd.getDisplayName());
		widgets.put(pd.getId(), new SPEvaluationTime(parent, this, pd, gpd));

		gd = new GridData();
		gd.horizontalSpan = 2;
		createWidget4Property(parent, JRBaseImage.PROPERTY_LAZY, false).getControl().setLayoutData(gd);
		createWidget4Property(parent, JRBaseImage.PROPERTY_USING_CACHE);

		createWidget4Property(parent, JRBaseStyle.PROPERTY_FILL);
		createWidget4Property(parent, JRBaseStyle.PROPERTY_SCALE_IMAGE);

		createWidget4Property(parent, JRBaseImage.PROPERTY_ON_ERROR_TYPE);

	}

}
