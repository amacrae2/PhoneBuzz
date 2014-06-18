package twilio;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.CallFactory;
import com.twilio.sdk.resource.factory.SmsFactory;
import com.twilio.sdk.resource.instance.Call;
import com.twilio.sdk.resource.instance.Sms;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
public class Example {
 
  // Find your Account Sid and Token at twilio.com/user/account
  public static final String ACCOUNT_SID = "ACc99721549b267f2890e41c798bf6a800";
  public static final String AUTH_TOKEN = "7bc402749f447fb31433e7c6b331578c";
 
  public static void main(String[] args) throws TwilioRestException {
    TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
 
    // Build a filter for the MessageList
    Map<String, String> params = new HashMap<String, String>();
    params.put("Url", "http://localhost:8080/Phone/TwilioServlet");
    params.put("To", "+14083482354");
    params.put("From", "+18313374593");
 
    CallFactory messageFactory = client.getAccount().getCallFactory();
    Call message = messageFactory.create(params);
    System.out.println(message.getSid());
  }
}