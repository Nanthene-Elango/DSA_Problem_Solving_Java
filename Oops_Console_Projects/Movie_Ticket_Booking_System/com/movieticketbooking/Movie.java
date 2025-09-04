package Oops_Console_Projects.Movie_Ticket_Booking_System.com.movieticketbooking;

/**
 * class to store the details of the movies
 */

public class Movie {

	private int movieID;
	private String movieTitle;
	private String language;
	private String genre;
	private String sensorBoard;
	private String duration;
	private String releaseDate;
	static int count = 0;
	
	/**
	 * Constructor of Movie class to initialize movie class
	 * attributes
	 * 
	 * @param movieTitle
	 * @param language
	 * @param genre
	 * @param sensorBoard
	 * @param releaseDate
	 */
	public Movie(String movieTitle , String language , String genre 
			, String sensorBoard ,String duration , String releaseDate) {
		
		this.movieID = ++count;
		this.movieTitle = movieTitle;
		this.language = language;
		this.genre = genre;
		this.sensorBoard = sensorBoard;
//		this.description = desc;
		this.duration = duration;
		this.releaseDate = releaseDate;

	}
	
	public int getMovieID() {
		return movieID;
	}

	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getSensorBoard() {
		return sensorBoard;
	}

	public void setSensorBoard(String sensorBoard) {
		this.sensorBoard = sensorBoard;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}	

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	
	
	/**
	 * Overridden method to convert the object into a string 
	 */
	@Override 
	public String toString() {
		return "Title: " + movieTitle + "\nLanguage: " + language + "\nGenre: " 
				+ "\nCBFC: " + sensorBoard + "\nDuration: "+ duration +
				"\nRelease Date: " + releaseDate ;
	}
}
