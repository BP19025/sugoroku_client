import java.util.ArrayList;

/**
 *クライアントを管理するクラス
 *@author fumofumo3
 */
class ClientManageServer
{
	private ArrayList<User> users;
	private ArrayList<Lobby> lobbys;
	private DatabaseManager dbManager;
	private ComManager comManager;


	public ClientManageServer()
	{
		this.users = new ArrayList<User>();
		this.lobbys = new ArrayList<Lobby>();
		this.dbManager = new DatabaseManager();
		this.comManager = new ComManager();
	}

	/**
	 *WIP メッセージを処理して実行するメソッド
	 *@author fumofumo3
	 */
	public void handleMessage()
	{
		switch(msg)
		{
			default:
				break;
		}
	}

	public void signIn(String userID, String pwd)
	{

	}

	/**
	 *WIP サインアップをするメソッド
	 * @author fumofumo3
	 * @param userID ユーザID
	 * @param pwd パスワード
	 */
	public void signUp(String userID, String pwd)
	{
		boolean isExistUser = dbManager.searchUser(userID, pwd);

		if(isExistUser)
		{

		}
		else
		{
			this.dbManager.signUp(userID, pwd);
			this.comManager.sendMessage();
		}
	}

	public void matchRandom()
	{
	}

	public void matchPrivate()
	{
	}

	public boolean isExistLobby(String lobbyID)
	{
		String id;
		for(int num = 0; num < this.lobbys.size(); num++)
		{
			id = this.lobbys.get(num).getLobbyID();
			if(lobbyID.equals(id))
			{
				return true;
			}
		}

		return false;
	}

	public void createLobby(String lobbyID)
	{
	}

	public boolean exitLobby(String userID)
	{
		User user = this.searchUser(userID);
		if(user == null)
		{
			return false;
		}

		String lobbyID = user.getLobbyID();
		Lobby lobby = this.searchLobby(lobbyID);
		if(lobby == null)
		{
			return false;
		}

		lobby.deleteUser(userID);
		if(lobby.getUserNum() == 0)
		{
			this.deleteLobby(lobby);
		}

		return true;
	}

	public Lobby decideRandomLobby()
	{
	}

	public void startGame(String str)
	{
	}

	public void castChat(String chat)
	{
	}

	private User searchUser(String userID)
	{
		String id;
		for(int num = 0; num < this.users.size(); num++)
		{
			id = this.users.get(num).getName();
			if(userID.equals(id))
			{
				return this.users.get(num);
			}
		}

		return null;
	}

	private Lobby searchLobby(String lobbyID)
	{
		String id;
		for(int num = 0; num < this.lobbys.size(); num++)
		{
			id = this.lobbys.get(num).getLobbyID();
			if(lobbyID.equals(id))
			{
				return this.lobbys.get(num);
			}
		}

		return null;
	}

	private void deleteLobby(Lobby targetLobby)
	{
		for(int num = 0; num < this.lobbys.size(); num++)
		{
			if(targetLobby == this.lobbys.get(num))
			{
				this.lobbys.remove(num);
				return;
			}
		}
	}
}