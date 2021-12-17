import java.util.ArrayList;

/**
 *ロビーのクラス
 *@author DaichiF12
 */
class Lobby
{
	private ArrayList<User> users;
	private String lobbyID;
	private boolean isRandom;
	private ArrayList<boolean> readyList;
	private String lobbyPassword;


	public Lobby(String id, String pass, boolean patternFlag)
	{
		this.users = new ArrayList<>();
    	this.lobbyID = id;
    	this.isRandom = patternFlag;
		this.readyList = new ArrayList<>();
		this.lobbyPassword = pass;
	}

	public String getLobbyID()
	{
		return this.lobbyID;
	}

	public int getUserNum()
	{
		return this.users.size();
	}

	public int getUserNum(String userid)
	{
		int upos;
		String idtmp;

		for(upos = 0; upos < this.getUserNum(); upos++)
    	{
			idtmp = this.users.get(upos).getName();
			if(idtmp.equals(userid))
			{
				break;
			}
		}

		return upos;
	}

	public ArrayList<User> getUserList()
	{
		return this.users;
	}

	public void setReady(String userid)
	{
		int pos = this.getUserNum(userid);
		this.readyList.set(pos,true);
	}

	public void addUser(User user)
	{
		this.users.add(user);
	}

	public void deleteUser(String userid)
	{
		int pos = this.getUserNum(userid);
		this.users.remove(pos);
	}

	public String getPassword()
	{
		return this.lobbyPassword;
	}
}