package main;

public class Game {
	
	private String GameID, GameName, GameType;
	private int GamePrice, GameStock;
	
	
	
	
	public Game(String gameID, String gameName, String gameType, int gamePrice, int gameStock) {
		
		GameID = gameID;
		GameName = gameName;
		GameType = gameType;
		GamePrice = gamePrice;
		GameStock = gameStock;
	}




	public String getGameID() {
		return GameID;
	}




	public void setGameID(String gameID) {
		GameID = gameID;
	}




	public String getGameName() {
		return GameName;
	}




	public void setGameName(String gameName) {
		GameName = gameName;
	}




	public String getGameType() {
		return GameType;
	}




	public void setGameType(String gameType) {
		GameType = gameType;
	}




	public int getGamePrice() {
		return GamePrice;
	}




	public void setGamePrice(int gamePrice) {
		GamePrice = gamePrice;
	}




	public int getGameStock() {
		return GameStock;
	}




	public void setGameStock(int gameStock) {
		GameStock = gameStock;
	}




	public Game() {
		
	}

}
