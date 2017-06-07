package io.pivotal.microsamples.soapme;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SoapmeApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SoapmeApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
//		ClientImpl client = (ClientImpl)doc.getClientFromWsdl("http://myurl:8080/DataCentersWS?wsdl");
//		String operationName = "getVirtualisationManagerUuid";
//		BindingOperationInfo op = doc.getOperation(client, operationName);
//		List<MessagePartInfo> messagesParts = op.getInput().getMessageParts();
//		Object[] params = new Object[messagesParts.size()];
///* feed yours params here (this feeding was heavy in my code */
//		Object[] res = client.invoke(op, params);


//		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
//		Client client = dcf.createClient("http://www.webservicex.com/globalweather.asmx?wsdl");
//
//		Object[] res = client.invoke("GetWeatherX", "New York", "USA");
//		System.out.println("Echo response: " + res[0]);

	}
}
