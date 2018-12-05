package Twitter;

import java.util.List;
import twitter4j.*;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;


public class TwitterApp {

	private List<Status> estadosDoIscte;

	private TwitterFactory tf;
	private twitter4j.Twitter twitter;
	private String filtro = "iscteiul";

	public String consumerApiKey="4rJVbcVIboahTgUlsd7oOFwDd";
	public String apiSecretKey="wbHgBD2qAJwZpLacQF9wICwnP79UUEvbQ2D1C9SS74KHl79vdW";
	public String accessToken="159232832-8BKv6atg6nF2YVsAwUvoj2y4KTXsytriJt9eWCa5";
	public String accessTokenSecret="ndoKlk7Tp5rv7aMVVvtgfNj5FxDNeTnRpQdgWJ0KdBMLb";
	public ConfigurationBuilder cb = new ConfigurationBuilder();


	public List<Status> getListaTweets(){
		return estadosDoIscte;
	}

	public TwitterApp(){


	}

	/**inicia a conexão com a api do twitter
	 * @throws TwitterException
	 */
	public void initTwitter() throws TwitterException{
		cb.setDebugEnabled(true)
		.setOAuthConsumerKey(consumerApiKey)
		.setOAuthConsumerSecret( apiSecretKey)
		.setOAuthAccessToken(accessToken)
		.setOAuthAccessTokenSecret(accessTokenSecret);
		TwitterFactory tf = new TwitterFactory(cb.build());
		twitter4j.Twitter twitter = tf.getInstance();

//		.setOAuthConsumerKey("4rJVbcVIboahTgUlsd7oOFwDd")
//		.setOAuthConsumerSecret("wbHgBD2qAJwZpLacQF9wICwnP79UUEvbQ2D1C9SS74KHl79vdW")
//		.setOAuthAccessToken("159232832-8BKv6atg6nF2YVsAwUvoj2y4KTXsytriJt9eWCa5")
//		.setOAuthAccessTokenSecret("ndoKlk7Tp5rv7aMVVvtgfNj5FxDNeTnRpQdgWJ0KdBMLb");
//		tf = new TwitterFactory(cb.build());
//		twitter = tf.getInstance();
		
		
//------------------------------------------

		twitter.getHomeTimeline();

		List<Status> estadosDaTimeLine = twitter.getHomeTimeline();
		for(Status st : estadosDaTimeLine)
		{
			System.out.println(st.getUser().getName()+" -- "+st.getText());

			estadosDoIscte = twitter.getUserTimeline(filtro);
			for(Status si: estadosDoIscte){
				//				System.out.println(si.getUser().getName()+" -- "+si.getText());
			}
		}
	}

	public void actualizaTwitter() throws TwitterException {
//		List<Status> estadosDaTimeLine = twitter.getHomeTimeline();
//		for(Status st : estadosDaTimeLine)
//		{
//			System.out.println(st.getUser().getName()+" -- "+st.getText());
//
//			estadosDoIscte = twitter.getUserTimeline("iscteiul");
//			
//		}
		estadosDoIscte = twitter.getUserTimeline(filtro);
	}

	/**permite retweetar(repostar) um tweet
	 * @throws TwitterException 
	 */
	public void retweetar() throws TwitterException {
		TwitterFactory tf1 = new TwitterFactory();
		Twitter twitter = tf1.getInstance();
		twitter.setOAuthConsumer(consumerApiKey, apiSecretKey);
		AccessToken accessToken = new AccessToken("159232832-8BKv6atg6nF2YVsAwUvoj2y4KTXsytriJt9eWCa5", "ndoKlk7Tp5rv7aMVVvtgfNj5FxDNeTnRpQdgWJ0KdBMLb");
		twitter.setOAuthAccessToken(accessToken);
		twitter.retweetStatus(getTweetId());

	}

	/**permite favoritar (colocar "gosto" num tweet
	 */
	public  void favoritar() throws TwitterException {
		TwitterFactory factory = new TwitterFactory();

		Twitter twitter = factory.getInstance();
		twitter.setOAuthConsumer(consumerApiKey, apiSecretKey);
		AccessToken accessToken = new AccessToken("159232832-8BKv6atg6nF2YVsAwUvoj2y4KTXsytriJt9eWCa5", "ndoKlk7Tp5rv7aMVVvtgfNj5FxDNeTnRpQdgWJ0KdBMLb");
		twitter.setOAuthAccessToken(accessToken);
		Status status = twitter.createFavorite(getTweetId());	 
	}

	/**permite responder a um tweet
	 */
//	public void responder() {
//		TwitterFactory factory = new TwitterFactory();
//
//		Twitter twitter = factory.getInstance();
//		twitter.setOAuthConsumer(consumerApiKey, apiSecretKey);
//		AccessToken accessToken = new AccessToken("159232832-8BKv6atg6nF2YVsAwUvoj2y4KTXsytriJt9eWCa5", "ndoKlk7Tp5rv7aMVVvtgfNj5FxDNeTnRpQdgWJ0KdBMLb");
//		twitter.setOAuthAccessToken(accessToken);
//		String replyMessage; //implementar um scanner?
//		StatusUpdate statusUpdate = new StatusUpdate(replyMessage);
//		long inReplyToStatusId;
//		statusUpdate.setInReplyToStatusId(inReplyToStatusId);
//		Status status = twitter.updateStatus(statusUpdate);
//	}

	/**Funções que vão ser primariamente usadas para fazer os testes
>>>>>>> branch 'Development' of https://github.com/grfas/ES1-2018-IC2-63.git
	/**devolve um id(chave de identificação) associado a um tweet específico
	 */
	public long getTweetId() { //help com isto sff
		long tweetId = 0; //preciso de alterar isto
		return tweetId;
	}
	/**devolve a chave do Consumidor da API (API key)
	 */
	public String getConsumerApiKey() {
		return consumerApiKey;
	}
	/**devolve a chave secreta do Consumidor da API (API secret key)
	 */
	public String getApiSecretKey() {
		return apiSecretKey;
	}
	/**devolve a chave de Acesso (Access token)
	 */
	public String getAccessToken() {
		return accessToken;
	}
	/**devolve a chave secreta de acesso (Access token secret)
	 */
	public String getAccessTokenSecret() {
		return accessTokenSecret;
	}
	
//	public boolean isLiked() {
//		
//	}
	
	
	
	public void setFiltro(String filtro) {
		this.filtro=filtro;
	}
	
	public String getFiltro() {
		return this.filtro;
	}
	
	

}