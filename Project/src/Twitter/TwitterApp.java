package Twitter;

import java.util.List;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;


public class TwitterApp {

	ConfigurationBuilder cb = new ConfigurationBuilder();
	TwitterFactory tf = new TwitterFactory(cb.build());
	twitter4j.Twitter twitter = tf.getInstance();
	private  List<Status> estadosDoIscte;

	public TwitterApp(){


	}

	public void initTwitter() throws TwitterException{





		cb.setDebugEnabled(true)
		.setOAuthConsumerKey("4rJVbcVIboahTgUlsd7oOFwDd")
		.setOAuthConsumerSecret("wbHgBD2qAJwZpLacQF9wICwnP79UUEvbQ2D1C9SS74KHl79vdW")
		.setOAuthAccessToken("159232832-8BKv6atg6nF2YVsAwUvoj2y4KTXsytriJt9eWCa5")
		.setOAuthAccessTokenSecret("ndoKlk7Tp5rv7aMVVvtgfNj5FxDNeTnRpQdgWJ0KdBMLb");


		twitter.getHomeTimeline();

		estadosDoIscte = twitter.getHomeTimeline();
					for(Status st : estadosDaTimeLine){
						System.out.println(st.getUser().getName()+" -- "+st.getText());
					//System.out.println(st.getUser().getName().equals("Rafa")+" --"+st.getText());
					}
	}

	public List<Status> getListaTweets(){
		try {
			estadosDoIscte = twitter.getUserTimeline("iscteiul");
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Status si: estadosDoIscte){
			System.out.println(si.getUser().getName()+" -- "+si.getText());
		}
		return estadosDoIscte;
	}	

}
