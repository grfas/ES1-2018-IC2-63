package Twitter;

	import java.util.List;
	import twitter4j.*;
	import twitter4j.auth.AccessToken;
	import twitter4j.conf.ConfigurationBuilder;
	/**
	 * @author Gonçalo Canha
	 * Classe do twitter
	 *
	 */

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

	/**
	 * getListaTweets,
	 * Getter para uma lista de tweets com estados do iscte.
	 * @return estadosDoIscte, uma lista de tweets relativos ao iscteiul
	 */
	public List<Status> getListaTweets(){
		return estadosDoIscte;
	}

//	public TwitterApp(){
//
//
//	}

	/**
	 *initTwitter,
	 * inicia a conexão com a api do twitter
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
	 * Actualiza a lista de tweets com estados relativos a um filtro
	 * @throws TwitterException
	 *
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


	/**
	 * reweetar, 
	 * permite retweetar(repostar) um tweet
	 * @param estado, este estado é o tweet que pretendemos retweetar 
	 * @throws TwitterException 
	 */
	public void retweetar(Status estado) throws TwitterException {
		long id =estado.getId();
		twitter.retweetStatus((id));
	}
	

	/**Funções que vão ser primariamente usadas para fazer os testes
>>>>>>> branch 'Development' of https://github.com/grfas/ES1-2018-IC2-63.git


	/**
	 * getConsumerApiKey,
	 * Getter que devolve a chave do Consumidor da API (consumerApiKey).
	 * @return consumerApiKey
	 */
	public String getConsumerApiKey() {
		return consumerApiKey;
	}
	
	/**
	 * getApiSecretKey, 
	 * Getter que devolve a chave secreta do Consumidor da API (apiSecretKey).
	 * @return apiSecretKey
	 */
	public String getApiSecretKey() {
		return apiSecretKey;
	}
	
	/**
	 * getAccessToken,
	 * Getter que devolve a chave de Acesso (accessToken).
	 * @return getAcessToken
	 */
	public String getAccessToken() {
		return accessToken;
	}
	
	/**
	 * getAcessTokenSecret,
	 * Getter que devolve a chave secreta de acesso (accessTokenSecret).
	 * @return accessTokenSecret
	 */
	public String getAccessTokenSecret() {
		return accessTokenSecret;
	}



	/**
	 * setFiltro,
	 * Setter for filtro (filter).
	 * @param filtro, é o filtro que vamos aplicar aquando da exibição dos tweets.
	 */
	public void setFiltro(String filtro) {
		this.filtro=filtro;
	}

	/**
	 * getFiltro,
	 * Getter que devolve o filtro (filter).
	 * @return filtro
	 */
	public String getFiltro() {
		return this.filtro;
	}

}