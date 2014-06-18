package twilio;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.CallFactory;
import com.twilio.sdk.resource.instance.Call;
import com.twilio.sdk.verbs.Say;
import com.twilio.sdk.verbs.TwiMLException;
import com.twilio.sdk.verbs.TwiMLResponse;

/**
 * Servlet implementation class TwilioServlet
 */
@WebServlet("/TwilioServlet")
public class TwilioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Find your Account Sid and Token at twilio.com/user/account
	public static final String ACCOUNT_SID = "ACc99721549b267f2890e41c798bf6a800";
	public static final String AUTH_TOKEN = "7bc402749f447fb31433e7c6b331578c";
	 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TwilioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
		String phoneNumber = request.getParameter("phoneNumber");
		
		// Create a TwiML response and add our friendly message.
        TwiMLResponse twiml = new TwiMLResponse();
        Say say = new Say("Hello Monkey");
        try {
            twiml.append(say);
        } catch (TwiMLException e) {
            e.printStackTrace();
        }
 
        
        response.setContentType("application/xml");
        response.getWriter().print(twiml.toXML());
        
        TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
        
        // Build a filter for the MessageList
        Map<String, String> params = new HashMap<String, String>();
        params.put("Url", "http://localhost:8080/Phone/TwilioServlet");
        params.put("To", "+14083482354");
        params.put("From", "+18313374593");
     
        CallFactory messageFactory = client.getAccount().getCallFactory();
        Call message;
		try {
			message = messageFactory.create(params);
	        System.out.println(message.getSid());
		} catch (TwilioRestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
