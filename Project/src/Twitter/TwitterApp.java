package Twitter;

import java.util.List;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;


public class TwitterApp {

	private List<Status> estadosDoIscte;

	public List<Status> getListaTweets(){
		return estadosDoIscte;
	}

	public TwitterApp(){


	}

	public void initTwitter() throws TwitterException{


		ConfigurationBuilder cb = new ConfigurationBuilder();

		cb.setDebugEnabled(true)
		.setOAuthConsumerKey("4rJVbcVIboahTgUlsd7oOFwDd")
		.setOAuthConsumerSecret("wbHgBD2qAJwZpLacQF9wICwnP79UUEvbQ2D1C9SS74KHl79vdW")
		.setOAuthAccessToken("159232832-8BKv6atg6nF2YVsAwUvoj2y4KTXsytriJt9eWCa5")
		.setOAuthAccessTokenSecret("ndoKlk7Tp5rv7aMVVvtgfNj5FxDNeTnRpQdgWJ0KdBMLb");
		TwitterFactory tf = new TwitterFactory(cb.build());
		twitter4j.Twitter twitter = tf.getInstance();

		twitter.getHomeTimeline();

		List<Status> estadosDaTimeLine = twitter.getHomeTimeline();
		for(Status st : estadosDaTimeLine)
		{
			System.out.println(st.getUser().getName()+" -- "+st.getText());

			estadosDoIscte = twitter.getUserTimeline("iscteiul");
			for(Status si: estadosDoIscte)
			{
				System.out.println(si.getUser().getName()+" -- "+si.getText());
			}
		}



	}
}