package com.jaspersoft.studio.server.utils;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.NTCredentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.eclipse.core.net.proxy.IProxyChangeEvent;
import org.eclipse.core.net.proxy.IProxyChangeListener;
import org.eclipse.core.net.proxy.IProxyData;
import org.eclipse.core.net.proxy.IProxyService;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.jaspersoft.studio.server.Activator;
import com.jaspersoft.studio.server.model.server.ServerProfile;
import com.jaspersoft.studio.server.protocol.restv2.RestV2Connection;

public class HttpUtils {

	public static Executor setupProxy(Executor exec, URI uri) {
		for (IProxyData d : proxyService.select(uri)) {
			exec.auth(new HttpHost(d.getHost(), d.getPort()), getCredentials(d));
			exec.authPreemptiveProxy(new HttpHost(d.getHost(), d.getPort()));
			break;
		}
		executors.put(exec, uri);
		return exec;
	}

	public static Request setRequest(Request req, ServerProfile sp) {
		req.connectTimeout(sp.getTimeout());
		req.socketTimeout(sp.getTimeout());
		if (sp.isChunked())
			req.setHeader("Transfer-Encoding", "chunked");
		else
			req.removeHeaders("Transfer-Encoding");
		req.setHeader("Accept", "application/" + RestV2Connection.FORMAT);
		return req;
	}

	public static Request get(String url, ServerProfile sp) throws HttpException, IOException {
		System.out.println(url);
		return HttpUtils.setRequest(Request.Get(url), sp);
	}

	public static Request put(String url, ServerProfile sp) throws HttpException, IOException {
		System.out.println(url);
		return HttpUtils.setRequest(Request.Put(url), sp);
	}

	public static Request post(String url, ServerProfile sp) throws HttpException, IOException {
		System.out.println(url);
		return HttpUtils.setRequest(Request.Post(url), sp);
	}

	public static Request delete(String url, ServerProfile sp) throws HttpException, IOException {
		System.out.println(url);
		return HttpUtils.setRequest(Request.Delete(url), sp);
	}

	private static Map<Executor, URI> executors = new HashMap<Executor, URI>();

	public static IProxyService getProxyService() {
		BundleContext bc = Activator.getDefault().getBundle().getBundleContext();
		ServiceReference<?> serviceReference = bc.getServiceReference(IProxyService.class.getName());
		IProxyService service = (IProxyService) bc.getService(serviceReference);
		service.addProxyChangeListener(new IProxyChangeListener() {

			@Override
			public void proxyInfoChanged(IProxyChangeEvent event) {
				for (Executor exe : executors.keySet())
					setupProxy(exe, executors.get(exe));
			}
		});
		return service;
	}

	private static IProxyService proxyService = getProxyService();

	protected static Credentials getCredentials(IProxyData data) {
		String userId = data.getUserId();
		Credentials proxyCred = new UsernamePasswordCredentials(userId, data.getPassword());
		// if the username is in the form "user\domain"
		// then use NTCredentials instead.
		int domainIndex = userId.indexOf("\\");
		if (domainIndex > 0) {
			String domain = userId.substring(0, domainIndex);
			if (userId.length() > domainIndex + 1) {
				String user = userId.substring(domainIndex + 1);
				proxyCred = new NTCredentials(user, data.getPassword(), data.getHost(), domain);
			}
		}
		return proxyCred;
	}
}
