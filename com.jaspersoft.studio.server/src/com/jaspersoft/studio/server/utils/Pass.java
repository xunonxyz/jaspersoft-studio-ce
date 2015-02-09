/*******************************************************************************
 * Copyright (C) 2005 - 2014 TIBCO Software Inc. All rights reserved.
 * http://www.jaspersoft.com.
 * 
 * Unless you have purchased  a commercial license agreement from Jaspersoft,
 * the following license terms  apply:
 * 
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package com.jaspersoft.studio.server.utils;

import net.sf.jasperreports.util.SecretsUtil;

import com.jaspersoft.studio.server.secret.JRServerSecretsProvider;
import com.jaspersoft.studio.utils.jasper.JasperReportsConfiguration;

public class Pass {

	private static SecretsUtil secretsUtil = SecretsUtil.getInstance(JasperReportsConfiguration.getDefaultInstance());

	public static String getPass(String key) {
		return secretsUtil.getSecret(JRServerSecretsProvider.SECRET_NODE_ID, key);
	}
}
