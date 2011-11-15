package com.jaspersoft.studio.server.wizard.resource.page;

import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;

import com.jaspersoft.jasperserver.api.metadata.xml.domain.impl.ResourceDescriptor;
import com.jaspersoft.studio.model.ANode;
import com.jaspersoft.studio.server.model.MReportUnit;
import com.jaspersoft.studio.utils.UIUtils;

public class RDReportUnitPage extends AResourcePage {

	public RDReportUnitPage(ANode parent, MReportUnit resource) {
		super("rdreportunit", parent, resource);
		setTitle("Report Unit");
		setDescription("Report Unit");
	}

	@Override
	protected void createTabs(TabFolder tabFolder) {
		super.createTabs(tabFolder);
		createReportUnit(tabFolder);
		createControlResources(tabFolder);
		createDatasource(tabFolder);
		createQuery(tabFolder);
	}

	protected void createReportUnit(TabFolder tabFolder) {
		TabItem item = new TabItem(tabFolder, SWT.NONE);
		item.setText("Report Unit");

		Composite composite = new Composite(tabFolder, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));
		item.setControl(composite);

		UIUtils.createLabel(composite, "Controls Layout");

		CCombo cictype = new CCombo(composite, SWT.BORDER);
		cictype.setItems(new String[] { "Popup screen", "Separate page",
				"Top of page", "In page" });

		UIUtils.createLabel(composite, "");

		Button ispromp = new Button(composite, SWT.CHECK);
		ispromp.setText("Always Prompt");
		ispromp.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		UIUtils.createLabel(composite, "JSP For Report View");

		Text jspview = new Text(composite, SWT.BORDER);
		jspview.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		jspview.setToolTipText("within /WEB-INF/jsp, leave blank for default");

		UIUtils.createLabel(composite, "JSP To Run InputControls");

		Text jspic = new Text(composite, SWT.BORDER);
		jspic.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		jspic.setToolTipText("within /WEB-INF/jsp, leave blank for default");

		ReportProxy v = getProxy(res.getValue());
		bindingContext.bindValue(
				SWTObservables.observeSingleSelectionIndex(cictype),
				PojoObservables.observeValue(v, "layoutControl"));
		bindingContext.bindValue(
				SWTObservables.observeText(jspview, SWT.Modify),
				PojoObservables.observeValue(v, "jspView"));
		bindingContext.bindValue(SWTObservables.observeText(jspic, SWT.Modify),
				PojoObservables.observeValue(v, "jspIC"));
		bindingContext.bindValue(SWTObservables.observeSelection(ispromp),
				PojoObservables.observeValue(v, "allowPrompt"));

		res.getChildren();

	}

	private ReportProxy getProxy(ResourceDescriptor rd) {
		proxy.setResourceDescriptor(rd);
		return proxy;
	}

	private ReportProxy proxy = new ReportProxy();

	class ReportProxy {
		private ResourceDescriptor rd;

		public void setResourceDescriptor(ResourceDescriptor rd) {
			this.rd = rd;
		}

		private int[] layouts = new int[] {
				ResourceDescriptor.RU_CONTROLS_LAYOUT_POPUP_SCREEN,
				ResourceDescriptor.RU_CONTROLS_LAYOUT_SEPARATE_PAGE,
				ResourceDescriptor.RU_CONTROLS_LAYOUT_TOP_OF_PAGE, 4 };

		public void setLayoutControl(int lang) {
			rd.setResourceProperty(ResourceDescriptor.PROP_RU_CONTROLS_LAYOUT,
					layouts[lang]);
		}

		public int getLayoutControl() {
			int lc = rd
					.getResourcePropertyValueAsInteger(ResourceDescriptor.PROP_RU_CONTROLS_LAYOUT);
			for (int i = 0; i < layouts.length; i++)
				if (layouts[i] == lc)
					return i;
			return -1;
		}

		public void setJspIC(String lang) {
			rd.setResourceProperty(
					ResourceDescriptor.PROP_RU_INPUTCONTROL_RENDERING_VIEW,
					lang);
		}

		public String getJspIC() {
			return rd
					.getResourcePropertyValue(ResourceDescriptor.PROP_RU_INPUTCONTROL_RENDERING_VIEW);
		}

		public void setJspView(String lang) {
			rd.setResourceProperty(
					ResourceDescriptor.PROP_RU_REPORT_RENDERING_VIEW, lang);
		}

		public String getJspView() {
			return rd
					.getResourcePropertyValue(ResourceDescriptor.PROP_RU_REPORT_RENDERING_VIEW);
		}

		public void setAllowPrompt(boolean lang) {
			rd.setResourceProperty(
					ResourceDescriptor.PROP_RU_ALWAYS_PROPMT_CONTROLS, lang);
		}

		public boolean isAllowPrompt() {
			return rd
					.getResourcePropertyValueAsBoolean(ResourceDescriptor.PROP_RU_ALWAYS_PROPMT_CONTROLS);
		}
	}

	protected void createControlResources(TabFolder tabFolder) {
		TabItem item = new TabItem(tabFolder, SWT.NONE);
		item.setText("Controls && Resources");

		Composite composite = new Composite(tabFolder, SWT.NONE);
		composite.setLayout(new GridLayout(3, false));
		item.setControl(composite);

	}

	protected void createDatasource(TabFolder tabFolder) {
		TabItem item = new TabItem(tabFolder, SWT.NONE);
		item.setText("Data Source");

		Composite composite = new Composite(tabFolder, SWT.NONE);
		composite.setLayout(new GridLayout(3, false));
		item.setControl(composite);

		ResourceDescriptor rd = res.getValue();
		for (Object obj : rd.getChildren()) {
			ResourceDescriptor r = (ResourceDescriptor) obj;
			if (r.getWsType().equals(ResourceDescriptor.TYPE_DATASOURCE)) {
				
			}
		}

	}

	protected void createQuery(TabFolder tabFolder) {
		ResourceDescriptor rd = res.getValue();
		for (Object obj : rd.getChildren()) {
			ResourceDescriptor r = (ResourceDescriptor) obj;
			if (r.getWsType().equals(ResourceDescriptor.TYPE_QUERY)) {
				RDQueryPage.createDatasourceTab(bindingContext, tabFolder, r);
			}
		}
	}
}
