package com.jaspersoft.studio.data.sql.action.select;

import com.jaspersoft.studio.data.sql.SQLQueryDesigner;
import com.jaspersoft.studio.data.sql.Util;
import com.jaspersoft.studio.data.sql.action.AMultiSelectionAction;
import com.jaspersoft.studio.data.sql.model.query.MGroupBy;
import com.jaspersoft.studio.data.sql.model.query.MGroupByColumn;
import com.jaspersoft.studio.data.sql.model.query.select.MSelectColumn;
import com.jaspersoft.studio.model.ANode;

public class CreateGroupByFromColumn extends AMultiSelectionAction {

	public CreateGroupByFromColumn(SQLQueryDesigner designer) {
		super("&Add To Group By", designer);
	}

	protected boolean isGoodNode(ANode element) {
		return element instanceof MSelectColumn;
	}

	@Override
	public void run() {
		MGroupByColumn gbc = null;
		MGroupBy mgroupby = null;
		for (Object obj : selection) {
			if (obj instanceof MSelectColumn) {
				MSelectColumn msc = (MSelectColumn) obj;
				if (mgroupby == null)
					mgroupby = Util.getKeyword(msc, MGroupBy.class);
				gbc = new MGroupByColumn(mgroupby, msc);
			}
		}
		selectInTree(gbc);
	}

}