package Twitter;

import java.util.List;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;


public class TwitterApp {
<<<<<<< HEAD
	ConfigurationBuilder cb = new ConfigurationBuilder();
	TwitterFactory tf = new TwitterFactory(cb.build());
	twitter4j.Twitter twitter = tf.getInstance();
=======
	
	private static List<Status> estadosDoIscte;
	
	public static List<Status> getListaTwitts(){
		return estadosDoIscte;
	}
	
>>>>>>> refs/heads/Swing
	public TwitterApp(){
		
	}
	
	public void initTwitter() throws TwitterException {

	public void iniciaTwitter() {

		

		cb.setDebugEnabled(true)
		.setOAuthConsumerKey("4rJVbcVIboahTgUlsd7oOFwDd")
		.setOAuthConsumerSecret("wbHgBD2qAJwZpLacQF9wICwnP79UUEvbQ2D1C9SS74KHl79vdW")
		.setOAuthAccessToken("159232832-8BKv6atg6nF2YVsAwUvoj2y4KTXsytriJt9eWCa5")
		.setOAuthAccessTokenSecret("ndoKlk7Tp5rv7aMVVvtgfNj5FxDNeTnRpQdgWJ0KdBMLb");
		

		twitter.getHomeTimeline();

		/*List<Status> estadosDaTimeLine = twitter.getHomeTimeline();
		for(Status st : estadosDaTimeLine)
		{
			System.out.println(st.getUser().getName()+" -- "+st.getText());
		 */
		
		//System.out.println(st.getUser().getName().equals("Rafa")+" --"+st.getText());
	}
	
	public List<Status> getListaTweets(){
		List<Status> estadosDoIscte = twitter.getUserTimeline("iscteiul");
		for(Status si: estadosDoIscte)
		{
			System.out.println(si.getUser().getName()+" -- "+si.getText());
		}
	}
}
