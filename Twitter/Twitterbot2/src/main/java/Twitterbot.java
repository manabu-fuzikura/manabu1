

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;

public class Twitterbot extends HttpServlet{
	static Logger logger = Logger.getLogger("SenyaBot");

	private	 static final String consumerKey = "21SibawalJYWH03UerrFMSxD2";
	private     static final String consumerSecret = "uWCVCW7UTEknAZupgH1I3GOmeQdg7U9OcPkrPn5lQTMsVy9cWZ";
    private     static final String accessToken = "1196225729391820800-OIqJW5oCISU1mQytCWdAdXfRIW3Pvh";
	private     static final String accessTokenSecret = "ZlY2zDfr2O4cM1l1GuJOqsvs5eoFyt4wg9UAePxJuJkHy";



	private static final String tweet = "ãã?®ãã­ã°è¶?é¢ç½ãwwâ?";

	private static final String getTweet(){
		String tweets[] = {
				"é¾æ³æ´?",
				"å°å²©äºè¾²å ´",
				"ãããè¸ã",
				"çå²¡ç¾è¡é¤¨",
				"æ°´æã?¯å®ä¼æ¥ãªãã ããª",
				"ã¨ããããå?å®¶è¡ãã?ã?",
				"ã¦ã¼ãã©ã¤ã¹ä»ãã¡ã?ã??¼?",
				"ããã«ã¬ã¼ãæå¤ã¨ç¾å³ããã?",
				"ãã®ã?ã¾ãã",
				"ãã?®ãã®çè¦ãã¨ã?ã³ã·ã§ã³ããã£ã¡ã?ã?ãã?­ã¼",
				"å¤§å°?ã¾ããã£ãã",
				"ããã¯é£å¸å¶ã§ã?"
		};
		int randint = (int)(Math.random()*tweets.length);
		return tweets[randint];
	}





	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		//http://twitter4j.org/ja/configuration.html
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
			.setOAuthAccessToken(accessToken)
			.setOAuthAccessTokenSecret(accessTokenSecret)
			.setOAuthConsumerKey(consumerKey)
			.setOAuthConsumerSecret(consumerSecret);
		String message = getTweet();
		Twitter twitter = new TwitterFactory(cb.build()).getInstance();
		try {
			//Twitterã«æ¸ãå?ºã?
			twitter.updateStatus(message);
		} catch (TwitterException e) {
			logger.log(Level.SEVERE, "Twitter error", e);
		}
	}

			public static void main(String[] args){

				Twitter twitter = new TwitterFactory().getInstance();
				twitter.setOAuthConsumer(consumerKey, consumerSecret);
				twitter.setOAuthAccessToken(new AccessToken(accessToken,accessTokenSecret));
				try{
					twitter.updateStatus(tweet);
					System.out.println("ã?ã¤ã¼ãããã?½?");
				} catch(TwitterException e){
					System.err.println("ã?ã¤ã¼ãå¤±æ?"+e.getMessage());
				}

			try{
				twitter.updateStatus(getTweet());
				System.out.println("ã?ã¤ã¼ãããã?½?");
			} catch(TwitterException d){
					System.err.println("ã?ã¤ã¼ãå¤±æ?"+d.getMessage());

			}
			}
	}
