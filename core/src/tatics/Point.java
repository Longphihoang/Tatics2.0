package tatics;

public class Point  {

	
	/**
	 * 
	 */
	public int level = 0;
	public String type = "";
	public int x;
	public int y;

	public Point() {
	}

	public Point(Point p) {

		this.x=p.x;
		this.y=p.y;

	}

	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}

	public void translate(int a,int b)
	{
		x=x+a;
		y=y+b;
	}

	public double getX()
	{
		return x;
	}
	public double getY()
	{
		return y;
	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
