package interfacee;

public  interface FullTime {
	/*only executives implement the interface FullTime
	 * they can hold meetings, take vacations and a fixed bonus can be added to their salary*/
	
	final  double BONUS=600;

	public void holdMeeting(int hour);
	public void vacation();
	public void addBonus ();
	
	
}
