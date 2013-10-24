package biz.winho.entity;

public class Friendentity {
	private Integer friendid;
	private String friendname;
	private String friendmood;
	private String friendteam;
	
	public Friendentity(){
		
	}

	public Friendentity(Integer friendid, String friendname, String friendmood,
			String friendteam) {
		this.friendid = friendid;
		this.friendmood = friendmood;
		this.friendname = friendname;
		this.friendteam = friendteam;
	}

	public Integer getFriendid() {
		return friendid;
	}

	public void setFriendid(Integer friendid) {
		this.friendid = friendid;
	}

	public String getFriendname() {
		return friendname;
	}

	public void setFriendname(String friendname) {
		this.friendname = friendname;
	}

	public String getFriendmood() {
		return friendmood;
	}

	public void setFriendmood(String friendmood) {
		this.friendmood = friendmood;
	}

	public String getFriendteam() {
		return friendteam;
	}

	public void setFriendteam(String friendteam) {
		this.friendteam = friendteam;
	}

}
