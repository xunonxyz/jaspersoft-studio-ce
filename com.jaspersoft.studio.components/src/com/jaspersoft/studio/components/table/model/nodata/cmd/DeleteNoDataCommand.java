/*******************************************************************************
 * Copyright © 2010-2023. Cloud Software Group, Inc. All rights reserved.
 *******************************************************************************/
package com.jaspersoft.studio.components.table.model.nodata.cmd;

import org.eclipse.gef.commands.Command;

import com.jaspersoft.studio.components.table.model.nodata.MTableNoData;

import net.sf.jasperreports.components.table.DesignBaseCell;
import net.sf.jasperreports.components.table.StandardTable;

/*
 * link nodes & together.
 * 
 * @author Chicu Veaceslav
 */
public class DeleteNoDataCommand extends Command {
	private DesignBaseCell jrCell;
	private StandardTable tbl;

	public DeleteNoDataCommand(MTableNoData srcNode) {
		super();
		jrCell = srcNode.getValue();
		tbl = srcNode.getMTable().getStandardTable();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	@Override
	public void execute() {
		tbl.setNoData(null);
	}

	@Override
	public boolean canExecute() {
		return tbl.getNoData() != null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#canUndo()
	 */
	@Override
	public boolean canUndo() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	@Override
	public void undo() {
		tbl.setNoData(jrCell);
	}
}
