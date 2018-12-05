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

	public String consumerApiKey="WlykUrj8IWMlPgMHpffoTO5ZD";
	public String apiSecretKey="EnvICCHNRqmOZEjVS5th7haBhvbjoCrVPwNHMpPjcz3uQklWle";
	public String accessToken="159232832-19nUFvi655cA9TDS7r2zDEbjTnpnhXnTf1sdC5Xk";
	public String accessTokenSecret="e0OW9UdG62C6OzEHBNTAeVFf4yF8a6mwsI47h5HyQmo7J";
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
		//		TwitterFactory tf1 = new TwitterFactory();
		//		Twitter twitter = tf1.getInstance();
		//		twitter.setOAuthConsumer(consumerApiKey, apiSecretKey);
		//		AccessToken accessToken = new AccessToken("159232832-8BKv6atg6nF2YVsAwUvoj2y4KTXsytriJt9eWCa5", "ndoKlk7Tp5rv7aMVVvtgfNj5FxDNeTnRpQdgWJ0KdBMLb");
		//		twitter.setOAuthAccessToken(accessToken);
		//É preciso criar os botões na gui e colocar os handlers aqui para retweetar


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
		//Coloco o handler do botão retweetar e chamo a função retweetar dentro do handler mas antes tenho que ver com o tweet selecionado na lista

	}
	/**
	 * actualizaTwitter,
	 * Atualiza a lista de tweets com estados relativos a um filtro
	 */
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
	public void retweetar(Status estado) throws TwitterException {



		long id =estado.getId();
		twitter.retweetStatus((id));

	}
	//
	//	/**permite favoritar (colocar "gosto" num tweet
	//	 */
	//	public  void favoritar() throws TwitterException {
	//		TwitterFactory factory = new TwitterFactory();
	//
	//		Twitter twitter = factory.getInstance();
	//		twitter.setOAuthConsumer(consumerApiKey, apiSecretKey);
	//		AccessToken accessToken = new AccessToken("159232832-8BKv6atg6nF2YVsAwUvoj2y4KTXsytriJt9eWCa5", "ndoKlk7Tp5rv7aMVVvtgfNj5FxDNeTnRpQdgWJ0KdBMLb");
	//		twitter.setOAuthAccessToken(accessToken);
	//		Status status = twitter.createFavorite(getTweetId());	 
	//	}

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


	/**
	 * getCOnsumerApiKey
	 * Getter para devolve a chave do Consumidor da API (API key)
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
	/**
	 * devolve a chave secreta de acesso (Access token secret)
	 */
	public String getAccessTokenSecret() {
		return accessTokenSecret;
	}

	//	public boolean isLiked() {
	//		
	//	}


	/**
	 * setFiltro,
	 * Setter for filtro (filter).
	 * @param filtro this is the filter we want want to apply when displaying tweets
	 */
	public void setFiltro(String filtro) {
		this.filtro=filtro;
	}

	/**
	 * getFiltro,
	 * Getter for filtro (filter).
	 * @return filtro (filter)
	 */
	public String getFiltro() {
		return this.filtro;
	}

}